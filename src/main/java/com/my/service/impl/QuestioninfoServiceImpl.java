package com.my.service.impl;

import com.my.mapper.QuestioninfoMapper;
import com.my.pojo.Questioninfo;
import com.my.service.QuestioninfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname QuestioninfoServiceImpl
 * @Description TODO
 * @Date 2022/4/17 20:34
 * @Created by GuoYuan
 */
@Service
public class QuestioninfoServiceImpl implements QuestioninfoService {
    @Autowired
    QuestioninfoMapper questioninfoMapper;
    @Override
    public int addQuestion(Questioninfo questioninfo) {
        int flag = questioninfoMapper.addQuestion(questioninfo);
        return flag;
    }

    @Override
    public List<Questioninfo> findbyreply() {
        List<Questioninfo> list = questioninfoMapper.findbyreply();
        return list;
    }

    @Override
    public int delQuestion(int questionid) {
        int flag = questioninfoMapper.delQuestion(questionid);
        return flag;
    }

    @Override
    public int reply(int questionid) {
        int flag = questioninfoMapper.reply(questionid);
        return flag;
    }

    @Override
    public int executeQuery() {
        return questioninfoMapper.executeQuery();
    }
}
