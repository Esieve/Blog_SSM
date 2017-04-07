package tech.acodesigner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tech.acodesigner.dao.ArticleDao;
import tech.acodesigner.dto.*;
import tech.acodesigner.entity.Category;
import tech.acodesigner.entity.Link;
import tech.acodesigner.service.AboutService;
import tech.acodesigner.service.ArticleService;
import tech.acodesigner.service.CategoryService;
import tech.acodesigner.service.LinkService;
import tech.acodesigner.util.PageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created by 张秦遥 on 2017/4/6/0006.
 */
@SuppressWarnings("Since15")
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

    //博客首页
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String showBlogView(HttpServletRequest request, Model model) {
        List<ArticleLiteDto> recentArticles = articleService.getRecentArticles();
        request.getServletContext().setAttribute("recentArticles", recentArticles);
        //TODO
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

    //文章详情页面
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public String showArticleDetail(@PathVariable("articleId") Integer articleId, Model model, RedirectAttributes attributes) {
        OperationResult<ArticleDto> article = articleService.getArticleById(articleId);
        if (article.isSuccess() == false) {
            attributes.addFlashAttribute("info", article.getInfo());
            return "redirect:/blog";
        }
        articleService.addClicks(articleId);
        ArticleLiteDto preArticle = articleService.getPreArticle(articleId);
        ArticleLiteDto nextArticle = articleService.getNextArticle(articleId);
        // TODO: 2017/4/7/0007
//        ArrayList<MessageDto> comments = MessageDao.getComments(Integer.parseInt(id));
//        model.addAttribute("type", 0);
//        model.addAttribute("replytype", 2);
        model.addAttribute("articleId", articleId);
//        model.addAttribute("pid", articleId);
//        model.addAttribute("messages", comments);
        model.addAttribute("article", article.getData());
        model.addAttribute("preArticle", preArticle);
        model.addAttribute("nextArticle", nextArticle);
        model.addAttribute("mainPage", "articleDetail.jsp");
        return "blog/blog";
    }

    //分类页面
    @RequestMapping(value = {"/category", "/category/{categoryId}"}, method = RequestMethod.GET)
    public String showCategoryView(@PathVariable("categoryId") Optional<Integer> categoryId, Model model) {
        if (categoryId.isPresent()) {
            model.addAttribute("categoryId", categoryId.get().intValue());
        } else {
            model.addAttribute("categoryId", null);
        }
        List<CategoryDto> categories = categoryService.getCategories();
        Map<Integer, List<ArticleLiteDto>> articlesList = new HashMap<Integer, List<ArticleLiteDto>>();
        for (CategoryDto category : categories) {
            List<ArticleLiteDto> articles = articleService.getArticlesByCategoryId(category.getCategoryId());
            articlesList.put(category.getCategoryId(), articles);
        }
        model.addAttribute("categories", categories);
        model.addAttribute("articlesList", articlesList);
        model.addAttribute("mainPage", "category.jsp");
        return "blog/blog";
    }

    //归档页面
    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public String showArchiveView(Model model) {
        List<ArticleDto> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
        model.addAttribute("mainPage", "archive.jsp");
        return "blog/blog";
    }

    //留言页面
    // TODO: 2017/4/7/0007
    //关于页面
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAboutView(Model model, RedirectAttributes attributes) {
        AboutDto about = aboutService.getAbout();
        model.addAttribute("about", about);
        model.addAttribute("mainPage", "about.jsp");
        return "blog/blog";
    }

}
