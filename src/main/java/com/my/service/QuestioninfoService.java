package com.my.service;

import com.my.pojo.Questioninfo;

import java.util.List;

/**
*ClassName:UserinfoService
*Package:com.note.service
*
*Order:
*
*@author HUAWEI
 * @Date:2022/4/17 10:22;
*@auther:guoyuan
*/

public interface QuestioninfoService {
    int addQuestion(Questioninfo questioninfo);
    List<Questioninfo> findbyreply();
    int delQuestion(int questionid);
    int reply(int questionid);
    int executeQuery();
}
