package com.example.demo.good.mapper;

import com.example.demo.good.entity.Good;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 商品信息 Mapper 接口
 * </p>
 *
 * @author chenxiangyu
 * @since 2019-01-25
 */
public interface GoodMapper extends BaseMapper<Good> {

	@Select("select * from good")
	List<Good> getAllGoodList();
}
