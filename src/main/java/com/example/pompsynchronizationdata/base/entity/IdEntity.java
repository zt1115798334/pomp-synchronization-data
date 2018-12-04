package com.example.pompsynchronizationdata.base.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/9 10:04
 * description:统一定义id的entity基类.
 * *
 * * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * * Oracle需要每个Entity独立定义id的SEQUCENCE时，不继承于本类而改为实现一个Idable的接口。
 */
// JPA 基类的标识
@MappedSuperclass
@Data
public abstract class IdEntity implements Serializable {

    @Id
    protected Long id;
    /**
     * 页数
     */
    @Transient
    protected int pageNumber = 1;

    /**
     * 每页显示数量
     */
    @Transient
    protected int pageSize = 10;

}
