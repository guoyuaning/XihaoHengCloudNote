package com.my.service;

import com.my.pojo.Userinfo;
import com.my.util.ResultLogin;

import java.util.List;

/**
*ClassName:UserinfoService
*Package:com.note.service
*
*Order:
*
*@author HUAWEI
 * @Date:2022/3/23 10:22;
*@auther:guoyuan
*/

public interface UserinfoService {
    ResultLogin<Userinfo> loginChick(String username, String password);
    ResultLogin addUser(Userinfo userinfo, String code, String password1);
    List<Userinfo> selectByUsername(String username);
    List<Userinfo> selectsUserinfos();
    ResultLogin<String> chickPassword(String password);
    Boolean sendMailCode(String mailaddress,String code);

}
