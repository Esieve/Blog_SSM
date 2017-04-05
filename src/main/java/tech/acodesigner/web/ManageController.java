package tech.acodesigner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import tech.acodesigner.dto.ArticleDto;
import tech.acodesigner.dto.CategoryDto;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.Article;
import tech.acodesigner.service.ArticleService;
import tech.acodesigner.service.CategoryService;
import tech.acodesigner.util.ImagesUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by 77239 on 2017/4/4/0004.
 */
@Controller
@RequestMapping("/manage")
public class ManageController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public String showManageView(Model model) {
        model.addAttribute("mainPage", "manageView.jsp");
        return "manage/manage";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    public String showArticleList(Model model) {
        List<ArticleDto> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
        model.addAttribute("mainPage", "article.jsp");
        return "manage/manage";
    }

    @RequestMapping(value = {"/article/write", "/article/modify/{articleId}"}, method = RequestMethod.GET)
    public String editArticle(@PathVariable("articleId") Integer articleId, HttpServletRequest request, Model model) {
        if (articleId != null) {
            OperationResult<ArticleDto> result = articleService.getArticleById(articleId);
            if (result.isSuccess()) {
                model.addAttribute("article", result.getData());
            } else {
                //TODO
            }
        }

        List<CategoryDto> categories = categoryService.getCategories();
        model.addAttribute("categories", categories);

        String[] images = ImagesUtil.getImages(request.getServletContext().getRealPath("images/article"));
        model.addAttribute("images", images);

        model.addAttribute("mainPage", "articleEditor.jsp");
        return "manage/manage";
    }

    @RequestMapping(value = "/article/save/{articleId}", method = RequestMethod.POST)
    public String saveArticle(@PathVariable("articleId") Integer articleId, HttpServletRequest request, Model model) {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String categoryId = request.getParameter("categoryId");
        String image = request.getParameter("image");
        Article article = new Article(Integer.parseInt(request.getParameter("categoryId")), request.getParameter("title"),
                request.getParameter("content"), request.getParameter("image"));
        if (articleId == null) {
            OperationResult result = articleService.saveArticle(article);
            if (result.isSuccess()) {

            } else {

            }
        } else {
            article.setClicks(articleService.getArticleById(articleId).getData().getClicks());
            article.setArticleId(articleId);
            OperationResult result = articleService.updateArticle(article);
            if (result.isSuccess()) {

            } else {

            }
        }
        model.addAttribute("mainPage", "article.jsp");
        return "manage/manage";
    }

    @RequestMapping(value = "/article/delete/{articleId}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable("articleId") Integer articleId, Model model) {
        if (articleId == null) {
            //TODO
        } else {
            OperationResult result = articleService.deleteArticle(articleId);
            if (result.isSuccess()) {

            } else {
                //TODO
            }
        }
        model.addAttribute("mainPage", "article.jsp");
        return "manage/manage";
    }
}
