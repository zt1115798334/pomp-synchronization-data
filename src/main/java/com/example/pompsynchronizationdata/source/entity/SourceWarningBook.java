package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdPageEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:01
 * description:
 */
@Data
@Entity
@Table(name = "t_warning_book")
public class SourceWarningBook extends IdPageEntity {

	/**
	* 
	*/
	private Long userId;
	/**
	* 
	*/
	private String name;
	/**
	* 状态:1开启,0禁用
	*/
	private Integer status;
	/**
	* 类型（1=手机、2=邮箱）
	*/
	private Integer type;
	/**
	* 手机、邮箱
	*/
	private String value;
	/**
	* 保存时间
	*/
	private LocalDateTime time;

}
