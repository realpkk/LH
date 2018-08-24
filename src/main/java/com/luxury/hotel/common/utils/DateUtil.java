package com.luxury.hotel.common.utils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class DateUtil extends DateUtils{

    public static String[] parsePatterns = {"MM/dd/yyyy","MM-dd-yyyy HH:mm:ss"};

    /**
     *  获取当前MM/dd/yyyy格式日期
     * @return
     */
    public static String getDate(){
        return getDate("MM/dd/yyyy");
    }

    /**
     *  获取自定义时间格式的当前日期
     * @param pattern
     * @return
     */
    public static String getDate(String pattern){
        return DateFormatUtils.format(new Date(),pattern);
    }

    /**
     *  获取明天时间 MM/dd/yyyy
     * @return
     */
    public static String getTomorrowDate(){
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH,1);
        return DateFormatUtils.format(calendar.getTime(),"MM/dd/yyyy");
    }

    /**
     *  将日期转为时间字符串
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date,Object... pattern){
        String formatDate = null;
        if (pattern != null && pattern.length>0){
            formatDate = DateFormatUtils.format(date,pattern[0].toString());
        }else {
            formatDate = DateFormatUtils.format(date,"MM/dd/yyyy");
        }
        return formatDate;
    }

    /**
     *  将时间字符串转为日期
     * @param str
     * @return
     */
    public static Date parseDate(Object str){
        if (str == null){
            return null;
        }
        try{
            return parseDate(str.toString(),parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     *  计算时间段天数差
     * @param startTime
     * @param endTime
     * @return
     */
    public static int timeInterval(Date startTime,Date endTime){
        int interval = (int) ((endTime.getTime()-startTime.getTime()) /(1000 * 3600 * 24));
        return interval;
    }

    /**
     *  解析前台时间插件 获取时间段
     * @param timeRange
     * @return
     */
    public static Date[] timeRangeAnalyze(String timeRange){
        String[] range = timeRange.split(" - ");
        String checkInTimeStr = range[0];
        String checkOutTimeStr = range[1];
        Date checkInTime = DateUtil.parseDate(checkInTimeStr);
        Date checkOutTime = DateUtil.parseDate(checkOutTimeStr);
        Date[] checkDate = {checkInTime,checkOutTime};
        return  checkDate;
    }
}
