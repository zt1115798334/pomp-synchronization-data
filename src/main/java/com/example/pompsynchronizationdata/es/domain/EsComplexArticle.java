package com.example.pompsynchronizationdata.es.domain;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/22 9:29
 * description: 复杂的esArticle
 */
public class EsComplexArticle extends EsArticle {


    private Long typeId;

    private Long pageTotalElements;


    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getPageTotalElements() {
        return pageTotalElements;
    }

    public void setPageTotalElements(Long pageTotalElements) {
        this.pageTotalElements = pageTotalElements;
    }
}
