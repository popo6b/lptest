package com.itxs.product.dao;

import com.itxs.product.entity.ClassEntity;
import com.itxs.product.entity.TeacherEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 
 * 
 * @author ${author}
 * @email sunlightcs@gmail.com
 * @date 2021-03-16 11:55:06
 */
@Mapper
public interface TeacherDao extends BaseMapper<TeacherEntity> {

    List<ClassEntity> getAllClass(String teacherName);
}
