package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/06 15:37
 * description:
 */
@Data
@Entity
@Table(name = "t_filter_box")
public class TargetFilterBox extends IdIdentityEntity {
	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 内容
	*/
	private String content;
	/**
	* 类型（0关键词，1来源，2作者，3id过滤）
	*/
	private Integer filterType;
	/**
	* 开启状态：1  开启 0 停用
	*/
	private Integer enabledState;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 删除状态：1已删除 0未删除
	*/
	private Integer deleteState;


    
}
