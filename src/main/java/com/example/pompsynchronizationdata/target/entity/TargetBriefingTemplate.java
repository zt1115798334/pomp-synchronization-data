package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_briefing_template")
public class TargetBriefingTemplate  extends IdEntity {

	/**
	* 报告id
	*/
	private Long briefingId;
	/**
	* 报告类型：day,week,month
	*/
	private String briefingType;
	/**
	* 报告模板类型:1，通用版，2 媒体版
	*/
	private Integer templateType;
	/**
	* 模板编号：普通模板:{	0“预警舆情”；1“负面舆情”；2
	*/
	private Integer templateNumber;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
