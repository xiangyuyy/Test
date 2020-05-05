package com.example.demo.testdemo;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/310:36
 */
public class CopyTest {
    public static void main(String[] args) {
/*        test();
        HashMap<String,String> map = new HashMap<>();
        map.put();
        Hashtable<String,String> map1 = new Hashtable<>();
        HashSet<String> map2= new HashSet<>();
        map2.add();
        LinkedHashMap<String,String> mp3 = new LinkedHashMap<>();
        mp3.put();
        TreeMap<String,String> mp4 = new TreeMap<>();
        mp4.put();*/
        int randomMix = 500;
        int randomMax = 1000;
        int random = (int) (Math.random() * (randomMax-randomMix) + randomMix);//随机3-10秒
        int random1 = (int) (Math.random() * (randomMax-randomMix) + randomMix);//随机3-10秒
        int random2= (int) (Math.random() * (randomMax-randomMix) + randomMix);//随机3-10秒
        int random3 = (int) (Math.random() * (randomMax-randomMix) + randomMix);//随机3-10秒
        List<String> srcList = new ArrayList<>();
        srcList.add("张三");
        srcList.add("李四");
        srcList.add("王五");

        List<String> descList = new ArrayList<>(3);
        descList.add(null);
        descList.add(null);
        descList.add(null);
        descList.add("赵六");
        System.out.println(descList.size());

        Collections.copy(descList, srcList);

        for (String desc : descList) {
            desc = desc + "是笨蛋";
            System.out.println(desc);
        }
        for (int i = 0; i <descList.size() ; i++) {
            descList.set(i,descList.get(i)+"是笨蛋");
        }
        Hashtable<String,String> map = new Hashtable<>();
        System.out.println("1212");
        
    }

    public static void test(){
        String S = "S";
        if (S.equals("S")){
            S = "A";
        }
        else if (S.equals("A")){
            S = "B";
        }
        else {
            S = "C";
        }
        System.out.println(S);
    }
}
