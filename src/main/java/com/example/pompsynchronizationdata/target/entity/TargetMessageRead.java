package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
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
@Table(name = "t_message_read")
public class TargetMessageRead extends IdIdentityEntity {

	/**
	* 用户ID
	*/
	private Long userId;
	/**
	* 消息ID
	*/
	private Long messageId;
	/**
	*  创建时间
	*/
	private LocalDateTime createdTime;


    
}
