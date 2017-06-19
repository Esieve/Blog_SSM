package tech.acodesigner.service;

import tech.acodesigner.dto.ArticleDto;
import tech.acodesigner.dto.ArticleLiteDto;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.Article;
import tech.acodesigner.util.PageUtil;

import java.util.List;

/**
 * Created by 77239 on 2017/4/2/0002.
 */
public interface ArticleService {

    public List<ArticleDto> searchArticles(String key);

    public List<ArticleDto> pagination(PageUtil pageUtil);

    public ArticleLiteDto getPreArticle(int articleId);

    public ArticleLiteDto getNextArticle(int articleId);

    public OperationResult<ArticleDto> getArticleById(int articleId);

    public List<ArticleDto> getArticles();

    public List<ArticleLiteDto> getArticlesByCategoryId(int categoryId);

    public List<ArticleLiteDto> getRecentArticles();

    public List<ArticleLiteDto> getMostViewedArticles();

    public OperationResult updateArticle(Article article);

    public OperationResult saveArticle(Article article);

    public OperationResult deleteArticle(int articleId);

    public OperationResult addClicks(int articleId);

    public int countArticleNum();

}
