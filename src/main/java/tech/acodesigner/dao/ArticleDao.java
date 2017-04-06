package tech.acodesigner.dao;

import org.apache.ibatis.annotations.Param;
import tech.acodesigner.dto.AboutDto;
import tech.acodesigner.dto.ArticleDto;
import tech.acodesigner.dto.ArticleLiteDto;
import tech.acodesigner.entity.Article;
import tech.acodesigner.util.PageUtil;

import java.util.List;

/**
 * Created by 77239 on 2017/3/31/0031.
 */
public interface ArticleDao {

    public AboutDto getAbout();

    public int updateAbout(String content);

    public ArticleLiteDto getPreArticle(int articleId);

    public ArticleLiteDto getNextArticle(int articleId);

    public ArticleDto getArticleById(int articleId);

    public List<ArticleDto> getArticles();

    public List<ArticleDto> getArticlesByKey(String key);

    public List<ArticleDto> getArticlesByRange(PageUtil pageUtil);

    public List<ArticleLiteDto> getArticlesByCategoryId(int categoryId);

    public int updateArticle(Article article);

    public int saveArticle(Article article);

    public int deleteArticle(int articleId);

    public int addClicks(int articleId);

    public int countArticleNum();

}
