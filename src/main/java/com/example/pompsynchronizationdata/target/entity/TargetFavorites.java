package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 16:05
 * description:
 */
@Data
@Entity
@Table(name = "t_favorites")
public class TargetFavorites extends IdIdentityEntity {

	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 文章id
	*/
	private String articleId;
	/**
	* 创建时间
	*/
	private LocalDateTime createdTime;
	/**
	* 发布时间
	*/
	private LocalDateTime publishTime;
	/**
	* 载体
	*/
	private Integer carrier;
	/**
	* 区域：1 境内 0 境外
	*/
	private Integer region;
	/**
	* 情感 正面：positive, 负面：negative 中性 neutral
	*/
	private String emotion;


    
}
