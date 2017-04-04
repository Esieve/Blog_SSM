package tech.acodesigner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.entity.User;
import tech.acodesigner.service.UserService;
import tech.acodesigner.util.ImagesUtil;
import tech.acodesigner.util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = {RequestMethod.GET})
    public String showRegisterView(HttpServletRequest request, Model model) {
        String[] images = ImagesUtil.getImages(request.getServletContext().getRealPath("images/user"));
        model.addAttribute("images", images);
        model.addAttribute("mainPage", "registerCard.jsp");
        return "login/login";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, RedirectAttributes attributes) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        User user = new User(request.getParameter("username"),
                MD5Util.encoderPassword(request.getParameter("password")), request.getParameter("image"));
        OperationResult result = userService.registerUser(user);
        attributes.addFlashAttribute("info", result.getInfo());
        if (result.isSuccess()) {
            return "redirect:/login";
        } else {
            return "redirect:/register";
        }
    }

}
