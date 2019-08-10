package com.example.demo.student.service.impl;

import com.example.demo.student.entity.Student;
import com.example.demo.student.mapper.StudentMapper;
import com.example.demo.student.service.IStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-04-10
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

	@Override
	public Student selectsById(int id) {
		return this.baseMapper.selectsById(id);
	}

	@Override
	public List<Student> selectsList() {
		return this.baseMapper.selectsList();
	}

}
