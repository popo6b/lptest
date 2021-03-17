package com.itxs.product.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itxs.product.entity.ClassTeacherEntity;
import com.itxs.product.service.ClassTeacherService;
import com.itxs.common.utils.R;

import javax.annotation.Resource;


/**
 * 
 *
 * @author ${author}
 * @email sunlightcs@gmail.com
 * @date 2021-03-16 11:55:05
 */
@RestController
@RequestMapping("product/classteacher")
public class ClassTeacherController {

    @Resource
    private ClassTeacherService classTeacherService;

    /**
     * 列表
     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = classTeacherService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @RequestMapping("/info/{classId}")
    public R info(@PathVariable("classId") Integer classId){

		ClassTeacherEntity classTeacher = classTeacherService.getById(classId);
        return R.ok().put("classTeacher", classTeacher);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ClassTeacherEntity classTeacher){

        int i = classTeacherService.saveInfo(classTeacher);
        if (i>0){
            return R.ok();
        }else{
            return R.error("操作失败");
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ClassTeacherEntity classTeacher){

		classTeacherService.updateById(classTeacher);
        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] classIds){

		classTeacherService.removeByIds(Arrays.asList(classIds));
        return R.ok();
    }

}
