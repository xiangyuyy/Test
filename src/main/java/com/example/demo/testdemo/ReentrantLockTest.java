package com.example.demo.testdemo;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/215:16
 */
public class ReentrantLockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
    }
}
