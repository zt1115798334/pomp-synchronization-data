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
@Table(name = "t_abroad_website_group_default")
public class TargetAbroadWebsiteGroupDefault extends IdEntity {

	/**
	* 
	*/
	private String name;


    
}
