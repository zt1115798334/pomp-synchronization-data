package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:13
 * description:
 */
@Data
@Entity
@Table(name = "t_abroad_socialization_group")
public class TargetAbroadSocializationGroup extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 分组名称
	*/
	private String groupName;
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
	* 编号
	*/
	private Integer code;
	/**
	* 父级id
	*/
	private Long parentId;
	/**
	* 等级
	*/
	private Integer level;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
