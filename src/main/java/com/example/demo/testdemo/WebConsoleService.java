package com.example.demo.testdemo;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiaoh
 * @description: TODO
 * @date 2020/2/2515:52
 */
@Service
public class WebConsoleService {
    public static ConcurrentHashMap<String, Thread> consoleThreadMap = new ConcurrentHashMap<String, Thread>();  //创建hashmap，用于存储线程
    public void webConsole(String serial, String cmd,long period) {
        try {
                ThreadPoolManager.getInstance().addExecuteTask(new EachT(cmd,serial),period);
            consoleThreadMap.put(serial, Thread.currentThread());
        } catch (Exception e) {
        }
    }

    public void close(String serial) {
        try {
            consoleThreadMap.remove(serial);   //执行完成后，将线程从hashmap中移除
        } catch (Exception e) {
        }
    }

    private class EachT implements Runnable{

        private String cmd;
        private String serial;
        public EachT(String cmd,String serial) {
            this.cmd=cmd;
            this.serial=serial;
        }
        @Override
        public void run() {
            try {
                if(consoleThreadMap.containsKey(serial)) {
                    execute(serial);
                }
            }catch(Exception e) {

            }finally {
            }
        }

        public void execute(String serial) throws InterruptedException {
                System.out.println(Thread.currentThread().getName()+serial+new Date());
                Thread.currentThread().sleep(1000);

        }
    }
}
