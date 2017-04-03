package tech.acodesigner.util;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by 77239 on 2017/2/11/0011.
 */
public class DateUtil {

    public static String formatLong(long date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        return sdf.format(date);
    }
}
