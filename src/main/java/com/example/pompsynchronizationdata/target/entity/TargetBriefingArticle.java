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
@Table(name = "t_briefing_article")
public class TargetBriefingArticle  extends IdIdentityEntity {

	/**
	* 报告id
	*/
	private Long briefingId;
	/**
	* 文章id
	*/
	private String articleId;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 报告模板类型:1，通用版，2 媒体版
	*/
	private Integer templateType;
	/**
	* 模板编号：普通模板:{	0“预警舆情”；1“负面舆情”；2
	*/
	private Integer templateNumber;

}
