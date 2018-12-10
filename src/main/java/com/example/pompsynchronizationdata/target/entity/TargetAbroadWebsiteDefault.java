package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
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
@Table(name = "t_abroad_website_default")
public class TargetAbroadWebsiteDefault extends IdIdentityEntity {

	/**
	* 网站名称
	*/
	private String name;
	/**
	* 网站地址
	*/
	private String url;
	/**
	* 分组id
	*/
	private Long groupId;

	/**
	 * 删除状态：1已删除 0未删除
	 */
	private Integer deleteState;
    
}
