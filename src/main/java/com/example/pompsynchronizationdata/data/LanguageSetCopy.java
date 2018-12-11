package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceLanguageSet;
import com.example.pompsynchronizationdata.source.entity.SourceLanguages;
import com.example.pompsynchronizationdata.source.service.SourceLanguageSetService;
import com.example.pompsynchronizationdata.source.service.SourceLanguagesService;
import com.example.pompsynchronizationdata.target.entity.TargetLanguageGroup;
import com.example.pompsynchronizationdata.target.entity.TargetLanguageSet;
import com.example.pompsynchronizationdata.target.service.TargetLanguageGroupService;
import com.example.pompsynchronizationdata.target.service.TargetLanguageSetService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 *
 * @author six
 * date: 2018/12/6 10:07
 * description:
 */
@Component
public class LanguageSetCopy extends PageHandler<SourceLanguageSet> {

    @Autowired
    SourceLanguageSetService sourceLanguageSetService;

    @Autowired
    SourceLanguagesService sourceLanguagesService;

    @Autowired
    TargetLanguageSetService targetLanguageSetService;

    @Autowired
    TargetLanguageGroupService targetLanguageGroupService;

    @Override
    protected int handleDataOfPerPage(List<SourceLanguageSet> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceLanguageSet sourceLanguageSet = list.get(i);
            Long sourceLanguageSetId = sourceLanguageSet.getId();
            Integer sourceLanguageSetIsDelete = sourceLanguageSet.getIsDelete();
            Long sourceLanguageSetLanguageId = sourceLanguageSet.getLanguageId();
            String sourceLanguageSetQiyiWord = sourceLanguageSet.getQiyiWord();
            String sourceLanguageSetRelatedWord = sourceLanguageSet.getRelatedWord();
            String sourceLanguageSetSearchArea = sourceLanguageSet.getSearchArea();
            String sourceLanguageSetSiteUrl = sourceLanguageSet.getSiteUrl();
            LocalDateTime sourceLanguageSetTime = sourceLanguageSet.getTime();
            Long sourceLanguageSetUserId = sourceLanguageSet.getUserId();
            String sourceLanguageSetYuqingWord = sourceLanguageSet.getYuqingWord();

            Optional<TargetLanguageGroup> targetLanguageGroupOptional = targetLanguageGroupService.findByUserId(sourceLanguageSetUserId);
            TargetLanguageGroup targetLanguageGroup = targetLanguageGroupOptional.orElseGet(() -> saveDefaultLanguageGroup(sourceLanguageSetUserId));
            Long targetLanguageGroupId = targetLanguageGroup.getId();
            String searchArea = SysConst.SearchArea.ALL.getType();
            String relatedWords = "";
            String opinionWords = "";
            String ambiguousWords = "";
            String exclusionWords = "";
            Integer deleteState = SysConst.DeleteState.UN_DELETED.getCode();
            if (sourceLanguageSetId != null && sourceLanguageSetId != null && sourceLanguageSetUserId != null) {
                Long id = sourceLanguageSetId;
                Long userId = sourceLanguageSetUserId;
                Long languageSetId = sourceLanguageSetId;
                Optional<SourceLanguages> SourceLanguagesOptional = sourceLanguagesService.findById(sourceLanguageSetLanguageId);
                if (SourceLanguagesOptional.isPresent()) {
                    String setName = SourceLanguagesOptional.get().getName();
                    ambiguousWords = sourceLanguageSetQiyiWord;
                    opinionWords = sourceLanguageSetYuqingWord;
                    if (StringUtils.isNotEmpty(sourceLanguageSetSearchArea)) {
                        switch (sourceLanguageSetSearchArea) {
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
                    if (StringUtils.isNotEmpty(sourceLanguageSetRelatedWord)) {
                        relatedWords = sourceLanguageSetRelatedWord;
                    }
                    if (sourceLanguageSetIsDelete != null) {
                        if (sourceLanguageSetIsDelete == 0) {//no delete
                            deleteState = SysConst.DeleteState.UN_DELETED.getCode();
                        }
                        if (sourceLanguageSetIsDelete == 1) {//delete
                            deleteState = SysConst.DeleteState.DELETE.getCode();
                        }
                    }
                    if (sourceLanguageSetTime != null && setName != null) {
                        TargetLanguageSet targetLanguageSet = new TargetLanguageSet();
                        targetLanguageSet.setId(id);
                        targetLanguageSet.setSetName(setName);
                        targetLanguageSet.setLanguage(setName);
                        targetLanguageSet.setGroupId(targetLanguageGroupId);
                        targetLanguageSet.setDeleteState(deleteState);
                        targetLanguageSet.setAmbiguousWords(ambiguousWords);
                        targetLanguageSet.setRelatedWords(relatedWords);
                        targetLanguageSet.setSearchArea(searchArea);
                        targetLanguageSet.setSiteUrl(sourceLanguageSetSiteUrl);
                        targetLanguageSet.setCreatedTime(sourceLanguageSetTime);
                        targetLanguageSet.setUserId(userId);
                        targetLanguageSet.setOpinionWords(opinionWords);//ambignous_words ambiguous_words
                        targetLanguageSet.setExclusionWords(exclusionWords);
                        targetLanguageSetService.save(targetLanguageSet);

                    }
                }
            }
        }
        return size;
    }

    @Override
    protected Page<SourceLanguageSet> getPageList(int pageNumber) {
        return sourceLanguageSetService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }

    public TargetLanguageGroup saveDefaultLanguageGroup(Long userId) {
        TargetLanguageGroup targetLanguageGroup = new TargetLanguageGroup();
        targetLanguageGroup.setUserId(userId);
        targetLanguageGroup.setGroupName("默认分组");
        targetLanguageGroup.setOrderBy(1);
        targetLanguageGroup.setShowState(SysConst.ShowState.DISPLAY.getCode());
        targetLanguageGroup.setCreatedTime(DateUtils.currentDateTime());
        targetLanguageGroup.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());
        return targetLanguageGroupService.save(targetLanguageGroup);
    }

}
