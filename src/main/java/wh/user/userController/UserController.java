
package wh.user.userController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import wh.user.domain.User;
import wh.user.service.UserService;
import wh.util.MD5Util;


@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/getUser")
    public String getUser(HttpServletRequest request, Model model) {
        User user = userService.name();
        model.addAttribute("user", user);
        return "showUser";
    }


    @RequestMapping("/index")
    public String index(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String poString = request.getParameter("pow");
        System.out.println(username + "==============" + poString);
        return "showUser2";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String poString = request.getParameter("pow");
        String pow = MD5Util.getMD5(poString);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, pow);
        try {
            subject.login(token);
            return "showUser2";
        } catch (Exception e) {
            return "unauthorized";
        }
    }
}
