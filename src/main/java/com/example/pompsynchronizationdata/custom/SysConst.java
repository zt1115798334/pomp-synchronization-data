package com.example.pompsynchronizationdata.custom;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/9 10:18
 * description: 系统常量
 */
public class SysConst {

    public static final int DEFAULT_BATCH_SIZE = 200;
    public static final String DEFAULT_SORT_NAME = "publishTime";
    public static final String INDEX_CHART_SOURCE_ALL = "all";
    public static final String REDIS_CHANNEL = "ansj_term";


    public static final String MENU_DEFAULT_INDEX = "index"; //首页
    public static final String MENU_DEFAULT_SPECIAL_MONITOR = "specialMonitor"; //专题
    public static final String MENU_DEFAULT_WARNING = "warning"; //预警
    public static final String MENU_DEFAULT_EVENT = "event"; //事件
    public static final String MENU_DEFAULT_BRIEFING = "briefing"; //报告
    public static final String MENU_DEFAULT_APP_CENTER_MENU = "appCenterMenu"; //个人中心


    ///////////////////////////////////////////////////////////////////////////
    // 通用常量 -- 多实体类通用
    ///////////////////////////////////////////////////////////////////////////
    @Getter
    @AllArgsConstructor
    public enum ResultStatusCode {
        SUCCESS(0, "success"),
        FAILED(1, "failed"),
        ERROR(2, "error"),
        SYSTEM_ERROR(99, "system_error");

        private Integer code;
        private String name;
    }

    /**
     * 排序
     */
    @Getter
    @AllArgsConstructor
    public enum SortOrder {

        ASC("asc"),
        DESC("desc");

        private String code;
    }

    /**
     * 时间类型
     */
    @Getter
    @AllArgsConstructor
    public enum TimeType {
        CUSTOM_TIME("define", "自定义时间"),
        ALL("all", "全部"),
        TODAY("today", "今天"),
        YESTERDAY("yesterday", "昨天"),
        WEEK("week", "近7天"),
        MONTH("month", "近30天");

        private String code;
        private String name;

    }

    /**
     * 删除状态
     */
    @Getter
    @AllArgsConstructor
    public enum DeleteState {

        UN_DELETED(0, "未删除"),
        DELETE(1, "删除");

        private Integer code;
        private String name;
    }

    /**
     * 显示状态
     */
    @Getter
    @AllArgsConstructor
    public enum ShowState {

        HIDE(0, "隐藏"),
        DISPLAY(1, "显示");

        private Integer code;
        private String name;
    }

    /**
     * 置顶状态
     */
    @Getter
    @AllArgsConstructor
    public enum TopState {

        UN_TOP(0, "不置顶"),
        TOP(1, "置顶");

        private Integer code;
        private String name;

    }

    /**
     * 开启状态
     */
    @Getter
    @AllArgsConstructor
    public enum EnabledState {

        OFF(0, "停用"),
        ON(1, "开启");

        private Integer code;
        private String name;

    }

    /**
     * 阅读状态
     */
    @Getter
    @AllArgsConstructor
    public enum ReadState {

        UNREAD(0, "未读"),
        READ(1, "已读");

        private Integer code;
        private String name;
    }

    /**
     * 发送状态
     */
    @Getter
    @AllArgsConstructor
    public enum SendState {

        UNSENT(0, "未发送"),
        SENT(1, "已发送");

        private Integer code;
        private String name;

    }

    /**
     * 发送状态
     */
    @Getter
    @AllArgsConstructor
    public enum FromType {

        PANORAMA("panorama", "全景"),
        SPECIAL("special", "专题"),
        EVENT("event", "事件"),
        WARNING("warning", "预警"),
        ABROAD_NEWS("abroadNews", "境外新闻"),
        ABROAD_SOCIALIZATION("abroadSocialization", "境外媒体");

        private String type;
        private String name;
    }

    /**
     * 验证码类型
     */
    @Getter
    @AllArgsConstructor
    public enum VerificationCodeType {

        REG(0, "账户注册"),
        LOGIN(1, "账户登陆"),
        FORGET(2, "密码重置"),
        BIND(3, "账户绑定"),
        UNKNOWN(99, "未知");

        private Integer code;
        private String name;
    }

    public static Optional<VerificationCodeType> getVerificationCodeTypeByCode(Integer code) {
        return Arrays.stream(VerificationCodeType.values())
                .filter(replyType -> Objects.equal(code, replyType.getCode()))
                .findFirst();
    }

