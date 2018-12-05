package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:59
 * description:
 */
@Data
@Entity
@Table(name = "t_warning_rule")
public class TargetWarningRule extends IdIdentityEntity {
    /**
     *
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 预警规则标题
     */
    private String roleTitle;
    /**
     * 预警状态：1  开启 0 停用
     */
    private Integer enabledState;
    /**
     * 预警类型：0 机器预警 1 手动预警
     */
    private Integer warningType;
    /**
     * 预警等级  red 红色 ，orange 橙色，yellow黄色
     */
    private String warningLevel;
    /**
     * 全部 all ， 正面：positive, 负面：negative 中性 neutral
     */
    private String emotion;
    /**
     * 区域：0 全部1 境内 2 境外
     */
    private Integer region;
    /**
     * 载体
     */
    private String carrier;
    /**
     * 预警词
     */
    private String warningWords;
    /**
     * 排除词
     */
    private String exclusionWords;
    /**
     * 检索区域：title标题，content内容，all所有
     */
    private String searchArea;
    /**
     * 预警通知表的id数组
     */
    private String warningNoticeIds;
    /**
     * 预警通知类型：dialog弹框，email邮件 phone 短信 app
     */
    private String warningNoticeType;
    /**
     * 预警开始时间
     */
    private LocalTime startWarningTime;
    /**
     * 预警结束时间
     */
    private LocalTime endWarningTime;
    /**
     * 创建时间
     */
    private LocalDateTime createdTime;
    /**
     * 删除状态：1已删除 0未删除
     */
    private Integer deleteState;


}
