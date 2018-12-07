package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 09:56
 * description:
 */
@Data
@Entity
@Table(name = "t_user_app")
public class TargetUserApp extends IdIdentityEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* t_application_center_menu的id
	*/
	private Long menuId;
	/**
	* 是否展示在 菜单中 0 不展示 1 展示
	*/
	private Integer showState;

	/**
	 * 创建时间
	 */
	private LocalDateTime createdTime;
    
}
