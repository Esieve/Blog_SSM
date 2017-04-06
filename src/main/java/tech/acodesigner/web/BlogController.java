package tech.acodesigner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.acodesigner.dto.ArticleDto;
import tech.acodesigner.entity.Link;
import tech.acodesigner.service.AboutService;
import tech.acodesigner.service.ArticleService;
import tech.acodesigner.service.CategoryService;
import tech.acodesigner.service.LinkService;
import tech.acodesigner.util.PageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 张秦遥 on 2017/4/6/0006.
 */
@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private AboutService aboutService;

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String showBlogView(HttpServletRequest request, Model model) {
        //TODO
//        List<ArticleLiteDto> recentArticles = articleService.();
//        request.getServletContext().setAttribute("recentArticles", recentArticles);
//        ArrayList<MessageDto> recentMessages = MessageDao.getRecentMessages();
//        request.getServletContext().setAttribute("recentMessages",recentMessages);
        List<Link> links = linkService.getLinks();
        request.getServletContext().setAttribute("links", links);

        String page = request.getParameter("page");
        String search = request.getParameter("search");
        String s_content = request.getParameter("s_content");
        if (page == null || page == "") {
            page = "1";
        }
        PageUtil pageUtil = new PageUtil(Integer.parseInt(page), 3);
        List<ArticleDto> articles = null;
        if (search != null && search.equals("true") && s_content != null && !s_content.equals("")) {
            articles = articleService.searchArticles(s_content);
        } else {
            articles = articleService.pagination(pageUtil);
        }
        int total = articleService.countArticleNum();
        String pageCode = this.genPagination(total, Integer.parseInt(page), 3);
        model.addAttribute("pageCode", pageCode);
        model.addAttribute("articles", articles);
        model.addAttribute("mainPage", "article.jsp");
        return "blog/blog";
    }

    private String genPagination(int totalNum, int curPage, int pageSize) {
        int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        StringBuffer pageCode = new StringBuffer();
        pageCode.append("<ul class=\"pagination\">");
        pageCode.append("<li class='waves-effect'><a href='home?page=1'><i class=\"material-icons\">first_page</i></a></li>");
        if (curPage == 1) {
            pageCode.append("<li class=\"disabled\"><a><i class=\"material-icons\">chevron_left</i></a></li>");
        } else {
            pageCode.append("<li class='waves-effect'><a href=\"home?page=" + (curPage - 1) + "\"><i class=\"material-icons\">chevron_left</i></a></li>");
        }
        for (int i = curPage - 2; i <= curPage + 2; i++) {
            if (i < 1 || i > totalPage) {
                continue;
            }
            if (i == curPage) {
                pageCode.append("<li class='active waves-effect'><a href='#'>" + i
                        + "</a></li>");
            } else {
                pageCode.append("<li class='waves-effect'><a href='home?page=" + i + "'>" + i
                        + "</a></li>");
            }
        }
        if (curPage == totalPage) {
            pageCode.append("<li class='disabled'><a><i class=\"material-icons\">chevron_right</i></a></li>");
        } else {
            pageCode.append("<li class='waves-effect'><a href='home?page=" + (curPage + 1)
                    + "'><i class=\"material-icons\">chevron_right</i></a></li>");
        }
        pageCode.append("<li class='waves-effect'><a href='home?page=" + totalPage + "'><i class=\"material-icons\">last_page</i></a></li>");
        pageCode.append("</ul>");
        return pageCode.toString();
    }

}
