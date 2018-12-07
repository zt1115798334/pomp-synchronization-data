package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 16:24
 * description:
 */
@Data
@Entity
@Table(name = "t_comment_analysis_user")
public class SourceCommentAnalysisUser extends IdEntity {

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
	/**
	* 删除状态：0 未删除 1 删除
	*/
	private Integer deleteState;


    
}
