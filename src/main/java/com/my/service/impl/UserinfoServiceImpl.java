package com.my.service.impl;

import com.my.mapper.UserinfoMapper;
import com.my.pojo.Userinfo;
import com.my.service.UserinfoService;
import com.my.util.ResultLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserinfoServiceImpl implements UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;
    @Autowired
    JavaMailSenderImpl mailSender;
    @Override
    public ResultLogin loginChick(String username, String password){
        System.out.println("进入登录验证");
        ResultLogin resultLogin = new ResultLogin();
        List<Userinfo> userinfoList = userinfoMapper.selectByUsername(username);
        if(userinfoList.isEmpty()){
            resultLogin.setCode(1);
            resultLogin.setMsg("账号或密码错误，请重新输入！");
            return resultLogin;
        }else{
            Userinfo userinfo = userinfoList.get(0);
            if(password.equals(userinfo.getPassword())){
                resultLogin.setCode(0);
                resultLogin.setMsg("登录成功！");
                resultLogin.setResult(userinfo);
                return resultLogin;
            }else{
                resultLogin.setCode(1);
                resultLogin.setMsg("账号或密码错误，请重新输入！");
                resultLogin.setResult(userinfo);
                return resultLogin;
            }
        }
    }

    @Override
    public ResultLogin<Userinfo> addUser(Userinfo userinfo, String code, String password1) {
        System.out.println("进入service中的add");
        ResultLogin resultLogin = new ResultLogin();

        System.out.println("username:" + userinfo.getUsername() + "  email:" + userinfo.getEmail());
        System.out.println("开始寻找是否有存在的用户名");
        List<Userinfo> list = userinfoMapper.selectByAnyOne(userinfo);
        System.out.println("查找完毕");
        System.out.println("已经获取第一个值");
        //若账号，密码，邮箱为空
        if(userinfo.getUsername()=="" || userinfo.getPassword() =="" || userinfo.getEmail() ==""){
            System.out.println("参数中含有空值，失败");
            resultLogin.setCode(0);
            resultLogin.setMsg("用户名或密码为空，请填写完重试！");
            return  resultLogin;
        }
        System.out.println("参数中没有空值，通过");

        System.out.println(password1);
        System.out.println(userinfo.getPassword());
        //判断两次密码是否正确


        //判断邮箱是否被注册过
        if(list.isEmpty()){
            System.out.println("用户名或邮箱没有被注册过，通过");
        }else {
            System.out.println("用户名或邮箱已经被注册，失败");
            resultLogin.setCode(0);
            resultLogin.setMsg("账号或邮箱已经注册!");
            return resultLogin;
        }

        if(list.isEmpty()){
            System.out.println("用户名不存在，通过");
            //如果用户名不存在
            int falg = userinfoMapper.addUser(userinfo);
            if(falg > 0){
                System.out.println("注册成功");
                resultLogin.setCode(1);
                resultLogin.setResult(userinfo);
                resultLogin.setMsg("注册成功！");
            }else{
                System.out.println("注册失败");
                resultLogin.setCode(0);
                resultLogin.setMsg("注册失败，请稍后重试！");
            }
        }else {
            System.out.println("用户名已经被注册，失败");
            //若用户名已经被注册
            resultLogin.setCode(0);
            resultLogin.setMsg("用户名已被注册，请更换后重试！");
            resultLogin.setResult(userinfo);
        }
        return resultLogin;
    }

    @Override
    public List<Userinfo> selectsUserinfos() {
        List<Userinfo> list = userinfoMapper.selectUserinfos();
        return list;
    }

    @Override
    public List<Userinfo> selectByUsername(String username) {
        List<Userinfo> list = userinfoMapper.selectByUsername(username);
        return list;
    }

    @Override
    public ResultLogin<String> chickPassword(String password) {
        ResultLogin rl = new ResultLogin();
        if(password.length() < 8){
            rl.setCode(0);
            rl.setMsg("密码长度不能低于8位！");
            rl.setResult(password);
        }else{
            if(password.length() >= 16){
                rl.setCode(0);
                rl.setMsg("密码长度不能多余16位！");
                rl.setResult(password);
            }else {
                int count = 0;
                if (password.length() - password.replaceAll("[A-Z]", "").length() > 0)
                {
                    count++;
                }
                if (password.length() - password.replaceAll("[a-z]", "").length() > 0)
                {
                    count++;
                }
                if (password.length() - password.replaceAll("[0-9]", "").length() > 0)
                {
                    count++;
                }
                if (password.replaceAll("[0-9,A-Z,a-z]", "").length() > 0)
                {
                    count++;
                }

                if(count < 3 ){
                    rl.setCode(0);
                    rl.setMsg("密码必须包括大写字母,小写字母，数字，其它符号中的至少三种！");
                    rl.setResult(password);
                }else{
                    rl.setCode(1);
                    rl.setMsg("符合要求");
                    rl.setResult(password);
                }
            }

        }

        return rl;
    }

    public ResultLogin<Userinfo> yanUsername(Userinfo userinfo){
        ResultLogin<Userinfo> rl = new ResultLogin<>();
        //验证用户名是否已经存在
        return rl;
    }

    @Override
    public Boolean sendMailCode(String mailaddress,String code){

        System.out.println("进入");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        System.out.println("新建完毕");
        mailMessage.setSubject("小珩云笔记验证码");
        mailMessage.setText("您的验证码：" + code + "，如非本人操作，请忽略！请勿回复此邮箱");
        mailMessage.setTo(mailaddress);
        mailMessage.setFrom("xiaoyuyunnote@163.com");
        System.out.println("开始发送");
        mailSender.send(mailMessage);
        System.out.println("发送完毕");
        if( 2 > 0){
            return true;
        }
        return false;
    }
}
