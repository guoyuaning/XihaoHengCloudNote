package com.my.service.impl;

import com.my.mapper.UsermsginfoMapper;
import com.my.pojo.Usermsginfo;
import com.my.service.UsermsginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UsermsginfoServiceImpl
 * @Description TODO
 * @Date 2022/4/17 10:31
 * @Created by GuoYuan
 */
@Service
public class UsermsginfoServiceImpl implements UsermsginfoService {
    @Autowired
    UsermsginfoMapper usermsginfoMapper;
    @Override
    public int addUsermsg(int id) {
        int flag = usermsginfoMapper.addUsermsg(id);
        return flag;
    }

    @Override
    public Usermsginfo findbyid(int id) {
        Usermsginfo usermsginfo = usermsginfoMapper.findbyid(id);
        return usermsginfo;
    }

    @Override
    public int upateusermsg(Usermsginfo usermsginfo) {
        System.out.println("进入修改");
        int flag = usermsginfoMapper.upateusermsg(usermsginfo);
        System.out.println("修改结果：" + flag);
        return flag;
    }

    @Override
    public int delupdate(int id) {
        int flag = usermsginfoMapper.delupdate(id);
        return flag;
    }
}
