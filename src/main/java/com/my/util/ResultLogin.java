package com.my.util;

/**
 * ClassName:ResultLogin
 * Package:com.note.po
 * <p>
 * Order:登录返回状态码
 *
 * @Date:2022/3/20 17:55;
 * @auther:guoyuan
 */
public class ResultLogin<T> {
    private Integer code;
    private String msg;
    private T result;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultLogin{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", result=" + result +
                '}';
    }
}
