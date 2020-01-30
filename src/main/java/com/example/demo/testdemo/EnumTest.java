package com.example.demo.testdemo;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/1/3017:29
 */
public class EnumTest {
    public static void main(String[] args) {
        System.out.println(Quarter1.SPRING.desc);
    }

    public enum Quarter1 {
        SPRING(1,"春天","我");
        private  int code;
        private String msg;
        private String desc;
        Quarter1(int code,String msg,String desc){
            this.code = code;
            this.msg = msg;
            this.desc = desc;
        }
    }
}
