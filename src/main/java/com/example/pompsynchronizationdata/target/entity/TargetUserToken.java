package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/07 13:46
 * description:
 */
@Data
@Entity
@Table(name = "t_user_token")
public class TargetUserToken extends IdIdentityEntity {

    /**
     *
     */
    private Long userId;
    /**
     * 极光推送id
     */
    private String registrationId;
    /**
     * 用户的token
     */
    private String token;
    /**
     *
     */
    private LocalDateTime time;


}
