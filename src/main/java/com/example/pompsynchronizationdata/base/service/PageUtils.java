package com.example.pompsynchronizationdata.base.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/9 11:50
 * description:
 */
public class PageUtils {
    /**
     * @param page      当前页
     * @param size      每页条数
     * @param sortName  排序字段
     * @param sortOrder 排序方向
     */
    public static PageRequest buildPageRequest(int page, int size, String sortName, String sortOrder) {
        Sort sort = null;
        if (!StringUtils.isNotBlank(sortName)) {
            return PageRequest.of(page - 1, size);
        } else if (StringUtils.isNotBlank(sortOrder)) {
            if (StringUtils.equalsIgnoreCase(sortOrder, Sort.Direction.ASC.toString())) {
                sort = new Sort(Sort.Direction.ASC, sortName);
            } else {
                sort = new Sort(Sort.Direction.DESC, sortName);
            }
            return PageRequest.of(page - 1, size, sort);
        } else {
            sort = new Sort(Sort.Direction.ASC, sortName);
            return PageRequest.of(page - 1, size, sort);
        }
    }

    public static PageRequest buildPageRequest(int page, int size, String sortName) {
        return buildPageRequest(page, size, sortName, null);
    }
    public static PageRequest buildPageRequest(int page, int size) {
        return buildPageRequest(page, size, null, null);
    }

    public static PageRequest buildPageRequest(int page, int size, Sort sort) {
        return PageRequest.of(page - 1, size, sort);
    }
}
