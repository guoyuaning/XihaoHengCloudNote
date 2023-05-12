package com.my.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Classname Usermsginfo
 * @Description TODO
 * @Date 2022/4/16 20:20
 * @Created by GuoYuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usermsginfo {
    private int usermsgid;
    private int userid;
    private String nickname;
    //1为男，0为女
    private int sex;
    private int age;
    private String birthday;
    private String sign;
    private String swh;
    private int grade;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;//创建时间

}