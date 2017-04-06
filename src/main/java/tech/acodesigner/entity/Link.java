package tech.acodesigner.entity;

/**
 * Created by 77239 on 2017/3/28/0028.
 */
public class Link {
    private int linkId;
    private String linkName;
    private String url;

    public Link() {
    }

    public Link(String linkName, String url) {
        this.linkName = linkName;
        this.url = url;
    }

    public Link(int linkId, String linkName, String url) {
        this.linkId = linkId;
        this.linkName = linkName;
        this.url = url;
    }

    public int getLinkId() {
        return linkId;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
