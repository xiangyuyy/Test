package com.example.demo.testdemo;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/1/2816:32
 */
public class RecursionTest {
    public static void main(String[] args) {
       Integer i = 0;

        test(i);
        System.out.println(i);
    }
    public static void  test(Integer i){
        if (i >= 100){
            return;
        }
        else {
            System.out.println(i);
            test(i + 1);
        }
    }
}
