package com.example.demo.testdemo;

import java.util.Scanner;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/1919:59
 */
public class fanzhuan {
    public static void main(String[] args) {
        String c = "abcedf";
        //Integer c1 = Integer.valueOf("c",2);
        String c2 = Integer.toHexString((byte)'4');
        System.out.println("c2 = " + c2);
        char b = 'b';
        char B='B';
        System.out.println("c2 = " + c2);


 /*       String[] s = {"I","am", "a","hi", "boy"};
        for (int x=0,y=s.length-1;x<y;x++,y--){
            String temp = s[x];
            s[x] = s[y];
            s[y] = temp;
        }
        System.out.println("s = " + s);

        Integer i = 33;
        String s1 ="";
        for (int j = 2; j <=i ; j++) {
            if (i % j == 0){
                s1+=j;
                i= i/j;
                j=1;
            }
        }
        System.out.println("s = " + s1);*/

        Scanner sc = new Scanner(System.in);
        String[] sp = sc.nextLine().split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--)
            sb.append(sp[i] + " ");
        System.out.println(sb.toString().trim());
        sc.close();
    }
}
