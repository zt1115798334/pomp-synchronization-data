package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:19
 * description:
 */
@Data
@Entity
@Table(name = "t_abroad_media_group")
public class SourceAbroadMediaGroup extends IdEntity {

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
	* 时间
	*/
	private LocalDateTime time;
	/**
	* 编号
	*/
	private Integer code;
	/**
	* 父级id
	*/
	private Long parentId;
	/**
	* 等级
	*/
	private Integer level;
	/**
	* 是否删除（0：未删除，1：已删除）
	*/
	private Integer isDelete;


    
}
