package org.three.ourblog.blog.pojo.vo;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class BlogDescription {
    private Long id;
    private String title;
    private String type;
    private Boolean shareStatement;
    private Date updateTime;
}
