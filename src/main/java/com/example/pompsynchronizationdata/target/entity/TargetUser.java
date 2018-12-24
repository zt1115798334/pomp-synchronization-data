package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/14 13:16
 * description:
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "t_user")
public class TargetUser extends IdEntity {

	/**
	* 账户
	*/
	private String account;
	/**
	* 密码
	*/
	private String password;
	/**
	* 盐
	*/
	private String salt;
	/**
	* 手机号
	*/
	private String phone;
	/**
	* 邮箱
	*/
	private String email;
	/**
	* 账户状态：{0：冻结，1免费试用，2，试用用户，3正式会员}
	*/
	private Integer accountState;
	/**
	* 用户等级{1：一级账户,2:二级账户}
	*/
	private Integer accountLevel;
	/**
	* 账户到期时间
	*/
	private LocalDate expireDate;
	/**
	* 到期状态：{0：未到期，1 到期}
	*/
	private Integer expireState;
	/**
	* 性别：{0:女 1: 男  99: 未知}
	*/
	private Integer sex;
	/**
	* 公司单位
	*/
	private String company;
	/**
	* 城市
	*/
	private String city;
	/**
	* 运维人id
	*/
	private Long operationUserIdLc;
	/**
	* 项目名称
	*/
	private String projectName;
	/**
	* 项目别名
	*/
	private String projectAlias;
	/**
	* 套餐id
	*/
	private Long packageIdLc;
	/**
	* 父级id
	*/
	private Long parentId;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 更新时间
	*/
	private LocalDateTime updatedTime;
	/**
	* 最后登录时间
	*/
	private LocalDateTime lastLoginTime;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;

	private Long userConfigId;


    
}
