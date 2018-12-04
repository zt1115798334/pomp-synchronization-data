package com.example.pompsynchronizationdata.data;

import com.example.pompsynchronizationdata.custom.ConsoleProgressBar;
import com.example.pompsynchronizationdata.custom.SysConst;
import com.example.pompsynchronizationdata.es.domain.EsArticle;
import com.example.pompsynchronizationdata.es.service.EsArticleService;
import com.example.pompsynchronizationdata.source.entity.SourceFavorites;
import com.example.pompsynchronizationdata.source.entity.SourceWarning;
import com.example.pompsynchronizationdata.source.service.SourceFavoritesService;
import com.example.pompsynchronizationdata.target.entity.TargetFavorites;
import com.example.pompsynchronizationdata.target.service.TargetFavoritesService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/12/4 16:13
 * description:
 */
@Slf4j
@Component
public class FavoritesCopy extends PageHandler<SourceFavorites> {

    @Autowired
    private SourceFavoritesService sourceFavoritesService;

    @Autowired
    private TargetFavoritesService targetFavoritesService;

    @Autowired
    private EsArticleService esArticleService;

    @Override
    protected int handleDataOfPerPage(List<SourceFavorites> list, int pageNumber) {
        List<String> articleIdList = list.stream()
                .map(SourceFavorites::getArticleId)
                .distinct().collect(Collectors.toList());
        log.info("未删除文章Id数量为:" + articleIdList.size());
        List<EsArticle> esArticleList = esArticleService.findEsArticleListByIdsWithOutContent(articleIdList);
        log.info("查询出来de 的es文章数量为:" + esArticleList.size());

        Map<String, EsArticle> esArticleMap = esArticleList.stream()
                .collect(Collectors.toMap(EsArticle::getId, Function.identity()));

        int size = list.size();
        ConsoleProgressBar cpb = new ConsoleProgressBar(0, size, 50, '=');
        for (int i = 0; i < size; i++) {
            cpb.show(i);
            SourceFavorites sourceFavorites = list.get(i);
            String sourceFavoritesArticleId = sourceFavorites.getArticleId();
            if (esArticleMap.containsKey(sourceFavoritesArticleId)) {
                EsArticle esArticle = esArticleMap.get(sourceFavoritesArticleId);


                Long sourceFavoritesUserId = sourceFavorites.getUserId();
                LocalDateTime sourceFavoritesTime = sourceFavorites.getTime();
                String sourceFavoritesCarrie = sourceFavorites.getCarrie();
                String sourceFavoritesCountry = sourceFavorites.getCountry();
                Integer sourceFavoritesHot = sourceFavorites.getHot();
                LocalDateTime sourceFavoritesPublishTime = sourceFavorites.getPublishTime();


                TargetFavorites targetFavorites = new TargetFavorites();
                targetFavorites.setUserId(sourceFavoritesUserId);
                targetFavorites.setArticleId(sourceFavoritesArticleId);
                targetFavorites.setCreatedTime(sourceFavoritesTime);
                targetFavorites.setPublishTime(sourceFavoritesPublishTime);
                Integer carrieCode;
                if (StringUtils.isNotEmpty(sourceFavoritesCarrie)) {
                    switch (sourceFavoritesCarrie) {
                        case "综合":
                            carrieCode = SysConst.Carrie.Carrie_2000.getCode();
                            break;
                        case "新闻":
                            carrieCode = SysConst.Carrie.Carrie_2001.getCode();
                            break;
                        case "博客":
                            carrieCode = SysConst.Carrie.Carrie_2002.getCode();
                            break;
                        case "论坛":
                            carrieCode = SysConst.Carrie.Carrie_2003.getCode();
                            break;
                        case "微博":
                            carrieCode = SysConst.Carrie.Carrie_2004.getCode();
                            break;
                        case "微信":
                            carrieCode = SysConst.Carrie.Carrie_2005.getCode();
                            break;
                        case "QQ群":
                            carrieCode = SysConst.Carrie.Carrie_2006.getCode();
                            break;
                        case "电子报":
                            carrieCode = SysConst.Carrie.Carrie_2007.getCode();
                            break;
                        case "视频":
                            carrieCode = SysConst.Carrie.Carrie_2008.getCode();
                            break;
                        case "手机wap":
                            carrieCode = SysConst.Carrie.Carrie_2009.getCode();
                            break;
                        case "其他":
                            carrieCode = SysConst.Carrie.Carrie_2999.getCode();
                            break;
                        default:
                            carrieCode = esArticle.getCarrie();
                            break;
                    }
                }else{
                    carrieCode = esArticle.getCarrie();
                }
                targetFavorites.setCarrier(carrieCode);
                Integer region = SysConst.Region.REGION_INNER.getCode();
                if (StringUtils.isNotEmpty(sourceFavoritesCountry)) {
                    switch (sourceFavoritesCountry) {
                        case "境内":
                            region = SysConst.Region.REGION_INNER.getCode();
                            break;
                        case "境外":
                            region = SysConst.Region.REGION_OUTSIDE.getCode();
                            break;
                    }
                }else{
                    region = esArticle.getRegion();
                }
                targetFavorites.setRegion(region);
                targetFavorites.setEmotion(esArticle.getEmotion());
                targetFavoritesService.save(targetFavorites);
            }

        }

        return esArticleList.size();
    }

    @Override
    protected Page<SourceFavorites> getPageList(int pageNumber) {
        return sourceFavoritesService.findPageByEntity(pageNumber,DEFAULT_BATCH_SIZE);
    }
}
