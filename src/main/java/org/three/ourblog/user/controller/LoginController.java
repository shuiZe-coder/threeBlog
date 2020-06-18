package org.three.ourblog.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.three.ourblog.uitls.RespUtil;
import org.three.ourblog.user.pojo.TUser;
import org.three.ourblog.user.service.TUserService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private TUserService userService;

    @GetMapping("/login")
    public String login(){
        return "/admin/login";
    }

    @PostMapping("/verify")
    @ResponseBody
    public RespUtil verifyUser(TUser user, HttpSession session){
        boolean isTrue = userService.verifyUser(user);
        if (isTrue){
            session.setAttribute("user", user.getUsername());
            return RespUtil.ok().data("verify", "true");
        }else{
            return RespUtil.error().data("verify", "false");
        }
    }
}
