package com.my.mapper;

import com.my.pojo.Usermsginfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface UsermsginfoMapper {
    int addUsermsg(int id);
    Usermsginfo findbyid(int id);
    int upateusermsg(Usermsginfo usermsginfo);
    int delupdate(int id);
}
