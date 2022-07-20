package com.my.service.impl;

import com.my.mapper.PostinginfoMapper;
import com.my.pojo.Postinginfo;
import com.my.service.PostinginfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Classname PostinginfoServiceImpl
 * @Description TODO
 * @Date 2022/5/15 17:10
 * @Created by GuoYuan
 */
@Service
public class PostinginfoServiceImpl implements PostinginfoService {
    @Autowired
    PostinginfoMapper postinginfoMapper;
    @Override
    public int addPosting(Postinginfo postinginfo) {
        return postinginfoMapper.addPosting(postinginfo);
    }

    @Override
    public List<Postinginfo> findByUserid(int userid) {
        return postinginfoMapper.findByUserid(userid);
    }

    @Override
    public int delPosting(int postingid) {
        return postinginfoMapper.delPosting(postingid);
    }

    @Override
    public int updatePosting(Postinginfo postinginfo) {
        return postinginfoMapper.updatePosting(postinginfo);
    }

    @Override
    public int addGood(int postingid) {
        return postingid;
    }
}
