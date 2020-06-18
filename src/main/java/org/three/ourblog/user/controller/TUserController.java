package org.three.ourblog.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.three.ourblog.uitls.RespUtil;
import org.three.ourblog.user.pojo.TUser;
import org.three.ourblog.user.service.TUserService;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuize
 * @since 2020-06-17
 */
@Controller
@RequestMapping("/admin")
public class TUserController {

    @Autowired
    private TUserService userService;

    @GetMapping
    public String index(){
        return "/admin/index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/admin/login";
    }

}