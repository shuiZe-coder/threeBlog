package org.three.ourblog.blog.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author shuize
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="TBlog对象", description="")
public class TBlog implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private Boolean appreciation;

    private Boolean commentabled;

    private String content;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    private String description;

    private String firstPicture;

    private String flag;

    private Boolean published;

    private Boolean recommend;

    private Boolean shareStatement;

    private String title;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    private Integer views;

    private Long typeId;

    private Long userId;

    private Integer commentCount;
}
