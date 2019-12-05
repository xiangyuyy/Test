package com.example.demo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author xiaoh
 * @description: 测试DateTimeFormatter
 * @date 2019/12/59:22
 */
public class DateFormatTest {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.US);
    private static String date[] = { "2019-11-29 10:29", "2019-11-29 10:29", "2019-11-29 10:29" , "2019-11-29 10:29" , "2019-11-29 10:29" , "2019-11-29 10:29" , "2019-11-29 10:29"};

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    public static void main(String[] args) {
        for (int i = 0; i < date.length; i++) {
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {

                            String str1 = date[temp];
                            String str2 = formatter.format(LocalDateTime.parse(str1,formatter));
                            System.out.println(Thread.currentThread().getName() + ", " + str1 + "," + str2);
                            if(!str1.equals(str2)){
                                throw new RuntimeException(Thread.currentThread().getName()
                                        + ", Expected " + str1 + " but got " + str2);
                            }

                    } catch (Exception e) {
                        throw new RuntimeException("parse failed", e);
                    }
                }
            }).start();
        }
    }
}