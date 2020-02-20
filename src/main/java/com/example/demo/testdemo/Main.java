package com.example.demo.testdemo;

import javax.validation.constraints.Max;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int sign = 0;
            String str = scanner.nextLine();
            if(str.length() <= 8){
                System.out.println("NG");
                //sign = 1;
                continue;
            }
            char[] cha = str.toCharArray();
            int numsign = 0;
            int uppersign = 0;
            int lowersign = 0;
            int othersign = 0;
            for(int i = 0; i < str.length(); i++){
                if (numsign == 0 &&(cha[i] >= '0' && cha[i] <= '9')){
                    numsign = 1;
                }
                else if (uppersign == 0 && (cha[i] >= 'a' && cha[i] <= 'z' ) ){
                    uppersign = 1;
                }
                else if (lowersign == 0 && (cha[i] >= 'A' && cha[i] <= 'Z')){
                    lowersign = 1;
                }
                else {
                    othersign = 1;
                }
                if(uppersign + lowersign + numsign + othersign == 3){
                    break;
                }
            }
            if(uppersign + lowersign + numsign + othersign < 3){
                System.out.println("NG");
                //sign = 1;
                continue;
            }
            Set<String> set = new HashSet<>();
            for (int j = 0; j < str.length()-2; j++){
                StringBuilder sb = new StringBuilder();
                String str1 = sb.append(cha[j]).append(cha[j+1]).append(cha[j+2]).toString();
                if(set.contains(str1)){
                    System.out.println("NG");
                    sign = 1;
                    break;
                }else{
                    set.add(str1);
                }
            }
            if(sign == 0){
                System.out.println("OK");
            }
        }
    }
}