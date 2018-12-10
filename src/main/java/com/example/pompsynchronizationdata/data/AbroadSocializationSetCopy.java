package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceAbroadMediaSetting;
import com.example.pompsynchronizationdata.source.service.SourceAbroadMediaSettingService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadSocializationSet;
import com.example.pompsynchronizationdata.target.service.TargetAbroadSocializationSetService;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:35
 * description:
 */
@Component
public class AbroadSocializationSetCopy extends PageHandler<SourceAbroadMediaSetting> {

    @Autowired
    private SourceAbroadMediaSettingService sourceAbroadMediaSettingService;

    @Autowired
    private TargetAbroadSocializationSetService targetAbroadSocializationSetService;

    @Override
    protected int handleDataOfPerPage(List<SourceAbroadMediaSetting> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceAbroadMediaSetting sourceAbroadMediaSetting = list.get(i);
            Long sourceAbroadMediaSettingId = sourceAbroadMediaSetting.getId();
            Long sourceAbroadMediaSettingUserId = sourceAbroadMediaSetting.getUserId();
            String sourceAbroadMediaSettingName = sourceAbroadMediaSetting.getName();
            String sourceAbroadMediaSettingSearchArea = sourceAbroadMediaSetting.getSearchArea();
            String sourceAbroadMediaSettingRelatedWord = sourceAbroadMediaSetting.getRelatedWord();
            String sourceAbroadMediaSettingYuqingWord = sourceAbroadMediaSetting.getYuqingWord();
            String sourceAbroadMediaSettingQiyiWord = sourceAbroadMediaSetting.getQiyiWord();
            String sourceAbroadMediaSettingSiteUrl = sourceAbroadMediaSetting.getSiteUrl();
            LocalDateTime sourceAbroadMediaSettingTime = sourceAbroadMediaSetting.getTime();
            Integer sourceAbroadMediaSettingIsDelete = sourceAbroadMediaSetting.getIsDelete();
            Long sourceAbroadMediaSettingGroupId = sourceAbroadMediaSetting.getGroupId();
            Integer sourceAbroadMediaSettingOrderBy = sourceAbroadMediaSetting.getOrderBy();
            String sourceAbroadMediaSettingMonitorType = sourceAbroadMediaSetting.getMonitorType();
            String sourceAbroadMediaSettingUnrelatedWord = sourceAbroadMediaSetting.getUnrelatedWord();
            String sourceAbroadMediaSettingAuthorWord = sourceAbroadMediaSetting.getAuthorWord();

            String searchArea = SysConst.SearchArea.ALL.getType();
            if (Objects.equal(sourceAbroadMediaSettingSearchArea, "title")) {
                searchArea = SysConst.SearchArea.TITLE.getType();
            }
            if (Objects.equal(sourceAbroadMediaSettingSearchArea, "content")) {
                searchArea = SysConst.SearchArea.CONTENT.getType();
            }
            if (Objects.equal(sourceAbroadMediaSettingSearchArea, "all")) {
                searchArea = SysConst.SearchArea.ALL.getType();
            }

            String socialType = SysConst.SocialType.ALL.getType();
            if (Objects.equal(sourceAbroadMediaSettingMonitorType, "all")) {
                socialType = SysConst.SocialType.ALL.getType();
            }
            if (Objects.equal(sourceAbroadMediaSettingMonitorType, "twitter")) {
                socialType = SysConst.SocialType.TWITTER.getType();
            }
            if (Objects.equal(sourceAbroadMediaSettingMonitorType, "facebook")) {
                socialType = SysConst.SocialType.FACEBOOK.getType();
            }
            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            if (sourceAbroadMediaSettingIsDelete == 0) {//no delete
                deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            }
            if (sourceAbroadMediaSettingIsDelete == 1) {// delete
                deleteState = SysConst.DeleteState.DELETE.getCode();
            }

            TargetAbroadSocializationSet targetAbroadSocializationSet = new TargetAbroadSocializationSet();
            targetAbroadSocializationSet.setId(sourceAbroadMediaSettingId);
            targetAbroadSocializationSet.setGroupId(sourceAbroadMediaSettingGroupId);
            targetAbroadSocializationSet.setUserId(sourceAbroadMediaSettingUserId);
            targetAbroadSocializationSet.setSetName(sourceAbroadMediaSettingName);
            targetAbroadSocializationSet.setSocialType(socialType);
            targetAbroadSocializationSet.setOrderBy(sourceAbroadMediaSettingOrderBy);
            targetAbroadSocializationSet.setSearchArea(searchArea);
            targetAbroadSocializationSet.setRelatedWords(sourceAbroadMediaSettingRelatedWord);
            targetAbroadSocializationSet.setOpinionWords(sourceAbroadMediaSettingYuqingWord);
            targetAbroadSocializationSet.setExclusionWords(sourceAbroadMediaSettingQiyiWord);
            targetAbroadSocializationSet.setAuthor(sourceAbroadMediaSettingAuthorWord);
            targetAbroadSocializationSet.setCreatedTime(sourceAbroadMediaSettingTime);
            targetAbroadSocializationSet.setDeleteState(deleteState);

            targetAbroadSocializationSetService.save(targetAbroadSocializationSet);

        }
        return size;
    }

    @Override
    protected Page<SourceAbroadMediaSetting> getPageList(int pageNumber) {
        return sourceAbroadMediaSettingService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}
