package com.example.pompsynchronizationdata.es.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.pompsynchronizationdata.custom.EsConfig;
import com.example.pompsynchronizationdata.custom.EsUrlConstants;
import com.example.pompsynchronizationdata.custom.HttpClientUtils;
import com.example.pompsynchronizationdata.custom.MD5Utils;
import com.example.pompsynchronizationdata.es.service.EsInterfaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/8/22 10:55
 * description:
 */
@Service
public class EsInterfaceServiceImpl implements EsInterfaceService {

    @Autowired
    private EsConfig esConfig;

    private StringBuffer splicingEsUrl(String url) {
        String key = esConfig.getKey();
        String host = esConfig.getHost();
        String appId = esConfig.getAppId();
        long time = System.currentTimeMillis() / 1000;// 秒
        String token = MD5Utils.generateToken(key, time);
        StringBuffer restUrl = new StringBuffer();
        restUrl.append(host).append(url).append("?call_id=").append(time).append("&token=").append(token).append("&appid=").append(appId);
        return restUrl;
    }

    private String splicingEsUrl(String url, int pageNumber, int pageSize) {
        return splicingEsUrl(url).append("&page_no=").append(pageNumber).append("&page_size=").append(pageSize).toString();
    }


    @Override
    public String findArticleListWithOutContent(JSONObject params) {
        String url = splicingEsUrl(EsUrlConstants.URL_QUERY_BY_IDS_WITH_OUT_CONTENT).toString();
        return HttpClientUtils.getInstance().httpPostJson(url, params.getInnerMap());
    }



}
