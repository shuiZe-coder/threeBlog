package org.three.ourblog.blog.service;

import org.three.ourblog.blog.pojo.TBlog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.three.ourblog.blog.pojo.vo.BlogDescription;
import org.three.ourblog.blog.pojo.vo.BlogInfoVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
public interface TBlogService extends IService<TBlog> {

    List<TBlog> selectByInfo(BlogInfoVo blogInfoVo, long current, long limit);

    List<BlogDescription> selBlogDescription(List<TBlog> blogs);
}
