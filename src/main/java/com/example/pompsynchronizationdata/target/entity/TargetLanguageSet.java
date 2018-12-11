package com.example.pompsynchronizationdata.target.entity;

import java.time.LocalDateTime;

import javax.persistence.*;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;

import lombok.Data;


/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/11 11:15
 * description:
 */
@Data
@Entity
@Table(name = "t_language_set")
public class TargetLanguageSet extends IdIdentityEntity{
    	/**
	* 主键
	*/
	private Long id;
	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 语言{mongolian：蒙文，vivien ： 维文 tibetan ： 藏文}
	*/
	private String language;
	/**
	 * 专题名称
	 */
	private String setName;
	/**
	 * 分组id
	 */
	private Long groupId;
	/**
	 * 排除词
	 */
	private String exclusionWords;
	/**
	* 搜索区域（title：标题，content：内容，all：全部）
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
	* 站点URL
	*/
	private String siteUrl;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
