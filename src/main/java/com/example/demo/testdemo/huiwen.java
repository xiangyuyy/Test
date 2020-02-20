package com.example.demo.testdemo;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/2010:49
 */
public class huiwen {
    private static int maxLen = 0;

    private static String sub = "";

    public static void main(String[] args) {
        longestPalindrome("dfsafasafaafdf");

       /* BigDecimal c = new BigDecimal(1);
        BigDecimal h = new BigDecimal(0);
        BigDecimal f = new BigDecimal(0);
        for (int i = 0; i < 5; i++) {
            h = h.add(c);
            c = c.divide(new BigDecimal(2));
            if (i!= 4){
                h = h.add(c);
            }
            if (i== 4){
                f = c;
            }
        }*/
        Scanner scanner = new Scanner(System.in);
        int sum =scanner.nextInt();
       int index = 1;
        for (int q = 0;q<sum;q++){
            index = index+q;
            int next = index;
            for (int x = 0;x<sum-q;x++){
                 if (x== 0){
                     System.out.print(" "+next);
                 }
                 else {
                     next += x+1+q;
                     System.out.print(" "+next);
                 }
            }
            System.out.println("");
        }

        System.out.println("args = " + args);
    }

    public static String longestPalindrome(String s) {
        if (s.length() <= 1)
            return s;

        for (int i = 0; i < s.length() - 1; i++) {

            findLongestPalindrome(s, i, i);//单核回文

            findLongestPalindrome(s, i, i + 1);//双核回文
        }
        return sub;
    }


    public static void findLongestPalindrome(String s, int low, int high) {
        while (low >= 0 && high <= s.length() - 1) {
            if (s.charAt(low) == s.charAt(high)) {
                if (high - low + 1 > maxLen) {
                    maxLen = high - low + 1;
                    sub = s.substring(low, high + 1);
                }
                low --;//向两边扩散找当前字符为中心的最大回文子串
                high ++;
            }
            else
                break;
        }
    }
}
