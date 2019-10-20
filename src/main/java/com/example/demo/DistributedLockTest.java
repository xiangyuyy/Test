package com.example.demo;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

public class DistributedLockTest {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1000);// 模拟5人并发请求，用户钱包

        for (int i = 0; i < 20000; i++) {// 模拟5个用户
            AnalogUser analogUser = new AnalogUser("user" + i, "58899dcd-46b0-4b16-82df-bdfd0d953bfb", "1", "20.024", latch);
            analogUser.start();
        }
        latch.await();// 计数器減一 所有线程释放 并发访问。
        System.out.println("所有模拟请求结束  at " + sdf.format(new Date()));

    }

    static class AnalogUser extends Thread {
        String workerName;// 模拟用户姓名
        String openId;
        String openType;
        String amount;
        CountDownLatch latch;

        public AnalogUser(String workerName, String openId, String openType, String amount, CountDownLatch latch) {
            super();
            this.workerName = workerName;
            this.openId = openId;
            this.openType = openType;
            this.amount = amount;
            this.latch = latch;
        }
        @Override
        public void run() {
            // TODO Auto-generated method stub
            try {
                latch.countDown(); // 一直阻塞当前线程，直到计时器的值为0
                post();// 发送post 请求
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void post() {
            String result = "";
            System.out.println("模拟用户： " + workerName + " 开始发送模拟请求  at " + sdf.format(new Date()));
            String param = "userId=1002";
            result = sendGet("http://127.0.0.1:8813/customer/testDistributedLock", param);
            System.out.println("操作结果：" + result);
            System.out.println("模拟用户： " + workerName + " 模拟请求结束  at " + sdf.format(new Date()));

        }
        public static String sendGet(String url, String param) {
            StringBuilder result = new StringBuilder("");
            BufferedReader in = null;
            try {
                String urlNameString = StringUtils.isEmpty(param) ? url : url + "?" + param;
                URL realUrl = new URL(urlNameString);
                // 打开和URL之间的连接
                URLConnection connection = realUrl.openConnection();
                // 设置通用的请求属性
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                // 建立实际的连接
                connection.connect();
                // 定义 BufferedReader输入流来读取URL的响应
                in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                String line;
                while ((line = in.readLine()) != null) {
                    result.append(line);
                }
            } catch (Exception e) {
                // ////System.out.println("发送GET请求出现异常！" + e);
                e.printStackTrace();
                return "400";
            }
            // 使用finally块来关闭输入流
            finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            return result.toString();
        }
    }
}
