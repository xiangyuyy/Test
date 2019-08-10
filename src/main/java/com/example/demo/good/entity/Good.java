package com.example.demo.good.entity;

import java.math.BigDecimal;
import java.util.Date;
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
 * 商品信息
 * </p>
 *
 * @author chenxiangyu  come on
 * @since 2019-01-25
 */
@Data
@Accessors(chain = true)
public class Good{

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 微博。。
     */
    private String goodtypename;

    /**
     * 刷粉 点赞
     */
    private String goodclassname;

    private String goodname;

    private String describe;

    /**
     * 下单说明 
     */
    private String orderdescribe;

    private String photourl;

    /**
     * 最新上架 热销商品 精选商品
     */
    private String sign;

    /**
     * 快速的价格
     */
    private BigDecimal fastprice;

    /**
     * 慢速的价格
     */
    private BigDecimal slowprice;

    /**
     * 拿货快速的价格
     */
    private BigDecimal thirdfastprice;

    /**
     * 拿货慢速的价格
     */
    private BigDecimal thirdslowprice;

    /**
     * 0 下架 1 上架
     */
    private Integer status;

    private Date createtime;

    private Date updatetime;

}
