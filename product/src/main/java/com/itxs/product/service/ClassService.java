package com.itxs.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itxs.common.utils.PageUtils;
import com.itxs.product.entity.ClassEntity;
import com.itxs.product.entity.TeacherEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author ${author}
 * @email sunlightcs@gmail.com
 * @date 2021-03-16 11:55:06
 */
public interface ClassService extends IService<ClassEntity> {

//    PageUtils queryPage(Map<String, Object> params);
    void deleteClassInfo(String classId);

    List<TeacherEntity> getAllTeacher(String classId);


}

