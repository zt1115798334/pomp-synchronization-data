package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:32
 * description:
 */
@Data
@Entity
@Table(name = "t_abroad_setting")
public class SourceAbroadSetting extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 标题
	*/
	private String name;
	/**
	* 搜索范围（“title”：标题；“content”：“neirong”，“all”：全部）
	*/
	private String searchArea;
	/**
	* 相关词
	*/
	private String relatedWord;
	/**
	* 舆情词
	*/
	private String yuqingWord;
	/**
	* 歧义词
	*/
	private String qiyiWord;
	/**
	* 站点url
	*/
	private String siteUrl;
	/**
	* 创建时间
	*/
	private LocalDateTime time;
	/**
	* 是否删除（0：未删除，1：已删除）
	*/
	private Integer isDelete;


    
}
