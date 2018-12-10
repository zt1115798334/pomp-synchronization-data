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
@Table(name = "t_abroad_website")
public class TargetAbroadWebsite extends IdIdentityEntity {

	/**
	* 分组id
	*/
	private Long groupId;
	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 网站名称
	*/
	private String name;
	/**
	* 网站地址
	*/
	private String url;


    
}
