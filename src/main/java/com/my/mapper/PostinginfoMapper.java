package com.my.mapper;

import com.my.pojo.Postinginfo;
import com.my.pojo.Questioninfo;
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
public interface PostinginfoMapper {
    int addPosting(Postinginfo postinginfo);
    List<Postinginfo> findByUserid(int userid);
    int delPosting(int postingid);
    int updatePosting(Postinginfo postinginfo);
    int addGood(int postingid);
}