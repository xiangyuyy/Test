package com.example.demo.testdemo.huaweijk;

import com.example.demo.bicyle.entity.Bicyle;

import java.util.HashMap;

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

        HashMap<String,String> hashMap = new HashMap<>();
        String b ="1212";
        String a = b;
        a = "12";
        char c1 = 'c';
        char d1 = 'd';
        boolean f1 = c1>=d1;
        String b1 = new String("1212");
        String a1 = b1;
        a1 = "12";

        Integer c = 1;
        Integer v = c;
        v = 2;

        Integer f = new Integer(2);
        Integer g = f;
        g =  new Integer(3);


        int[] array = new int[]{1, 2, 3, 4};
        int[] array1 = array;
         array1[0] = 0;

         Integer bicyle1 = new Integer(1000000);
         change(bicyle1);

        String s = hashMap.put("1","1");
        String s1 = hashMap.put("11","11");
        String s2 = hashMap.put("112","112");
        System.out.println(s);
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

    public static void change(Integer bicyle){
        bicyle = 20000000;
    }

     private  class Inners{
        protected void u(){
        }
    }
}
