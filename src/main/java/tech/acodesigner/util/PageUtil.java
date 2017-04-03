package tech.acodesigner.util;

/**
 * Created by 77239 on 2017/2/19/0019.
 */
public class PageUtil {

    private int page;
    private int pageSize;
    private int start;

    public PageUtil(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.start = (page - 1) * pageSize;
    }

}
