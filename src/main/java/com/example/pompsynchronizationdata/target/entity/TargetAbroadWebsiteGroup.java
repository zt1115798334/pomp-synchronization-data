package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:20
 * description:
 */
@Data
@Entity
@Table(name = "t_abroad_website_group")
public class TargetAbroadWebsiteGroup extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 分组名称
	*/
	private String name;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
