package org.three.ourblog.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/admin/type")
public class AdminTypeController {

    @GetMapping("/manage")
    public String showTypeManagePage(){
        return "/admin/types";
    }

    @GetMapping("/add")
    public String showAddTypePage(){
        return "/admin/types-input";
    }
}
