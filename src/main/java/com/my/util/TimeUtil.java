package com.my.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Classname TimeUtil
 * @Description TODO
 * @Date 2022/4/17 20:51
 * @Created by GuoYuan
 */
public class TimeUtil {
    public String getdate(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        String ans = dateFormat.format(date);
        return ans;
    }
}
