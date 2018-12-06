package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Data
@Entity
@Table(name = "t_briefing")
public class TargetBriefing extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 报告的取值时间开始
	*/
	private LocalDateTime briefingStartTime;
	/**
	* 报告的取值时间结束
	*/
	private LocalDateTime briefingEndTime;
	/**
	* 报告类型：day,week,month
	*/
	private String briefingType;
	/**
	* 报告模板类型:1，通用版，2 媒体版
	*/
	private Integer templateType;
	/**
	* 报告的日期
	*/
	private LocalDate briefingDate;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
