package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceUser;
import com.example.pompsynchronizationdata.source.service.SourceUserService;
import com.example.pompsynchronizationdata.target.entity.TargetUser;
import com.example.pompsynchronizationdata.target.service.TargetUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/3 11:58
 * description:
 */
@Component
public class UserCopy extends PageHandler<SourceUser> {

    @Autowired
    private SourceUserService sourceUserService;

    @Autowired
    private TargetUserService targetUserService;

    @Override
    protected int handleDataOfPerPage(List<SourceUser> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 20, '=');
        for (int i = 0; i < size; i++) {
            SourceUser sourceUser = list.get(i);
            TargetUser targetUser = new TargetUser();
            targetUser.setId(sourceUser.getId());
            targetUser.setPhone(sourceUser.getPhone());
            targetUser.setName(sourceUser.getName());
            targetUser.setEmail(sourceUser.getEmail());
            targetUser.setPassword(sourceUser.getPassword());
            targetUser.setLevel(sourceUser.getLevel());
            targetUser.setExpired(sourceUser.getExpired());
            targetUser.setIndustry(sourceUser.getIndustry());
            targetUser.setThesaurus(sourceUser.getThesaurus());
            targetUser.setEvent(sourceUser.getEvent());
            targetUser.setIdentity(sourceUser.getIdentity());
            targetUser.setTieba(sourceUser.getTieba());
            targetUser.setSms(sourceUser.getSms());
            targetUser.setSex(sourceUser.getSex());
            targetUser.setCompany(sourceUser.getCompany());
            targetUser.setCity(sourceUser.getCity());
            targetUser.setInfo(sourceUser.getInfo());
            targetUser.setLsystemuserid(sourceUser.getLsystemuserid());
            targetUser.setProjectname(sourceUser.getProjectname());
            targetUser.setRemarksname(sourceUser.getRemarksname());
            targetUser.setLsystemuserid(sourceUser.getLsystemuserid());
            targetUser.setProreportsum(sourceUser.getProreportsum());
            targetUser.setGuidesum(sourceUser.getGuidesum());
            targetUser.setRememberToken(sourceUser.getRememberToken());
            targetUser.setEndtime(sourceUser.getEndtime());
            targetUser.setUpdatedAt(sourceUser.getUpdatedAt());
            targetUser.setCreatedAt(sourceUser.getCreatedAt());
            targetUser.setPlainPassword(sourceUser.getPlainPassword());
            targetUser.setSalt(sourceUser.getSalt());
            targetUser.setClientSource(sourceUser.getClientSource());
            targetUser.setClientName(sourceUser.getClientName());
            targetUser.setLabel(sourceUser.getLabel());
            targetUser.setRemark(sourceUser.getRemark());
            targetUser.setStep(sourceUser.getStep());
            targetUser.setIpShow(sourceUser.getIpShow());
            targetUser.setIdentityShow(sourceUser.getIdentityShow());
            targetUser.setRemark(sourceUser.getRemark());
            targetUser.setIsassessment(sourceUser.getIsassessment());
            targetUser.setUserDeviceToken(sourceUser.getUserDeviceToken());
            targetUser.setRegistrationId(sourceUser.getRegistrationId());
            targetUser.setDayNum(sourceUser.getDayNum());
            targetUser.setTotalNum(sourceUser.getTotalNum());
            targetUser.setNumTime(sourceUser.getNumTime());
            targetUser.setIsCode(sourceUser.getIsCode());
            targetUser.setIsLanguage(sourceUser.getIsLanguage());
            targetUser.setIsCountry(sourceUser.getIsCountry());
            targetUser.setAccountLevel(sourceUser.getAccountLevel());
            targetUser.setParentId(sourceUser.getParentId());
            targetUser.setAccountCount(sourceUser.getAccountCount());
            targetUser.setKeyWordCount(sourceUser.getKeyWordCount());
            targetUser.setMessageCount(sourceUser.getMessageCount());
            targetUser.setEventCount(sourceUser.getEventCount());
            targetUser.setOrderCount(sourceUser.getOrderCount());
            targetUser.setWarningVoice(sourceUser.getWarningVoice());
            targetUser.setOverseasSitesDefaultState(sourceUser.getOverseasSitesDefaultState());
            targetUserService.save(targetUser);
            cpb.show(i);
        }
        return size;
    }

    @Override
    protected Page<SourceUser> getPageList(int pageNumber) {
        return sourceUserService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}
