package com.example.demo.bicyle.entity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
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

    @TableId(value = "userid")
    private Integer userid;

    private String path;

    private Integer level;

    private Integer vision;

}
