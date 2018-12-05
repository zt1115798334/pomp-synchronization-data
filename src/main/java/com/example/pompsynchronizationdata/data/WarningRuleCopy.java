package com.example.pompsynchronizationdata.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.Hanzi2Unicode;
import com.example.pompsynchronizationdata.custom.MStringUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceWarningRule;
import com.example.pompsynchronizationdata.source.service.SourceWarningRuleService;
import com.example.pompsynchronizationdata.target.entity.TargetWarningRule;
import com.example.pompsynchronizationdata.target.service.TargetWarningRuleService;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/3 16:24
 * description:
 */
@Slf4j
@Component
public class WarningRuleCopy extends PageHandler<SourceWarningRule> {

    @Autowired
    private SourceWarningRuleService sourceWarningRuleService;

    @Autowired
    private TargetWarningRuleService targetWarningRuleService;

    @Override
    protected int handleDataOfPerPage(List<SourceWarningRule> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            SourceWarningRule sourceWarningRule = list.get(i);
            cpb.show(i);
            try {

                Long sourceWarningRuleId = sourceWarningRule.getId();
                Long sourceWarningRuleUserId = sourceWarningRule.getUserId();
                String sourceWarningRuleName = sourceWarningRule.getName();
                Integer sourceWarningRuleStatus = sourceWarningRule.getStatus();
                String sourceWarningRuleValue = sourceWarningRule.getValue();
                Integer sourceWarningRuleRuleType = sourceWarningRule.getRuleType();
                LocalDateTime sourceWarningRuleTime = sourceWarningRule.getTime();
                String sourceWarningRuleWarningLevel = sourceWarningRule.getWarningLevel();
                String sourceWarningRuleWarningArticlePosition = sourceWarningRule.getWarningArticlePosition();


                TargetWarningRule targetWarningRule = new TargetWarningRule();
                if (Objects.equal(sourceWarningRuleName, "手动预警") && sourceWarningRuleRuleType == 1) {   //手动预警的


                    Optional<TargetWarningRule> warningRuleOptional = targetWarningRuleService.findHandleByUserId(sourceWarningRuleUserId);

                    if (warningRuleOptional.isPresent()) {
                        continue;
                    }
                    targetWarningRule.setRoleTitle("手动预警");
                    targetWarningRule.setId(sourceWarningRuleId);
                    targetWarningRule.setUserId(sourceWarningRuleUserId);
                    targetWarningRule.setEnabledState(SysConst.EnabledState.ON.getCode());
                    targetWarningRule.setWarningType(SysConst.WarningType.ARTIFICIAL.getCode());
                    targetWarningRule.setEmotion(SysConst.Emotion.ALL.getType());
                    targetWarningRule.setSearchArea(SysConst.SearchArea.ALL.getType());
                    targetWarningRule.setRegion(SysConst.Region.ALL.getCode());
                    targetWarningRule.setCreatedTime(sourceWarningRuleTime);
                    targetWarningRule.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());
                    targetWarningRuleService.save(targetWarningRule);
                    continue;
                }
                //处理自动预警的

                if (StringUtils.isNotEmpty(sourceWarningRuleValue)) {
                    JSONObject sourceWarningRuleValueJSON = JSON.parseObject(sourceWarningRuleValue);

                    if (sourceWarningRuleValueJSON.containsKey("bookId")) { //通知人id
                        String bookId = sourceWarningRuleValueJSON.getString("bookId");
                        String waringNoticeIds = MStringUtils.decorateStr(bookId);
                        targetWarningRule.setWarningNoticeIds(waringNoticeIds);
                    }
                    if (sourceWarningRuleValueJSON.containsKey("carrie")) { //载体
                        String carrie = sourceWarningRuleValueJSON.getString("carrie");
                        String carrieArr;
                        if (StringUtils.isNotEmpty(carrie)) {
                            carrieArr = Arrays.stream(carrie.split(",")).map(Hanzi2Unicode::toHanzi)
                                    .map(str -> {
                                        Integer carrieCode = 0;
                                        switch (str) {
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
                                                System.out.println("载体无法解析 = " + str);
                                                carrieCode = SysConst.Carrie.Carrie_2999.getCode();
                                                break;
                                        }
                                        return carrieCode;
                                    }).map(String::valueOf)
                                    .collect(Collectors.joining(","));
                        } else {
                            List<Integer> code = SysConst.CarrieList.Carrie_ALL.getCode();
                            carrieArr = code.stream().map(String::valueOf).collect(Collectors.joining(","));
                        }
                        String carrieStr = MStringUtils.decorateStr(carrieArr);

                        targetWarningRule.setCarrier(carrieStr);
                    }

                    if (sourceWarningRuleValueJSON.containsKey("containAllWord")) { //预警词
                        String containAllWord = sourceWarningRuleValueJSON.getString("containAllWord");
                        if (StringUtils.isNotEmpty(containAllWord)) {
                            String containAllWordArr = Arrays.stream(containAllWord.split(","))
                                    .map(Hanzi2Unicode::toHanzi)
                                    .collect(Collectors.joining(","));
                            String containAllWords = MStringUtils.decorateStr(containAllWordArr);
                            targetWarningRule.setWarningWords(containAllWords);
                        }

                    }
                    if (sourceWarningRuleValueJSON.containsKey("noContainAllWord")) { //排除词
                        String noContainAllWord = sourceWarningRuleValueJSON.getString("noContainAllWord");
                        if (StringUtils.isNotEmpty(noContainAllWord)) {
                            String noContainAllWordArr = Arrays.stream(noContainAllWord.split(","))
                                    .map(Hanzi2Unicode::toHanzi)
                                    .collect(Collectors.joining(","));
                            String noContainAllWords = MStringUtils.decorateStr(noContainAllWordArr);
                            targetWarningRule.setExclusionWords(noContainAllWords);
                        }

                    }
                    if (sourceWarningRuleValueJSON.containsKey("type")) { //情感
                        String type = sourceWarningRuleValueJSON.getString("type");
                        String typeHZ = Hanzi2Unicode.toHanzi(type);
                        String emotion;
                        switch (typeHZ) {
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
                                System.out.println("情感无法解析=" + typeHZ);
                                emotion = SysConst.Emotion.ALL.getType();
                                break;
                        }
                        targetWarningRule.setEmotion(emotion);
                    } else {
                        System.out.println("id为" + sourceWarningRuleId + "没有情感");
                        targetWarningRule.setEmotion(SysConst.Emotion.ALL.getType());
                    }
                    if (sourceWarningRuleValueJSON.containsKey("warning_method")) { //预警类型
                        String warning_method = sourceWarningRuleValueJSON.getString("warning_method");
                        List<String> warningEmotionList = Lists.newArrayList();
                        if (warning_method.contains("tc")) {    //弹窗
                            warningEmotionList.add(SysConst.WarningNoticeType.DIALOG.getType());
                        }
                        if (warning_method.contains("yx")) {    //邮箱
                            warningEmotionList.add(SysConst.WarningNoticeType.EMAIL.getType());
                        }
                        if (warning_method.contains("dx")) {    //短信

                            warningEmotionList.add(SysConst.WarningNoticeType.PHONE.getType());
                        }
                        if (warning_method.contains("app")) {    //app

                            warningEmotionList.add(SysConst.WarningNoticeType.APP.getType());
                        }
                        if (warning_method.contains("weChat")) {    //微信公众号

                            warningEmotionList.add(SysConst.WarningNoticeType.WECHAT.getType());
                        }
                        targetWarningRule.setWarningNoticeType(String.join(",", warningEmotionList));
                    }
                    LocalTime startTime = LocalTime.MIN;
                    LocalTime endTime = LocalTime.MAX;
                    if (sourceWarningRuleValueJSON.containsKey("timeStart")) { //预警开始时间
                        String startTimeStr = sourceWarningRuleValueJSON.getString("timeStart");
                        String[] split = {};
                        if (startTimeStr.contains(":")) {
                            split = startTimeStr.split(":");
                        }
                        if (startTimeStr.contains("：")) {
                            split = startTimeStr.split("：");
                        }

                        startTime = LocalTime.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
                    }
                    if (sourceWarningRuleValueJSON.containsKey("timeEnd")) { //预警结束时间
                        String endTimeStr = sourceWarningRuleValueJSON.getString("timeEnd");
                        String[] split = {};
                        if (endTimeStr.contains("：")) {
                            split = endTimeStr.split("：");
                        }
                        if (endTimeStr.contains(":")) {
                            split = endTimeStr.split(":");
                        }
                        if (Objects.equal(split[0], "24")) {
                            endTime = LocalTime.MAX;
                        } else {
                            endTime = LocalTime.of(Integer.valueOf(split[0]), Integer.valueOf(split[1]));
                        }


                    }
                    targetWarningRule.setRegion(SysConst.Region.ALL.getCode());
                    targetWarningRule.setStartWarningTime(startTime);
                    targetWarningRule.setEndWarningTime(endTime);
                    targetWarningRule.setId(sourceWarningRuleId);
                    targetWarningRule.setWarningType(SysConst.WarningType.MACHINE.getCode());
                    targetWarningRule.setUserId(sourceWarningRuleUserId);
                    targetWarningRule.setRoleTitle(sourceWarningRuleName);
                    Integer enabledState = null;
                    if (sourceWarningRuleStatus == 1) {  //开启状态//开启
                        enabledState = SysConst.EnabledState.ON.getCode();
                    } else if (sourceWarningRuleStatus == 0) { //停用
                        enabledState = SysConst.EnabledState.OFF.getCode();
                    }
                    targetWarningRule.setEnabledState(enabledState);
                    String warningLevel = null;
                    if (StringUtils.isEmpty(sourceWarningRuleWarningLevel)) {
                        warningLevel = SysConst.WarningLevel.RED.getType();
                    }else{
                        switch (sourceWarningRuleWarningLevel) {
                            case "red":   //红色等级
                                warningLevel = SysConst.WarningLevel.RED.getType();
                                break;
                            case "orange":   //橙色等级
                                warningLevel = SysConst.WarningLevel.ORANGE.getType();
                                break;
                            case "yellow":   //黄色等级
                                warningLevel = SysConst.WarningLevel.YELLOW.getType();
                                break;
                        }
                    }


                    targetWarningRule.setWarningLevel(warningLevel);

                    String searchArea = null;
                    if (StringUtils.isEmpty(sourceWarningRuleWarningArticlePosition)){
                        searchArea = SysConst.SearchArea.ALL.getType();
                    }else{
                        switch (sourceWarningRuleWarningArticlePosition) {  //搜索范围
                            case "all":
                                searchArea = SysConst.SearchArea.ALL.getType();
                                break;
                            case "title":
                                searchArea = SysConst.SearchArea.TITLE.getType();
                                break;
                            case "content":
                                searchArea = SysConst.SearchArea.CONTENT.getType();
                                break;
                            default:
                                System.out.println("无法判断=" + sourceWarningRuleWarningArticlePosition);
                                break;
                        }
                    }

                    targetWarningRule.setSearchArea(searchArea);
                    targetWarningRule.setCreatedTime(sourceWarningRuleTime);
                    targetWarningRule.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());
                    targetWarningRuleService.save(targetWarningRule);
                 }
            } catch (Exception e) {
                log.error("出错id为" + sourceWarningRule.getId());
                e.printStackTrace();

            }
        }

        return size;
    }

    @Override
    protected Page<SourceWarningRule> getPageList(int pageNumber) {
        return sourceWarningRuleService.findPageByEntity(pageNumber, SysConst.DEFAULT_BATCH_SIZE);
    }

    public static void main(String[] args) {
        String s = Hanzi2Unicode.toHanzi("\\u5883\\u5185");
        System.out.println("s = " + s);

    }
}
