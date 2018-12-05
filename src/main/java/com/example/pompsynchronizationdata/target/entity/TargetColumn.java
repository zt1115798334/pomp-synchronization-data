package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 17:41
 * description:
 */
@Data
@Entity
@Table(name = "t_column")
public class TargetColumn extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 栏目名称
	*/
	private String columnName;
	/**
	* 排序
	*/
	private Integer orderBy;
	/**
	* 显示状态 0 不可见，1可见
	*/
	private Integer showState;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 位置:  1居中 2 居右
	*/
	private Integer position;
	/**
	* 栏目编码 0 为用户自定义 其他的参考系统栏目
	*/
	private Integer code;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
