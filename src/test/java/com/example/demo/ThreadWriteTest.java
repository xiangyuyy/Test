package com.example.demo;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.example.demo.bicyle.service.IBicyleService;
import com.example.demo.teacher.entity.Teacher;
import com.example.demo.teacher.service.ITeacherService;
import com.example.demo.teacherfortestthread.entity.Teacherfortestthread;
import com.example.demo.teacherfortestthread.service.ITeacherfortestthreadService;
import net.sf.cglib.beans.BeanCopier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ThreadWriteTest {
/*	@Autowired
	private IGoodtypeService goodtyperService;
	@Autowired
	private IStudentService StudentrService;*/

    @Autowired
    ITeacherService teacherService;
    @Autowired
    ITeacherfortestthreadService iTeacherfortestthreadService;
    @Autowired
    private IBicyleService bicyleService;
/*	@Autowired
	private TestOneConfig testOneConfig;
	@Autowired
	private IGoodService goodService;*/


    @Test
    public void testImportTestBicyle() throws InterruptedException {
/*        List<Teacher> list = teacherService.selectList(new EntityWrapper<>());
        Long begin = System.currentTimeMillis();
        list.parallelStream().forEach(x->{
            Teacherfortestthread teacherfortestthread = new Teacherfortestthread();
            teacherfortestthread.setId(x.getId());
            iTeacherfortestthreadService.insert(teacherfortestthread);
        });
        //TextThreadWrite.exec(list,iTeacherfortestthreadService);
        Long end = System.currentTimeMillis();
        Long run = end - begin;
        //Thread.sleep(20000);
        System.out.println("运行时间"+run);*/
        System.out.println(121213);
        Teacher teacher = teacherService.selectById(131464);
        final BeanCopier copier = BeanCopier.create(Teacher.class, Teacherfortestthread.class,false);
        Teacherfortestthread teacherfortestthread = new Teacherfortestthread();
        copier.copy(teacher,teacherfortestthread,null);
        //iTeacherfortestthreadService.insert(teacherfortestthread);
    }
}
