package com.example.demo.testdemo;

import com.example.demo.teacher.entity.Teacher;
import com.example.demo.teacher.service.ITeacherService;
import com.example.demo.teacherfortestthread.service.ITeacherfortestthreadService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TextThreadWrite {
    @Autowired
    ITeacherService teacherService;
    @Autowired
    ITeacherfortestthreadService iTeacherfortestthreadService;
    public static void main(String[] args) {
    }

    public static void exec(List<Teacher> list,ITeacherfortestthreadService iTeacherfortestthreadService) throws InterruptedException {
        int count = 30000;                   //一个线程处理300条数据
        int listSize = list.size();        //数据集合大小
        int runSize = (listSize / count) + 1;  //开启的线程数
        List<Teacher> newlist = null;       //存放每个线程的执行数据
        ExecutorService executor = Executors.newFixedThreadPool(runSize);      //创建一个线程池，数量和开启线程的数量一样
//创建两个个计数器
/*        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(runSize);*/
        //循环创建线程
        for (int i = 0; i < runSize; i++) {
            //计算每个线程执行的数据
            if ((i + 1) == runSize) {
                int startIndex = (i * count);
                int endIndex = list.size();
                newlist = list.subList(startIndex, endIndex);
            } else {
                int startIndex = (i * count);
                int endIndex = (i + 1) * count;
                newlist = list.subList(startIndex, endIndex);
            }
            //线程类
            MyThreadForWrites mythead = new MyThreadForWrites(newlist,iTeacherfortestthreadService);
            //这里执行线程的方式是调用线程池里的executor.execute(mythead)方法。

            new Thread(mythead).start();
           // executor.execute(mythead);
        }

/*        begin.countDown();
        end.await();*/

        //执行完关闭线程池
        //executor.shutdown();
    }
}

class MyThreadForWrites implements Runnable {
    private List<Teacher> list;
/*    private CountDownLatch begin;
    private CountDownLatch end;*/
    private     ITeacherfortestthreadService iTeacherfortestthreadService;

    //创建个构造函数初始化 list,和其他用到的参数
    public MyThreadForWrites(List<Teacher> list,ITeacherfortestthreadService iTeacherfortestthreadService) {
        this.list = list;
/*        this.begin = begin;
        this.end = end;*/
        this.iTeacherfortestthreadService = iTeacherfortestthreadService;
    }

    @Override
    public void run() {
        try {
            //执行完让线程直接进入等待
      /*      begin.await();*/
            for (int i = 0; i < list.size(); i++) {
                //这里还要说一下，，由于在实质项目中，当处理的数据存在等待超时和出错会使线程一直处于等待状态
                //分批 批量插入
                Thread.sleep(10000);
/*                Teacherfortestthread teacherfortestthread = new Teacherfortestthread();
                teacherfortestthread.setId(list.get(i).getId());
                iTeacherfortestthreadService.insert(teacherfortestthread);*/

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //这里要主要了，当一个线程执行完 了计数要减一不然这个线程会被一直挂起
// ，end.countDown()，这个方法就是直接把计数器减一的
/*            end.countDown();*/
        }
    }


}


