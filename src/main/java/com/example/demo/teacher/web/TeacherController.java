package com.example.demo.teacher.web;

import java.util.List;

import com.example.demo.TextThreadWrite;
import com.example.demo.teacherfortestthread.service.ITeacherfortestthreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.example.demo.DemoApplication;
import com.example.demo.teacher.entity.Teacher;
import com.example.demo.teacher.service.ITeacherService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-01-14
 */
@Controller
public class TeacherController {
    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);
	@Autowired
	private ITeacherService  teacherService;

	@Autowired
	ITeacherfortestthreadService iTeacherfortestthreadService;
	@RequestMapping("/teacher")
	public ModelAndView  index() {
		ModelAndView mav1=new ModelAndView();
		 mav1.addObject("message", "helloWorld");
		    EntityWrapper<Teacher> ew=new EntityWrapper<Teacher>();
		    Page<Teacher> page = new Page<Teacher>(1, 5);		    
		    Page<Teacher> teacherIPage= teacherService.selectPage(page,ew);;
		 mav1.addObject("teacherIPage", teacherIPage);
		 mav1.setViewName("login");
		 return mav1;
	}
	@RequestMapping("/loginaction")
	public ModelAndView  loginaction(String name,int age) {
		logger.info("loginaction参数,name{},age{}",name,age);
		ModelAndView mav=new ModelAndView();
	    EntityWrapper<Teacher> ew=new EntityWrapper<Teacher>();
	    ew.where("name = {0}",name).andNew("age > {0}",age).orderBy("age");
		List<Teacher> result = teacherService.selectList(ew);
		if (result.size() > 1) {
			 mav.addObject("message", "登录成功");	
		}
		else {
			 mav.addObject("message", "登录失败");	
		}
		 mav.setViewName("loginin");
		 return mav;
	}
	@GetMapping("/Test")
    @ResponseBody
	public  String getTest(){
		List<Teacher> list = teacherService.selectList(new EntityWrapper<>());
		Long begin = System.currentTimeMillis();
/*		try {
			TextThreadWrite.exec(list,iTeacherfortestthreadService);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		Long end = System.currentTimeMillis();
		Long run = end - begin;
		//Thread.sleep(20000);
		System.out.println("运行时间"+run);
		return  "Test";
	}
}

