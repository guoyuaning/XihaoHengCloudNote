package com.my.pojo;

/**
 * @Classname Usermsginfo
 * @Description TODO
 * @Date 2022/4/16 20:20
 * @Created by GuoYuan
 */
public class Packageinfo {
    private int packageid;
    private String packagename;
    private int userid;
    private int secrecy;
    private String date;
    private int order;

    public int getPackageid() {
        return packageid;
    }

    public void setPackageid(int packageid) {
        this.packageid = packageid;
    }

    public String getPackagename() {
        return packagename;
    }

    public void setPackagename(String packagename) {
        this.packagename = packagename;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getSecrecy() {
        return secrecy;
    }

    public void setSecrecy(int secrecy) {
        this.secrecy = secrecy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Packageinfo{" +
                "packageid=" + packageid +
                ", packagename='" + packagename + '\'' +
                ", userid=" + userid +
                ", secrecy=" + secrecy +
                ", date='" + date + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}