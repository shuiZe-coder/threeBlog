package org.three.ourblog.type.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.three.ourblog.type.pojo.TType;
import org.three.ourblog.type.service.TTypeService;
import org.three.ourblog.uitls.RespUtil;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
@RestController
@RequestMapping("/type")
public class TTypeController {
    @Autowired
    private TTypeService typeService;

    @GetMapping
    public RespUtil getAllBlogType(){
        List<TType> types = typeService.list(null);
        return RespUtil.ok().data("data", types);
    }
}

