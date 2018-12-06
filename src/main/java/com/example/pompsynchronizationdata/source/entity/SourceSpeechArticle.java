package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 11:11
 * description:
 */
@Data
@Entity
@Table(name = "t_speech_article")
public class SourceSpeechArticle extends IdIdentityEntity {

	/**
	* 
	*/
	private Long briefingId;
	/**
	* 文章ID
	*/
	private String articleId;
	/**
	* 
	*/
	private LocalDateTime time;
	/**
	* 报告模板类型：1，通用版，2 媒体版
	*/
	private String templateType;
	/**
	* 报告中模块类型
	*/
	private String speechInfoType;
	/**
	* 删除状态：0 未删除 1 删除
	*/
	private Integer deleteState;


    
}
