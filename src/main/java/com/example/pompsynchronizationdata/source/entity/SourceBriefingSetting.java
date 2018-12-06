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
@Table(name = "t_briefing_setting")
public class SourceBriefingSetting extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 时间
	*/
	private LocalDateTime time;
	/**
	* 报告生成时间
	*/
	private String generationTime;
	/**
	* 报告生成同步时间
	*/
	private String generationSyncTime;
	/**
	* 报告类型：day,week,month
	*/
	private String briefingType;
	/**
	* 报告模板类型:1，通用版，2 媒体版
	*/
	private String templateType;
	/**
	* 开关状态on：开； off ： 关
	*/
	private String switchState;
	/**
	* 0:默认；1：自定义
	*/
	private Integer isCustom;


    
}
