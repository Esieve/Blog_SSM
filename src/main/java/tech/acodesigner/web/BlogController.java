package tech.acodesigner.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tech.acodesigner.dto.*;
import tech.acodesigner.entity.Link;
import tech.acodesigner.service.AboutService;
import tech.acodesigner.service.ArticleService;
import tech.acodesigner.service.CategoryService;
import tech.acodesigner.service.LinkService;
import tech.acodesigner.util.PageUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * Created by 张秦遥 on 2017/4/6/0006.
 */
@SuppressWarnings("Since15")
@Controller
@RequestMapping("/blog")
public class BlogController {

    private final static Logger logger = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LinkService linkService;

    @Autowired
    private AboutService aboutService;

    @RequestMapping(method = RequestMethod.GET)
    public String showBlogView(HttpServletRequest request, Model model, @RequestParam(value = "page", required = false) String page,
                               @RequestParam(value = "search", required = false) String search) {
        List<ArticleDto> recentArticles = articleService.pagination(new PageUtil(1, 5));
        request.getServletContext().setAttribute("recentArticles", recentArticles);
        List<Link> links = linkService.getLinks();
        request.getServletContext().setAttribute("links", links);

        if (page == null || page == "") {
            page = "1";
        }
        PageUtil pageUtil = new PageUtil(Integer.parseInt(page), 3);
        List<ArticleDto> articles = null;
        String pageCode = null;
        if (search != null && !search.equals("")) {
            articles = articleService.searchArticles(search);
            pageCode = this.genPagination(articles.size(), Integer.parseInt(page), 3, "&search=" + search);
        } else {
            articles = articleService.pagination(pageUtil);
            int total = articleService.countArticleNum();
            pageCode = this.genPagination(total, Integer.parseInt(page), 3, "");
        }
        model.addAttribute("pageCode", pageCode);
        model.addAttribute("articles", articles);
        model.addAttribute("mainPage", "article.jsp");
        return "blog/blog";
    }

    private String genPagination(int totalNum, int curPage, int pageSize, String search) {
        int totalPage = totalNum % pageSize == 0 ? totalNum / pageSize : totalNum / pageSize + 1;
        StringBuffer pageCode = new StringBuffer();
        pageCode.append("<ul class=\"pagination\">");
        pageCode.append("<li class='waves-effect'><a href='blog?page=1'" + search + "><i class=\"material-icons\">first_page</i></a></li>");
        if (curPage == 1) {
            pageCode.append("<li class=\"disabled\"><a><i class=\"material-icons\">chevron_left</i></a></li>");
        } else {
            pageCode.append("<li class='waves-effect'><a href=\"blog?page=" + (curPage - 1) + search + "\"><i class=\"material-icons\">chevron_left</i></a></li>");
        }
        for (int i = curPage - 2; i <= curPage + 2; i++) {
            if (i < 1 || i > totalPage) {
                continue;
            }
            if (i == curPage) {
                pageCode.append("<li class='active waves-effect'><a href='#'>" + i
                        + "</a></li>");
            } else {
                pageCode.append("<li class='waves-effect'><a href='blog?page=" + i + "'>" + i
                        + "</a></li>");
            }
        }
        if (curPage == totalPage) {
            pageCode.append("<li class='disabled'><a><i class=\"material-icons\">chevron_right</i></a></li>");
        } else {
            pageCode.append("<li class='waves-effect'><a href='blog?page=" + (curPage + 1) + search
                    + "'><i class=\"material-icons\">chevron_right</i></a></li>");
        }
        pageCode.append("<li class='waves-effect'><a href='blog?page=" + totalPage + search + "'><i class=\"material-icons\">last_page</i></a></li>");
        pageCode.append("</ul>");
        return pageCode.toString();
    }

    //文章详情页的展示
    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public String showArticleView(@PathVariable("articleId") int articleId, Model model, RedirectAttributes attributes) {
        OperationResult<ArticleDto> articleResult = articleService.getArticleById(articleId);
        if (articleResult.isSuccess()) {
            OperationResult addClickResult = articleService.addClicks(articleId);
            if (addClickResult.isSuccess() == false) {
                logger.error("add click error.\tarticle:%s", articleId);
            }
            ArticleLiteDto preArticle = articleService.getPreArticle(articleId);
            ArticleLiteDto nextArticle = articleService.getNextArticle(articleId);
            model.addAttribute("articleId", articleId);
            model.addAttribute("article", articleResult.getData());
            model.addAttribute("preArticle", preArticle);
            model.addAttribute("nextArticle", nextArticle);
            model.addAttribute("mainPage", "articleDetail.jsp");
            return "blog/blog";
        } else {
            attributes.addFlashAttribute("info", articleResult.getInfo());
            return "redirect:/blog";
        }
    }

    //类别列表的展示
    @RequestMapping(value = {"/category", "/category/{categoryId}"}, method = RequestMethod.GET)
    public String showCategoryView(@PathVariable("categoryId") Optional<Integer> categoryId, Model model) {
        List<CategoryDto> categories = categoryService.getCategories();
        HashMap<Integer, List<ArticleLiteDto>> articlesList = new HashMap<Integer, List<ArticleLiteDto>>();
        for (CategoryDto category : categories) {
            List<ArticleLiteDto> articles = articleService.getArticlesByCategoryId(category.getCategoryId());
            articlesList.put(category.getCategoryId(), articles);
        }
        if (categoryId.isPresent()) {
            model.addAttribute("categoryId", categoryId.get());
        } else {
            model.addAttribute("categoryId", "");
        }
        model.addAttribute("categories", categories);
        model.addAttribute("articlesList", articlesList);
        model.addAttribute("mainPage", "category.jsp");
        return "blog/blog";
    }

    //归档列表展示
    @RequestMapping(value = "/archive", method = RequestMethod.GET)
    public String showArchiveView(Model model) {
        List<ArticleDto> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
        model.addAttribute("mainPage", "archive.jsp");
        return "blog/blog";
    }

    //对消息的管理
    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String showMessageView(Model model) {
        model.addAttribute("articleId", 0);
        model.addAttribute("mainPage", "message.jsp");
        return "blog/blog";
    }

    //关于页面的展示
    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAboutView(Model model) {
        AboutDto about = aboutService.getAbout();
        model.addAttribute("about", about);
        model.addAttribute("mainPage", "about.jsp");
        return "blog/blog";
    }
}
