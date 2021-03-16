package com.itxs.consumer.controller;

import com.itxs.common.utils.R;
import com.itxs.consumer.fegin.ClassFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author it小帅
 * @version 1.0
 * @datetime 2021/3/16 16:36
 */
@RequestMapping("/consumer")
public class ConsumerClassController {

    @Resource
    private ClassFeign classFeign;

    @RequestMapping("/get-all-class/{classId}")
    public R getAllClass(@PathVariable("classId") String classId){
       return classFeign.getClassAllTeacher(classId);
    }
}
