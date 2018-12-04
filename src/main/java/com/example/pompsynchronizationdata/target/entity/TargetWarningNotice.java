package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdPageEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/03 15:07
 * description:
 */
@Data
@Entity
@Table(name = "t_warning_notice")
public class TargetWarningNotice extends IdPageEntity {

    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 接收人姓名
     */
    private String noticeUsername;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机号
     */
    private String phone;


}
