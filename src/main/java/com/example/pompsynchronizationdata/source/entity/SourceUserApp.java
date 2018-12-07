package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 10:13
 * description:
 */
@Data
@Entity
@Table(name = "t_user_app")
public class SourceUserApp extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* app_menu的id
	*/
	private Long menuId;
	/**
	* 名称
	*/
	private String name;
	/**
	* 是否为自定义：0不是，1是
	*/
	private Integer isCustom;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;


    
}