    /**
     * 文件扩展名
     */
    @Getter
    @AllArgsConstructor
    public enum ExtensionName {
        WORD2003_EDITION("doc", "word2003"),
        WORD2007_EDITION("docx", "word2007"),
        EXCEL2003_EDITION("xls", "excel2003"),
        EXCEL2007_EDITION("xlsx", "excel2007"),
        PDF_EDITION("pdf", "pdf");

        private String type;
        private String name;
    }


    ///////////////////////////////////////////////////////////////////////////
    // 特别常量 -- 单实体类通用
    ///////////////////////////////////////////////////////////////////////////


    /**
     * 登录类型
     */
    @Getter
    @AllArgsConstructor
    public enum LoginType {

        AJAX("ajax", "ajax登陆"),
        TOKEN("token", "token登陆"),
        PHONE("phone", "手机号登陆");

        private String type;
        private String name;

    }

    /**
     * 账户状态
     */
    @Getter
    @AllArgsConstructor
    public enum AccountState {

        Frozen(0, "冻结"),
        FREE(1, "免费账户"),
        PROBATIONER(2, "试用账户"),
        CEREMONIAL(3, "正式账户");

        private Integer code;
        private String name;

    }

    /**
     * 账户等级
     */
    @Getter
    @AllArgsConstructor
    public enum AccountLevel {

        ONE_LEVEL(1, "一级账户"),
        TWO_LEVEL(2, "二级账户");

        private Integer code;
        private String name;

    }

    /**
     * 到期状态
     */
    @Getter
    @AllArgsConstructor
    public enum ExpireState {

        UNEXPIRED(0, "未到期"),
        EXPIRE(1, "到期");

        private Integer code;
        private String name;

    }

    /**
     * 性别
     */
    @Getter
    @AllArgsConstructor
    public enum Sex {

        WOMEN(0, "女"),
        MEN(1, "男"),
        Unknown(99, "未知");

        private Integer code;
        private String name;

    }


    /**
     * 过滤类型
     */
    @Getter
    @AllArgsConstructor
    public enum FilterType {

        KEYWORD(0, "关键词"),
        SOURCE(1, "来源"),
        AUTHOR(2, "作者"),
        ID(3, "Id过滤");

        private Integer code;
        private String name;

    }

    /**
     * 位置
     */
    @Getter
    @AllArgsConstructor
    public enum Position {

        CENTER(1, "居中"),
        RIGHT(2, "居右");

        private Integer code;
        private String name;
    }

    /**
     * 预警类型
     */
    @Getter
    @AllArgsConstructor
    public enum WarningType {

        MACHINE(0, "机器预警"),
        ARTIFICIAL(1, "手动预警");

        private Integer code;
        private String name;

    }

    /**
     * 预警等级
     */
    @Getter
    @AllArgsConstructor
    public enum WarningLevel {

        RED("red", "红色预警"),
        ORANGE("orange", "橙色预警"),
        YELLOW("yellow", "黄色预警");

        private String type;
        private String name;

    }

    public static Optional<WarningLevel> getWarningLevelByType(String type) {
        return Arrays.stream(WarningLevel.values())
                .filter(replyType -> StringUtils.equals(type, replyType.getType()))
                .findFirst();
    }

    /**
     * 情感范围
     */
    @Getter
    @AllArgsConstructor
    public enum Emotion {

        ALL("all", "全部"),
        POSITIVE("positive", "正面"),
        NEGATIVE("negative", "负面"),
        NEUTRAL("neutral", "中性"),
        IRRELEVANT("irrelevant", "无关");

        private String type;
        private String name;

    }

    public static Optional<Emotion> getEmotionByType(String type) {
        return Arrays.stream(Emotion.values())
                .filter(replyType -> StringUtils.equals(type, replyType.getType()))
                .findFirst();
    }


    /**
     * 载体范围
     */
    @Getter
    @AllArgsConstructor
    public enum Carrie {

        Carrie_2000(2000, "综合"),
        Carrie_2001(2001, "新闻"),
        Carrie_2002(2002, "博客"),
        Carrie_2003(2003, "论坛"),
        Carrie_2004(2004, "微博"),
        Carrie_2005(2005, "微信"),
        Carrie_2006(2006, "QQ群"),
        Carrie_2007(2007, "电子报"),
        Carrie_2008(2008, "视频"),
        Carrie_2009(2009, "手机wap"),
        Carrie_2999(2999, "其他");

        private Integer code;
        private String name;

    }

    public static Optional<Carrie> getCarrieByCode(Integer type) {
        return Arrays.stream(Carrie.values())
                .filter(replyType -> type.equals(replyType.getCode()))
                .findFirst();
    }

