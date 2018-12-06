package com.example.pompsynchronizationdata.source.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/6 14:09
 * description:
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SourceBriefingArticleKey implements java.io.Serializable {

    /**
     *
     */
    private Long briefingId;
    /**
     * 文章ID
     */
    private String articleId;
}
