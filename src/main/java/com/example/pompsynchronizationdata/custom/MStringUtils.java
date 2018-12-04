package com.example.pompsynchronizationdata.custom;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/11/17 13:43
 * description:
 */
public class MStringUtils {

    /**
     * @param text        字符串
     * @param matchingStr 需要匹配的字符
     * @param spanStart   匹配字符前添加的字符
     * @param spanEnd     匹配字符后添加的字符
     * @return
     */
    public static String signString(String text, String matchingStr, String spanStart, String spanEnd) {
        StringBuilder sb = new StringBuilder(text);
        Pattern pattern = Pattern.compile(matchingStr, Pattern.CASE_INSENSITIVE);
        Matcher match = pattern.matcher(text);
        int len = 0;
        while (match.find()) {
            int end = match.end();
            int start = match.start();
            sb.insert(start + len, spanStart);
            sb.insert(end + len + spanStart.length(), spanEnd);
            len += (spanStart + spanEnd).length();
        }
        return sb.toString();
    }

    /**
     * 将中文逗号转换为英文逗号
     *
     * @param text
     * @return
     */
    public static String replaceComma(String text) {
        return StringUtils.replace(text, "，", ",");
    }

    /**
     * 对包含 + * ，( ) 进行切分
     *
     * @param text
     * @return
     */
    public static List<String> splitStr(String text) {
        return Arrays.stream(text.split("\\+|\\*|,|\\(|\\)")).filter(StringUtils::isNotEmpty).collect(Collectors.toList());
    }

    /**
     * id转换为 #1#，#2#，的格式 方便模糊查询  否则会出现查询不准确的
     *
     * @param text
     * @return
     */
    public static String decorateStr(String text) {
        return Arrays.stream(text.split(",")).map(s -> "#" + s + "#").collect(Collectors.joining(","));
    }

    /**
     * id转换为 #1#，#2#，的格式 方便模糊查询  否则会出现查询不准确的
     *
     * @param text
     * @return
     */
    public static String decorateStr(List<Long> text) {
        return text.stream().map(s -> "#" + s + "#").collect(Collectors.joining(","));
    }

    /**
     * id转换为 #1#，#2#，的格式 转换为list<Long>
     *
     * @param text
     * @return
     */
    public static List<Long> decorateRecoveryStr(String text) {
        return Arrays.stream(text.replace("#", "").split(","))
                .map(Long::valueOf).collect(Collectors.toList());
    }

    /**
     * 截取字符串
     *
     * @param text        内容
     * @param splitLen    长度
     * @param replaceText 替换符号
     * @return
     */
    public static String interceptingReplacing(String text, Integer splitLen, String replaceText) {
        if (StringUtils.isNotEmpty(text)) {
            return text.length() > splitLen ? StringUtils.substring(text, 0, splitLen) + replaceText : text;
        } else {
            return "";
        }
    }

    /**
     * 请求参数格式转换 aop 接口使用
     *
     * @param parameterNames
     * @param parameterValues
     * @return
     */
    public static String parseParams(String[] parameterNames, Object[] parameterValues) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("[");
        int length = parameterNames.length;
        for (int i = 0; i < length; i++) {
            String parameterName = parameterNames[i];
            Object parameterValueObj = parameterValues[i];
            Class<?> parameterValueClazz = parameterValueObj.getClass();
            String parameterValue;
            if (parameterValueClazz.isPrimitive() ||
                    parameterValueClazz == String.class) {
                parameterValue = parameterValueObj.toString();
            } else if (parameterValueObj instanceof Serializable) {
                parameterValue = JSON.toJSONString(parameterValueObj);
            } else {
                parameterValue = parameterValueObj.toString();
            }
            stringBuffer.append(parameterName).append(":").append(parameterValue).append(" ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /**
     * 拼接邮件内容
     *
     * @param title           标题
     * @param siteName        站点名称
     * @param publishTime     发布时间
     * @param url             url
     * @param officialNetwork 官网地址
     * @param webName         官网名称
     * @return
     */
    public static String splicingEmailText(String title, String siteName, String publishTime, String url,
                                           String officialNetwork, String webName) {
        StringBuffer stringBuffer = new StringBuffer();
        webName = StringUtils.isNotEmpty(webName) ? webName : "未知站点";
        stringBuffer.append("标题：").append(title).append("<br>")
                .append("来源：").append(siteName).append("<br>")
                .append("发布时间：").append(publishTime).append("<br>")
                .append("文章链接：").append("<a target='_blank' href='").append(url).append("'>").append(url).append("</a>")
                .append("<br>").append("<br>").append("<br><a href='").append(officialNetwork)
                .append("' target='_blank'>【").append(webName).append("】<a>");
        return stringBuffer.toString();
    }

    /**
     * 拼接短信内容
     *
     * @param publishTime 发布时间
     * @param url         url
     * @param webName     官网名称
     * @return
     */
    public static String splicingShortMessage(String publishTime, String url, String webName) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("【").append(webName).append("】").append(publishTime).append("监测到一条预警信息，请及时关注，文章链接").append(url);
        return stringBuffer.toString();
    }

    /**
     * 正则提取url中的主域名
     *
     * @param url
     * @return
     */
    public static String getUrlMain(String url) {
        Pattern urlMainPattern = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");
        Matcher m = urlMainPattern.matcher(url);
        String urlMain = "";
        if (m.find()) {
            urlMain = m.group();
        } else {
            urlMain = "default.com";
        }
        return urlMain;
    }

    /**
     * 截取http 或者https
     * @param url
     * @return
     */
    public static String urlInterceptHttp(String url) {
        if (url.startsWith("http://")) {
            url = url.substring(7);
        }
        if (url.startsWith("https://")) {
            url = url.substring(8);
        }
        return url;
    }

    public static void main(String[] args) {
        String str = "(小米*魅族)+华为,苹果";
        MStringUtils.splitStr(str).stream().forEach(System.out::println);
    }
}
