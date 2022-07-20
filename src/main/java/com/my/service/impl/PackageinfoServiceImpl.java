package com.my.service.impl;

import com.my.mapper.PackageinfoMapper;
import com.my.pojo.Packageinfo;
import com.my.service.PackageinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import java.util.List;

/*
 * @Classname PackageinfoServiceImpl
 * @Description TODO
 * @Date 2022/4/19 16:48
 * @Created by GuoYuan
 */
@Component
@Service
public class PackageinfoServiceImpl implements PackageinfoService {
    @Autowired
    PackageinfoMapper packageinfoMapper;
    @Override
    public int addPackage(Packageinfo packageinfo) {
        int flag = packageinfoMapper.addPackage(packageinfo);
        return flag;
    }

    @Override
    public int updantePackage(Packageinfo packageinfo) {
        int flag = packageinfoMapper.updantePackage(packageinfo);
        return flag;
    }

    @Override
    public List<Packageinfo> findByUserid(int userid) {
        List<Packageinfo> list = packageinfoMapper.findByUserid(userid);
        return list;
    }

    @Override
    public int deletePackageById(int packageid) {
        int flag = packageinfoMapper.deletePackageById(packageid);
        return flag;
    }
}
