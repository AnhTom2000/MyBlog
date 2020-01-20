package cc.ccocc.utils.date;

import org.springframework.util.StringUtils;

import java.time.Instant;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Created on 19:21  18/01/2020
 * Description:
 * 时间工具类
 *
 * @author Weleness
 */

public class DateUtils {

    /**
     * @Method Description:
     * 例如 2020-1-18
     * @Author weleness
     * @Return
     */
    private static final String DATE = "yyyy-MM-dd";

    private static final String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    private static final String TIME = "HHmmss";

    public static final String TIME_WITHOUT_SECOND = "HH:mm";

    public static final String DATE_TIME_WITHOUT_SECONDS = "yyyy-MM-dd HH:mm";


    /**
     * @param date   date
     * @param patten 格式
     * @Method Description:
     * 格式化日期为字符串
     * @Author weleness
     * @Return
     */

    public static String format(java.util.Date date, String patten) {
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(DateTimeFormatter.ofPattern(patten));
    }

    /**
     * @Method
     * Description:
     *  解析字符串为date
     * @Author weleness
     * @param dateStr 日期字符串
     * @param patten  格式
     * @Return
     */
    public static java.util.Date parse(String dateStr , String patten){
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr,DateTimeFormatter.ofPattern(patten));
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return  Date.from(instant);
    }

    /**
     * LocalDateTime类型转为Date
     *
     * @param localDateTime LocalDateTime object
     * @return Date object
     */
    public static java.util.Date localDateTime2Date(LocalDateTime localDateTime) {
        return  Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取当前日期
     *
     * @param pattern 格式，默认格式yyyyMMdd
     * @return 20190101
     */
    public static String getCurrentDay(String pattern) {
        LocalDateTime localDateTime = LocalDateTime.now();

        if (StringUtils.isEmpty(pattern)) {
            pattern = "yyyy-MM-dd";
        }

        return format((Date) localDateTime2Date(localDateTime), pattern);
    }
}
