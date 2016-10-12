package df.open.statistic.util.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 说明:
 * <p/>
 * Copyright: Copyright (c)
 * <p/>
 * Company: 江苏千米网络科技有限公司
 * <p/>
 *
 * @author 付亮(OF2101)
 * @version 1.0.0
 * @date 2016/8/24
 */
public class DateUtil {
    private static final String FORMAT = "yyyy-MM-dd HH:mm:ss";


    public static Date getDate() {
        Calendar day = Calendar.getInstance();
        return day.getTime();
    }

    /**
     * 获得当前时间，格式 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getDateString() {
        return getDateString(FORMAT);
    }


    public static String getDateString(String format) {
        Calendar day = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(day.getTime());
    }

    /**
     * 转换时间格式
     *
     * @param date
     * @param format
     * @return
     */
    public static String formatDate(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

}
