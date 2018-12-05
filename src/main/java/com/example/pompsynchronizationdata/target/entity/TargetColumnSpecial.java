package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 17:41
 * description:
 */
@Data
@Entity
@Table(name = "t_column_special")
public class TargetColumnSpecial extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 分组id
	*/
	private Long columnId;
	/**
	* 专题名称
	*/
	private String specialName;
	/**
	* 排序
	*/
	private Integer orderBy;
	/**
	* 检索区域：title标题，content内容，all所有
	*/
	private String searchArea;
	/**
	* 全部 all ， 正面：positive, 负面：negative 中性 neutral
	*/
	private String emotion;
	/**
	* 载体
	*/
	private String carrier;
	/**
	* 相关词
	*/
	private String relatedWords;
	/**
	* 舆情词
	*/
	private String opinionWords;
	/**
	* 歧义词
	*/
	private String ambiguousWords;
	/**
	* 排除词
	*/
	private String exclusionWords;
	/**
	* 站点URL
	*/
	private String siteUrl;
	/**
	* 作者
	*/
	private String author;
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
