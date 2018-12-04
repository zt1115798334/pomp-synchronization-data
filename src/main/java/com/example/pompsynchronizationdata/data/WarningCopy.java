package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.es.domain.EsArticle;
import com.example.pompsynchronizationdata.es.service.EsArticleService;
import com.example.pompsynchronizationdata.source.entity.SourceWarning;
import com.example.pompsynchronizationdata.source.service.SourceWarningService;
import com.example.pompsynchronizationdata.target.entity.TargetWarning;
import com.example.pompsynchronizationdata.target.service.TargetWarningService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
public class WarningCopy extends PageHandler<SourceWarning> {

    @Autowired
    private SourceWarningService sourceWarningService;

    @Autowired
    private TargetWarningService targetWarningService;

    @Autowired
    private EsArticleService esArticleService;

    @Override
    protected int handleDataOfPerPage(List<SourceWarning> list, int pageNumber) {
        log.info("开始请求es获取数据..");
        List<String> articleIdList = list.stream()
                .filter(sourceWarning -> sourceWarning.getDeleteState() == 0)
                .map(SourceWarning::getId).distinct().collect(Collectors.toList());
        log.info("未删除文章Id数量为:" + articleIdList.size());
        List<EsArticle> esArticleList = esArticleService.findEsArticleListByIdsWithOutContent(articleIdList);
        log.info("查询出来的es文章数量为:" + esArticleList.size());
        Map<String, EsArticle> esArticleMap = esArticleList.stream()
                .collect(Collectors.toMap(EsArticle::getId, Function.identity()));


        List<SourceWarning> noDeleteSourceWarning = list.stream()
                .filter(sourceWarning -> sourceWarning.getDeleteState() == 0)
                .collect(Collectors.toList());
        int size = noDeleteSourceWarning.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');

        for (int i = 0; i < size; i++) {
            SourceWarning sourceWarning = noDeleteSourceWarning.get(i);
            String sourceWarningArticleId = sourceWarning.getId();

            if (esArticleMap.containsKey(sourceWarningArticleId)) {

                EsArticle esArticle = esArticleMap.get(sourceWarningArticleId);

                Integer sourceWarningUserId = sourceWarning.getUserId();
                String sourceWarningCarrie = sourceWarning.getCarrie();
                String sourceWarningCountry = sourceWarning.getCountry();
                Integer sourceWarningHot = sourceWarning.getHot();
                Long sourceWarningDeleteState = sourceWarning.getDeleteState();
                Integer sourceWarningMode = sourceWarning.getMode();
                LocalDateTime publishTime = sourceWarning.getPublishTime();
                LocalDateTime sourceWarningInTime = sourceWarning.getInTime();
                LocalDateTime sourceWarningPhoneTime = sourceWarning.getPhoneTime();
                LocalDateTime sourceWarningEmailTime = sourceWarning.getEmailTime();
                Integer sourceWarningIsRead = sourceWarning.getIsRead();
                Long sourceWarningWarningRuleId = sourceWarning.getWarningRuleId();
                String sourceWarningWarningLevel = sourceWarning.getWarningLevel();


                Integer carrieCode;
                switch (sourceWarningCarrie) {
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
                        System.out.println("载体无法解析 = " + sourceWarningCarrie);
                        carrieCode = SysConst.Carrie.Carrie_2999.getCode();
                        break;
                }
                Integer region = SysConst.Region.REGION_INNER.getCode();
                switch (sourceWarningCountry) {
                    case "境内":
                        region = SysConst.Region.REGION_INNER.getCode();
                        break;
                    case "境外":
                        region = SysConst.Region.REGION_OUTSIDE.getCode();
                        break;
                }
                Integer warningType = SysConst.WarningType.MACHINE.getCode();
                if (sourceWarningMode == 0) { //机器
                    warningType = SysConst.WarningType.MACHINE.getCode();
                }
                if (sourceWarningMode == 1) { //手动
                    warningType = SysConst.WarningType.ARTIFICIAL.getCode();
                }
//
                TargetWarning targetWarning = new TargetWarning();
                targetWarning.setArticleId(sourceWarningArticleId);
                targetWarning.setUserId(Long.valueOf(sourceWarningUserId));
                targetWarning.setWarningRuleId(sourceWarningWarningRuleId);
                targetWarning.setPublishTime(publishTime);
                targetWarning.setCarrier(carrieCode);
                targetWarning.setRegion(region);
                targetWarning.setEmotion(esArticle.getEmotion());
                targetWarning.setWarningType(warningType);
                targetWarning.setWarningDate(sourceWarningInTime.toLocalDate());
                targetWarning.setWarningTime(sourceWarningInTime);
                String warningLevel = SysConst.WarningLevel.RED.getType();
                if (StringUtils.isEmpty(sourceWarningWarningLevel)) {
                    warningLevel = SysConst.WarningLevel.RED.getType();
                } else {
                    switch (sourceWarningWarningLevel) {
                        case "red":
                            warningLevel = SysConst.WarningLevel.RED.getType();
                            break;
                        case "orange":
                            warningLevel = SysConst.WarningLevel.ORANGE.getType();
                            break;
                        case "yellow":
                            warningLevel = SysConst.WarningLevel.YELLOW.getType();
                            break;
                    }
                }
                targetWarning.setWarningLevel(warningLevel);


                Integer readState = SysConst.ReadState.UNREAD.getCode();
                if (sourceWarningIsRead == 0) {   //未读
                    readState = SysConst.ReadState.UNREAD.getCode();
                } else if (sourceWarningIsRead == 1) {   //已读
                    readState = SysConst.ReadState.READ.getCode();
                }
                targetWarning.setReadState(readState);
                if (sourceWarningPhoneTime == null) {
                    targetWarning.setSendPhoneState(SysConst.SendState.UNSENT.getCode());
                } else {
                    targetWarning.setSendPhoneState(SysConst.SendState.SENT.getCode());
                    targetWarning.setSendPhoneTime(sourceWarningPhoneTime);
                }
                if (sourceWarningEmailTime == null) {
                    targetWarning.setSendEmailState(SysConst.SendState.UNSENT.getCode());
                } else {
                    targetWarning.setSendEmailState(SysConst.SendState.SENT.getCode());
                    targetWarning.setSendEmailTime(sourceWarningEmailTime);
                }
                targetWarningService.save(targetWarning);
            }
            cpb.show(i);
        }
        return esArticleList.size();
    }

    @Override
    protected Page<SourceWarning> getPageList(int pageNumber) {
        return sourceWarningService.findPageByEntity(pageNumber, SysConst.DEFAULT_BATCH_SIZE);
    }
}
