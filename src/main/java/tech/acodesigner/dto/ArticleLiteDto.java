package tech.acodesigner.dto;

/**
 * Created by 77239 on 2017/4/1/0001.
 */
public class ArticleLiteDto {

    private int articleId;
    private String title;
    private String pubDate;

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

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
