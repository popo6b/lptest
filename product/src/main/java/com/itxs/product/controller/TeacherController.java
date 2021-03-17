package com.itxs.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.itxs.product.entity.ClassEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.itxs.product.entity.TeacherEntity;
import com.itxs.product.service.TeacherService;
import com.itxs.common.utils.PageUtils;
import com.itxs.common.utils.R;

import javax.annotation.Resource;


/**
 * 
 *
 * @author ${author}
 * @email sunlightcs@gmail.com
 * @date 2021-03-16 11:55:06
 */
@RestController
@RequestMapping("product/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = teacherService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") Integer id){

		TeacherEntity teacher = teacherService.getById(id);
        return R.ok().put("teacher", teacher);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody TeacherEntity teacher){

		teacherService.save(teacher);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody TeacherEntity teacher){

		teacherService.updateById(teacher);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){

		teacherService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 删除教师信息
     * @param id
     * @return
     */
    @DeleteMapping("/delete-info/{id}")
    public R deleteInfo(@PathVariable String id){

        if (!ObjectUtils.isEmpty(id)){
            teacherService.removeInfo(id);
            return R.ok();
        }else{
            return R.error(100001,"请求参数错误");
        }
    }

    /**
     * 获取这个老师教的所有班级
     * @param teacherName
     * @return
     */
    @GetMapping("/get-allClass")
    @SentinelResource(value = "get-allClass", blockHandler = "deal_testhotkey")
    public R GetMapping(@RequestParam String teacherName){

        if (!ObjectUtils.isEmpty(teacherName)){
            List<ClassEntity> allClass = teacherService.getAllTeacher(teacherName);
            return R.ok().put("allClass",allClass);
        }else{
            return R.error(100001,"参数错误");
        }
    }

    public R deal_testhotkey(String teacherName, BlockException e){

        return R.error("服务限流");
    }

}
