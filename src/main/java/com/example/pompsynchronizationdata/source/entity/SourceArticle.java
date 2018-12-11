package com.example.pompsynchronizationdata.source.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/11 09:50
 * description:
 */
@Data
@Entity
@Table(name = "t_article")
public class SourceArticle {
    /**
     * 文章id
     */
    @Id
    private String id;
    /**
     * 相似文章id
     */
    private String relId;
    /**
     * 区域：0 全部1 境内 2 境外
     */
    private Integer region;
    /**
     * 载体
     */
    private String carrie;
    /**
     * 网站
     */
    private String siteName;
    /**
     * 索引时间
     */
    private LocalDateTime createTime;
    /**
     * 采集时间
     */
    private LocalDateTime gatherTime;
    /**
     * 发布时间
     */
    private LocalDateTime publishTime;
    /**
     * url主域名
     */
    private String urlMain;
    /**
     * url
     */
    private String url;
    /**
     * 作者
     */
    private String author;
    /**
     * 转载源
     */
    @Column(name = "from_c")
    private String fromC;
    /**
     * 点击数
     */
    @Column(name = "view_c")
    private Long viewC;
    /**
     * 评论数
     */
    @Column(name = "comment_c")
    private Long commentC;
    /**
     * 是否相关 0 否  1是
     */
    private Integer isRelated;
    /**
     * 是否舆情 0 否 1 是
     */
    private Integer isOpinion;
    /**
     * 正面：positive, 负面：negative 中性 neutral
     */
    private String emotion;
    /**
     * 采集文件的名称
     */
    private String ossPath;
    /**
     * 原文标题
     */
    private String title;
    /**
     * 将文章标题中出现的特殊的字符替换掉
     */
    private String cleanTitle;
    /**
     * 文章内容字数
     */
    private Long contentWords;
    /**
     * 摘要
     */
    private String summary;
    /**
     * 正文内容
     */
    private String content;
    /**
     * 排除文章user id
     */
    private String unRelatedUserId;
    /**
     * 阅读文章user id
     */
    private String readUserId;


}
