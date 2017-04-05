package tech.acodesigner.entity;

import java.util.Date;

/**
 * Created by 77239 on 2017/4/1/0001.
 */
public class Article {

    private int articleId;
    private int categoryId;
    private int userId;
    private String title;
    private String content;
    private Date pubDate;
    private int clicks;
    private String image;

    public Article() {
    }

    public Article(int categoryId, String title, String content, String image) {
        this.categoryId = categoryId;
        this.title = title;
        this.content = content;
        this.image = image;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
