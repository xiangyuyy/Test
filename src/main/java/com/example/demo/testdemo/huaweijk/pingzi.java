package com.example.demo.testdemo.huaweijk;

import com.sun.javafx.collections.MappingChange;

import java.util.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/2216:49
 */
public class pingzi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = 'a';
        char A = 'A';
        char b= 'b';
        int[][] map = new int[6][5];
        map[1][1] = 1;
        Map<String,Integer> map1 = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        Integer  f = list.get(0);
        Collections.sort(list);
        String s ="1";
        while (sc.hasNextDouble()) {
            double n = sc.nextDouble();
            double i = 1;
            while (i * i * i < n) i++;
            while (i * i * i > n) i -= 0.1;
            while (i * i * i < n) i += 0.01;
            String res = String.format("%.1f", i);
            System.out.println(res);

/*            int i = scanner.nextInt();
            if (i == 0){
                break;
            }
            else {
                System.out.println(getCount(i,0));
            }*/
        }
    }
    private static int getCount(int c,int s){
        int n = c/3;
        int f = n +  c%3;
        s +=n;
        if (f>=3) {
           return getCount(f, s);
        }
        if (f == 2){
            return s+1;
        }
        else {
            return s;
        }
    }
}
