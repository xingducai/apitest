package com.yuancda.apitest.demo;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

public class DateFormatUtil {


    public static String format(String format) {

        return DateFormatUtils.format(new Date(), format);
    }


}
