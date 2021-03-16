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
 * @date 2021-03-16 11:55:06
 */
@Data
@TableName("lp_class")
public class ClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 班级id
	 */
	@TableId
	private Integer id;
	/**
	 * 班级名
	 */
	private String className;

}
