package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 17:19
 * description:
 */
@Data
@Entity
@Table(name = "t_briefing_article")
public class SourceBriefingArticle implements java.io.Serializable {


	@EmbeddedId
	private SourceBriefingArticleKey id;
	/**
	* 
	*/
	private LocalDateTime time;
	/**
	* 0:自动添加负面舆情 1:手动添加舆情
	*/
	private Long insertType;


    
}
