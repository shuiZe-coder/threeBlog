package org.three.ourblog.blog.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import org.three.ourblog.blog.pojo.TBlog;
import org.three.ourblog.blog.pojo.vo.BlogDescription;
import org.three.ourblog.blog.pojo.vo.BlogInfoVo;
import org.three.ourblog.blog.service.TBlogService;
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
@RequestMapping("/blog")
public class TBlogController {
    @Autowired
    private TBlogService blogService;

    @GetMapping("/all")
    public RespUtil all(){
        List<BlogDescription> blogs = blogService.selBlogDescription(null);
        return RespUtil.ok().data("data", blogs);
    }

    @GetMapping("/{current}/{limit}")
    public RespUtil blogByPage(@PathVariable long current, @PathVariable long limit){
        Page<TBlog> page = new Page<>(current, limit);
        blogService.page(page);
        List<BlogDescription> bds = blogService.selBlogDescription(page.getRecords());
        return RespUtil.ok().data("data", bds);
    }

    @PostMapping("/{current}/{limit}")
    public RespUtil selectByInfo(@PathVariable long current, @PathVariable long limit,
                                 @RequestBody(required = false) BlogInfoVo blogInfoVo){
        List<TBlog> blogs = blogService.selectByInfo(blogInfoVo, current, limit);
        List<BlogDescription> bds = blogService.selBlogDescription(blogs);
        return RespUtil.ok().data("data", bds);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public RespUtil delBlog(@PathVariable long id){
        boolean isTrue = blogService.removeById(id);
        if (isTrue){
            return RespUtil.ok().message("删除博客成功");
        }else{
            return RespUtil.error().message("删除博客失败");
        }
    }

    @PostMapping
    @Transactional
    public RespUtil addBlog(@RequestBody TBlog blog){
        boolean save = blogService.save(blog);
        if (save){
            return RespUtil.ok().message("添加博客成功");
        }else{
            return RespUtil.error().message("添加博客失败");
        }
    }

    @PutMapping
    @Transactional
    public RespUtil updateBlog(@RequestBody TBlog blog){
        boolean update = blogService.update(blog, null);
        if (update){
            return RespUtil.ok().message("修改博客成功");
        }else{
            return RespUtil.error().message("修改博客失败");
        }
    }

    @PostMapping("/content")
    public RespUtil content(TBlog blog){
        return RespUtil.ok().data("data", blog);
    }
}

