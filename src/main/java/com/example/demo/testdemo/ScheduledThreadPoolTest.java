package com.example.demo.testdemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/3/316:33
 */
public class ScheduledThreadPoolTest {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        DelayQueueDemo.DelayedElement delayedElement = new DelayQueueDemo.DelayedElement(1000,"msg");
        DelayQueueDemo.DelayedElement delayedElement1 = new DelayQueueDemo.DelayedElement(4000,"msg1");
        BlockingQueue<DelayQueueDemo.DelayedElement> deque = new DelayQueue<>();
        deque.offer(delayedElement);
        deque.offer(delayedElement1);
        BlockingQueue<DelayQueueDemo.DelayedElement> deque1 = new DelayQueue<>();
        deque1.offer(delayedElement);
        deque1.offer(delayedElement1);
        BlockingQueue<DelayQueueDemo.DelayedElement> deque2 = new DelayQueue<>();
        deque2.offer(delayedElement);
        deque2.offer(delayedElement1);
        try {
            //schedule to run after sometime
            System.out.println("Current Time = " + getNowDate());
            /*       for(int i=0; i<2; i++){*/
            //Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("111111", deque);
/*            WorkerThread worker1 = new WorkerThread("22222",deque1);
            WorkerThread worker2 = new WorkerThread("33333",deque2);*/
            //延迟5秒后执行
            ScheduledFuture scheduledFuture = scheduledThreadPool.schedule(worker, 0, TimeUnit.SECONDS);
/*            scheduledThreadPool.schedule(worker1, 0, TimeUnit.SECONDS);
            scheduledThreadPool.schedule(worker2, 0, TimeUnit.SECONDS);*/
            /*  }*/
           Thread.sleep(300);
           scheduledFuture.cancel(true);
            //Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
   /*     scheduledThreadPool.shutdown();
        while (!scheduledThreadPool.isTerminated()) {
            //wait for all tasks to finish
        }*/
        System.out.println("Finished all threads");
    }

    /**
     * 获取现在时间
     *
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter;
        formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String ctime = formatter.format(currentTime);
        return ctime;
    }
}