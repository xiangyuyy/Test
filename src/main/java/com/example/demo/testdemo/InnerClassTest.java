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
        String s = Integer.toBinaryString(5);
        Integer sa = 1;
        //Inner.Inners inners = new Inner().new Inners();
        //inners.u();
    }

    private void g(){
        RecursionTest test = new RecursionTest();
       /* RecursionTest.Inners inners  = test.new test.Inners();
        inners.u();*/
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

   /*public  class Inner{
        private  class Inners{
            private void u(){

            }
        }
    }*/
}
