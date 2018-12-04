package com.example.pompsynchronizationdata.es.service;

import com.example.pompsynchronizationdata.es.domain.EsArticle;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/20 11:24
 * description: es文章查询的业务层
 */
public interface EsArticleService {

    /**
     * 根据文章id集合获取文章列表 -- 不包含文章详情
     *
     * @param articleIds 文章id集合
     * @return
     */
    List<EsArticle> findEsArticleListByIdsWithOutContent(List<String> articleIds);


}
