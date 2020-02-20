package com.example.demo.testdemo;

import com.example.demo.bicyle.entity.Bicyle;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/221:08
 */
public class ParalleStreamTest {
    public static void main(String[] args) {
        List<Test> list = new ArrayList();
        for (int i = 0; i < 1000; i++) {
            Test t = new Test(i);
            list.add(t);
        }
        List<Test> list2 = Collections.synchronizedList(new ArrayList<>());//必须使用线程安全的列表 后面是parallelStream操作
        //List<Test> list2 = new ArrayList<>();
        list.parallelStream().forEach(e ->{
            e.set(-1);
            list2.add(e);
            if (ObjectUtils.isEmpty(e)){
                System.out.println("------------------------null");
            }
                });
        //线程不安全 可能扩容超界 或者为null
        List<Test> list3 = list2.parallelStream().filter(x-> ObjectUtils.isEmpty(x)).collect(Collectors.toList());

        ArrayList<Bicyle> bicyles = new ArrayList<>();
        for (int i = 0; i <100000 ; i++) {
            bicyles.add(new Bicyle().setUserid(i));
        }
        bicyles.parallelStream().forEach(x->{
            x.setUserid(-1);
        });
        List<Bicyle> bicyless = bicyles.stream().filter(x->x.getUserid()!=-1).collect(Collectors.toList());
        int i =  5/4;
        int i1 =  5/6;
        System.out.println(bicyless.size());
    }

    public static class Test{
        private Integer i;
        Test(Integer i){
            this.i = i;
        }

        public void set(Integer i){
            this.i = i;
        }
        public Integer get(){
            return i;
        }
    }
}
