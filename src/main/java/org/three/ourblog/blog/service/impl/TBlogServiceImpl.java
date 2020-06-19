package org.three.ourblog.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.three.ourblog.blog.pojo.TBlog;
import org.three.ourblog.blog.mapper.TBlogMapper;
import org.three.ourblog.blog.pojo.vo.BlogDescription;
import org.three.ourblog.blog.pojo.vo.BlogInfoVo;
import org.three.ourblog.blog.service.TBlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.three.ourblog.type.pojo.TType;
import org.three.ourblog.type.service.TTypeService;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
@Service
public class TBlogServiceImpl extends ServiceImpl<TBlogMapper, TBlog> implements TBlogService {



    @Autowired
    private TTypeService typeService;

    @Override
    public List<TBlog> selectByInfo(BlogInfoVo blogInfoVo, long current, long limit) {
        Page<TBlog> page = new Page<>(current, limit);
        QueryWrapper wrapper = new QueryWrapper();
        if (!StringUtils.isEmpty(blogInfoVo.getTitle())){
            wrapper.like("title", blogInfoVo.getTitle());
        }
        if (blogInfoVo.getTypeId() != null){
            wrapper.eq("type_id", blogInfoVo.getTypeId());
        }
        this.page(page, wrapper);
        return page.getRecords();
    }

    @Override
    public List<BlogDescription> selBlogDescription(List<TBlog> blogs) {
        if (blogs == null) {
            blogs = this.list(null);
        }
        List<BlogDescription> res = new ArrayList<BlogDescription>();
        List<TType> types = typeService.list(null);
        for (TBlog blog: blogs){
            BlogDescription bd = new BlogDescription();
            BeanUtils.copyProperties(blog, bd);
            for (TType blogType: types){
                if (blog.getTypeId() == blogType.getId()){
                    bd.setType(blogType.getName());
                    break;
                }
            }
            res.add(bd);
        }
        return res;
    }


}
