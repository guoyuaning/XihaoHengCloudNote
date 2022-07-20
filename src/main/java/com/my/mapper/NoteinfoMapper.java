package com.my.mapper;

import com.my.pojo.Noteinfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname PackageinfoMapper
 * @Description TODO
 * @Date 2022/4/18 10:16
 * @Created by GuoYuan
 */
@Mapper
@Repository
public interface NoteinfoMapper {
    int addnote(Noteinfo noteinfo);
    int updanteNote(Noteinfo noteinfo);
    List<Noteinfo> findByPackageid(int noteid);
    int deletenoteById(int noteid);
    Noteinfo findByNoteid(int noteid);
}