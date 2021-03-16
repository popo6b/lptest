package com.itxs.product.dao;

import com.itxs.product.entity.ClassEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author ${author}
 * @email sunlightcs@gmail.com
 * @date 2021-03-16 11:55:06
 */
@Mapper
public interface ClassDao extends BaseMapper<ClassEntity> {

    int deleteInfo(String classId);
	
}
