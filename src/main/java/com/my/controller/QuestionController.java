package com.my.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.my.pojo.Questioninfo;
import com.my.service.QuestioninfoService;
import com.my.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @Classname UsermsgController
 * @Description TODO
 * @Date 2022/4/16 23:43
 * @Created by GuoYuan
 */
@Controller
public class QuestionController {
    @Autowired
    QuestioninfoService questioninfoService;
    @RequestMapping("/question/add")
    public String add(HttpServletRequest request, HttpServletResponse response,Questioninfo questioninfo){
        //获取当前用户ID
        Object stringid = request.getSession().getAttribute("userid");
        int id = Integer.parseInt(stringid.toString());
        questioninfo.setUserid(id);
        //获取当前日期
        TimeUtil timeUtil = new TimeUtil();
        String date = timeUtil.getdate();

        questioninfo.setDate(date);
        System.out.println(questioninfo);
        int flag = questioninfoService.addQuestion(questioninfo);
        System.out.println("执行结果：" + flag);
        return "redirect:/toquestion";
    }

    @RequestMapping("/admin/selectAllQuestion")
    @ResponseBody
    public String selectForQuestion(int page,int limit){
        int counts = questioninfoService.executeQuery();//总条数
        int startRow = (page - 1)*limit;//起始行
        return "{\n" +
                "\t\"msg\": \"操作成功！\",\n" +
                "\t\"code\": \"0\",\n" +
                "\t\"data\": [\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 1,\n" +
                "\t\t\t\"name\": \"iPhone\",\n" +
                "\t\t\t\"type\": \"1\",\n" +
                "\t\t\t\"price\": 6000.0,\n" +
                "\t\t\t\"size\": 55,\n" +
                "\t\t\t\"status\": 1,\n" +
                "\t\t\t\"description\": \"说明\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 2,\n" +
                "\t\t\t\"name\": \"watch\",\n" +
                "\t\t\t\"type\": \"1\",\n" +
                "\t\t\t\"price\": 500.0,\n" +
                "\t\t\t\"size\": 35,\n" +
                "\t\t\t\"status\": 1,\n" +
                "\t\t\t\"description\": \"说明\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 3,\n" +
                "\t\t\t\"name\": \"television\",\n" +
                "\t\t\t\"type\": \"1\",\n" +
                "\t\t\t\"price\": 1000.0,\n" +
                "\t\t\t\"size\": 90,\n" +
                "\t\t\t\"status\": 1,\n" +
                "\t\t\t\"description\": \"说明\"\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"id\": 4,\n" +
                "\t\t\t\"name\": \"computer\",\n" +
                "\t\t\t\"type\": \"1\",\n" +
                "\t\t\t\"price\": 4500.0,\n" +
                "\t\t\t\"size\": 60,\n" +
                "\t\t\t\"status\": 1,\n" +
                "\t\t\t\"description\": \"说明\"\n" +
                "\t\t}\n" +
                "\t],\n" +
                "\t\"count\": 4\n" +
                "}";
    }

}
