package com.itxs.product.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author ${author}
 * @email sunlightcs@gmail.com
 * @date 2021-03-16 11:55:05
 */
@Data
@TableName("lp_class_teacher")
public class ClassTeacherEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 班级号
	 */
	@TableId
	private Integer classId;
	/**
	 * 教师号
	 */
	private Integer teacherId;
	/**
	 * 语数外（3门课程，0-语文，1-数学，2-英语）
	 */
	private Integer teachStatus;

}