    /**
     * 载体范围
     */
    @Getter
    @AllArgsConstructor
    public enum CarrieList {

        Carrie_ALL(Arrays.asList(2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2999), "全部"),
        Carrie_2000(Collections.singletonList(2000), "综合"),
        Carrie_2001(Collections.singletonList(2001), "新闻"),
        Carrie_2002(Collections.singletonList(2002), "博客"),
        Carrie_2003(Collections.singletonList(2003), "论坛"),
        Carrie_2004(Collections.singletonList(2004), "微博"),
        Carrie_2005(Collections.singletonList(2005), "微信"),
        Carrie_2006(Collections.singletonList(2006), "QQ群"),
        Carrie_2007(Collections.singletonList(2007), "电子报"),
        Carrie_2008(Collections.singletonList(2008), "视频"),
        Carrie_2009(Collections.singletonList(2009), "手机wap"),
        Carrie_2999(Collections.singletonList(2999), "其他");

        private List<Integer> code;
        private String name;
    }

    /**
     * 搜索范围
     */
    @Getter
    @AllArgsConstructor
    public enum SearchArea {

        ALL("all", "全部"),
        TITLE("title", "标题"),
        CONTENT("content", "内容");

        private String type;
        private String name;

    }

    /**
     * 过滤类型
     */

    @Getter
    @AllArgsConstructor
    public enum Region {

        ALL(0, "全部"),
        REGION_INNER(1, "境内"),
        REGION_OUTSIDE(2, "境外");

        private Integer code;
        private String name;

    }

    /**
     * 语言类型
     */
    @Getter
    @AllArgsConstructor
    public enum Language {

        CHINESE("chinese", "中文"),
        MONGOLIAN("mongolian", "蒙文"),
        VIVIEN("vivien", "维文"),
        TIBETAN("tibetan", "藏文");

        private String type;
        private String name;

    }

    /**
     * 通知类型
     */
    @Getter
    @AllArgsConstructor
    public enum NoticeType {

        DIALOG("dialog", "弹框"),
        EMAIL("email", "邮件"),
        PHONE("phone", "短信"),
        APP("app", "APP"),
        WE_CHAT("weChat", "微信");

        private String type;
        private String name;

    }

    /**
     * 报告类型
     */
    @Getter
    @AllArgsConstructor
    public enum BriefingType {
        DAY("day", "日报"),
        WEEK("week", "周报"),
        MONTH("month", "月报");

        private String type;
        private String name;
    }

    public static Optional<BriefingType> getBriefingTypeByType(String type) {
        return Arrays.stream(BriefingType.values())
                .filter(replyType -> StringUtils.equals(type, replyType.getType()))
                .findFirst();
    }

    /**
     * 报告模板类型
     */
    @Getter
    @AllArgsConstructor
    public enum TemplateType {
        CURRENCY_EDITION(1, "通用版"),
        MEDIA_EDITION(2, "媒体版");

        private Integer code;
        private String name;
    }

    /**
     * 模板编号
     */
    @Getter
    @AllArgsConstructor
    public enum TemplateNumber {
        CURRENCY_EDITION_0(0, "预警舆情"),
        CURRENCY_EDITION_1(1, "负面舆情"),
        CURRENCY_EDITION_2(2, "重点舆情"),
        CURRENCY_EDITION_3(3, "舆情载体趋势图"),
        CURRENCY_EDITION_4(4, "情感分时段分布"),
        CURRENCY_EDITION_5(5, "正负面信息趋势图"),
        CURRENCY_EDITION_6(6, "舆情分类分布（矩形树图）"),
        CURRENCY_EDITION_7(7, "情感分布"),
        CURRENCY_EDITION_8(8, "负面热力图"),
        CURRENCY_EDITION_9(9, "地域参与热力图"),
        CURRENCY_EDITION_10(10, "主体参与排行榜"),
        MEDIA_EDITION_0(0, "新闻舆情"),
        MEDIA_EDITION_1(1, "两微舆情"),
        MEDIA_EDITION_2(2, "论坛舆情"),
        MEDIA_EDITION_3(3, "纸媒舆情");

        private Integer code;
        private String name;

    }

    /**
     * 报告生成方式 是否默认 或者自定义
     */
    @Getter
    @AllArgsConstructor
    public enum BriefingCustom {

        DEFAULT(0, "默认"),
        CUSTOM(1, "自定义");

        private Integer code;
        private String name;

    }

