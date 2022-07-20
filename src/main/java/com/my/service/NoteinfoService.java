package com.my.service;

import com.my.pojo.Noteinfo;

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

public interface NoteinfoService {
    int addnote(Noteinfo noteinfo);
    int updanteNote(Noteinfo noteinfo);
    List<Noteinfo> findByPackageid(int packageid);
    int deletenoteById(int noteid);
    Noteinfo findByNoteid(int noteid);
}
