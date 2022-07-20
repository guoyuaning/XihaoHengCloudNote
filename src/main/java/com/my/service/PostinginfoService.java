package com.my.service;

import com.my.pojo.Postinginfo;
import com.my.pojo.Questioninfo;

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

public interface PostinginfoService {
    int addPosting(Postinginfo postinginfo);
    List<Postinginfo> findByUserid(int userid);
    int delPosting(int postingid);
    int updatePosting(Postinginfo postinginfo);
    int addGood(int postingid);
}
