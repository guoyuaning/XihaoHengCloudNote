package com.my.pojo;

/**
 * @Classname Usermsginfo
 * @Description TODO
 * @Date 2022/4/16 20:20
 * @Created by GuoYuan
 */
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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getUsermsgid() {
        return usermsgid;
    }

    public void setUsermsgid(int usermsgid) {
        this.usermsgid = usermsgid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSwh() {
        return swh;
    }

    public void setSwh(String swh) {
        this.swh = swh;
    }

    @Override
    public String toString() {
        return "Usermsginfo{" +
                "usermsgid=" + usermsgid +
                ", userid=" + userid +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birthday='" + birthday + '\'' +
                ", sign='" + sign + '\'' +
                ", swh='" + swh + '\'' +
                ", grade=" + grade +
                '}';
    }
}