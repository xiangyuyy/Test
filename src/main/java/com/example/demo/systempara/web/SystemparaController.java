package com.example.demo.systempara.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.security.MD5Encoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.common.Result;
import com.example.demo.systempara.entity.Systempara;
import com.example.demo.systempara.service.ISystemparaService;
import com.example.demo.teacher.entity.Teacher;
import com.example.demo.teacher.service.ITeacherService;
import com.example.demo.utils.MD5Encrypt;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

/**
 * <p>
 * 系统参数表 前端控制器
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-01-23
 */
@Controller
/* @RequestMapping("/") */
public class SystemparaController {
	private static final Logger logger = LoggerFactory.getLogger(SystemparaController.class);
	@Autowired
	private ISystemparaService systemparaService;

	@RequestMapping("/index")
	public ModelAndView index() {
		logger.info("index1111");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webui/index");
		return mav;
	}
	@RequestMapping("/")
	public ModelAndView frist() {
		logger.info("frist1111");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webui/index");
		return mav;
	}

	@RequestMapping("/console")
	public ModelAndView console() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webui/console");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webui/login");
		return mav;
	}

	@RequestMapping("/syspara/index")
	public ModelAndView sysParaIndex() {
		EntityWrapper<Systempara> ew = new EntityWrapper<Systempara>();
		Systempara systempara = systemparaService.selectOne(ew);
		ModelAndView mav = new ModelAndView();
		mav.addObject("systempara", systempara);
		mav.setViewName("webui/syspara/index");
		return mav;
	}

	@RequestMapping("/loginin")
	@ResponseBody
	public Result loginIn(String username, String password) {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		EntityWrapper<Systempara> ew = new EntityWrapper<Systempara>();
		password = MD5Encrypt.MD5Encode(password);
		ew.where("adminaccount = {0}", username).andNew("adminpassword = {0}", password);
		List<Systempara> list = systemparaService.selectList(ew);
		Result result = new Result();
		if (list.size() == 1) {
			result.setMsg("登录成功");
			HttpSession session = request.getSession();			
			session.setAttribute("adminName", "adminName");
		} else {
			result.setSucess(false);
			result.setMsg("登录失败");
		}
		return result;
	}
	
	@RequestMapping("/syspara/update")
	@ResponseBody
	public Result sysParaUpdate(Systempara systempara,String oldPass) {
		if (!oldPass.equals(systempara.getAdminpassword())) {
			systempara.setAdminpassword(MD5Encrypt.MD5Encode(systempara.getAdminpassword()));
		}
		systempara.setUpdatetime(new Date());
		systempara.setCreatetime(new Date());
		boolean b = systemparaService.updateById(systempara);
		Result result = new Result();
		if (b) {
			result.setMsg("提交成功");
		}
		else {
			result.setSucess(false);
			result.setMsg("提交失败");
		}
		return result;
	}
}
