package com.my.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.pojo.Questioninfo;
import com.my.pojo.Rutil;
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
    public String selectForQuestion() throws JsonProcessingException {
        int count = questioninfoService.executeQuery();//总条数行
        List<Questioninfo> findbyreply = questioninfoService.findbyreply();
        Rutil<Questioninfo> rutil = new Rutil(count,findbyreply);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(rutil);
    }

}
