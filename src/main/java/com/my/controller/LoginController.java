package com.my.controller;


import com.my.pojo.Userinfo;
import com.my.service.UserinfoService;
import com.my.service.UsermsginfoService;
import com.my.util.ResultLogin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


@Controller
public class    LoginController {
    @Autowired
    private UserinfoService userinfoService;
    @Autowired
    private UsermsginfoService usermsginfoService;

    //验证登录信息是否正确
    @RequestMapping( "/user/tlogin")
    public String login(String username, String password, Model model , HttpServletRequest request, HttpServletResponse response){
        //获取当前的用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try {
                subject.login(token);
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "user/login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "user/login";
        }
        request.getSession().setAttribute("username",username);
        List<Userinfo> userinfos = userinfoService.selectByUsername(username);
        Userinfo userinfo = userinfos.get(0);
        request.getSession().setAttribute("userid",userinfo.getUserid());
        return "redirect:/tomain";
    }

    //添加注册用户信息
    @RequestMapping(value = "/user/registered")
    public String registenrd( Userinfo userinfo, String code, String password1,HttpServletRequest request, HttpServletResponse response,Model model){
        System.out.println("进入注册service！");

        //邮箱验证码，判断是否正确
        String Emailcode = (String) request.getSession().getAttribute(code);
        if(code.equals(Emailcode)){
        }else{
            model.addAttribute("msg","验证码输入错误，请一分钟后重试");
            return("user/login");
        }
        request.getSession().removeAttribute("");
        //增加用户
        ResultLogin resultSet = userinfoService.addUser(userinfo,code,password1);

        //判断service是否试下成功
        if(resultSet.getCode().equals(1)){
            System.out.println("service执行成功");
            request.getSession().setAttribute("username",userinfo.getUsername());
            model.addAttribute("username",userinfo.getUsername());
            List<Userinfo> userinfos = userinfoService.selectByUsername(userinfo.getUsername());
            Userinfo userinfo0 = userinfos.get(0);
            usermsginfoService.addUsermsg(userinfo0.getUserid());
            request.getSession().setAttribute("userid",userinfo0.getUserid());
            return "redirect:/tomain";
        }else{
            System.out.println("service执行失败");
            model.addAttribute("msg",resultSet.getMsg());
            return "user/login";
        }
    }

    //查找是否已经存在该用户名
    @RequestMapping(value = "/user/selectByUsername")
    @ResponseBody
    public Map<String,Object> yanUsername(String username){
        Map<String,Object> map = new HashMap<String,Object>();
        List<Userinfo> list = userinfoService.selectByUsername(username);
        if(username.length() < 8){
            map.put("userExsit",true);
            map.put("msg","账号不得低于8位！");
            return map;
        }
        if(list.isEmpty()){
            map.put("userExsit",false);
            map.put("msg","The account can be used");
        }else {
            map.put("userExsit",true);
            map.put("msg","该账号已被占用！");
        }
        return map;
    }

    //验证密码是否符合规则
    @RequestMapping(value = "/user/yanPassword")
    @ResponseBody
    public Map<String,Object> yanPassword(String password){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultLogin<String> lg = userinfoService.chickPassword(password);
        if(lg.getCode().equals(0)){
            map.put("userExsit",false);
            map.put("msg",lg.getMsg());
        }else {
            map.put("userExsit",true);
            map.put("msg",lg.getMsg());
        }
        return map;
    }
    //验证密码是否符合规则
    @RequestMapping(value = "/user/for")
    @ResponseBody
    public String foregin(Userinfo userinfo,String yzm){
        List<Userinfo> list = userinfoService.selectByUsername(userinfo.getUsername());
        Userinfo userinfo1 = list.get(0);
        System.out.println(userinfo);
        System.out.println(yzm);
        if(userinfo.getEmail() == userinfo1.getEmail()){

        }else {
            return "用户名和邮箱不匹配，请稍后重试";
        }
        return "修改成功";
    }

    //向邮箱发送验证码
    @ResponseBody
    @RequestMapping(value = "/user/doEmail")
    public Map<String,Object> yanEmail(String email ,HttpSession session){
        System.out.println("进入"+email+"邮箱验证");
        Map<String,Object> map = new HashMap<String,Object>();
        String code = "";
        String[] letters = new String[]{
                "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "a", "s", "d", "f", "g", "h", "j", "k", "l", "z", "x", "c", "v", "b", "n", "m",
                "A", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M",
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(letters[(int) Math.floor(Math.random() * letters.length)]);
        }

        //获取6位随机验证码（中文），根据项目需要选择中英文
        code = String.valueOf(new Random().nextInt(899999) + 100000);
        System.out.println("验证码已生成"+email + " " + code);
        session.setAttribute("code" ,code);
        System.out.println("已上传session");
        if(userinfoService.sendMailCode(email,code)){
            map.put("userExsit",true);
            map.put("msg","发送成功");
        }else{
            map.put("msg","发送失败");
            map.put("userExsit",false);
        }
        System.out.println("发送over");
        return map;
    }

    //用户退出
    @RequestMapping(value = "/exit")
    public String userExit(HttpServletRequest request, HttpServletResponse response,Model model){
        System.out.println("进入exit");
        //销毁session对象
        request.getSession().removeAttribute("username");
        model.addAttribute("msg","用户退出成功！");
        System.out.println("执行完毕");
        return "user/login";
    }
}