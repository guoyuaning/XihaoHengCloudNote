package com.my.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname Questioninfo
 * @Description TODO
 * @Date 2022/4/17 19:59
 * @Created by GuoYuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questioninfo {
    private int questionid;
    private int userid;
    private String title;
    private String content;
    private String date;
    private String reply;
    private String replyContent;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;//创建时间
}