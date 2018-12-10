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
@Table(name = "t_overseas_sites_default")
public class SourceOverseasSitesDefault extends IdEntity {

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
	* 删除状态 1 删除 0 未删除
	*/
	private Integer deleteState;


    
}
