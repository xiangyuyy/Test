package com.example.demo.testdemo;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/2515:34
 */
public final class ThreadPoolManager {
    private static ThreadPoolManager sThreadPoolManager = new ThreadPoolManager();

    // 线程池维护线程的最少数量
    private static final int SIZE_CORE_POOL = 50;

    /*
     * 线程池单例创建方法
     */
    public static ThreadPoolManager getInstance() {
        return sThreadPoolManager;
    }
    private final ScheduledThreadPoolExecutor mThreadPool = new ScheduledThreadPoolExecutor(SIZE_CORE_POOL);
    /*
     * 将构造方法访问修饰符设为私有，禁止任意实例化。
     */
    private ThreadPoolManager() {
    }
    /*
     * 向线程池中添加任务方法
     */
    public void addExecuteTask(Runnable task,long period) {
        if (task != null) {
            mThreadPool.scheduleAtFixedRate(task,10,period,TimeUnit.SECONDS);
        }
    }

    /*
     * 关闭线程池，不在接受新的任务，会把已接受的任务执行玩
     */
    public void shutdown() {
        mThreadPool.shutdownNow();
    }
}
