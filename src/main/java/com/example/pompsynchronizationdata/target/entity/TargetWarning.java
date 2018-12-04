package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 11:06
 * description:
 */
@Data
@Entity
@Table(name = "t_warning")
public class TargetWarning extends IdIdentityEntity {

    /**
     * 文章id
     */
    private String articleId;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 预警规则Id
     */
    private Long warningRuleId;
    /**
     * 文章发布时间
     */
    private LocalDateTime publishTime;
    /**
     * 载体
     */
    private Integer carrier;
    /**
     * 区域：1 境内 2 境外
     */
    private Integer region;
    /**
     * 情感 正面：positive, 负面：negative 中性 neutral
     */
    private String emotion;
    /**
     * 预警类型：0 机器预警 1 手动预警
     */
    private Integer warningType;
    /**
     * 预警日期
     */
    private LocalDate warningDate;
    /**
     * 预警时间
     */
    private LocalDateTime warningTime;
    /**
     * 预警等级  red 红色 ，orange 橙色，yellow黄色
     */
    private String warningLevel;
    /**
     * 读取状态：0未读，1已读
     */
    private Integer readState;
    /**
     * 短信发送状态 0 未发送 1 已发送
     */
    private Integer sendPhoneState;
    /**
     * 短信发送时间
     */
    private LocalDateTime sendPhoneTime;
    /**
     * 邮件发送状态 0 未发送 1 已发送
     */
    private Integer sendEmailState;
    /**
     * 邮件发送时间
     */
    private LocalDateTime sendEmailTime;


}
