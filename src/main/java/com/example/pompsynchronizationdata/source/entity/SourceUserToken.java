package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 13:41
 * description:
 */
@Data
@Entity
@Table(name = "t_user_token")
public class SourceUserToken extends IdEntity {

	/**
	* 
	*/
	private Long userId;
	/**
	* 用户名
	*/
	private String phone;
	/**
	* 注册id
	*/
	private String registrationId;
	/**
	* 用户设备标识
	*/
	private String token;
	/**
	* 
	*/
	private LocalDateTime time;


    
}
