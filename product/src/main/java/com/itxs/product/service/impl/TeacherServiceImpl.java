package com.itxs.product.service.impl;

import com.itxs.product.entity.ClassEntity;
import com.itxs.product.entity.ClassTeacherEntity;
import com.itxs.product.service.ClassTeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itxs.common.utils.PageUtils;

import com.itxs.product.dao.TeacherDao;
import com.itxs.product.entity.TeacherEntity;
import com.itxs.product.service.TeacherService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;


@Service("teacherService")
public class TeacherServiceImpl extends ServiceImpl<TeacherDao, TeacherEntity> implements TeacherService {

    @Resource
    private ClassTeacherService classTeacherService;

    @Transactional
    @Override
    public void removeInfo(String id) {


        if(!ObjectUtils.isEmpty(id)) {
            classTeacherService.remove(new QueryWrapper<ClassTeacherEntity>().eq("teacher_id", id));
            baseMapper.deleteById(id);
        }
    }

    /**
     * 通过教师号获取所有班级
     * @param teacherName
     * @return
     */
    @Override
    public List<ClassEntity> getAllTeacher(String teacherName) {

        if (!ObjectUtils.isEmpty(teacherName)) {
            return baseMapper.getAllClass(teacherName);
        }else{
            return null;
        }
    }

//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<TeacherEntity> page = this.page(
//                new Query<TeacherEntity>().getPage(params),
//                new QueryWrapper<TeacherEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}