package com.example.pompsynchronizationdata.custom;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/9/10 15:45
 * description: es相关工具类
 */
public class EsUtils {

    protected static final Logger log = LoggerFactory.getLogger(EsUtils.class);


    public static JSONArray getJSONArrayEsResult(String str) {
        JSONArray result = new JSONArray();
        if (StringUtils.isNotEmpty(str)) {
            JSONObject jo = JSON.parseObject(str);
            if (Objects.equal("0", jo.getString("code"))) {
                if (jo.containsKey("result") && jo.getJSONArray("result") != null) {
                    result = jo.getJSONArray("result");
                }
            } else {
                log.info("result:{}", jo.toJSONString());
            }
        }
        return result;
    }

    public static JSONObject getJSONObjectEsResult(String str) {
        JSONObject result = null;
        if (StringUtils.isNotEmpty(str)) {
            JSONObject jo = JSON.parseObject(str);
            if (Objects.equal("0", jo.getString("code"))) {
                if (jo.containsKey("result")) {
                    result = jo.getJSONObject("result");
                }
            } else {
                log.info("result:{}", jo.toJSONString());
            }
        }
        return result;
    }

    /**
     * 处理统一参数
     * @param searchArea     搜索位置 关键词的位置
     * @param emotion        情感
     * @param carrier        载体
     * @param relatedWords   相关词
     * @param opinionWords   舆情词
     * @param exclusionWords 排除词
     * @param siteUrl        站点
     * @param author         作者
     * @return
     */
    public static JSONObject getQueryParams(String searchArea, String emotion, String carrier,
                                            String relatedWords, String opinionWords, String exclusionWords,
                                            String siteUrl, String author) {
        JSONObject csJo = new JSONObject();

        if (StringUtils.isNotEmpty(searchArea)) {
            csJo.put("relatedArea", searchArea); //关键词的位置
        } else {
            csJo.put("relatedArea", SysConst.SearchArea.ALL.getType());
        }
        if (!Objects.equal(emotion, SysConst.Emotion.ALL.getType())) {
            csJo.put("nature", emotion);
        }
        if (StringUtils.isNotEmpty(carrier)) {
            csJo.put("carrie", carrier.split(","));
        } else {
            csJo.put("carrie", SysConst.CarrieList.Carrie_ALL.getCode());
        }

        List<String> relatedWordsList = Lists.newArrayList();
        relatedWordsList.addAll(Arrays.asList(relatedWords.split(",")));
        csJo.put("relatedWords", relatedWordsList);
        if (StringUtils.isNotEmpty(opinionWords)) {
            csJo.put("opinionWords", opinionWords.split(","));
        }
        if (StringUtils.isNotEmpty(exclusionWords)) {
            csJo.put("unrelated", exclusionWords.split(","));
        }
        if (StringUtils.isNotEmpty(siteUrl)) {
            List<String> collect = Arrays.stream(siteUrl.split(","))
                    .map(MStringUtils::urlInterceptHttp)    //截取http 或者https
                    .collect(Collectors.toList());
            csJo.put("urlMain", collect);
        }
        if (StringUtils.isNotEmpty(author)) {
            csJo.put("author", author.split(","));
        }
        return csJo;
    }

    /**
     * 处理报告统一参数
     * @param params
     * @param briefing
     */

}
