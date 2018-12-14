package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.source.entity.SourceUser;
import com.example.pompsynchronizationdata.source.service.SourceUserService;
import com.example.pompsynchronizationdata.target.entity.TargetUser;
import com.example.pompsynchronizationdata.target.entity.TargetUserConfig;
import com.example.pompsynchronizationdata.target.service.TargetUserConfigService;
import com.example.pompsynchronizationdata.target.service.TargetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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

    @Autowired
    private TargetUserConfigService targetUserConfigService;

    @Override
    protected int handleDataOfPerPage(List<SourceUser> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 20, '=');
        for (int i = 0; i < size; i++) {
            SourceUser sourceUser = list.get(i);
            Long sourceUserId = sourceUser.getId();
            String sourceUserPhone = sourceUser.getPhone();
            String sourceUserName = sourceUser.getName();
            String sourceUserEmail = sourceUser.getEmail();
            String sourceUserPassword = sourceUser.getPassword();
            Integer sourceUserLevel = sourceUser.getLevel();
            Integer sourceUserExpired = sourceUser.getExpired();
            Integer sourceUserIndustry = sourceUser.getIndustry();
            Integer sourceUserThesaurus = sourceUser.getThesaurus();
            Integer sourceUserEvent = sourceUser.getEvent();
            Integer sourceUserIdentity = sourceUser.getIdentity();
            Integer sourceUserTieba = sourceUser.getTieba();
            Integer sourceUserSms = sourceUser.getSms();
            Integer sourceUserSex = sourceUser.getSex();
            String sourceUserCompany = sourceUser.getCompany();
            String sourceUserCity = sourceUser.getCity();
            Integer sourceUserInfo = sourceUser.getInfo();
            Long sourceUserLsystemuserid = sourceUser.getLsystemuserid();
            String sourceUserProjectname = sourceUser.getProjectname();
            String sourceUserRemarksname = sourceUser.getRemarksname();
            Long sourceUserLsyspackageid = sourceUser.getLsyspackageid();
            Integer sourceUserProreportsum = sourceUser.getProreportsum();
            Integer sourceUserGuidesum = sourceUser.getGuidesum();
            String sourceUserRememberToken = sourceUser.getRememberToken();
            LocalDateTime sourceUserEndtime = sourceUser.getEndtime();
            LocalDateTime sourceUserUpdatedAt = sourceUser.getUpdatedAt();
            LocalDateTime sourceUserCreatedAt = sourceUser.getCreatedAt();
            String sourceUserPlainPassword = sourceUser.getPlainPassword();
            String sourceUserSalt = sourceUser.getSalt();
            Integer sourceUserClientSource = sourceUser.getClientSource();
            String sourceUserClientName = sourceUser.getClientName();
            Integer sourceUserLabel = sourceUser.getLabel();
            String sourceUserRemark = sourceUser.getRemark();
            String sourceUserStep = sourceUser.getStep();
            Integer sourceUserIpShow = sourceUser.getIpShow();
            Integer sourceUserIdentityShow = sourceUser.getIdentityShow();
            String sourceUserRemark1 = sourceUser.getRemark1();
            Integer sourceUserIsassessment = sourceUser.getIsassessment();
            String sourceUserUserDeviceToken = sourceUser.getUserDeviceToken();
            String sourceUserRegistrationId = sourceUser.getRegistrationId();
            Integer sourceUserDayNum = sourceUser.getDayNum();
            Integer sourceUserTotalNum = sourceUser.getTotalNum();
            LocalDateTime sourceUserNumTime = sourceUser.getNumTime();
            Integer sourceUserIsCode = sourceUser.getIsCode();
            Integer sourceUserIsLanguage = sourceUser.getIsLanguage();
            Integer sourceUserIsCountry = sourceUser.getIsCountry();
            Integer sourceUserAccountLevel = sourceUser.getAccountLevel();
            Long sourceUserParentId = sourceUser.getParentId();
            Integer sourceUserAccountCount = sourceUser.getAccountCount();
            Integer sourceUserKeyWordCount = sourceUser.getKeyWordCount();
            Integer sourceUserMessageCount = sourceUser.getMessageCount();
            Integer sourceUserEventCount = sourceUser.getEventCount();
            Integer sourceUserOrderCount = sourceUser.getOrderCount();
            String sourceUserWarningVoice = sourceUser.getWarningVoice();
            Integer sourceUserOverseasSitesDefaultState = sourceUser.getOverseasSitesDefaultState();

            Integer sex = SysConst.Sex.Unknown.getCode();
            if (sourceUserSex == 1) {//男
                sex = SysConst.Sex.MEN.getCode();
            }
            if (sourceUserSex == 2) {//女
                sex = SysConst.Sex.WOMEN.getCode();
            }
            Integer expireState = SysConst.ExpireState.UNEXPIRED.getCode();
            if (sourceUserExpired == 0) {    //未禁用
                expireState = SysConst.ExpireState.UNEXPIRED.getCode();
            }
            if (sourceUserExpired == 1) {    //禁用
                expireState = SysConst.ExpireState.EXPIRE.getCode();
            }
            Integer accountLevel = SysConst.AccountLevel.ONE_LEVEL.getCode();
            if (sourceUserAccountLevel == 1) {
                accountLevel = SysConst.AccountLevel.ONE_LEVEL.getCode();
            }
            if (sourceUserAccountLevel == 2) {
                accountLevel = SysConst.AccountLevel.TWO_LEVEL.getCode();
            }
            Integer accountState = SysConst.AccountState.Frozen.getCode();

            if (sourceUserLevel == 0) { //冻结
                accountState = SysConst.AccountState.Frozen.getCode();
            }
            if (sourceUserLevel == 1) { //免费
                accountState = SysConst.AccountState.FREE.getCode();
            }
            if (sourceUserLevel == 2) { //试用
                accountState = SysConst.AccountState.PROBATIONER.getCode();
            }
            if (sourceUserLevel == 3) { //正式
                accountState = SysConst.AccountState.CEREMONIAL.getCode();
            }
            TargetUser targetUser = new TargetUser();
            targetUser.setId(sourceUserId);
            targetUser.setAccount(sourceUserPhone);
            targetUser.setPassword(sourceUserPassword);
            targetUser.setPhone(sourceUserPhone);
            targetUser.setEmail(sourceUserEmail);
            targetUser.setAccountState(accountState);
            targetUser.setAccountLevel(accountLevel);
            targetUser.setExpireDate(sourceUserEndtime.toLocalDate());
            targetUser.setExpireState(expireState);
            targetUser.setSex(sex);
            targetUser.setCompany(sourceUserCompany);
            targetUser.setCity(sourceUserCity);
            targetUser.setOperationUserIdL(sourceUserLsystemuserid);
            targetUser.setProjectName(sourceUserProjectname);
            targetUser.setProjectAlias(sourceUserRemarksname);
            targetUser.setParentId(sourceUserParentId);
            targetUser.setCreatedTime(sourceUserEndtime);
            targetUser.setUpdatedTime(DateUtils.currentDateTime());
            targetUser.setLastLoginTime(DateUtils.currentDateTime());
            targetUser.setDeleteState(SysConst.DeleteState.UN_DELETED.getCode());


            targetUserService.save(targetUser);

            TargetUserConfig userConfig = new TargetUserConfig();
            userConfig.setUserId(sourceUserId);
            userConfig.setWarningAppState(SysConst.EnabledState.ON.getCode());
            userConfig.setIndexChartSourceSpecialId(SysConst.INDEX_CHART_SOURCE_ALL);
            userConfig.setAbroadWebsiteDefaultShowState(SysConst.ShowState.DISPLAY.getCode());
            userConfig.setSpecialReportCount(sourceUserProreportsum);
            userConfig.setEventCount(sourceUserEvent);
            userConfig.setSubAccountCount(sourceUserAccountCount);
            userConfig.setOrderAppCount(sourceUserOrderCount);
            userConfig.setSmsCount(sourceUserSms);
            targetUserConfigService.save(userConfig);

            cpb.show(i);
        }
        return size;
    }

    @Override
    protected Page<SourceUser> getPageList(int pageNumber) {
        return sourceUserService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}
