package com.example.demo.testdemo;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/3/316:32
 */
@Data
public class WorkerThread implements Runnable {

    private String name;
    private BlockingQueue<DelayQueueDemo.DelayedElement> delayedElements;
    public WorkerThread(String name,BlockingQueue<DelayQueueDemo.DelayedElement> delayedElements){
        this.name = name;
        this.delayedElements = delayedElements;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Join. Time = " + getNowDate()+"--"+name);
        while (delayedElements.size()>0) {
            try {
                DelayQueueDemo.DelayedElement delayedElement =  delayedElements.take();
                System.out.println(Thread.currentThread().getName() + " Start. Time = " + getNowDate()+"--"+name);
                System.out.println(Thread.currentThread().getName() + " msg = " + getNowDate()+"--"+delayedElement.getMsg());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //threadSleep();
            //System.out.println(Thread.currentThread().getName() + " End. Time = " + getNowDate()+"--"+name);
        }
    }

    /**
     * 睡3秒
     */
    public void threadSleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
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
