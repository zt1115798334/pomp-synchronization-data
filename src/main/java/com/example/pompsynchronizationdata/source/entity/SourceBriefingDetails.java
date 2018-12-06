package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:19
 * description:
 */
@Data
@Entity
@Table(name = "t_briefing_details")
public class SourceBriefingDetails extends IdEntity {

	/**
	* 
	*/
	private Long briefingId;
	/**
	* 模板编号：0“预警舆情”；1“负面舆情”；2
	*/
	private Long templateNumber;
	/**
	* 删除状态：0
	*/
	private Long deleteState;
	/**
	* dayWeekMonth：日周月;special:专题
	*/
	private String briefingType;


    
}
