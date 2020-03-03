package com.example.demo.testdemo.huaweijk;

import java.util.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/2217:14
 */
public class fama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int[]  weights=new int[n];
            int[]  numbers=new int[n];
            for(int i=0;i<n;i++)
                weights[i]=sc.nextInt();
            for(int i=0;i<n;i++)
                numbers[i]=sc.nextInt();
            int result = fama(n,weights,numbers);
            System.out.println(result);
        }
        sc.close();
    }
    public static int fama(int n,int[] wei,int[] num) {
        Set<Integer> set = new HashSet<Integer>();//set结构去除重复
        set.add(0);//初始化set否则报错
        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<Integer>(set);//不断的更新set存进新的数组
            for(int j=1;j<=num[i];j++){//遍历每组砝码的个数
                for(int k=0;k<list.size();k++)
                    set.add(list.get(k)+j*wei[i]);
            }
        }
        return set.size();
    }

}