    /**
     * 应用中心的所有app
     */
    @Getter
    @AllArgsConstructor
    public enum MenuApp {
        APP_CLOUD_SEARCH_INDEX(1L, "cloudSearchIndex", "云搜索"),
        APP_SITE(2L, "site", "网站巡查"),
        APP_PUBLIC_SENTIMENT_CHART(3L, "publicSentimentChart", "智能图表"),
        APP_BIG_SCREEN(4L, "bigScreen", "舆情大屏"),
        APP_ABROAD_NEWS(5L, "abroadNews", "境外新闻媒体监测"),
        APP_LANGUAGE(6L, "language", "多语言监测"),
        APP_ABROAD_WEBSITE(7L, "abroadWebsite", "境外网址导航"),
        APP_COMMENT_ANALYSIS(8L, "commentAnalysis", "评论分析"),
        APP_APP(11L, "app", "舆情管家APP"),
        APP_SITE_CHANNEL(13L, "siteChannel", "网站频道巡查"),
        APP_ABROAD_SOCIALIZATION(14L, "abroadSocialization", "境外社交媒体监测");

        private Long code;
        private String identify;
        private String name;

    }

    public static Optional<MenuApp> getMenuAppByCode(Long code) {
        return Arrays.stream(MenuApp.values())
                .filter(menuApp -> code.equals(menuApp.code))
                .findFirst();
    }

    /**
     * app状态
     */
    @Getter
    @AllArgsConstructor
    public enum AppState {

        APP_STATE_0(0, "可使用"),
        APP_STATE_1(1, "敬请期待"),
        APP_STATE_2(2, "删除"),
        APP_STATE_3(3, "用户已订阅");

        private Integer code;
        private String name;

    }

    /**
     * 报告专题类型
     */
    @Getter
    @AllArgsConstructor
    public enum SpecialEvent {

        SPECIAL("special", "专题"),
        EVENT("event", "事件");

        private String type;
        private String name;

    }

    /**
     * 站点信息
     *
     * @param websiteUrl
     * @return
     */
    public static Optional<WebsiteInfo> getWebsiteInfo(String websiteUrl) {
        final String sina = "sina.com";
        final String qq = "qq.com";
        final String w163 = "163.com";
        final String sohu = "sohu.com";
        String webName = "";
        if (websiteUrl.contains(sina)) {
            webName = "新浪网";
        } else if (websiteUrl.contains(qq)) {
            webName = "腾讯网";
        } else if (websiteUrl.contains(w163)) {
            webName = "网易";
        } else if (websiteUrl.contains(sohu)) {
            webName = "搜狐网";
        } else {
            webName = "默认";
        }
        return getWebsiteInfoBySource(webName);
    }

    /**
     * 站点信息
     */
    @Getter
    @AllArgsConstructor
    public enum WebsiteInfo {

        DEFAULT("默认", "", ""),
        WEBSITE_10("新浪网", "http://news.sina.com.cn/", "review-pic1_03.png"),
        WEBSITE_20("腾讯网", "http://news.qq.com/", "review-pic2_03.png"),
        WEBSITE_30("网易", "http://news.163.com/", "review-pic3_03.png"),
        WEBSITE_40("搜狐网", "http://news.sohu.com/", "review-pic4_03.png");

        private String websiteSource;
        private String websiteUrl;
        private String websiteIcon;

    }

    private static Optional<WebsiteInfo> getWebsiteInfoBySource(String websiteSource) {
        return Arrays.stream(WebsiteInfo.values())
                .filter(websiteInfo -> StringUtils.equals(websiteSource, websiteInfo.getWebsiteSource()))
                .findFirst();
    }

    /**
     * 评论分析状态
     */
    @Getter
    @AllArgsConstructor
    public enum AnalysisState {

        SUBMISSION_SUCCESS(0, "提交成功"),
        ANALYSIS(1, "分析中"),
        ANALYSIS_SUCCESS(2, "分析完成"),
        ANALYSIS_FAILURE(3, "分析失败");

        private Integer code;
        private String name;

    }

    /**
     * 词性类型
     */
    @Getter
    @AllArgsConstructor
    public enum WordType {

        WORD(0, "单词"),
        COMPOUND_WORD(1, "组合词");

        private Integer code;
        private String name;

    }

    /**
     * 词来源
     */
    @Getter
    @AllArgsConstructor
    public enum WordSource {

        SYSTEM(0, "系统"),
        USER(1, "用户"),
        ALL(2, "都有");

        private Integer code;
        private String name;

    }

    /**
     * 监测媒体类型
     */
    @Getter
    @AllArgsConstructor
    public enum SocialType {

        ALL("all", "全部"),
        TWITTER("twitter", "推特"),
        FACEBOOK("facebook", "facebook");

        private String type;
        private String name;

    }
}
