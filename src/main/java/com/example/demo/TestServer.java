package com.example.demo;

import org.springframework.stereotype.Service;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2019/11/1211:57
 */
@Service
public class TestServer {
    public String s;

    public TestServer() {
        s = "12";
    }

    public String getString() {
        return s;
    }
    public String getString1() {
        return s+1;
    }
}
