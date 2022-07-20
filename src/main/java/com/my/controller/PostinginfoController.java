package com.my.controller;

import com.my.pojo.Postinginfo;
import com.my.service.PostinginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostinginfoController {
    @Autowired
    PostinginfoService postinginfoService;
    @RequestMapping("/postinginfo/add")
    public String add(Postinginfo postinginfo){
        int flag = postinginfoService.addPosting(postinginfo);
        if(flag == 1){
            return "发表成功(YES)";
        }
        return "发送失败(NO)";
    }
    @RequestMapping("/postinginfo/update")
    public String update(Postinginfo postinginfo){
        int flag = postinginfoService.updatePosting(postinginfo);
        if(flag == 1){
            return "修改成功(YES)";
        }
        return "修改失败(NO)";
    }
    @RequestMapping("/postinginfo/delete")
    public String delete(int postingid){
        int flag = postinginfoService.delPosting(postingid);
        if(flag == 1){
            return "发表成功(YES)";
        }
        return "发送失败(NO)";
    }
    @RequestMapping("/postinginfo/findByUserid")
    public List<Postinginfo> findByUserid(int userid){
        List<Postinginfo> list = postinginfoService.findByUserid(userid);
        return list;
    }
}