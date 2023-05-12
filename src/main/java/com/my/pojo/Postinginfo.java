package com.my.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname postinginfo
 * @Description TODO
 * @Date 2022/5/15 16:55
 * @Created by GuoYuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Postinginfo {
    private int postingid;
    private int userid;
    private String username;
    private String date;
    private String content;
    private int good;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;//创建时间

}
