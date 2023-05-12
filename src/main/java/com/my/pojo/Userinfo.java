package com.my.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Userinfo {
    private Integer userid;
    private String username;
    private String password;
    private String email;
    private String perms;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createtime;//创建时间
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updatetime;//创建时间

}
