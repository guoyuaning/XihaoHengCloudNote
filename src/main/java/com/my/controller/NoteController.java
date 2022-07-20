package com.my.controller;


import com.my.pojo.Noteinfo;
import com.my.service.NoteinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Classname NoteController
 * @Description TODO
 * @Date 2022/4/16 23:47
 * @Created by GuoYuan
 */
@Controller
public class NoteController {
    @Autowired
    NoteinfoService noteinfoService;
    @RequestMapping(value ="/note/add", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String addNote(Noteinfo noteinfo,HttpServletRequest request, HttpServletResponse response){
        noteinfo.setUserid((Integer) request.getSession().getAttribute("userid"));
        noteinfo.setContent("点此输写一段新的旅程吧！");
        int flag = noteinfoService.addnote(noteinfo);
        System.out.println(noteinfo);
        if(flag == 1){
            return "恭喜，添加成功，开始一段新的旅程吧.(YES)";
        }else{
            return "抱歉，添加失败，请稍后重试.(NO)";
        }
    }
    @RequestMapping("/note/findbypackage")
    @ResponseBody
    public List<Noteinfo> findNote(Integer packageid){
        List<Noteinfo> list = noteinfoService.findByPackageid(packageid);
        return list;
    }
    @RequestMapping("/note/show")
    public String noteshow(int noteid, HttpServletRequest request, HttpServletResponse response){
        Noteinfo noteinfo = noteinfoService.findByNoteid(noteid);
        request.getSession().setAttribute("noteinfo",noteinfo);
        return "redirect:/toshow";
    }
    @RequestMapping("/note/update")
    @ResponseBody
    public Integer updateNote(Noteinfo noteinfo){
        int flag = noteinfoService.updanteNote(noteinfo);
        return flag;
    }
    @RequestMapping("/note/delete/{noteid}")
    @ResponseBody
    public Integer delNote(@PathVariable(name = "noteid")int noteid){
        System.out.println("删除笔记ID" + noteid);
        int flag = noteinfoService.deletenoteById(noteid);
        return flag;
    }
}