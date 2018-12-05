package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 17:52
 * description:
 */
@Data
@Entity
@Table(name = "t_column")
public class SourceColumn extends IdEntity {

	/**
	* 栏目名称
	*/
	private String name;
	/**
	* 排序
	*/
	private Integer orderBy;
	/**
	* 是否可见:1可见;0不可见
	*/
	private Integer showStatus;
	/**
	* 用户id
	*/
	private Integer userId;
	/**
	* 
	*/
	private LocalDateTime time;
	/**
	* 
	*/
	private Integer code;
	/**
	* 位置：1居中 2 居右
	*/
	private Integer position;


    
}
