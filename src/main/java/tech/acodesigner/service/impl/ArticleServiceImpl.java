package tech.acodesigner.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.acodesigner.dao.ArticleDao;
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

    public OperationResult<List<ArticleDto>> searchArticles(String key) {
        List<ArticleDto> articles = articleDao.getArticlesByKey(key);
        OperationResult<List<ArticleDto>> op = new OperationResult<List<ArticleDto>>();
        if (articles.size() == 0) {
            op.setSuccess(false);
            op.setInfo("无结果");
        } else {
            op.setSuccess(true);
            op.setData(articles);
        }
        return op;
    }

    public List<ArticleDto> pagination(PageUtil pageUtil) {
        return articleDao.getArticlesByRange(pageUtil);
    }

    public OperationResult<ArticleLiteDto> getPreArticle(int articleId) {
        ArticleLiteDto article = articleDao.getPreArticle(articleId);
        OperationResult<ArticleLiteDto> or = new OperationResult<ArticleLiteDto>();
        if (article == null) {
            or.setSuccess(false);
            or.setInfo("无");
        } else {
            or.setSuccess(true);
            or.setData(article);
        }
        return or;
    }

    public OperationResult<ArticleLiteDto> getNextArticle(int articleId) {
        ArticleLiteDto article = articleDao.getNextArticle(articleId);
        OperationResult<ArticleLiteDto> or = new OperationResult<ArticleLiteDto>();
        if (article == null) {
            or.setSuccess(false);
            or.setInfo("无");
        } else {
            or.setSuccess(true);
            or.setData(article);
        }
        return or;
    }

    public OperationResult<ArticleDto> getArticleById(int articleId) {
        ArticleDto article = articleDao.getArticleById(articleId);
        OperationResult<ArticleDto> or = new OperationResult<ArticleDto>();
        if (article == null) {
            or.setSuccess(false);
            or.setInfo("该文章不存在");
        } else {
            or.setSuccess(true);
            or.setData(article);
        }
        return or;
    }

    public List<ArticleDto> getArticles() {
        return articleDao.getArticles();
    }

    public List<ArticleLiteDto> getArticlesByCategoryId(int categoryId) {
        return articleDao.getArticlesByCategoryId(categoryId);
    }

    public OperationResult updateArticle(Article article) {
        OperationResult or = new OperationResult();
        int result = articleDao.updateArticle(article);
        if (result <= 0) {
            or.setSuccess(false);
            or.setInfo("更新失败");
        } else {
            or.setSuccess(true);
            or.setInfo("更新成功");
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
            or.setInfo("操作失败");
        } else {
            or.setSuccess(true);
            or.setInfo("操作成功");
        }
        return or;
    }
}
