package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:04
 * description:
 */

@Data
@Entity
@Table(name = "t_message")
public class SourceMessage extends IdEntity {

	/**
	* 用户类型(便于公告推送)等级(0:冻结;1:免费用户;2:试用用户;3正式会员;)
	*/
	private Integer userLevel;
	/**
	* 用户ID
	*/
	private Integer userId;
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
	private Integer type;
	/**
	* 删除标识:0未删除;1逻辑删除;
	*/
	private Integer isdelete;
	/**
	* 发送时间
	*/
	private LocalDateTime time;


    
}
