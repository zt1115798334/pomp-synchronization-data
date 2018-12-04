package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:53
 * description:
 */
@Data
@Entity
@Table(name = "t_warning_rule")
public class SourceWarningRule extends IdEntity {

	/**
	* 用户ID
	*/
	private Long userId;
	/**
	* 名称
	*/
	private String name;
	/**
	* 状态:1开启,0停用
	*/
	private Integer status;
	/**
	* 规则Json字符串
	*/
	private String value;
	/**
	* 0:自动预警；1:手动预警
	*/
	private Integer ruleType;
	/**
	* 保存时间
	*/
	private LocalDateTime time;
	/**
	* 预警等级  red 红色 ，orange 橙色，yellow黄色
	*/
	private String warningLevel;
	/**
	* 预警位置 all全部 title 标题, content 内容
	*/
	private String warningArticlePosition;


    
}
