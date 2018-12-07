package com.example.pompsynchronizationdata.data;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.MStringUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceColumnTag;
import com.example.pompsynchronizationdata.source.service.SourceColumnTagService;
import com.example.pompsynchronizationdata.target.entity.TargetColumnSpecial;
import com.example.pompsynchronizationdata.target.service.TargetColumnSpecialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/4 18:00
 * description:
 */
@Component
public class ColumnSpecialCopy extends PageHandler<SourceColumnTag> {

    @Autowired
    private SourceColumnTagService sourceColumnTagService;

    @Autowired
    private TargetColumnSpecialService targetColumnSpecialService;

    @Override
    protected int handleDataOfPerPage(List<SourceColumnTag> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceColumnTag sourceColumnTag = list.get(i);
            Long sourceColumnTagId = sourceColumnTag.getId();
            String sourceColumnTagName = sourceColumnTag.getName();
            Integer sourceColumnTagShowAs = sourceColumnTag.getShowAs();
            Integer sourceColumnTagOrderAs = sourceColumnTag.getOrderAs();
            Integer sourceColumnTagUserId = sourceColumnTag.getUserId();
            String sourceColumnTagWhereAs = sourceColumnTag.getWhereAs();
            String sourceColumnTagDemonstrations = sourceColumnTag.getDemonstrations();
            Integer sourceColumnTagColumnId = sourceColumnTag.getColumnId();
            String sourceColumnTagSearchArea = sourceColumnTag.getSearchArea();
            String sourceColumnTagCarrie = sourceColumnTag.getCarrie();
            String sourceColumnTagRelatedWord = sourceColumnTag.getRelatedWord();
            String sourceColumnTagYuqingWord = sourceColumnTag.getYuqingWord();
            String sourceColumnTagQiyiWord = sourceColumnTag.getQiyiWord();
            String sourceColumnTagUnrelatedWord = sourceColumnTag.getUnrelatedWord();
            String sourceColumnTagSiteUrl = sourceColumnTag.getSiteUrl();
            String sourceColumnTagAuthor = sourceColumnTag.getAuthor();
            LocalDateTime sourceColumnTagTime = sourceColumnTag.getTime();
            Integer sourceColumnTagType = sourceColumnTag.getType();
            Integer sourceColumnTagIsDelete = sourceColumnTag.getIsDelete();
            Integer sourceColumnTagAppShowAs = sourceColumnTag.getAppShowAs();
            Integer sourceColumnTagIsTop = sourceColumnTag.getIsTop();
            LocalDateTime sourceColumnTagTopTime = sourceColumnTag.getTopTime();
            String sourceColumnTagEmotion = sourceColumnTag.getEmotion();

            String carrieStr = "#2000#,#2001#,#2002#,#2003#,#2004#,#2005#,#2006#,#2007#,#2008#,#2009#,#2999#";
            String emotion = SysConst.Emotion.ALL.getType();
            String searchArea = SysConst.SearchArea.ALL.getType();
            String relatedWords = "";
            String opinionWords = "";
            String ambiguousWords = "";
            String exclusionWords = "";
            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            Integer showState = SysConst.ShowState.DISPLAY.getCode();
            Integer topState = SysConst.TopState.UN_TOP.getCode();
            LocalDateTime topTime = null;
            Integer appShowState = SysConst.ShowState.DISPLAY.getCode();
            Integer appTopState = SysConst.TopState.UN_TOP.getCode();
            LocalDateTime appTopTime = null;
            if (sourceColumnTagType != null && sourceColumnTagType == 0) {//旧版标签
                if (StringUtils.isNotEmpty(sourceColumnTagWhereAs)) {
                    JSONObject whereAsJSON = JSONObject.parseObject(sourceColumnTagWhereAs);
                    if (whereAsJSON != null) {
                        if (whereAsJSON.containsKey("carrie")) {    //载体
                            JSONArray carrieJSONArray = whereAsJSON.getJSONArray("carrie");
                            if (carrieJSONArray != null) {
                                String carrieCodeStr = carrieJSONArray.stream()
                                        .map(String::valueOf)
                                        .map(carrie -> {
                                            Integer carrieCode = 0;
                                            switch (carrie) {
                                                case "综合":
                                                    carrieCode = SysConst.Carrie.Carrie_2000.getCode();
                                                    break;
                                                case "新闻":
                                                    carrieCode = SysConst.Carrie.Carrie_2001.getCode();
                                                    break;
                                                case "博客":
                                                    carrieCode = SysConst.Carrie.Carrie_2002.getCode();
                                                    break;
                                                case "论坛":
                                                    carrieCode = SysConst.Carrie.Carrie_2003.getCode();
                                                    break;
                                                case "微博":
                                                    carrieCode = SysConst.Carrie.Carrie_2004.getCode();
                                                    break;
                                                case "微信":
                                                    carrieCode = SysConst.Carrie.Carrie_2005.getCode();
                                                    break;
                                                case "QQ群":
                                                    carrieCode = SysConst.Carrie.Carrie_2006.getCode();
                                                    break;
                                                case "电子报":
                                                    carrieCode = SysConst.Carrie.Carrie_2007.getCode();
                                                    break;
                                                case "视频":
                                                    carrieCode = SysConst.Carrie.Carrie_2008.getCode();
                                                    break;
                                                case "手机wap":
                                                    carrieCode = SysConst.Carrie.Carrie_2009.getCode();
                                                    break;
                                                case "其他":
                                                    carrieCode = SysConst.Carrie.Carrie_2999.getCode();
                                                    break;
                                                default:
                                                    carrieCode = SysConst.Carrie.Carrie_2999.getCode();
                                                    break;
                                            }
                                            return carrieCode;
                                        })
                                        .map(String::valueOf)
                                        .collect(Collectors.joining(","));
                                carrieStr = MStringUtils.decorateStr(carrieCodeStr);
                            }

                        }
                        if (whereAsJSON.containsKey("nature")) {    //情感
                            String natureStr = whereAsJSON.getString("nature");
                            switch (natureStr) {
                                case "正面":     //正面
                                    emotion = SysConst.Emotion.POSITIVE.getType();
                                    break;
                                case "负面":     //负面
                                    emotion = SysConst.Emotion.NEGATIVE.getType();
                                    break;
                                case "中性":     //中性
                                    emotion = SysConst.Emotion.NEUTRAL.getType();
                                    break;
                                case "全部":     //全部
                                    emotion = SysConst.Emotion.ALL.getType();
                                    break;
                                case "相关":     //全部
                                    emotion = SysConst.Emotion.ALL.getType();
                                    break;
                                case "舆情":     //中性
                                    emotion = SysConst.Emotion.NEUTRAL.getType();
                                    break;
                                default:
                                    emotion = SysConst.Emotion.ALL.getType();
                                    break;
                            }
                        }

                        if (whereAsJSON.containsKey("search")) {
                            JSONObject searchJSON = whereAsJSON.getJSONObject("search");
                            String all = searchJSON.containsKey("all") ? searchJSON.getString("all") : "";
                            String title = searchJSON.containsKey("title") ? searchJSON.getString("title") : "";
                            String content = searchJSON.containsKey("content") ? searchJSON.getString("content") : "";
                            if (StringUtils.isNotEmpty(all)) {
                                searchArea = SysConst.SearchArea.ALL.getType();
                                relatedWords = all;
                            }
                            if (StringUtils.isNotEmpty(title)) {
                                searchArea = SysConst.SearchArea.TITLE.getType();
                                relatedWords = title;
                            }
                            if (StringUtils.isNotEmpty(content)) {
                                searchArea = SysConst.SearchArea.CONTENT.getType();
                                relatedWords = content;
                            }
                            if (StringUtils.isNotEmpty(sourceColumnTagRelatedWord)) {
                                relatedWords = sourceColumnTagRelatedWord;
                            }
                        }
                    }

                }

            }
            if (sourceColumnTagType == null || sourceColumnTagType == 1) {//新版标签
                if (StringUtils.isNotEmpty(sourceColumnTagSearchArea)) {
                    switch (sourceColumnTagSearchArea) {
                        case "title":
                            searchArea = SysConst.SearchArea.TITLE.getType();
                            break;
                        case "content":
                            searchArea = SysConst.SearchArea.CONTENT.getType();
                            break;
                        case "all":
                            searchArea = SysConst.SearchArea.ALL.getType();
                            break;
                        default:
                            searchArea = SysConst.SearchArea.ALL.getType();
                            break;

                    }
                }
                if (StringUtils.isNotEmpty(sourceColumnTagEmotion)) {
                    switch (sourceColumnTagEmotion) {
                        case "正面":     //正面
                            emotion = SysConst.Emotion.POSITIVE.getType();
                            break;
                        case "positive":     //正面
                            emotion = SysConst.Emotion.POSITIVE.getType();
                            break;
                        case "负面":     //负面
                            emotion = SysConst.Emotion.NEGATIVE.getType();
                            break;
                        case "negative":     //负面
                            emotion = SysConst.Emotion.NEGATIVE.getType();
                            break;
                        case "中性":     //中性
                            emotion = SysConst.Emotion.NEUTRAL.getType();
                            break;
                        case "neutral":     //中性
                            emotion = SysConst.Emotion.NEUTRAL.getType();
                            break;
                        case "全部":     //全部
                            emotion = SysConst.Emotion.ALL.getType();
                            break;
                        case "all":     //全部
                            emotion = SysConst.Emotion.ALL.getType();
                            break;
                        case "相关":     //全部
                            emotion = SysConst.Emotion.ALL.getType();
                            break;
                        case "舆情":     //中性
                            emotion = SysConst.Emotion.NEUTRAL.getType();
                            break;
                        default:
                            emotion = SysConst.Emotion.ALL.getType();
                            break;
                    }
                }
                if (StringUtils.isNotEmpty(sourceColumnTagCarrie)) {    //载体
                    String carrieCodeStr = Arrays.stream(sourceColumnTagCarrie.split(","))
                            .map(carrie -> {
                                Integer carrieCode = 0;
                                switch (carrie) {
                                    case "新闻":
                                        carrieCode = SysConst.Carrie.Carrie_2001.getCode();
                                        break;
                                    case "综合":
                                        carrieCode = SysConst.Carrie.Carrie_2000.getCode();
                                        break;
                                    case "博客":
                                        carrieCode = SysConst.Carrie.Carrie_2002.getCode();
                                        break;
                                    case "论坛":
                                        carrieCode = SysConst.Carrie.Carrie_2003.getCode();
                                        break;
                                    case "微博":
                                        carrieCode = SysConst.Carrie.Carrie_2004.getCode();
                                        break;
                                    case "微信":
                                        carrieCode = SysConst.Carrie.Carrie_2005.getCode();
                                        break;
                                    case "QQ群":
                                        carrieCode = SysConst.Carrie.Carrie_2006.getCode();
                                        break;
                                    case "电子报":
                                        carrieCode = SysConst.Carrie.Carrie_2007.getCode();
                                        break;
                                    case "视频":
                                        carrieCode = SysConst.Carrie.Carrie_2008.getCode();
                                        break;
                                    case "手机wap":
                                        carrieCode = SysConst.Carrie.Carrie_2009.getCode();
                                        break;
                                    case "其他":
                                        carrieCode = SysConst.Carrie.Carrie_2999.getCode();
                                        break;
                                    default:
                                        carrieCode = SysConst.Carrie.Carrie_2999.getCode();
                                        break;
                                }
                                return carrieCode;
                            })
                            .map(String::valueOf)
                            .collect(Collectors.joining(","));
                    carrieStr = MStringUtils.decorateStr(carrieCodeStr);
                }

            }


            opinionWords = sourceColumnTagYuqingWord;
            ambiguousWords = sourceColumnTagQiyiWord;
            exclusionWords = sourceColumnTagUnrelatedWord;
            if (sourceColumnTagIsDelete != null) {
                if (sourceColumnTagIsDelete == 0) { //未删除
                    deleteState = SysConst.DeleteState.UN_DELETED.getCode();
                }
                if (sourceColumnTagIsDelete == 1) { //已删除
                    deleteState = SysConst.DeleteState.DELETE.getCode();
                }
            }
            if (sourceColumnTagShowAs != null) {
                if (sourceColumnTagShowAs == 1) { //展示
                    showState = SysConst.ShowState.DISPLAY.getCode();
                }
                if (sourceColumnTagShowAs == 0) { //不展示
                    showState = SysConst.ShowState.HIDE.getCode();
                }
            }
            if (sourceColumnTagIsTop != null) {
                if (sourceColumnTagIsTop == 0) {   //不置顶
                    topState = SysConst.TopState.UN_TOP.getCode();
                }
                if (sourceColumnTagIsTop == 1) {   //置顶
                    topState = SysConst.TopState.TOP.getCode();
                    topTime = sourceColumnTagTopTime;
                }
            }
            if (sourceColumnTagAppShowAs != null) {
                if (sourceColumnTagAppShowAs == 0) {//不可见
                    appShowState = SysConst.ShowState.HIDE.getCode();
                }
                if (sourceColumnTagAppShowAs == 1) {//可见
                    appShowState = SysConst.ShowState.DISPLAY.getCode();
                }
            }



            TargetColumnSpecial targetColumnSpecial = new TargetColumnSpecial();
            targetColumnSpecial.setId(sourceColumnTagId);
            targetColumnSpecial.setUserId(Long.valueOf(sourceColumnTagUserId));
            targetColumnSpecial.setColumnId(Long.valueOf(sourceColumnTagColumnId));
            targetColumnSpecial.setSpecialName(sourceColumnTagName);
            targetColumnSpecial.setOrderBy(((pageNumber - 1) * 200) + i);
            targetColumnSpecial.setSearchArea(searchArea);
            targetColumnSpecial.setEmotion(emotion);
            targetColumnSpecial.setCarrier(carrieStr);
            targetColumnSpecial.setRelatedWords(relatedWords);
            targetColumnSpecial.setOpinionWords(opinionWords);
            targetColumnSpecial.setAmbiguousWords(ambiguousWords);
            targetColumnSpecial.setExclusionWords(exclusionWords);
            targetColumnSpecial.setSiteUrl(sourceColumnTagSiteUrl);
            targetColumnSpecial.setAuthor(sourceColumnTagAuthor);
            targetColumnSpecial.setCreatedTime(sourceColumnTagTime);
            targetColumnSpecial.setDeleteState(deleteState);
            targetColumnSpecial.setShowState(showState);
            targetColumnSpecial.setTopState(topState);
            targetColumnSpecial.setTopTime(topTime);
            targetColumnSpecial.setAppShowState(appShowState);
            targetColumnSpecial.setAppTopState(appTopState);
            targetColumnSpecial.setAppTopTime(appTopTime);

            targetColumnSpecialService.save(targetColumnSpecial);
        }
        return size;
    }

    @Override
    protected Page<SourceColumnTag> getPageList(int pageNumber) {
        return sourceColumnTagService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}
