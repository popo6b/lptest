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
public interface TeacherService extends IService<TeacherEntity> {
    void removeInfo(String id);

    /**
     * 通过教室id获取这个教师的所有课程
     * @param teacherId
     * @return
     */
    List<ClassEntity> getAllTeacher(String teacherId);

//    PageUtils queryPage(Map<String, Object> params);
}

