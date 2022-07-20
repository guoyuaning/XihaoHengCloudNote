package com.my.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class AdminController {

    @RequestMapping( "/admin/show")
    @ResponseBody
    public String login(){
        return "Hello";
    }

    @RequestMapping("/admin/showQuestion")
    public String showQuestion(){
        return "admin/question";
    }

}