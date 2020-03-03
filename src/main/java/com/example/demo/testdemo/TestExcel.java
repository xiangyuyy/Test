package com.example.demo.testdemo;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/1217:28
 */
public class TestExcel {
    public static void main(String[] args) {
/*        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String a = scanner.nextLine();
        s = s.toUpperCase();
        a= a.toUpperCase();
        int b = 0;
        for (int i = 0; i <s.length(); i++) {
            if (String.valueOf(s.charAt(i)).equals(a)){
                b++;
            }
        }
        System.out.print(b);*/

        Scanner sc = new Scanner(System.in);
        String ss = "";
        while (sc.hasNext()) {
                String s  = sc.next();//这n个数先放进有个数组里面
                ss +=s;
                if (s.equals("a")){
                    break;
                }
        }

        System.out.println("ss = " + ss);
  /*      Map<String,String> map = new HashMap<>();
        map.put("0","1");
        map.put("2","2");

        Set<String> set = map.keySet();
        for (String item:
                set ) {
            System.out.println("item = " + item);
        }
*/
/*        Set<Integer> set = new HashSet();
        for (int i = 0; i <s.length(); i++) {
            set.add(Integer.parseInt(String.valueOf(s.charAt(i))));
        }

        Object[] integers = set.toArray();
        for (int i = 0; i <integers.length -1; i++) {
            for (int j = 0; j < integers.length - 1 - i ; j++) {
                Integer temp = Integer.parseInt(integers[j].toString());
                Integer next = Integer.parseInt(integers[j+1].toString());
                if (next >= temp ){
                    exchange(integers,j+1,j);
                }
            }
        }*/

/*        String strUrl = "F:\\测试图片.jpg";
        File file = new File(strUrl);
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
    }
    public static void exchange(Object a[], int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] Test(int[] a){
        int [] b =new int [1000];
        for (int i =0;i<1000;i++){
            b[i] = 0;
        }
        int len = a.length;
        for (int i =0;i<len;i++)
        {
            b[a[i]] = 1;
        }

        // return b;
        return b;
    }

}
