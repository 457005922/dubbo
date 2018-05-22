package com.dubbo.consumer.web;

import com.dubbo.api.UserService;
import com.dubbo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述:
 *
 * @author hubugui
 * @version 0.1
 * @email hubugui@izjjf.cn
 * @since  2018/5/21
 */
@Controller
@RequestMapping("/welcome")
public class WelComeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String sayHello(String name,Model model) {
        String welcome = userService.sayHi(name);
        model.addAttribute("welcome",welcome);
        return "welcome";
    }


    @RequestMapping("/get")
    public String get(Model model) {
        User welcome = userService.select();
        model.addAttribute("user",welcome);
        return "welcome";
    }
}
