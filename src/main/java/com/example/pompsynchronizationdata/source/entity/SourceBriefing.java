package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:19
 * description:
 */
@Data
@Entity
@Table(name = "t_briefing")
public class SourceBriefing extends IdEntity {

	/**
	* 用户ID
	*/
	private String userId;
	/**
	* 简报名称(按照时间自动生成)
	*/
	private String title;
	/**
	* 载体分布统计:1显示,0不显示
	*/
	private Integer chartFenbu;
	/**
	* 舆情属性监控:1显示,0不显示
	*/
	private Integer chartShuxing;
	/**
	* 前10负面信息站点:1显示,0不显示
	*/
	private Integer chartFumian;
	/**
	* 前10正面信息站点:1显示,0不显示
	*/
	private Integer chartZhengmian;
	/**
	* 
	*/
	private String checkedTable;
	/**
	* 
	*/
	private String checkedList;
	/**
	* 概述
	*/
	private String content;
	/**
	* 
	*/
	private LocalDateTime time;
	/**
	* 0日报1周报2月报3分类报告
	*/
	private Long type;
	/**
	* 0:未删除；1:已删除
	*/
	private Integer isDelete;
	/**
	* 报告模板类型:1，通用版，2 媒体版
	*/
	private String templateType;
	/**
	* 采集开始时间
	*/
	private LocalDateTime startDateTime;
	/**
	* 采集结束时间
	*/
	private LocalDateTime endDateTime;


    
}
