package com.itxs.product.service.impl;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itxs.common.utils.PageUtils;

import com.itxs.product.dao.ClassTeacherDao;
import com.itxs.product.entity.ClassTeacherEntity;
import com.itxs.product.service.ClassTeacherService;
import org.springframework.util.ObjectUtils;


@Service("classTeacherService")
public class ClassTeacherServiceImpl extends ServiceImpl<ClassTeacherDao, ClassTeacherEntity> implements ClassTeacherService {
    @Override
    public int  saveInfo(ClassTeacherEntity classTeacher)  {
        //Todo 首先我们判断classTeacher中的cid和status是否已经存在
        QueryWrapper<ClassTeacherEntity> queryWrapper=new QueryWrapper<>();
        if (classTeacher.getClassId()!=null){
            queryWrapper.eq("class_id",classTeacher.getClassId());
        }
        if (classTeacher.getTeachStatus()!=null){
            queryWrapper.eq("teach_status",classTeacher.getTeachStatus());
        }
        Integer count = baseMapper.selectCount(queryWrapper);
        if (count>0){
          return -1;
        }else{
            if (classTeacher.getTeacherId()!=null){
                return baseMapper.insert(classTeacher);
            }else{
               return -1;
            }
        }
    }

//
//    @Override
//    public PageUtils queryPage(Map<String, Object> params) {
//        IPage<ClassTeacherEntity> page = this.page(
//                new Query<ClassTeacherEntity>().getPage(params),
//                new QueryWrapper<ClassTeacherEntity>()
//        );
//
//        return new PageUtils(page);
//    }

}