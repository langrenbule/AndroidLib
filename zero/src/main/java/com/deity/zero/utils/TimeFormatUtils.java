package com.deity.zero.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * 时间格式化
 * Created by fengwenhua on 2016/6/3.
 */
public class TimeFormatUtils {
    /**毫秒级*/
    public static SimpleDateFormat mFormat_yyyyMMddHHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA);
    /**秒级*/
    public static SimpleDateFormat mFormat_yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
    /**yyyy-MM-dd-HH:mm:ss*/
    public static SimpleDateFormat mFormat_yyyy_MM_dd_HHmmss = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.CHINA);
    /**包含星期几 2016-6-3 周五 09:20:53*/
    public static SimpleDateFormat mFormat_chineseTimeWhithWeek = new SimpleDateFormat("yyyy-MM-dd E HH:mm:ss", Locale.CHINA);
    /**yyyyMMdd*/
    public static SimpleDateFormat mFormat_yyyyMMdd = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);

}
