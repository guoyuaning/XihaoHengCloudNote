package com.my.controller;

import com.my.pojo.Packageinfo;
import com.my.service.PackageinfoService;
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
public class PackageController {
    @Autowired
    PackageinfoService packageinfoService;
    @RequestMapping(value = "/package/add", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String add(HttpServletRequest request, HttpServletResponse response, Packageinfo packageinfo){
        //获取当前用户ID
        Object stringid = request.getSession().getAttribute("userid");
        int id = Integer.parseInt(stringid.toString());
        packageinfo.setUserid(id);
        //获取时间
        TimeUtil timeUtil = new TimeUtil();
        String date = timeUtil.getdate();
        packageinfo.setDate(date);
        int flag = packageinfoService.addPackage(packageinfo);
        if(flag == 1){
            return "恭喜，添加成功，开始一段新的旅程吧.(YES)";
        }else{
            return "抱歉，添加失败，请稍后重试.(NO)";
        }
    }
    @RequestMapping("/package/show")
    @ResponseBody
    public List<Packageinfo> findPackage(HttpServletRequest request, HttpServletResponse response){
        int id = (int) request.getSession().getAttribute("userid");
        List<Packageinfo> list = packageinfoService.findByUserid(id);
        return list;
    }
}
