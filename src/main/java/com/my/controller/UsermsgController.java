package com.my.controller;

import com.my.pojo.Usermsginfo;
import com.my.service.UsermsginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Classname UsermsgController
 * @Description TODO
 * @Date 2022/4/16 23:43
 * @Created by GuoYuan
 */
@Controller
public class UsermsgController {
    @Autowired
    UsermsginfoService usermsginfoService;
    @RequestMapping("/usermsg/update")
    public String update(Usermsginfo usermsginfo){
        String off = usermsginfo.getSwh();
        if(off == "on"){

        }else {
            usermsginfo.setSwh("off");
        }
        System.out.println(usermsginfo);
        usermsginfoService.upateusermsg(usermsginfo);
        return "redirect:/usermsg/show";

    }
    @RequestMapping("/usermsg/show")
    public String showmsg(HttpServletRequest request, HttpServletResponse response,Model model){
        Object stringid = request.getSession().getAttribute("userid");
        int id = Integer.parseInt(stringid.toString());
        Usermsginfo usermsginfo = usermsginfoService.findbyid(id);
        model.addAttribute("usermsginfo",usermsginfo);
        return "user/infosetting";
    }
}
