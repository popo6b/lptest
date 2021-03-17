package com.itxs.product.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.itxs.product.entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.itxs.product.entity.ClassEntity;
import com.itxs.product.service.ClassService;
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
@RequestMapping("product/class")
public class ClassController {

    @Resource
    private ClassService classService;

//    /**
//     * 列表
//     */
//    @RequestMapping("/list")
//    public R list(@RequestParam Map<String, Object> params){
//        PageUtils page = classService.queryPage(params);
//
//        return R.ok().put("page", page);
//    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    public R info(@PathVariable("id") String id){

		ClassEntity classroom = classService.getById(id);
        return R.ok().put("classroom", classroom);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    public R save(@RequestBody ClassEntity classroom){

		classService.save(classroom);
        return R.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public R update(@RequestBody ClassEntity classroom){

		classService.updateById(classroom);
        return R.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    public R delete(@RequestBody Integer[] ids){

		classService.removeByIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
     * 删除某个班级的信息
     * @param id
     * @return
     */
    @DeleteMapping("/deleteInfo/{id}")
    public R deleteInfo(@PathVariable String id){

        if (!ObjectUtils.isEmpty(id)){
            classService.deleteClassInfo(id);
            return R.ok();
        }else{
            return R.error(100001,"请求参数错误");
        }
    }

    /**
     * 获取这个教室里面的所有老师
     * @param classId 教室号
     * @return
     */
    @GetMapping("/get-teachers/{classId}")
    public R getClassAllTeacher(@PathVariable String classId){

        if(!ObjectUtils.isEmpty(classId)){
            List<TeacherEntity> allTeacher = classService.getAllTeacher(classId);
            return R.ok().put("teachers",allTeacher);
        }else{
            return R.error(100001,"请求参数错误");
        }
    }

}
