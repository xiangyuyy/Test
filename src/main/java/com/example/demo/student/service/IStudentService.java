package com.example.demo.student.service;

import com.example.demo.student.entity.Student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-04-10
 */
public interface IStudentService extends IService<Student> {
	Student selectsById(@Param("id") int id);
	List<Student> selectsList();
}
