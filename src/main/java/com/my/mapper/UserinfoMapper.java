package com.my.mapper;

import com.my.pojo.Userinfo;
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
public interface UserinfoMapper {
    List<Userinfo> selectByUsername(String username);
    int addUser(Userinfo userinfo);
    List<Userinfo> selectUserinfos();
    List<Userinfo> selectByAnyOne(Userinfo userinfo);
}
