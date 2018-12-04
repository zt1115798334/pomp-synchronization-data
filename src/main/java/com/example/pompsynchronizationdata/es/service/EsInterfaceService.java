package com.example.pompsynchronizationdata.es.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/22 10:55
 * description: es接口业务层
 */
public interface EsInterfaceService {


    /**
     * 根据文章id集合查询文章集合接口 -- 不包含文章详情
     *
     * @param params 参数
     * @return
     */
    String findArticleListWithOutContent(JSONObject params);



}
