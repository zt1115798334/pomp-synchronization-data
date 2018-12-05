package com.example.pompsynchronizationdata.source.entity;

import com.example.pompsynchronizationdata.base.entity.IdIdentityEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/05 15:39
 * description:
 */
@Data
@Entity
@Table(name = "t_event")
public class SourceEvent extends IdIdentityEntity {

    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 舆情事件名称
     */
    private String title;
    /**
     * 词 用 , 分开
     */
    private String word;
    /**
     * 舆情词
     */
    private String yuqingWord;
    /**
     * 屏蔽词
     */
    private String excludeWord;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     *
     */
    private LocalDateTime time;
    /**
     * 词库事件id
     */
    private Long eventId;
    /**
     * 是否置顶：0不置顶，1置顶
     */
    private Integer isTop;
    /**
     * 置顶时间
     */
    private LocalDateTime topTime;
    /**
     * 0未删除，1已删除
     */
    private Integer isDelete;
    /**
     *
     */
    private Integer appShowAs;
    /**
     *
     */
    private Integer appTopShowAs;


}
