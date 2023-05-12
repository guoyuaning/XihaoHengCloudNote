package com.my.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname noteinfo
 * @Description TODO
 * @Date 2022/4/11 18:29
 * @Created by GuoYuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Noteinfo {
    private Integer noteid;
    private Integer userid;
    private Integer packageid;
    private String title;
    private String content;
    private String secrecy;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;//创建时间

}
