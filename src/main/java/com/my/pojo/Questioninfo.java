package com.my.pojo;

/**
 * @Classname Questioninfo
 * @Description TODO
 * @Date 2022/4/17 19:59
 * @Created by GuoYuan
 */
public class Questioninfo {
    private int questionid;
    private int userid;
    private String title;
    private String content;
    private String date;
    private String reply;

    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Questioninfo{" +
                "questionid=" + questionid +
                ", userid=" + userid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date='" + date + '\'' +
                ", reply='" + reply + '\'' +
                '}';
    }
}