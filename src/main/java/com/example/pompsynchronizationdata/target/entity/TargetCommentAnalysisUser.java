package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 16:15
 * description:
 */
@Data
@Entity
@Table(name = "t_comment_analysis_user")
public class TargetCommentAnalysisUser extends IdIdentityEntity {
    	/**
	* id
	*/
	private Long id;
	/**
	* 用户id
	*/
	private Long userId;
	/**
	* 分析id
	*/
	private Long analysisId;
	/**
	* urlMD5
	*/
	private String urlMd5;
	/**
	* 添加时间
	*/
	private LocalDateTime createdTime;


    
}
