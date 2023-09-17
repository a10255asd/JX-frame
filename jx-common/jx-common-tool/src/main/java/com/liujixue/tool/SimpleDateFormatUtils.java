package com.liujixue.tool;
import java.text.SimpleDateFormat;
/**
 * @Author LiuJixue
 * @Date 2023/9/17 20:44
 * @ClassName: SimpleDateFormatUtils
 * @Description: TODO
 */
public class SimpleDateFormatUtils {

    private static final ThreadLocal<SimpleDateFormat> THREAD_LOCAL = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static SimpleDateFormat getTime() {
        SimpleDateFormat simpleDateFormat = THREAD_LOCAL.get();
        if(simpleDateFormat == null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
        return simpleDateFormat;
    }

}
