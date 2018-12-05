package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 17:52
 * description:
 */
@Data
@Entity
@Table(name = "t_column_tag")
public class SourceColumnTag extends IdEntity {

	/**
	* 
	*/
	private String name;
	/**
	* 
	*/
	private Integer showAs;
	/**
	* 
	*/
	private Integer orderAs;
	/**
	* 
	*/
	private Integer userId;
	/**
	* 
	*/
	private String whereAs;
	/**
	* 
	*/
	private String demonstrations;
	/**
	* 
	*/
	private Integer columnId;
	/**
	* 检索区域：title标题，content内容，all所有
	*/
	private String searchArea;
	/**
	* 载体
	*/
	private String carrie;
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
	* 排除词
	*/
	private String unrelatedWord;
	/**
	* 站点url
	*/
	private String siteUrl;
	/**
	* 作者
	*/
	private String author;
	/**
	* 
	*/
	private LocalDateTime time;
	/**
	* 类型：0旧版本标签，1新版本标签
	*/
	private Integer type;
	/**
	* 是否已删除：0未删除，1已删除
	*/
	private Integer isDelete;
	/**
	* app 中是否可见 1：可见，0：不可见
	*/
	private Integer appShowAs;
	/**
	* app 中是否置顶 0：置顶，1:不置顶
	*/
	private Integer appTopShowAs;
	/**
	* 是否置顶：0不置顶，1置顶
	*/
	private Integer isTop;
	/**
	* 置顶时间
	*/
	private LocalDateTime topTime;
	/**
	* 全部 all ， 正面：positive, 负面：negative 中性 neutral
	*/
	private String emotion;
	/**
	* 
	*/
	private String urlStr;
	/**
	* 
	*/
	private String urlStrReal;


    
}
