package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:10
 * description:
 */
@Data
@Entity
@Table(name = "t_message")
public class TargetMessage extends IdEntity {

	/**
	* 用户类型(便于公告推送)等级(0:冻结;1:免费用户;2:试用用户;3正式会员;)
	*/
	private Integer userLevel;
	/**
	* 用户ID
	*/
	private Long createdUserId;
	/**
	* 标题
	*/
	private String title;
	/**
	* 内容
	*/
	private String content;
	/**
	* 类型:1公告通知;2系统提示;3客服反馈
	*/
	private Integer messageType;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;


    
}
