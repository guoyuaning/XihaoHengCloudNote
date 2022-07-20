package com.my.service;

import com.my.pojo.Usermsginfo;

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

public interface UsermsginfoService {
    int addUsermsg(int id);
    Usermsginfo findbyid(int id);
    int upateusermsg(Usermsginfo usermsginfo);
    int delupdate(int id);
}
