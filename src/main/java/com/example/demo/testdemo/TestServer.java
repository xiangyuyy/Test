package com.example.demo.testdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2019/11/1211:57
 */
@Service
public class TestServer {


    public static void main(String[] args) {
        //随机一个数字
        int index1 = (int) (Math.random());
        for (int i = 0; i <10000 ; i++) {
            double index2 = Math.random();
            int index = (int) (index2 * 6);
            System.out.println("index = " + index2+"---");
            System.out.println("index = " + index+"---");
        }
        int index3 = (int) (0.99999 * 6);
        System.out.println("index3= " + index3+"---");
    }
    public String s;

    public TestServer() {
        s = "12";
    }
    public String getString1() {
        return s+1;
    }
}
