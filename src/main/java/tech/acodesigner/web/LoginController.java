package tech.acodesigner.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tech.acodesigner.dto.OperationResult;
import tech.acodesigner.dto.UserDto;
import tech.acodesigner.entity.User;
import tech.acodesigner.service.UserService;
import tech.acodesigner.util.MD5Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 77239 on 2017/4/3/0003.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = {RequestMethod.GET})
    public String showLoginView(Model model) {
        return "login/login";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String checkUser(HttpServletRequest request, RedirectAttributes attributes) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        HttpSession session = request.getSession();
        User user = new User(request.getParameter("username"), MD5Util.encoderPassword(request.getParameter("password")));
        OperationResult<UserDto> result = userService.checkUser(user);
        if (result.isSuccess()) {
            session.setAttribute("curUser", result.getData());
            if (result.getData().getUserType() == 0) {
                return "redirect:/blog";
            } else {
                return "redirect:/manage";
            }
        } else {
            attributes.addFlashAttribute("info", result.getInfo());
            return "redirect:/login";
        }
    }

}
