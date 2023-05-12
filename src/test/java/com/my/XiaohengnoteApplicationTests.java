//package com.my;
//
//import com.my.pojo.Noteinfo;
//import com.my.service.NoteinfoService;
//import com.my.service.UserinfoService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSenderImpl;
//import org.springframework.mail.javamail.MimeMessageHelper;
//
//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;
//import java.io.File;
//import java.util.HashMap;
//import java.util.List;
//
//@SpringBootTest
//class XiaohengnoteApplicationTests {
//
//    @Autowired
//    JavaMailSenderImpl mailSender;
//    @Autowired
//    private UserinfoService userinfoService;
//    @Autowired
//    private NoteinfoService noteinfoService;
//
//    //一个简单的邮件发送
//    @Test
//    void t1(){
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setSubject("测试文件");
//        mailMessage.setText("测试内容，无需回复！");
//        mailMessage.setTo("2576709493@qq.com");
//        mailMessage.setFrom("xiaoyuyunnote@163.com");
//        mailSender.send(mailMessage);
//    }
//
//    //一个复杂的的邮件发送
//    @Test
//    void t2() throws MessagingException {
//        MimeMessage mailMessage = mailSender.createMimeMessage();
//        //组件
//        MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true);
//
//        helper.setSubject("测试文件");
//        helper.setText("<p style='color:red'>测试发送附件</p>",true);
//
//        //附件
//        helper.addAttachment("1.jpg",new File("C:\\Users\\gy\\Pictures\\Camera Roll\\home1.jpg"));
//
//        helper.setTo("2576709493@qq.com");
//        helper.setFrom("xiaoyuyunnote@163.com");
//        mailSender.send(mailMessage);
//    }
//
//    @Test
//    void t3(){
//        userinfoService.sendMailCode("2576709493@qq.com","111111");
//    }
//
//    @Test
//    void t4(){
//        List<Noteinfo> lis = noteinfoService.findByPackageid(7);
//        lis.forEach(item-> System.out.println(item));
//    }
//
//    @Test
//    void t5(){
//       Noteinfo noteinfo = new Noteinfo();
//       noteinfo.setNoteid(1);
//       noteinfo.setTitle("第一个笔记");
//       noteinfo.setContent("<p>9999</p>");
//       int flag = noteinfoService.updanteNote(noteinfo);
//        System.out.println(flag);
//    }
//
//    @Test
//    void t6(){
//        int a = t7(17);
//        System.out.println(a);
//    }
//
//    @Test
//    int t7(int cap){
//        int MAXIMUM_CAPACITY = 100000000;
//        int n = cap - 1;
//        n |= n >>> 1;
//        n |= n >>> 2;
//        n |= n >>> 4;
//        n |= n >>> 8;
//        n |= n >>> 16;
//        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
//    }
//}
