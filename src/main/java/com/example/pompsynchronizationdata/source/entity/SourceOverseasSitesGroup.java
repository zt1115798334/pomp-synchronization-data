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
@Table(name = "t_overseas_sites_group")
public class SourceOverseasSitesGroup extends IdEntity {

	/**
	* 
	*/
	private String name;
	/**
	* 
	*/
	private Long userId;
	/**
	* 是否删除：0未删除，1已删除
	*/
	private Integer isDeleted;


    
}
