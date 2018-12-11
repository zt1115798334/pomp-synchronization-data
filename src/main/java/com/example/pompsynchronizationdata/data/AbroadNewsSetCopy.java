package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceAbroadSetting;
import com.example.pompsynchronizationdata.source.service.SourceAbroadSettingService;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadNewsGroup;
import com.example.pompsynchronizationdata.target.entity.TargetAbroadNewsSet;
import com.example.pompsynchronizationdata.target.service.TargetAbroadNewsGroupService;
import com.example.pompsynchronizationdata.target.service.TargetAbroadNewsSetService;
import com.google.common.base.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 11:42
 * description:
 */
@Component
public class AbroadNewsSetCopy extends PageHandler<SourceAbroadSetting> {


    @Autowired
    private SourceAbroadSettingService sourceAbroadSettingService;

    @Autowired
    private TargetAbroadNewsGroupService targetAbroadNewsGroupService;

    @Autowired
    private TargetAbroadNewsSetService targetAbroadNewsSetService;

    @Override
    protected int handleDataOfPerPage(List<SourceAbroadSetting> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceAbroadSetting sourceAbroadSetting = list.get(i);
            Long sourceAbroadSettingUserId = sourceAbroadSetting.getUserId();
            String sourceAbroadSettingName = sourceAbroadSetting.getName();
            String sourceAbroadSettingSearchArea = sourceAbroadSetting.getSearchArea();
            String sourceAbroadSettingRelatedWord = sourceAbroadSetting.getRelatedWord();
            String sourceAbroadSettingYuqingWord = sourceAbroadSetting.getYuqingWord();
            String sourceAbroadSettingQiyiWord = sourceAbroadSetting.getQiyiWord();
            String sourceAbroadSettingSiteUrl = sourceAbroadSetting.getSiteUrl();
            LocalDateTime sourceAbroadSettingTime = sourceAbroadSetting.getTime();
            Integer sourceAbroadSettingIsDelete = sourceAbroadSetting.getIsDelete();


            Optional<TargetAbroadNewsGroup> targetAbroadNewsGroupOptional = targetAbroadNewsGroupService.findByUserId(sourceAbroadSettingUserId);

            TargetAbroadNewsGroup targetAbroadNewsGroup = targetAbroadNewsGroupOptional.orElseGet(() -> saveDefaultAbroadNewsGroup(sourceAbroadSettingUserId));


            Long targetAbroadNewsGroupId = targetAbroadNewsGroup.getId();

            String searchArea = SysConst.SearchArea.ALL.getType();

            if (Objects.equal(sourceAbroadSettingSearchArea, "title")) {
                searchArea = SysConst.SearchArea.TITLE.getType();
            }
            if (Objects.equal(sourceAbroadSettingSearchArea, "content")) {
                searchArea = SysConst.SearchArea.CONTENT.getType();
            }
            if (Objects.equal(sourceAbroadSettingSearchArea, "all")) {
                searchArea = SysConst.SearchArea.ALL.getType();
            }
            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            if (sourceAbroadSettingIsDelete == 0) { //no delete
                deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            }
            if (sourceAbroadSettingIsDelete == 1) {//delete
                deleteState = SysConst.DeleteState.DELETE.getCode();
            }


            TargetAbroadNewsSet targetAbroadNewsSet = new TargetAbroadNewsSet();
            targetAbroadNewsSet.setGroupId(targetAbroadNewsGroupId);
            targetAbroadNewsSet.setUserId(sourceAbroadSettingUserId);
            targetAbroadNewsSet.setSetName(sourceAbroadSettingName);
            targetAbroadNewsSet.setOrderBy(1);
            targetAbroadNewsSet.setSearchArea(searchArea);
            targetAbroadNewsSet.setRelatedWords(sourceAbroadSettingRelatedWord);
            targetAbroadNewsSet.setOpinionWords(sourceAbroadSettingYuqingWord);
            targetAbroadNewsSet.setAmbiguousWords(sourceAbroadSettingQiyiWord);
            targetAbroadNewsSet.setExclusionWords(null);
            targetAbroadNewsSet.setSiteUrl(sourceAbroadSettingSiteUrl);
            targetAbroadNewsSet.setAuthor(null);
            targetAbroadNewsSet.setCreatedTime(sourceAbroadSettingTime);
            targetAbroadNewsSet.setDeleteState(deleteState);
            targetAbroadNewsSetService.save(targetAbroadNewsSet);


        }
        return size;
    }

    @Override
    protected Page<SourceAbroadSetting> getPageList(int pageNumber) {
        return sourceAbroadSettingService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }

    private TargetAbroadNewsGroup saveDefaultAbroadNewsGroup(Long userId) {
        TargetAbroadNewsGroup targetAbroadNewsGroup = new TargetAbroadNewsGroup();
        targetAbroadNewsGroup.setUserId(userId);
        targetAbroadNewsGroup.setGroupName("默认分组");
        targetAbroadNewsGroup.setOrderBy(1);
        targetAbroadNewsGroup.setShowState(SysConst.ShowState.DISPLAY.getCode());
        targetAbroadNewsGroup.setCreatedTime(DateUtils.currentDateTime());
        targetAbroadNewsGroup.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());
        return targetAbroadNewsGroupService.save(targetAbroadNewsGroup);
    }
}
