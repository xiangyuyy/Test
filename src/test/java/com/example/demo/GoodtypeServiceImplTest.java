package com.example.demo;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.common.ConfigBeanValue;
import com.example.demo.common.TestOneConfig;
import com.example.demo.good.service.IGoodService;
import com.example.demo.goodtype.entity.Goodtype;
import com.example.demo.goodtype.service.IGoodtypeService;
import com.example.demo.student.entity.Student;
import com.example.demo.student.service.IStudentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodtypeServiceImplTest {
	@Autowired
	private IGoodtypeService goodtyperService;
	@Autowired
	private IStudentService StudentrService;
	
	@Autowired
	private TestOneConfig testOneConfig;
	@Autowired
	private IGoodService goodService;
/*	@Test
	public void testGetPageList() {
		Goodtype g = goodtyperService.selectById(2);
		System.out.println(g.getName());
	}
	@Test
	public void test1GetPageList() {
		Goodtype g = goodtyperService.selectById(3);
		System.out.println(g.getName());
	}
	@Test
	public void getstudent() {
		Student g = StudentrService.selectsById(1);
		System.out.println(g.getTeacher().getName());
	}
	@Test
	public void getstudentlist() {
		List<Student> g = StudentrService.selectsList();
		System.out.println(g.get(0).getTeacher().getName());
	}*/
	@Test
	public void getAllGoodsByMyselfMapper() {
		goodService.getAllGoodList();
		System.out.println("开心死了！");
		System.err.println(testOneConfig.getFirst());
		System.err.println(testOneConfig.getSecond());
	}

}
