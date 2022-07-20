package com.my.service;

import com.my.pojo.Packageinfo;

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

public interface PackageinfoService {
    int addPackage(Packageinfo packageinfo);
    int updantePackage(Packageinfo packageinfo);
    List<Packageinfo> findByUserid(int userid);
    int deletePackageById(int packageid);
}
