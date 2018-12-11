package com.example.pompsynchronizationdata.target.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;

import lombok.Data;


/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/11 11:15
 * description:
 */

@Data
@Entity
@Table(name = "t_language_group")
public class TargetLanguageGroup extends IdIdentityEntity{
	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 栏目名称'
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
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
