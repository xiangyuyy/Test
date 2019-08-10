package com.example.demo.student.mapper;

import com.example.demo.student.entity.Student;

import org.apache.ibatis.annotations.Param;

import java.util.List;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-04-10
 */
public interface StudentMapper extends BaseMapper<Student> {

	@Select("SELECT * FROM student WHERE Sid = #{id}")
	@Results({
	       //查询关联对象
	       @Result(property = "teacher",
	               column = "Sid",
	               one = @One(select = "com.example.demo.teacher.mapper.TeacherMapper.selectById"))
	})
	Student selectsById(@Param("id") int id);
	
	@Select("SELECT * FROM student")
	@Results({
	       //查询关联对象
	       @Result(property = "teacher",
	               column = "Sid",
	               one = @One(select = "com.example.demo.teacher.mapper.TeacherMapper.selectById"))
	})
	List<Student> selectsList();
}
