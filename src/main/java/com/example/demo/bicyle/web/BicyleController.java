package com.example.demo.bicyle.web;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.bicyle.entity.Bicyle;
import com.example.demo.bicyle.service.IBicyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-09-27
 */
@RestController
@RequestMapping("/bicyle")
@Slf4j
public class BicyleController {
    @Autowired
    private IBicyleService bicyleService;

    @RequestMapping("/testUnOptimisticLock")
    public String testUnOptimisticLock() {
        EntityWrapper<Bicyle> ew = new EntityWrapper<Bicyle>();
        ew.andNew().eq("userid", 12323333);
        Bicyle bicyle = bicyleService.selectOne(ew);
        if (bicyle.getLevel() > 0) {
            System.out.println("---------进入");
            bicyle.setLevel(bicyle.getLevel() - 1);
            boolean result = bicyleService.updateById(bicyle);
            System.out.println("---------result"+result);
        }
        return "sucess";
    }

    @RequestMapping("/testOptimisticLock")
    public String testOptimisticLock() {
        EntityWrapper<Bicyle> ew = new EntityWrapper<Bicyle>();
        ew.andNew().eq("userid", 12323333);
        Bicyle bicyle = bicyleService.selectOne(ew);
        if (bicyle.getLevel() > 0) {
            System.out.println("---------进入");
            EntityWrapper<Bicyle> ew1 = new EntityWrapper<Bicyle>();
            ew1.andNew().eq("userid", 12323333);
            ew1.andNew().eq("vision", bicyle.getVision());
            Bicyle bicyle1 = bicyleService.selectOne(ew1);
            if (Objects.isNull(bicyle1)){
                System.out.println("---------null");
                return "fail";

            }
            System.out.println("---------getVision" +bicyle1.getVision());
            bicyle1.setVision(bicyle1.getVision() + 1);
            bicyle1.setLevel(bicyle1.getLevel() - 1);
            boolean result = bicyleService.updateById(bicyle1);
            System.out.println("---------result"+result);
        }
        return "sucess";
    }
    @RequestMapping("/testThreadPool")
    public String testThreadPool() {
        AtomicInteger atomicInteger = new AtomicInteger(0) ;
        ExecutorService executor = Executors.newFixedThreadPool(120); //创建一个线程池，数量和开启线程的数量一样
        for (int i = 0; i <20000 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Bicyle bicyle = new Bicyle();
                    bicyle.setVision(atomicInteger.get());
                    bicyleService.insert(bicyle);
                }
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sucess";
    }
}
