package com.example.demo.testdemo;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/1/2815:45
 */
public class InnerClassTest {
    public static void main(String[] args) {
        InnerClassTest t = new InnerClassTest();
        t.test(1);
        t.test(2);
    }

     void test(final int b) { //局部内部类
        final int a = 10;
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b+1);
            };
        }.start();
    }
}
