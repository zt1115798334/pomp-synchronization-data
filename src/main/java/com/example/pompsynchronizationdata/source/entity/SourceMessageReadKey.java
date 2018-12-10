package com.example.pompsynchronizationdata.source.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/10 14:47
 * description:
 */
@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SourceMessageReadKey implements java.io.Serializable {
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 消息ID
     */
    private Long messageId;
}
