package com.example.demo;

/**
 * @author xiaoh
 * @description: 死锁线程
 * @date 2020/1/2117:44
 */
public class TestDeadLockThread implements Runnable {

    private int value;
    private  static Object lock1 = new Object();
    private  static Object lock2 = new Object();
    public TestDeadLockThread(int value){
        this.value = value;
    }
    @Override
    public void run() {
        if (value == 1){
            synchronized (lock1){
                try {
                    System.out.println("value = " + value);
                    System.out.println("lock1 ");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2){
                    System.out.println("value = " + value);
                    System.out.println("lock2 ");
                }
            }
        }
        else {
            synchronized (lock2){
                try {
                    System.out.println("value = " + value);
                    System.out.println("lock2 ");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1){
                    System.out.println("value = " + value);
                    System.out.println("lock1 ");
                }
            }
        }
    }
}
