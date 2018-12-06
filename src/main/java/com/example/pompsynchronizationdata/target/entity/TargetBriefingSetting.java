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
 * date: 2018/12/05 16:54
 * description:
 */
@Data
@Entity
@Table(name = "t_briefing_setting")
public class TargetBriefingSetting  extends IdIdentityEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 报告生成时间
	*/
	private Integer generationTime;
	/**
	* 报告生成同步时间
	*/
	private Integer generationSyncTime;
	/**
	* 报告类型：day,week,month
	*/
	private String briefingType;
	/**
	* 报告模板类型:1，通用版，2 媒体版
	*/
	private Integer templateType;
	/**
	* 开启状态：1  开启 0 停用
	*/
	private Integer enabledState;
	/**
	* 自定义状态：0:默认；1：自定义
	*/
	private Integer customState;


    
}
