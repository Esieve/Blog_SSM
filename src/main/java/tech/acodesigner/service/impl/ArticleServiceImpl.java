package tech.acodesigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.acodesigner.dao.ArticleDao;
import tech.acodesigner.dao.cache.RedisDao;
import tech.acodesigner.dto.ArticleDto;
import tech.acodesigner.dto.ArticleLiteDto;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.Article;
import tech.acodesigner.service.ArticleService;
import tech.acodesigner.util.PageUtil;

import java.util.List;

/**
 * Created by 77239 on 2017/4/2/0002.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private RedisDao redisDao;

    public List<ArticleDto> searchArticles(String key) {
        return articleDao.getArticlesByKey(key);
    }

    public List<ArticleDto> pagination(PageUtil pageUtil) {
        return articleDao.getArticlesByRange(pageUtil);
    }

    public ArticleLiteDto getPreArticle(int articleId) {
        ArticleLiteDto article = articleDao.getPreArticle(articleId);
        if (article == null) {
            return new ArticleLiteDto(-1, "这已经是第一篇了");
        } else {
            return article;
        }
    }

    public ArticleLiteDto getNextArticle(int articleId) {
        ArticleLiteDto article = articleDao.getNextArticle(articleId);
        if (article == null) {
            return new ArticleLiteDto(-1, "这已经是最后一篇了");
        } else {
            return article;
        }
    }

    //增加了redis对文章详情缓存
    public OperationResult<ArticleDto> getArticleById(int articleId) {
        OperationResult<ArticleDto> or = new OperationResult<ArticleDto>();

        ArticleDto article = redisDao.getArticleByIdInCache(articleId);
        if (article == null) {
            article = articleDao.getArticleById(articleId);
            if (article == null) {
                or.setSuccess(false);
                or.setInfo("该文章不存在");
            } else {
                redisDao.saveArticleInCache(article);
                or.setSuccess(true);
                or.setData(article);
            }
        }
        return or;
    }

    public List<ArticleDto> getArticles() {
        return articleDao.getArticles();
    }

    public List<ArticleLiteDto> getArticlesByCategoryId(int categoryId) {
        return articleDao.getArticlesByCategoryId(categoryId);
    }

    public List<ArticleLiteDto> getRecentArticles() {
        return articleDao.getRecentArticlesTitle();
    }

    public List<ArticleLiteDto> getMostViewedArticles() {
        return articleDao.getArticlesByClicks();
    }

    public OperationResult updateArticle(Article article) {
        OperationResult or = new OperationResult();
        int result = articleDao.updateArticle(article);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("修改失败");
        } else {
            or.setSuccess(true);
            or.setInfo("修改成功");
        }
        return or;
    }

    public OperationResult saveArticle(Article article) {
        OperationResult or = new OperationResult();
        int result = articleDao.saveArticle(article);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("保存失败");
        } else {
            or.setSuccess(true);
            or.setInfo("保存成功");
        }
        return or;
    }

    public OperationResult deleteArticle(int articleId) {
        OperationResult or = new OperationResult();
        int result = articleDao.deleteArticle(articleId);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("删除失败");
        } else {
            or.setSuccess(true);
            or.setInfo("删除成功");
        }
        return or;
    }

    public OperationResult addClicks(int articleId) {
        OperationResult or = new OperationResult();
        int result = articleDao.addClicks(articleId);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("点击量增加失败");
        } else {
            or.setSuccess(true);
            or.setInfo("点击量增加成功");
        }
        return or;
    }

    public int countArticleNum() {
        return articleDao.countArticleNum();
    }

}
