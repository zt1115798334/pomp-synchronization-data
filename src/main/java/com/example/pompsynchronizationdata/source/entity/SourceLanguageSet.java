package com.example.pompsynchronizationdata.source.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.pompsynchronizationdata.base.entity.IdEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "t_language_set")
public class SourceLanguageSet extends IdEntity {
	private Long userId;
	private Long languageId;//语言id
	private String searchArea;//搜索区域，tile：标题；content：内容；all：标题及内容
	private String relatedWord;//相关词
	private String yuqingWord;//舆情词
	private String qiyiWord;//歧义词
	private String siteUrl;//url
	private LocalDateTime time;//时间
	private Integer isDelete;//是否删除：0未删除，1已删除
	

}
