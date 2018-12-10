package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:19
 * description:
 */
@Data
@Entity
@Table(name = "t_abroad_news_group")
public class TargetAbroadNewsGroup extends IdIdentityEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 栏目名称
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
