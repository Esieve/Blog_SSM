package tech.acodesigner.dto;

import tech.acodesigner.entity.Category;

import java.util.Date;

/**
 * Created by 77239 on 2017/4/1/0001.
 */
public class ArticleDto {

    private int articleId;
    private String title;
    private String content;
    private Date pubDate;
    private int clicks;
    private String image;
    private Category category;
    private UserDto user;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pubDate=" + pubDate +
                ", clicks=" + clicks +
                ", image='" + image + '\'' +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
