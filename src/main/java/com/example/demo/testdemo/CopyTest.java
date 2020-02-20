package com.example.demo.testdemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/310:36
 */
public class CopyTest {
    public static void main(String[] args) {
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
        System.out.println("1212");
    }
}
