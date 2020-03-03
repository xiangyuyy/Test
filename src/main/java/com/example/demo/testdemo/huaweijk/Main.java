package com.example.demo.testdemo.huaweijk;


import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.*;
public  class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = "121212";
        String S = "121212s1212";
        String[] SS = s1.split("s");
        String[] SS1 = S.split("s");
        Integer s11 = 1;
        Integer d = new Integer(1);
        Boolean t11 = s11 == d;
        Boolean t1 = s11.equals(d);

        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int n = scanner.nextInt();
            int c = 0;
            for (int i = 0; i <n ; i++) {
                String s ="";
                for (int j = 0; j <i+1 ; j++){
                    s+=a;
                }
                int r = Integer.valueOf(s);
                c+=r;
            }
            System.out.println(c);
        }
    }
}