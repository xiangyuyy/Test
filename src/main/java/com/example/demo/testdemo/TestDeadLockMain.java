package com.example.demo.testdemo;

/**
 * @author xiaoh
 * @description: 死锁线程测试主类
 * @date 2020/1/2117:52
 */
public class TestDeadLockMain {
    public static void main(String[] args) {
        TestDeadLockThread testDeadLockThread1 = new TestDeadLockThread(1);
        TestDeadLockThread testDeadLockThread2 = new TestDeadLockThread(2);
        new Thread(testDeadLockThread1).start();
        new Thread(testDeadLockThread2).start();
        System.out.println("TestDeadLockMain.main");
    }
}
