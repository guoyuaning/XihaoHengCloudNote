//package com.my;
//
//import com.my.mapper.PackageinfoMapper;
//import com.my.mapper.UsermsginfoMapper;
//import com.my.pojo.Packageinfo;
//import com.my.pojo.Usermsginfo;
//import com.my.service.PackageinfoService;
//import com.my.service.UsermsginfoService;
//import com.my.util.TimeUtil;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
///**
// * @Classname TestUsermsginfo
// * @Description TODO 测试usermsginfo mybatis语句
// * @Date 2022/4/17 10:21
// * @Created by GuoYuan
// */
//@SpringBootTest
//public class TestUsermsginfo {
//
//    @Autowired
//    UsermsginfoService usermsginfoService;
//    @Autowired
//    PackageinfoService packageinfoService;
//    @Autowired
//    PackageinfoMapper packageinfoMapper;
//    @Autowired
//    UsermsginfoMapper usermsginfoMapper;
//    //测试修改
//    @Test
//    public void t1(){
//        Usermsginfo usermsginfo = new Usermsginfo();
//        usermsginfo.setUsermsgid(11);
//        usermsginfo.setUserid(11);
//        usermsginfo.setAge(20);
//        usermsginfo.setBirthday("2001-01-25");
//        usermsginfo.setGrade('0');
//        usermsginfo.setNickname("清晨出发");
//        usermsginfo.setSex(1);
//        usermsginfo.setSign("我想和这个世界谈谈");
//        usermsginfo.setSwh("on");
//        int falg = usermsginfoService.upateusermsg(usermsginfo);
//        System.out.println("修改执行结果：" + falg);
//    }
//    //Usermsginfo{usermsgid=0, userid=11, nickname='清晨出发', sex=1, age=0, birthday='201-01-25',
//    // sign='我想和这个世界谈谈', swh='null', grade=0}
//    //测试新建
//    @Test
//    public void t2(){
//        int id = 11;
//        int flag = usermsginfoService.addUsermsg(12);
//        System.out.println("执行结果：" + flag);
//    }
//    //测试查找
//    @Test
//    public void t3(){
//        Usermsginfo usermsginfo = usermsginfoService.findbyid(11);
//        System.out.println(usermsginfo);
//    }
//    //测试删除
//    @Test
//    public void t4(){
//        int falg = usermsginfoService.delupdate(11);
//        System.out.println(falg);
//    }
//
//    @Test
//    public void t5(){
//        System.out.println(usermsginfoMapper.getClass().getName());
//    }
//
//    @Test
//    public void t6(){
//        Packageinfo packageinfo = new Packageinfo();
//        packageinfo.setUserid(1);
//        packageinfo.setPackagename("SpringBoot7");
//        TimeUtil timeUtil = new TimeUtil();
//        String date = timeUtil.getdate();
//        packageinfo.setDate(date);
//        System.out.println(packageinfo);
//        int flag = packageinfoService.addPackage(packageinfo);
//        System.out.println("执行结果:" + flag);
//    }
//
//    @Test
//    public void t7(){
//        System.out.println("开始执行");
//        List<Packageinfo> flag = packageinfoMapper.findByUserid(1);
//        System.out.println("执行结果:" + flag);
//    }
//}