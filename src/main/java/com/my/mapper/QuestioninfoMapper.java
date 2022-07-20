package com.my.mapper;

import com.my.pojo.Questioninfo;
import com.my.pojo.Usermsginfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ClassName:UserinfoDao
 * Package:com.my.note.dao
 * <p>
 * Order:
 *
 * @Date:2022/3/19 20:51;
 * @auther:guoyuan
 */
@Mapper
@Repository
public interface QuestioninfoMapper {
    int addQuestion(Questioninfo questioninfo);
    List<Questioninfo> findbyreply();
    int delQuestion(int questionid);
    int reply(int questionid);
    int executeQuery();
}