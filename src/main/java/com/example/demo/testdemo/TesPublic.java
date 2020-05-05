package com.example.demo.testdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class TesPublic {

    public static List<Long> list = null;
    public TesPublic(){
        getList();
    }

    public static List<Long>  getList(){
        if (Objects.isNull(list)){
            Long  s = new Date().getTime();
            System.out.println("------" +s);
            list = new ArrayList<>();
            list.add(new Date().getTime());
        }
        return list;
    }

    public  List<Long>  get(){
        System.out.println("------hashCode" +list.hashCode());
        return list;
    }
}
