package com.example.pompsynchronizationdata.es.domain;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/30 15:58
 * description: es分页类
 */
public class EsPage<T> {

    private List<T> list;

    private Long totalElements;

    public EsPage(List<T> list, Long totalElements) {
        this.list = list;
        this.totalElements = totalElements;
    }

    public List<T> getList() {
        return list;
    }

    public Long getTotalElements() {
        return totalElements;
    }
}
