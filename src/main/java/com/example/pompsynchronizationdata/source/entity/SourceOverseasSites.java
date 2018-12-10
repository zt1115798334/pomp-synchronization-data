package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 10:10
 * description:
 */
@Data
@Entity
@Table(name = "t_overseas_sites")
public class SourceOverseasSites extends IdEntity {

	/**
	* 网站名称
	*/
	private String name;
	/**
	* 网站地址
	*/
	private String url;
	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 
	*/
	private Long groupId;


    
}
