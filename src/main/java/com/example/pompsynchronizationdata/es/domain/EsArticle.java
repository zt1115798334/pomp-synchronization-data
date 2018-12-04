package com.example.pompsynchronizationdata.es.domain;

import com.alibaba.fastjson.JSONArray;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/22 9:29
 * description: es文章
 */
public class EsArticle {

    /**
     * 文章id
     */
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
    private Integer carrie;

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
     * 发布时间
     */
    private String publishTimeStr;

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
    private String from;

    /**
     * 点击数
     */
    private Long view;

    /**
     * 评论数
     */
    private Long comment;

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
     * 预警等级  red 红色 ，orange 橙色，yellow黄色
     */
    private String warningLevel;

    /**
     * 加入报告信息
     */
    private List<String> joinBriefingInfo;

    /**
     * 阅读人员id
     */
    private JSONArray readUserIds;

    /**
     * 无关人员id
     */
    private JSONArray unRelatedUserIds;

    /**
     * 阅读状态
     */
    private boolean readState;

    /**
     * 收藏状态
     */
    private boolean favoriteState;

    /**
     * 是否是境外
     */
    private boolean isAbroad;

    public EsArticle() {
    }

    public EsArticle(String id, String relId, Integer region, Integer carrie,
                     String siteName, LocalDateTime createTime, LocalDateTime gatherTime, LocalDateTime publishTime,
                     String urlMain, String url, String author, String from,
                     Long view, Long comment, Integer isRelated, Integer isOpinion,
                     String emotion, String ossPath, String title, String cleanTitle,
                     Long contentWords, String summary, String content,
                     JSONArray readUserIds, JSONArray unRelatedUserIds) {
        this.id = id;
        this.relId = relId;
        this.region = region;
        this.carrie = carrie;
        this.siteName = siteName;
        this.createTime = createTime;
        this.gatherTime = gatherTime;
        this.publishTime = publishTime;
        this.urlMain = urlMain;
        this.url = url;
        this.author = author;
        this.from = from;
        this.view = view;
        this.comment = comment;
        this.isRelated = isRelated;
        this.isOpinion = isOpinion;
        this.emotion = emotion;
        this.ossPath = ossPath;
        this.title = title;
        this.cleanTitle = cleanTitle;
        this.contentWords = contentWords;
        this.summary = summary;
        this.content = content;
        this.readUserIds = readUserIds;
        this.unRelatedUserIds = unRelatedUserIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public Integer getRegion() {
        return region;
    }

    public void setRegion(Integer region) {
        this.region = region;
    }

    public Integer getCarrie() {
        return carrie;
    }

    public void setCarrie(Integer carrie) {
        this.carrie = carrie;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getGatherTime() {
        return gatherTime;
    }

    public void setGatherTime(LocalDateTime gatherTime) {
        this.gatherTime = gatherTime;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }

    public String getPublishTimeStr() {
        return publishTimeStr;
    }

    public void setPublishTimeStr(String publishTimeStr) {
        this.publishTimeStr = publishTimeStr;
    }

    public String getUrlMain() {
        return urlMain;
    }

    public void setUrlMain(String urlMain) {
        this.urlMain = urlMain;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getView() {
        return view;
    }

    public void setView(Long view) {
        this.view = view;
    }

    public Long getComment() {
        return comment;
    }

    public void setComment(Long comment) {
        this.comment = comment;
    }

    public Integer getIsRelated() {
        return isRelated;
    }

    public void setIsRelated(Integer isRelated) {
        this.isRelated = isRelated;
    }

    public Integer getIsOpinion() {
        return isOpinion;
    }

    public void setIsOpinion(Integer isOpinion) {
        this.isOpinion = isOpinion;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getOssPath() {
        return ossPath;
    }

    public void setOssPath(String ossPath) {
        this.ossPath = ossPath;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCleanTitle() {
        return cleanTitle;
    }

    public void setCleanTitle(String cleanTitle) {
        this.cleanTitle = cleanTitle;
    }

    public Long getContentWords() {
        return contentWords;
    }

    public void setContentWords(Long contentWords) {
        this.contentWords = contentWords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(String warningLevel) {
        this.warningLevel = warningLevel;
    }

    public List<String> getJoinBriefingInfo() {
        return joinBriefingInfo;
    }

    public void setJoinBriefingInfo(List<String> joinBriefingInfo) {
        this.joinBriefingInfo = joinBriefingInfo;
    }

    public boolean isReadState() {
        return readState;
    }

    public JSONArray getReadUserIds() {
        return readUserIds;
    }

    public void setReadUserIds(JSONArray readUserIds) {
        this.readUserIds = readUserIds;
    }

    public JSONArray getUnRelatedUserIds() {
        return unRelatedUserIds;
    }

    public void setUnRelatedUserIds(JSONArray unRelatedUserIds) {
        this.unRelatedUserIds = unRelatedUserIds;
    }

    public void setReadState(boolean readState) {
        this.readState = readState;
    }

    public boolean isFavoriteState() {
        return favoriteState;
    }

    public void setFavoriteState(boolean favoriteState) {
        this.favoriteState = favoriteState;
    }

    public boolean isAbroad() {
        return isAbroad;
    }

    public void setAbroad(boolean abroad) {
        isAbroad = abroad;
    }
}
