package com.example.pompsynchronizationdata.target.entity;

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
@Table(name = "t_abroad_news_set")
public class TargetAbroadNewsSet extends IdIdentityEntity {

	/**
	* 分组id
	*/
	private Long groupId;
	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 专题名称
	*/
	private String setName;
	/**
	* 排序
	*/
	private Integer orderBy;
	/**
	* 检索区域：title标题，content内容，all所有
	*/
	private String searchArea;
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

}
