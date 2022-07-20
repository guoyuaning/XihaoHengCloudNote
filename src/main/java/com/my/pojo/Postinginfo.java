package com.my.pojo;

/**
 * @Classname postinginfo
 * @Description TODO
 * @Date 2022/5/15 16:55
 * @Created by GuoYuan
 */
public class Postinginfo {
    private int postingid;
    private int userid;
    private String username;
    private String date;
    private String content;
    private int good;

    public int getPostingid() {
        return postingid;
    }

    public void setPostingid(int postingid) {
        this.postingid = postingid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    @Override
    public String toString() {
        return "postinginfo{" +
                "postingid=" + postingid +
                ", userid=" + userid +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                ", good=" + good +
                '}';
    }
}
