package com.my.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Rutil
 * @Description TODO
 * @Date 2023/5/10 10:43
 * @Created by GuoYuan
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rutil<T> {
    private Integer code;
    private String msg;
    private Integer count;
    private T data;


    public Rutil(Integer count,T data) {
        this.code = 0;
        this.count = count;
        this.data = data;
    }
}
