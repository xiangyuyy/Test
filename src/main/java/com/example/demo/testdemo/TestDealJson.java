package com.example.demo.testdemo;

import com.alibaba.fastjson.JSON;


public class TestDealJson {

    public static void main(String[] args) {
        String ss = "{\"total\":{\"count\":3,\"bandwidth\":2858352},\"streams\":{\"4233c75485d12b\":{\"bandwidth\":979176,\"count\":1},\"234c123413b\":{\"count\":2,\"bandwidth\":1879176},}}";
        OnlineDTO dto = JSON.parseObject(ss,OnlineDTO.class);
        System.out.println(JSON.toJSONString(dto));
    }
}

