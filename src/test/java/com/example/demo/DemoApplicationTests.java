package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println("12122");
	}
	@Test
	public void testDateTime() {
		LocalDateTime  start  = LocalDateTime.now(ZoneId.of("Asia/Aden"));
		LocalDateTime  start1  = LocalDateTime.now();
		DateTimeFormatter  dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		System.out.println(start.format(dateTimeFormatter));
		System.out.println(start1.format(dateTimeFormatter));
				
	}
	@Test
	public void testObjectJson() {
		JSONObject jsonObject = new JSONObject();
		SAXReader reader = new SAXReader();
		String text = "<html>" + "<head>" + "<title>dom4j解析一个例子</title>"
                + "<script>" + "<username>yangrong</username>"
                + "<password>123456</password>" + "</script>" + "</head>"
                + "<body>" + "<result>0</result>" + "<form>"
                + "<banlce>1000</banlce>" + "<subID>36242519880716</subID>"
                + "</form>" + "</body>" + "</html>";
		try {
			Document document = DocumentHelper.parseText(text);
            // 获取根节点
            Element rootElt = document.getRootElement(); 
            // 拿到根节点的名称
            System.out.println("根节点：" + rootElt.getName()); 
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		
		}
	}
	@Test
	public void testList() throws ParseException {

/*        Date date = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String s = format1.format(date);
        Date today = format1.parse(s);
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = c.getTime();//明天
        System.out.println(1212);*/

/*	    Object o = new ArrayList<>();
        List<String> list = (List<String>) o;

        List<String> lista = new ArrayList<>();
        List<String> listW =  (List<String>) lista;

        System.out.println("234234");*/

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String s = simpleDateFormat.format(date);
        Date today = simpleDateFormat.parse(s);
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();//昨天

/*        DateFormat df = DateFormat.getDateInstance();
        Date date = new Date();
        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String s = df.format(date);
        Date today = format1.parse(s);
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, 1);
        Date tomorrow = c.getTime();//这是明天
        c.setTime(today);
        c.add(Calendar.DAY_OF_MONTH, -1);
        Date yesterday = c.getTime();//这是昨天*/
	}
}

