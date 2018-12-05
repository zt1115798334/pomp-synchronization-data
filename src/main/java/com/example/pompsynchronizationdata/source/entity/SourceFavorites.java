package com.example.pompsynchronizationdata.source.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/04 15:59
 * description:
 */
@Data
@Entity
@Table(name = "t_favorites")
public class SourceFavorites {
    /**
     *
     */
    private Long userId;
    /**
     *
     */
    private String articleId;
    /**
     *
     */
    private LocalDateTime time;
    /**
     * 载体
     */
    private String carrie;
    /**
     * 来源：境内，境外
     */
    private String country;
    /**
     * 热度值
     */
    private Integer hot;
    /**
     * 新闻发布时间
     */
    private LocalDateTime publishTime;
    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     *
     */
    private String ossPath;


}
