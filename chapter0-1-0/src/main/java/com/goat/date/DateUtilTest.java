package com.goat.date;

import org.junit.Test;


import java.text.ParseException;

/**
     * @Description:  排班
     * @author: 杨帆
     * @Param:
     * @Return:
     * @Date:   2018/9/27
*/
public class DateUtilTest {



    @Test
    public void test() throws ParseException {
        System.out.println(DateUtil.scheduling("20181209","20181213"));
    }


    @Test
    public void tes1t()   {
        String temp = WeekUtil.getLastYearFirstDayOfWeek("2018","30",0);
        System.out.println(temp);
    }

}
