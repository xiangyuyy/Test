package com.example.demo.good.web;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.common.ConfigBeanValue;
import com.example.demo.common.DataBaseUtils;
import com.example.demo.common.PagePara;
import com.example.demo.common.PageVo;
import com.example.demo.common.Result;
import com.example.demo.good.entity.Good;
import com.example.demo.good.service.IGoodService;
import com.example.demo.goodclass.entity.Goodclass;
import com.example.demo.goodclass.service.IGoodclassService;

import lombok.Value;
import lombok.experimental.var;

/**
 * <p>
 * 商品信息 前端控制器
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-01-25
 */
@Controller
public class GoodController {
	@Autowired
	private IGoodService goodService;
	@Autowired
	private DataBaseUtils utils;

	@RequestMapping("/good/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("webui/good/list");
		return mav;
	}

	@RequestMapping("/good/listform")
	public ModelAndView listform(String id) {
		ModelAndView mav = new ModelAndView();
		Good good = new Good();
		Good result = goodService.selectById(id);
		String[] goodsignList = utils.getGoodsignName();
		List<String> goodtypeNameList = utils.getGoodtypeName();
		List<String> goodclassNameList = utils.getGoodclassName();
		if (result != null) {
			good = result;
		} else {
			good.setStatus(1);// 默认为上架
			good.setSign(goodsignList[0]);
			good.setPhotourl("");
			good.setGoodtypename(goodtypeNameList.get(0));
			good.setGoodclassname(goodclassNameList.get(0));
		}
		mav.addObject("goodsignList", goodsignList);
		mav.addObject("goodtypeNameList", goodtypeNameList);
		mav.addObject("goodclassNameList", goodclassNameList);
		mav.addObject("good", good);
		mav.setViewName("webui/good/listform");
		return mav;
	}

	@RequestMapping("/good/getlist")
	@ResponseBody
	public PageVo<Good> getlist(Good good, PagePara pagePara) {
		return goodService.GetPageList(good, pagePara);
	}

	@RequestMapping("/good/update")
	@ResponseBody
	public Result update(Good good) {
		Result result = new Result();
		boolean b;
		if (good.getId() == null || good.getId() == 0) {
			good.setCreatetime(new Date());
			good.setUpdatetime(new Date());
			b = goodService.insert(good);
		} else {
			good.setUpdatetime(new Date());
			b = goodService.updateById(good);
		}
		if (b) {
			result.setMsg("提交成功");
		} else {
			result.setSucess(false);
			result.setMsg("提交失败");
		}
		return result;
	}

	@RequestMapping("/good/upload")
	@ResponseBody
	public Result uplaod(HttpServletRequest req, @RequestParam("file") MultipartFile file) {
		Result result = new Result();
		try {
			// 第二种：获取项目路径 D:\git\daotie\daotie
			File directory = new File("");// 参数为空
			String courseFile = directory.getCanonicalPath();
			// 2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
			String fileName = System.currentTimeMillis() + file.getOriginalFilename();
			// 3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
			String url = "/uploaded/" + fileName;
			/*
			 * String destFileName1 = req.getServletContext().getRealPath("/static/");
			 * String destFileName = req.getServletContext().getRealPath("/static/") +
			 * "/uploaded/" + fileName;
			 */
			String destFileName = courseFile + "/target/classes/static/uploaded/" + fileName;
			// String destFileName = req.getServletContext().getRealPath("") + "uploaded" +
			// File.separator + fileName;
			// 4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
			File destFile = new File(destFileName);
			destFile.getParentFile().mkdirs();
			// 5.把浏览器上传的文件复制到希望的位置
			file.transferTo(destFile);
			FileReader reader = new FileReader("E:\\1.txt");
			reader.read();
			result.setMsg("提交成功");
			result.setData(url);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			result.setSucess(false);
			result.setMsg(e.getMessage());
		} catch (IllegalStateException e) {
			e.printStackTrace();
			result.setSucess(false);
			result.setMsg(e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			result.setSucess(false);
			result.setMsg(e.getMessage());
		}
		return result;
	}
}
