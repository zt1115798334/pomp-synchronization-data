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
@Table(name = "t_comment_analysis")
public class SourceCommentAnalysis extends IdEntity {

	/**
	* 网站图标
	*/
	private String websiteIcon;
	/**
	* 网站来源url
	*/
	private String websiteUrl;
	/**
	* 网站来源
	*/
	private String websiteSource;
	/**
	* url
	*/
	private String url;
	/**
	* urlMD5
	*/
	private String urlMd5;
	/**
	* 标题
	*/
	private String title;
	/**
	* 清除符号标题
	*/
	private String titleClear;
	/**
	* 评论数量
	*/
	private Integer commentNumber;
	/**
	* 文章发布时间
	*/
	private LocalDateTime publishTime;
	/**
	* 分析时间  
	*/
	private LocalDateTime analysisTime;
	/**
	* 分析状态 0： 提交成功 1：分析中 2: 分析完成 3：分析失败
	*/
	private Integer analysisState;
	/**
	* 显示状态 0：展示 1 不展示
	*/
	private Integer displayState;


    
}
