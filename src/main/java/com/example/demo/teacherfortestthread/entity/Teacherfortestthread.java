package com.example.demo.teacherfortestthread.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.Version;

import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-10-20
 */
@Data
/*@Accessors(chain = true)*/
public class Teacherfortestthread {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "Id")
    private Integer Id;

    private String Name;

    private Integer Age;

}
