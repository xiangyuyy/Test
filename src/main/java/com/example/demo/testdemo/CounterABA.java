package com.example.demo.testdemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/1/2520:28
 */
public class CounterABA {
    public static void main(String[] args) {
        Integer a = Integer.valueOf("1");
        Integer b = 1;
        Boolean c = a == b;
        if (c) {
            AtomicInteger count = new AtomicInteger(0);
            System.out.printf("true");
            System.out.println("incrementAndGet" + count.incrementAndGet());
            System.out.println("getAndIncrement" + count.getAndIncrement());
        }
        safeAtomicReferenceCounter unsafeCounter = new safeAtomicReferenceCounter();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            executorService.execute(unsafeCounter);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(2, TimeUnit.SECONDS);
            System.out.println("--------------------------------------------result" + unsafeCounter.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
     /*   try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}

class UnsafeCounter implements Runnable {
    private volatile int count = 0;// 也不行  volatile 可见性 顺序重拍 不保证原则性

    public void add() {
        count++;//非原子性操作
        if(get() == 10000){
            System.out.println("add--------" + get());
        }
    }

    public int get() {
        return count;
    }

    @Override
    public void run() {
        add();
    }
}

class safeCounter implements Runnable {
    public AtomicInteger count = new AtomicInteger(0);//会循环 执行直到+1成功

    public void add() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count.getAndIncrement();
        if(get() == 10000){
            System.out.println("add--------" + get());
        }
    }

    public int get() {
        return count.get();
    }

    @Override
    public void run() {
        add();
    }
}

/**
 * f
 * 有时间 戳的  compareAndSet可能存在失败 不一定累加成功
 */
class safeAtomicStampedReferenceCounter implements Runnable {
    public AtomicStampedReference<Integer> count = new AtomicStampedReference(0, 0);//如果同时进入 有一部分+1是不成功的

    public void add() {
     /*   System.out.println("add--------" + get());
        Boolean b = count.compareAndSet(get(), get() + 1, get(), get()+1);
        System.out.println("Boolean--------" + b);*/
        while (true) {
            int stamp = count.getStamp();
            System.out.println("add--------" + get());
            Boolean b = count.compareAndSet(get(), get() + 1, count.getStamp(), count.getStamp()+1);
            System.out.println("Boolean--------" + b);
            if (b) break;
        }
    }

    public Integer get() {   //int 到integet转化  存在装箱
        return count.getReference();
    }

  /*  public int get() {   //int 到integet转化  存在装箱
        return (int) count.getReference();
    }
*/
    @Override
    public void run() {
        add();
    }
}

//compareAndSet可能存在失败 不一定累加成功
class safeAtomicReferenceCounter implements Runnable {
    private AtomicReference<Integer> count = new AtomicReference<Integer>(0);

  /*  public void add() { //累加成功
        while (true) {
            System.out.println(Thread.currentThread().getName()+"add--------" + get());
            Integer temp = count.get();
            Boolean b = count.compareAndSet(temp, temp + 1);
            if (b) {
                System.out.println("true--------" + get());
                break;
            }
        }
    }*/

    public void add() {
            //System.out.println(Thread.currentThread().getName()+"add--------" + get());
            Integer temp = count.get();
            Boolean b = count.compareAndSet(temp, temp + 1);
            if (!b) {
                System.out.println("false--------" + get());
            }
    }

    public int get() {
        return count.get();
    }

    @Override
    public void run() {
        add();
    }
}

