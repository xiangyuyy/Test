package com.example.demo;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierUserCaseTest {

    public static void main(String[] args) throws IOException, InterruptedException {

        CyclicBarrier barrier = new CyclicBarrier(5,new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(" 开会了，996工作要开始了！");
            }
        });

        ExecutorService executor = Executors.newFixedThreadPool(5);
        executor.submit(new Thread(new Worker(barrier, "项目经理",10000)));
        executor.submit(new Thread(new Worker(barrier, "产品经理",1000)));
        executor.submit(new Thread(new Worker(barrier, "程序员1号",1000)));
        executor.submit(new Thread(new Worker(barrier, "程序员2号",1000)));
        executor.submit(new Thread(new Worker(barrier, "程序员3号",1000)));
        executor.shutdown();

    }



}
class Worker implements Runnable{
    // 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)
    private CyclicBarrier barrier;
    private String name;
    private Integer sleepTime;

    public Worker(CyclicBarrier barrier,String name,Integer sleepTime){
        this.barrier = barrier;
        this.name = name;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(sleepTime);
            System.out.println(name + " 准备好了...");
            // barrier的await方法，在所有参与者都已经在此 barrier 上调用 await 方法之前，将一直等待。
            barrier.await();
            System.out.println(name + " 做事情了...");
            Thread.sleep(sleepTime);
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
