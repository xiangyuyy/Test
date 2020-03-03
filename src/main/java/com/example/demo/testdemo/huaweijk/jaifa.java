package com.example.demo.testdemo.huaweijk;


import java.util.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/2410:22
 */
public class jaifa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double q= 2;
        double q1 = 3;
        double t1 = q/q1;
        String s2 = String.valueOf(t1);
        String s1 = s2.substring(0,s2.indexOf('.')+2);
        String first = input.nextLine();
        String two = input.nextLine();
        char[] t = two.toCharArray();
        if (first.length()>=two.length()){
            int[] r = new int[first.length()];
            int[] k = new int[first.length()];
            for (int i = 0; i <first.length() ; i++) {
                k[i] = Integer.parseInt(String.valueOf(first.charAt(i)));
                if (two.length()>i){
                    r[first.length()-i-1] = Integer.parseInt(String.valueOf(first.charAt(t.length-i-1)));
                }
                else{
                    r[first.length()-i-1] = 0;
                }
            }
            int[] s = new int[first.length()+1];
            for (int i = k.length; i >0; i--) {
                int o = r[i-1]+k[i-1];
                if (o>=10){
                    o = o %10;
                    s[i-1] = 1;
                }
                s[i]+= o;
            }
            System.out.println("s = " + s);
        }
    }
}
