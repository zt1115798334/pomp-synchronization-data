package com.example.pompsynchronizationdata.source.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:12
 * description:
 */
@Data
@Entity
@Table(name = "t_warning")
public class SourceWarning{
	/**
	* 文章ID
	*/
	@Id
	private String id;
	/**
	* 文章相同内容ID
	*/
	private String relId;
	/**
	* 用户ID
	*/
	private Integer userId;
	/**
	* 载体
	*/
	private String carrie;
	/**
	* 来源:境内,境外
	*/
	private String country;
	/**
	* 热度值
	*/
	private Integer hot;
	/**
	* 预警方式:0ES推送;1用户手动
	*/
	private Integer mode;
	/**
	* 新闻发布时间
	*/
	private LocalDateTime publishTime;
	/**
	* 接收到的时间
	*/
	private LocalDateTime inTime;
	/**
	* 短信状态:空:未发送,有:已发送
	*/
	private LocalDateTime phoneTime;
	/**
	* 邮件状态:空:未发送,有:已发送
	*/
	private LocalDateTime emailTime;
	/**
	* 已读标识：0未读，1已读；默认0
	*/
	private Integer isRead;
	/**
	* 
	*/
	private Long warningRuleId;
	/**
	* 删除状态：0
	*/
	private Long deleteState;
	/**
	* 预警等级  red 红色 ，orange 橙色，yellow黄色
	*/
	private String warningLevel;

}
