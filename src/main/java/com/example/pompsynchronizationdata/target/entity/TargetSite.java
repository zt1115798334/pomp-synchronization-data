package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 11:06
 * description:
 */
@Data
@Entity
@Table(name = "t_site")
public class TargetSite extends IdEntity {

	/**
	* 用户ID
	*/
	private Long userId;
	/**
	* 栏目名称
	*/
	private String siteName;
	/**
	* 站点url
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
