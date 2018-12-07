package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 15:33
 * description:
 */
@Data
@Entity
@Table(name = "t_filter_box")
public class SourceFilterBox extends IdEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 内容
	*/
	private String content;
	/**
	* 类型（0关键词，1来源，2作者）
	*/
	private Integer type;
	/**
	* 状态：0停用，1启用
	*/
	private Integer status;
	/**
	* 
	*/
	private LocalDateTime time;
	/**
	* 是否已删除：0未删除，1已删除
	*/
	private Integer isDelete;


    
}
