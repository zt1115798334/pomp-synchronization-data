package com.example.pompsynchronizationdata.es.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.pompsynchronizationdata.custom.DateUtils;
import com.example.pompsynchronizationdata.custom.EsUtils;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.es.domain.EsArticle;
import com.example.pompsynchronizationdata.es.domain.EsComplexArticle;
import com.example.pompsynchronizationdata.es.domain.EsPage;
import com.example.pompsynchronizationdata.es.service.EsArticleService;
import com.example.pompsynchronizationdata.es.service.EsInterfaceService;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/20 11:31
 * description:
 */
@Service
public class EsArticleServiceImpl implements EsArticleService {

    protected final Logger log = LoggerFactory.getLogger(EsArticleService.class);

    @Autowired
    private EsInterfaceService esInterfaceService;

    private EsArticle jsonObjToArticle(JSONObject jsonObj) {
        EsArticle esArticle = new EsArticle();
        esArticle.setId(jsonObj.getString("id"));
        esArticle.setRelId(jsonObj.getString("relId"));
        esArticle.setRegion(jsonObj.getInteger("country"));
        esArticle.setCarrie(jsonObj.getInteger("carrie"));
        esArticle.setSiteName(jsonObj.getString("siteName"));
        esArticle.setCreateTime(DateUtils.parseDateTimeUTC(jsonObj.getString("createTime")));
        esArticle.setGatherTime(DateUtils.parseDateTimeUTC(jsonObj.getString("gatherTime")));
        esArticle.setPublishTime(DateUtils.parseDateTimeUTC(jsonObj.getString("publishTime")));
        esArticle.setUrlMain(jsonObj.getString("urlMain"));
        esArticle.setUrl(jsonObj.getString("url"));
        esArticle.setAuthor(jsonObj.getString("author"));
        esArticle.setFrom(jsonObj.getString("from"));
        esArticle.setView(jsonObj.getLong("view"));
        esArticle.setComment(jsonObj.getLong("comment"));
        esArticle.setIsRelated(jsonObj.getInteger("isrelated"));
        esArticle.setIsOpinion(jsonObj.getInteger("isyuqing"));

        String emotion = "";
        Integer isNegative = jsonObj.getInteger("isnegative"); //负面
        Integer isNeutral = jsonObj.getInteger("isneutral");  //中性
        Integer isPositive = jsonObj.getInteger("ispositive");    //正面
        if (isNegative == 1 && isNeutral == 0 && isPositive == 0) {
            emotion = SysConst.Emotion.NEGATIVE.getType();
        }
        if (isNegative == 0 && isNeutral == 1 && isPositive == 0) {
            emotion = SysConst.Emotion.NEUTRAL.getType();
        }
        if (isNegative == 0 && isNeutral == 0 && isPositive == 1) {
            emotion = SysConst.Emotion.POSITIVE.getType();
        }

        esArticle.setEmotion(emotion);


        esArticle.setOssPath(jsonObj.getString("ossPath"));
        esArticle.setTitle(jsonObj.getString("title"));
        esArticle.setCleanTitle(jsonObj.getString("cleanTitle"));
        esArticle.setContentWords(jsonObj.getLong("contentWords"));
        esArticle.setSummary(jsonObj.getString("summary"));
        esArticle.setContent(jsonObj.getString("content"));
        esArticle.setReadUserIds(jsonObj.getJSONArray("readUsers"));
        esArticle.setUnRelatedUserIds(jsonObj.getJSONArray("readUsers")); // TODO: 2018/11/1 需要调整
        return esArticle;
    }

    private List<EsArticle> jsonToArticleList(String str) {
        JSONArray jsonArray = EsUtils.getJSONArrayEsResult(str);
        return jsonArray.stream()
                .map(obj -> JSON.parseObject(JSONObject.toJSONString(obj)))
                .map(this::jsonObjToArticle).collect(Collectors.toList());
    }

    @Override
    public List<EsArticle> findEsArticleListByIdsWithOutContent(List<String> articleIds) {
        JSONObject params = new JSONObject();
        params.put("ids", articleIds);
        String str = esInterfaceService.findArticleListWithOutContent(params);
        return jsonToArticleList(str);
    }

    
}
