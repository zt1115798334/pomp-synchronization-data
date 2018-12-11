package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 10:36
 * description:
 */
@Data
@Entity
@Table(name = "t_site")
public class SourceSite extends IdEntity {

	/**
	* 用户ID
	*/
	private Long userId;
	/**
	* 栏目名称
	*/
	private String columns;
	/**
	* 地址
	*/
	private String url;
	/**
	* 网站名称
	*/
	private String name;
	/**
	* 
	*/
	private LocalDateTime time;
	/**
	* 
	*/
	private Integer status;
	/**
	* 站点类型  0用户设置  ；1系统设置
	*/
	private Integer siteType;
	/**
	* 站点分类：0是关注站点，1是排除站点
	*/
	private Integer siteNature;
	/**
	* 是否排除关键词：0是不过滤，1是过滤
	*/
	private Integer isword;


    
}
