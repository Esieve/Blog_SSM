package tech.acodesigner.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tech.acodesigner.dto.AboutDto;
import tech.acodesigner.dto.ArticleDto;
import tech.acodesigner.dto.ArticleLiteDto;
import tech.acodesigner.entity.Article;
import tech.acodesigner.util.DateUtil;
import tech.acodesigner.util.PageUtil;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 77239 on 2017/4/1/0001.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/dao.xml")
public class ArticleDaoTest {

    @Autowired
    private ArticleDao articleDao;

    @Test
    public void getAbout() throws Exception {
        AboutDto about = articleDao.getAbout();
        System.out.println(about.getContent());
    }

    @Test
    public void updateAbout() throws Exception {
        int result = articleDao.updateAbout("hello test");
        System.out.println(result);
    }

    @Test
    public void searchArticles() throws Exception {
        List<ArticleDto> articles = articleDao.searchArticles("2");
        for (ArticleDto article : articles) {
            System.out.println(article.getContent());
        }
    }

    @Test
    public void pagination() throws Exception {
        PageUtil pageUtil = new PageUtil(1, 5);
        List<ArticleDto> articles = articleDao.pagination(pageUtil);
        for (ArticleDto article : articles) {
            System.out.println(article.getContent());
        }
    }

    @Test
    public void getPreArticle() throws Exception {
        ArticleLiteDto article = articleDao.getPreArticle(11);
        System.out.println(article.getTitle());
    }

    @Test
    public void getNextArticle() throws Exception {
        ArticleLiteDto article = articleDao.getNextArticle(11);
        System.out.println(article.getTitle());
    }

    @Test
    public void getArticleById() throws Exception {
        ArticleDto article = articleDao.getArticleById(11);
        System.out.println(article.getContent());
    }

    @Test
    public void getArticles() throws Exception {
        List<ArticleDto> articles = articleDao.getArticles();
        for (ArticleDto article:articles) {
            System.out.println(article.getContent());
        }
    }

    @Test
    public void getArticlesByCategoryId() throws Exception {
        List<ArticleLiteDto> articles = articleDao.getArticlesByCategoryId(13);
        for (ArticleLiteDto article:articles) {
            System.out.println(article.getTitle());
        }
    }

    @Test
    public void updateArticle() throws Exception {
        Article article = new Article();
        article.setArticleId(13);
        article.setCategoryId(13);
        article.setTitle("test2");
        article.setContent("test2");
        article.setImage("test2");
        int result = articleDao.updateArticle(article);
        System.out.println(result);
    }

    @Test
    public void saveArticle() throws Exception {
        Article article = new Article();
        article.setCategoryId(13);
        article.setTitle("test");
        article.setContent("test");
        article.setPubDate(DateUtil.formatLong(System.currentTimeMillis(),"yyyy-MM-dd HH:mm:ss"));
        article.setImage("test");
        int result = articleDao.saveArticle(article);
        System.out.println(result);
    }

    @Test
    public void deleteArticle() throws Exception {
        int result = articleDao.deleteArticle(13);
        System.out.println(result);
    }

    @Test
    public void addClicks() throws Exception {
        int result = articleDao.addClicks(13);
        System.out.println(result);
    }

}