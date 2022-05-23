package Util;

import view.windows;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogUtils {
    public static void print(String msg){
        Date date = new Date();
        // 定义格式化时间输出格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentSimpleDateFormat = simpleDateFormat.format(date);
        windows.jta.insert(currentSimpleDateFormat + ":" +msg + "\n",0);
    }
}
