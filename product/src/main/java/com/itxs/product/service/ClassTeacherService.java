package com.itxs.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itxs.common.utils.PageUtils;
import com.itxs.product.entity.ClassTeacherEntity;

import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email sunlightcs@gmail.com
 * @date 2021-03-16 11:55:05
 */
public interface ClassTeacherService extends IService<ClassTeacherEntity> {

//    PageUtils queryPage(Map<String, Object> params);

    int saveInfo(ClassTeacherEntity classTeacher) ;
}

