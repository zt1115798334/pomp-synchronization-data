package com.example.pompsynchronizationdata.target.entity;

import com.example.pompsynchronizationdata.base.entity.IdEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 15:47
 * description:
 */
@Data
@Entity
@Table(name = "t_abroad_socialization_set")
public class TargetAbroadSocializationSet extends IdEntity {
    /**
     * 主键
     */
    private Long id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 分组id
     */
    private Long groupId;
    /**
     * 社交类型：{
     * all：全部，twitter：Twitter facebook:Facebook
     * }
     */
    private String socialType;

    /**
     * 专题名称
     */
    private String setName;
    /**
     * 排序
     */
    private Integer orderBy;
    /**
     * 检索区域：title标题，content内容，all所有
     */
    private String searchArea;
    /**
     * 相关词
     */
    private String relatedWords;
    /**
     * 舆情词
     */
    private String opinionWords;
    /**
     * 排除词
     */
    private String exclusionWords;
    /**
     * 作者
     */
    private String author;
    /**
     * 创建时间
     */
    private LocalDateTime createdTime;
    /**
     * 删除状态：1已删除 0未删除
     */
    private Integer deleteState;


}
