/*
package com.example.demo;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

*/
/**
 * 本地业务事件信息队列消费监听器，spring初始化完成后启动队列消费线程，拿到队列中处理业务逻辑
 *
 * @author cxy
 *//*

@Slf4j
@Component
public class BusinessEventConsumer implements InitializingBean {
    @Autowired
    private BusinessEventQueue businessEventQueue;

    @Override
    public void afterPropertiesSet() {
        ScheduledExecutorService executorService =
            new ScheduledThreadPoolExecutor(BusinessEventConfig.consumerThreadNumber,
                new BasicThreadFactory.Builder().namingPattern("businessEvent-consumer-%d").daemon(true).build());
        for (int i = 0; i < BusinessEventConfig.consumerThreadNumber; i++) {
            executorService.execute(new Consumer());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                log.error("business_event consumer thread exception.", e);
            }
        }
    }

    class Consumer implements Runnable {

        private long lastSendMQTime = System.currentTimeMillis();

        @Override
        public void run() {
            List<BusinessEventMessage> eventMessageList = Lists.newArrayList();

            while (true) {
                try {
                    BusinessEventMessage message = businessEventQueue.take();

                    if (!message.getEventSuccess()) {
                        sendMQEventFailMessage(message);
                    }

                    eventMessageList.add(message);
                    long currentTime = System.currentTimeMillis();
                    boolean isArrivalTime = (currentTime - lastSendMQTime) >= configProperties.getSendMqInterval();
                    if (eventMessageList.size() >= configProperties.getSendMqQueueThreshold() || isArrivalTime) {
                        List<BusinessEventMessage> groupMessageList = new ArrayList<>(eventMessageList);
                        sendMQMessage(groupMessageList);
                        eventMessageList.clear();
                        lastSendMQTime = System.currentTimeMillis();
                    }
                } catch (Exception e) {
                    log.error("businessEvent consumer thread abnormal exit ", e);
                }
            }
        }
    }

}
*/
