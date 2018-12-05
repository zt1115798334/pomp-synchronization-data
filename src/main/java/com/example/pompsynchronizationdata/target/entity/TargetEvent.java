package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 15:55
 * description:
 */
@Data
@Entity
@Table(name = "t_event")
public class TargetEvent extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 事件名称
	*/
	private String eventTitle;
	/**
	* 事件开始时间
	*/
	private LocalDateTime eventStartTime;
	/**
	* 事件结束时间
	*/
	private LocalDateTime eventEndTime;
	/**
	* 相关词
	*/
	private String relatedWords;
	/**
	* 舆情词
	*/
	private String opinionWords;
	/**
	* 排除词
	*/
	private String exclusionWords;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;
	/**
	* 显示状态 0 不可见，1可见
	*/
	private Integer showState;
	/**
	* 置顶状态：0不置顶，1置顶
	*/
	private Integer topState;
	/**
	* 置顶时间
	*/
	private LocalDateTime topTime;
	/**
	* app 中是显示状态 0 不可见，1可见
	*/
	private Integer appShowState;
	/**
	* app 中置顶状态 1：置顶，0:不置顶
	*/
	private Integer appTopState;
	/**
	* app中置顶时间
	*/
	private LocalDateTime appTopTime;


    
}
