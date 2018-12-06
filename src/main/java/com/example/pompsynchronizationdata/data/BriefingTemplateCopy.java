package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.target.entity.TargetBriefing;
import com.example.pompsynchronizationdata.target.entity.TargetBriefingTemplate;
import com.example.pompsynchronizationdata.target.service.TargetBriefingService;
import com.example.pompsynchronizationdata.target.service.TargetBriefingTemplateService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 14:56
 * description:
 */
@Component
public class BriefingTemplateCopy extends PageHandler<TargetBriefing> {

    @Autowired
    private TargetBriefingService targetBriefingService;

    @Autowired
    private TargetBriefingTemplateService targetBriefingTemplateService;

    @Override
    protected int handleDataOfPerPage(List<TargetBriefing> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            TargetBriefing targetBriefing = list.get(i);
            Long targetBriefingId = targetBriefing.getId();
            String briefingType = targetBriefing.getBriefingType();
            Integer targetBriefingTemplateType = targetBriefing.getTemplateType();
            if (targetBriefingTemplateType.equals(SysConst.TemplateType.CURRENCY_EDITION.getCode())) {
                List<TargetBriefingTemplate> briefingTemplates = encapsulationCurrency(targetBriefingId, briefingType);
                targetBriefingTemplateService.saveAll(briefingTemplates);
            }
            if (targetBriefingTemplateType.equals(SysConst.TemplateType.MEDIA_EDITION.getCode())) {
                List<TargetBriefingTemplate> briefingTemplates = encapsulationEdition(targetBriefingId, briefingType);
                targetBriefingTemplateService.saveAll(briefingTemplates);
            }
        }
        return size;
    }

    @Override
    protected Page<TargetBriefing> getPageList(int pageNumber) {
        return targetBriefingService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }

    private final Integer CURRENCY_EDITION = SysConst.TemplateType.CURRENCY_EDITION.getCode();
    private final Integer MEDIA_EDITION = SysConst.TemplateType.MEDIA_EDITION.getCode();
    private final Integer UN_DELETED = SysConst.DeleteState.UN_DELETED.getCode();
    private final Integer DELETED = SysConst.DeleteState.DELETE.getCode();

    /**
     * 分装通用报告模板
     *
     * @param briefingId   报告id
     * @param briefingType 报告类型
     * @return
     */
    private ArrayList<TargetBriefingTemplate> encapsulationCurrency(Long briefingId, String briefingType) {
        return Lists.newArrayList(
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 0, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 1, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 2, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 3, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 4, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 5, DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 6, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 7, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 8, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 9, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, CURRENCY_EDITION, 10, UN_DELETED)
        );
    }

    /**
     * 分装媒体报告模板
     *
     * @param briefingId   报告id
     * @param briefingType 报告类型
     * @return
     */
    private ArrayList<TargetBriefingTemplate> encapsulationEdition(Long briefingId, String briefingType) {
        return Lists.newArrayList(
                new TargetBriefingTemplate(briefingId, briefingType, MEDIA_EDITION, 0, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, MEDIA_EDITION, 1, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, MEDIA_EDITION, 2, UN_DELETED),
                new TargetBriefingTemplate(briefingId, briefingType, MEDIA_EDITION, 3, UN_DELETED)
        );
    }
}
