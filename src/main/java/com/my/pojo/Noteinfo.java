package com.my.pojo;

/**
 * @Classname noteinfo
 * @Description TODO
 * @Date 2022/4/11 18:29
 * @Created by GuoYuan
 */
public class Noteinfo {
    private Integer noteid;
    private Integer userid;
    private Integer packageid;
    private String title;
    private String content;
    private String secrecy;

    public Integer getNoteid() {
        return noteid;
    }

    public void setNoteid(Integer noteid) {
        this.noteid = noteid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPackageid() {
        return packageid;
    }

    public void setPackageid(Integer packageid) {
        this.packageid = packageid;
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

    public String getSecrecy() {
        return secrecy;
    }

    public void setSecrecy(String secrecy) {
        this.secrecy = secrecy;
    }

    @Override
    public String toString() {
        return "Noteinfo{" +
                "noteid=" + noteid +
                ", userid=" + userid +
                ", packageid=" + packageid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", secrecy='" + secrecy + '\'' +
                '}';
    }
}
