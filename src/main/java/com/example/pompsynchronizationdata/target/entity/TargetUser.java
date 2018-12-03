package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdPageEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/11/30 16:11
 * description:
 */
@Data
@Entity
@Table(name = "t_users")
public class TargetUser extends IdPageEntity {
    /**
     *
     */
    private Long id;
    /**
     * 手机
     */
    private String phone;
    /**
     * 姓名
     */
    private String name;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 密码
     */
    private String password;
    /**
     * 等级(0:冻结;1:免费用户;2:试用用户;3正式会员;4到期)
     */
    private Integer level;
    /**
     * 到期（0未到期1到期）
     */
    private Integer expired;
    /**
     * 行业
     */
    private Integer industry;
    /**
     * 词数量
     */
    private Integer thesaurus;
    /**
     * 事件数量
     */
    private Integer event;
    /**
     * 身份查询数量
     */
    private Integer identity;
    /**
     * 贴吧查询数量
     */
    private Integer tieba;
    /**
     * 短信次数
     */
    private Integer sms;
    /**
     * 性别:0未设置;1男;2女
     */
    private Integer sex;
    /**
     * 单位
     */
    private String company;
    /**
     * 城市,地域
     */
    private String city;
    /**
     * 认证状态:0未提交;1审核通过;2审核未通过;3未审核
     */
    private Integer info;
    /**
     * 维护人id
     */
    private Long lsystemuserid;
    /**
     * 项目名称
     */
    private String projectname;
    /**
     * 项目别名
     */
    private String remarksname;
    /**
     * 套餐id
     */
    private Long lsyspackageid;
    /**
     * 专报数量
     */
    private Integer proreportsum;
    /**
     * 导控数量
     */
    private Integer guidesum;
    /**
     *
     */
    private String rememberToken;
    /**
     * 项目结束时间
     */
    private LocalDateTime endtime;
    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;
    /**
     * 注册时间
     */
    private LocalDateTime createdAt;
    /**
     *
     */
    private String plainPassword;
    /**
     *
     */
    private String salt;
    /**
     * 客户来源:0网络1渠道2销售
     */
    private Integer clientSource;
    /**
     * 客户来源名称
     */
    private String clientName;
    /**
     * 客户标签：0一般1优质2可以
     */
    private Integer label;
    /**
     *
     */
    private String remark;
    /**
     *
     */
    private String step;
    /**
     * 是否显示贴吧查询0不显示；1显示
     */
    private Integer ipShow;
    /**
     * 是否显示身份查询0不显示；1显示
     */
    private Integer identityShow;
    /**
     *
     */
    private String remark1;
    /**
     * 是否研判
     */
    private Integer isassessment;
    /**
     *
     */
    private String userDeviceToken;
    /**
     * 极光推送 用户设备标识id
     */
    private String registrationId;
    /**
     * 每天查询次数
     */
    private Integer dayNum;
    /**
     * 每天总查询次数
     */
    private Integer totalNum;
    /**
     * 记录时间
     */
    private LocalDateTime numTime;
    /**
     * 是否开启验证1开启0不开启
     */
    private Integer isCode;
    /**
     * 多语言开启
     */
    private Integer isLanguage;
    /**
     * 境外开启
     */
    private Integer isCountry;
    /**
     * 用户等级
     */
    private Integer accountLevel;
    /**
     * 父级id
     */
    private Long parentId;
    /**
     * 子账号数量
     */
    private Integer accountCount;
    /**
     * 关键词数量
     */
    private Integer keyWordCount;
    /**
     * 短信数量
     */
    private Integer messageCount;
    /**
     * 事件数量
     */
    private Integer eventCount;
    /**
     * 订购应用数量
     */
    private Integer orderCount;
    /**
     * 预警提示开关 on, off
     */
    private String warningVoice;
    /**
     * 显示状态 0 不可见，1可见
     */
    private Integer overseasSitesDefaultState;


}
