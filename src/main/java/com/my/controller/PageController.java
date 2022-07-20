package com.my.controller;

import com.my.pojo.Noteinfo;
import com.my.pojo.Packageinfo;
import com.my.service.PackageinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Classname PageController
 * @Description TODO
 * @Date 2022/4/16 16:20
 * @Created by GuoYuan
 */
@Controller
public class PageController {

    @Autowired
    PackageinfoService packageinfoService;
    @RequestMapping("/tomain")
    public Object main(HttpServletRequest request, HttpServletResponse response, Model model){
        Object stringid = request.getSession().getAttribute("userid");
        String username = (String) request.getSession().getAttribute("username");
        int id = Integer.parseInt(stringid.toString());
        List<Packageinfo> list = packageinfoService.findByUserid(id);
        model.addAttribute("list",list);
        model.addAttribute("username",username);
        return "main";
    }
    @RequestMapping("/tomain1")
    public String tomain1(){
        return "main";
    }
    @RequestMapping("/toqqq")
    public String qqq(){
        return "qqq";
    }
    @RequestMapping("/toquestion")
    public String question(){
        return "question";
    }
    @RequestMapping("/toshow")
    public String show(Model model,HttpServletRequest request, HttpServletResponse response){
        Noteinfo noteinfo = (Noteinfo) request.getSession().getAttribute("noteinfo");
        model.addAttribute(noteinfo);
        return "show";
    }
    @RequestMapping("/tostarted")
    public String started(){
        return "started";
    }
    @RequestMapping("/toLogin")
    public String login(){
        System.out.println("进入toLogin");
        return "user/login";
    }
    @RequestMapping("/toinfosetting")
    public String infosetting(){
        return "user/infosetting";
    }
    @RequestMapping("/toaddpackage")
    public String to(){
        return "note/addpackage";
    }
    @RequestMapping("/toEmpty")
    public String toempty(){
        return "note/empty";
    }
    @RequestMapping("/toAddNote")
    public String toAddNote(){
        return "note/addnote";
    }
    @RequestMapping("/toforget")
    public String toForPas(){
        return "user/forget";
    }
    @RequestMapping(value = "/tonot", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String tonot(){
        return "没有该权限";
    }
    @RequestMapping("/toShare")
    public String toShare(){
        return "/share";
    }
}
