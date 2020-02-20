package com.example.demo.testdemo;

import java.util.Scanner;
public class orderMain {
    public static void main(String[] args) {
        String s = new String("2");
/*        String[] str = {"cap",
                "to",
                "cat",
                "card",
                "two",
                "too",
                "up",
                "boat",
                "boot"};
        result(str);
        Integer c =1;*/

        Scanner scanner = new Scanner(System.in);
        int sum =scanner.nextInt();
        String[] str = new String[1000];
        int count = 0;
        for (int i = 0; i < sum; i++) {
            str[count] =  scanner.nextLine();
            count++;
        }
        int o = 0;
        String[] result = new String[1000];
        for (int j = 0; j <count ; j++) {
            Boolean add = true;
            for (int q = 0; q <str[j].length() ; q++){
                char c = str[j].toLowerCase().charAt(q);
                Boolean b = check(c);
                if (!b){
                    add = false;
                    break;
                }
            }
            if (add){
                result[o] = str[j];
                o++;
            }
        }
        result(str,o);
        for (int j = 0; j <o ; j++) {
            System.out.println(str[j]);
        }
    }
    public static void result(String[] str,Integer count) {
        for (int i = 0; i <count-1 ; i++) {
            for (int j = 0; j <count-1-i ; j++) {
                String s = str[j];
                String n = str[j+1];
                int lenght = s.length();
                if (n.length() <= s.length()){
                    lenght = n.length();
                }
                for (int k = 0; k <lenght ; k++) {
                    if (s.charAt(k) > n.charAt(k)){
                        change(str,j,j+1);
                        break;
                    }
                    else {
                        if (s.charAt(k) != n.charAt(k)){
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void change(String[] str,int i,int j) {
        String temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }

    public static Boolean check(char c) {
        if (c >= 'a' && c <= 'z' ){
            return true;
        }
        else {
            return  false;
        }
    }
}
