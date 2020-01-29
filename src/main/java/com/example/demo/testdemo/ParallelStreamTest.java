package com.example.demo.testdemo;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2019/10/3119:11
 */
public class ParallelStreamTest {
    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String time1 = "2019-11-29 10:29";
        String time2 = "2019-11-29 10:30";
        LocalDateTime s =  LocalDateTime.parse(time1,formatter);
        LocalDateTime s2 = LocalDateTime.now();
        String S1 = formatter.format(s2);

        ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<SimpleDateFormat>();
        simpleDateFormatThreadLocal.set(sdf);


        SimpleDateFormat simpleDateFormat = simpleDateFormatThreadLocal.get();

        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<100000;i++) {
            list.add(i);
        }
        List<Integer> list1 = new ArrayList<>();
        list.parallelStream().forEach(x->{
            try {
                Thread.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(x);
            list1.add(x);
        });

   /*     for (int i = 0;i<1000000;i++) {
            list.remove(0);
        }*/
        list1.stream().sorted();
        System.out.println("----------------------"  + list1.size());
    }
/*        List<Integer> a = new ArrayList<Integer>();
        System.out.println("before" + a.size());
        testValue(a);
        System.out.println("afer" + a.size());*/
/*        Teacher t =  new Teacher();
        t.setName("陈相宇");
        System.out.println(t.getAge());

        String[] d = new String[1];
        d[0] ="23";
        for (int i = d.length - 2; i >= 0; i--) {
            System.out.println(d[0]);
        }*/
       /* Integer all = 0;
        test(all);
        System.out.println(all);
        System.out.println("sayHello");*/

/*
        // 获取当月第一天和最后一天
        Calendar cale = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday, lastday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        firstday = format.format(cale.getTime());
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        // 获取前月的最后一天加1天
        cale.add(Calendar.DAY_OF_MONTH, 1);
        lastday = format.format(cale.getTime());
        System.out.println("本月第一天和最后一天分别是 ： " + firstday + " and " + lastday);
*/


    public static void testValue(List<Integer> a) {
        a.add(1);
    }

    private  static void test(Integer all){
        if (all == 100){
            return;
        }
        System.out.println(all);
        all = all + 1;
        test(all);
    }
}
