package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 16:54
 * description:
 */
@Data
@Entity
@Table(name = "t_briefing_notice")
public class TargetBriefingNotice  extends IdIdentityEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 邮箱
	*/
	private String email;


    
}
