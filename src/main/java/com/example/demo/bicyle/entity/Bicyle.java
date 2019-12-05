package com.example.demo.bicyle.entity;

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
 * @since 2019-09-27
 */
@Data
@Accessors(chain = true)
public class Bicyle  {

    private static final long serialVersionUID = 1L;

    private Integer userid;

    private String path;

    private Integer level;

}
