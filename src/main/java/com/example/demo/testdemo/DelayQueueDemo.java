package com.example.demo.testdemo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.security.DenyAll;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/2811:13
 */
@Slf4j
public class DelayQueueDemo {


    public static void main(String[] args) throws InterruptedException {

        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(1);
        List<BlockingQueue<DelayedElement>> list = new LinkedList<>();
        final BlockingQueue<DelayedElement> deque = new DelayQueue<>();
        deque.put(new DelayedElement(1000 * 1, "i1=" + 1));
        deque.put(new DelayedElement(1000 * 2, "i1=----" + 1));
        deque.put(new DelayedElement(1000 * 3, "i1=-----------------" + 1));

        final BlockingQueue<DelayedElement> deque1 = new DelayQueue<>();

        deque1.put(new DelayedElement(2000 * 1, "i2=" + 2));
        deque1.put(new DelayedElement(2000 * 2, "i2=----" + 2));
        deque1.put(new DelayedElement(2000 * 3, "i2=-----------------" + 2));
        list.add(deque);
        list.add(deque1);
        Runnable producerRunnable = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        //log.info("1111111");
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable customerRunnable = new Runnable() {
            public void run() {
                while (true) {
                    try {
                        for (BlockingQueue<DelayedElement> item: list) {
                            log.info("我消费了一个===" + item.take().msg);
                        }
                        //Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        Runnable getSize= new Runnable() {
            @Override
            public void run() {
                while (true) {
                    for (BlockingQueue<DelayedElement> item: list) {
                        log.info("size={}", item.size());
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };

        Thread thread1 = new Thread(producerRunnable);
        thread1.start();

        Thread thread2 = new Thread(customerRunnable);
        thread2.start();

        Thread thread3 = new Thread(getSize);
        thread3.start();

    }
@Data
    static class DelayedElement implements Delayed {

        private final long expire;  //到期时间
        private final String msg;   //数据

        public  DelayedElement(long delay, String msg) {
            this.msg = msg;
            expire = System.currentTimeMillis() + delay;    //到期时间 = 当前时间+延迟时间
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(this.expire - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        //延迟队列是一个根据时间来排序的一个优先级队列
        @Override
        public int compareTo(Delayed o) {
            return (int) (this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
        }
    }
}

