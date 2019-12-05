package com.example.demo;

import org.springframework.stereotype.Service;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2019/10/2116:40
 */
@Service
public class TestLazyBean {
    public  TestLazyBean(){
        System.out.println("初始化TestLazyBean");
    }
    public  void sayHello(){
        String[] d = new String[1];
        d[0] ="23";
        for (int i = d.length - 2; i >= 0; i--) {
            System.out.println(d[0]);
        }
        System.out.println("sayHello");
    }
}
