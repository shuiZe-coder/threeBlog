package org.three.ourblog.blog.pojo.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
public class BlogDescription {
    private Long id;
    private String title;
    private String type;
    private Boolean shareStatement;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date updateTime;
    private Boolean published;
}
