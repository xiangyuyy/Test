package com.example.demo;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import com.example.demo.bicyle.service.IBicyleService;
import com.example.demo.teacher.entity.Teacher;
import com.example.demo.teacher.service.ITeacherService;
import com.example.demo.utils.FileUtil;
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
/*	@Autowired
	private IGoodtypeService goodtyperService;
	@Autowired
	private IStudentService StudentrService;*/

	@Autowired
	private ITeacherService teacherService;
    @Autowired
    private IBicyleService bicyleService;
/*	@Autowired
	private TestOneConfig testOneConfig;
	@Autowired
	private IGoodService goodService;*/


    @Test
    public void testImportTestBicyle(){
        List<String> list = new ArrayList<String>();
        /*	String path = "C:\\Users\\xiaoh\\Desktop\\sso-logs\\205\\sso_localhost_access_log.2019-08-30.txt";*/
        String path = "C:\\Users\\xiaoh\\Desktop\\text.txt";
        try {
            File f = new File(path);
            if (f.exists()) {
                FileReader fr = null;
                try {
                    fr = new FileReader(path);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    list.add(line);
                    line = br.readLine();
                }
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImpotTextBicyle.exec(list,bicyleService);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	/*@Test
	public void testImportTest(){
		List<String> list = new ArrayList<String>();
		String path = "C:\\Users\\xiaoh\\Desktop\\sso-logs\\205\\sso_localhost_access_log.2019-08-30.txt";
        String path = "C:\\Users\\xiaoh\\Desktop\\sso-logs\\186\\sso_localhost_access_log.2019-09-01.txt";
        try {
            File f = new File(path);
            if (f.exists()) {
                FileReader fr = null;
                try {
                    fr = new FileReader(path);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while (line != null) {
                    list.add(line);
                    line = br.readLine();
                }
                br.close();
                fr.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ImpotText.exec(list,teacherService);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		String path = "C:\\Users\\xiaoh\\Desktop\\sso-logs\\205\\sso_localhost_access_log.2019-08-30.txt";
		try {
			File f = new File(path);
			if (f.exists()) {
				FileReader fr = null;
				try {
					fr = new FileReader(path);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);
				String line = br.readLine();
				while (line != null) {
					System.out.println(line);
					Teacher teacher = new Teacher();
					int beginIndex = line.indexOf("POST");
					if (beginIndex > 0) {
						int endIndex = line.indexOf("HTTP");
						String b = line.substring(beginIndex, endIndex);
						teacher.setName(b);
						teacherService.insert(teacher);
					}
					line = br.readLine();
				}
				br.close();
				fr.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String c = "172.16.188.52 - - [30/Aug/2019:17:41:33 +0800] \"POST /shop/getSetShop HTTP/1.0\" 200 359";
		int beginIndex = c.indexOf("POST");
		int endIndex = c.indexOf("HTTP");
		String b = c.substring(beginIndex,endIndex);
		System.out.println("b = " + b);
		String content = null;
		try {
			content = FileUtil.getFileContent("C:\\Users\\xiaoh\\Desktop\\sso-logs\\205\\test.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(content);
	}*/
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
	}*/
/*	@Test
	public void getstudentlist() {
		List<Student> g = StudentrService.selectsList();
		System.out.println(g.get(0).getTeacher().getName());
	}*/
	@Test
	public void getAllGoodsByMyselfMapper() {
/*		goodService.getAllGoodList();
		System.out.println("开心死了！");//s
		System.err.println(testOneConfig.getFirst());
		System.err.println(testOneConfig.getSecond());*/

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> s = list.stream().filter(x -> x.equals(4)).collect(Collectors.toList());
        System.out.println(323);
	}

}
