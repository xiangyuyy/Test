package com.example.demo.testdemo;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/1/2520:28
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        Msg counter = new Msg();
        HashMap<String,String> hashMap = new HashMap<>();
        //counter.set(); //不设置报错
        Count count = new Count(counter);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(count);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("--------------------------------------------result" + count.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
    class Count implements Runnable {
        private Msg counter;
        public Count(Msg counter){
            this.counter = counter;
        }
        public void add() {
            counter.set();
            counter.add();
                System.out.println(Thread.currentThread().getName() +  "counter--------" + get());
        }

        public int get() {
            return counter.get();
        }

        @Override
        public void run() {
            add();
        }
    }
    class Msg{
        private  final ThreadLocal<Integer> counter = new ThreadLocal<>();
        protected void set(){
            counter.set(0);
        }
        protected Integer get(){
          return   counter.get();
        }
        protected void add(){
            counter.set(get()+1);
        }
    }




