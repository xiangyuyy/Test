package com.example.demo.student.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.example.demo.teacher.entity.Teacher;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;



import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-04-10
 */
@Data
@Accessors(chain = true)
public class Student extends Model<Student> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "SId", type = IdType.AUTO)
    private Integer SId;

    private String name;

    private Integer teacherid;
    @TableField(exist = false) 
    private Teacher teacher;

    @Override
    protected Serializable pkVal() {
        return this.SId;
    }

}
