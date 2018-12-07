package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.source.entity.SourceUser;
import com.example.pompsynchronizationdata.source.entity.SourceUserToken;
import com.example.pompsynchronizationdata.source.service.SourceUserService;
import com.example.pompsynchronizationdata.source.service.SourceUserTokenService;
import com.example.pompsynchronizationdata.target.entity.TargetUserToken;
import com.example.pompsynchronizationdata.target.service.TargetUserTokenService;
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
 * @author zhang tong
 * date: 2018/12/7 13:50
 * description:
 */
@Component
public class UserTokenCopy extends PageHandler<SourceUserToken> {

    @Autowired
    private SourceUserTokenService sourceUserTokenService;

    @Autowired
    private TargetUserTokenService targetUserTokenService;

    @Autowired
    private SourceUserService sourceUserService;

    @Override
    protected int handleDataOfPerPage(List<SourceUserToken> list, int pageNumber) {
        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceUserToken sourceUserToken = list.get(i);
            Long sourceUserTokenUserId = sourceUserToken.getUserId();
            String sourceUserTokenPhone = sourceUserToken.getPhone();
            String sourceUserTokenRegistrationId = sourceUserToken.getRegistrationId();
            String sourceUserTokenToken = sourceUserToken.getToken();
            LocalDateTime sourceUserTokenTime = sourceUserToken.getTime();

            Optional<SourceUser> sourceUserOptional = sourceUserService.findById(sourceUserTokenUserId);
            if (sourceUserOptional.isPresent()) {
                if (StringUtils.isNotEmpty(sourceUserTokenRegistrationId)) {
                    TargetUserToken targetUserToken = new TargetUserToken();
                    targetUserToken.setUserId(sourceUserTokenUserId);
                    targetUserToken.setRegistrationId(sourceUserTokenRegistrationId);
                    targetUserToken.setToken(sourceUserTokenToken);
                    targetUserToken.setTime(sourceUserTokenTime);
                    targetUserTokenService.save(targetUserToken);
                }

            }

        }
        return size;
    }

    @Override
    protected Page<SourceUserToken> getPageList(int pageNumber) {
        return sourceUserTokenService.findPageByEntity(pageNumber, DEFAULT_BATCH_SIZE);
    }
}
