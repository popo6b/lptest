package com.itxs.product.service.impl;

import com.itxs.product.dao.ClassTeacherDao;
import com.itxs.product.entity.ClassTeacherEntity;
import com.itxs.product.entity.TeacherEntity;
import com.itxs.product.service.ClassTeacherService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.itxs.product.dao.ClassDao;
import com.itxs.product.entity.ClassEntity;
import com.itxs.product.service.ClassService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;


@Service("classService")
public class ClassServiceImpl extends ServiceImpl<ClassDao, ClassEntity> implements ClassService {

    @Resource
    private ClassTeacherService classTeacherService;

    @Resource
    private TeacherServiceImpl teacherService;

    @Transactional
    @Override
    public void deleteClassInfo(String classId) {

        //Todo 删除我们的教室信息和删除中间表的信息
        if (!ObjectUtils.isEmpty(classId)) {
            classTeacherService.removeById(classId);
            baseMapper.deleteById(classId);
        }

    }



    /**
     * 通过班级获得所有的
     * @param classId
     * @return
     */
    @Override
    public List<TeacherEntity> getAllTeacher(String classId) {

        //Todo 业务层的方式进行实现
        if (!ObjectUtils.isEmpty(classId)) {
            List<ClassTeacherEntity> classTeachers = classTeacherService.list(new QueryWrapper<ClassTeacherEntity>().eq("class_id", classId));
            List<Integer> ids = new ArrayList<>();
            for (ClassTeacherEntity classTeacher : classTeachers) {
                ids.add(classTeacher.getTeacherId());
            }
            List<TeacherEntity> teacherEntities = teacherService.listByIds(ids);
            return teacherEntities;
        }else{
            return null;
        }
    }




//
//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<ClassEntity> page = this.page(
//                new Query<ClassEntity>().getPage(params),
//                new QueryWrapper<ClassEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}