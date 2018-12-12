package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/12 14:45
 * description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_user_config")
public class TargetUserConfig extends IdIdentityEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* app预警状态 1  开启 0 停用
	*/
	private Integer warningAppState;
	/**
	* 专题id,all表示全部
	*/
	private String indexChartSourceSpecialId;
	/**
	* 显示状态 0 不可见，1可见
	*/
	private Integer abroadWebsiteDefaultShowState;


    
}
