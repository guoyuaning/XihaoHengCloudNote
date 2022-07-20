package com.my.service.impl;

import com.my.mapper.NoteinfoMapper;
import com.my.pojo.Noteinfo;
import com.my.service.NoteinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname NoteinfoServiceImpl
 * @Description TODO
 * @Date 2022/4/20 16:40
 * @Created by GuoYuan
 */
@Service
public class NoteinfoServiceImpl implements NoteinfoService {
    @Autowired
    NoteinfoMapper noteinfoMapper;
    @Override
    public int addnote(Noteinfo noteinfo) {
        int flag = noteinfoMapper.addnote(noteinfo);
        return flag;
    }

    @Override
    public int updanteNote(Noteinfo noteinfo) {
        int flag = noteinfoMapper.updanteNote(noteinfo);
        return flag;
    }

    @Override
    public List<Noteinfo> findByPackageid(int packageid) {
        List<Noteinfo> list = noteinfoMapper.findByPackageid(packageid);
        return list;
    }

    @Override
    public int deletenoteById(int noteid) {
        int flag = noteinfoMapper.deletenoteById(noteid);
        return flag;
    }

    @Override
    public Noteinfo findByNoteid(int noteid) {
        Noteinfo noteinfo = noteinfoMapper.findByNoteid(noteid);
        return noteinfo;
    }
}