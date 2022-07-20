package com.my.mapper;

import com.my.pojo.Packageinfo;
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
public interface PackageinfoMapper {
    int addPackage(Packageinfo packageinfo);
    int updantePackage(Packageinfo packageinfo);
    List<Packageinfo> findByUserid(int userid);
    int deletePackageById(int packageid);
}