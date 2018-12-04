package com.example.pompsynchronizationdata.custom;

import com.example.pompsynchronizationdata.base.entity.IdPageEntity;
import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2018/7/16 9:48
 * description:时间工具类
 */
public class DateUtils {
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_FORMAT_1 = "MM/dd";
    public static final String DATE_FORMAT_2 = "MMdd";
    public static final String DATE_FORMAT_3 = "yyyyMMdd";

    public static final String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMAT_1 = "MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_2 = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMAT_3 = "yyyy-MM-dd HH";
    public static final String DATE_TIME_FORMAT_4 = "yyyyMMddHHmmss";

    public static final String GREENWICH_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_TIME_CS = "yyyy年MM月dd日 HH:mm:ss";

    public static final String TIME_FORMAT = "HH:mm";
    public static final String TIME_FORMAT_1 = "HH:mm:ss";

    /**
     * 获取最新日期
     *
     * @return
     */
    public static LocalDate currentDate() {
        return LocalDate.now();
    }

    /**
     * 获取最新时间
     *
     * @return
     */
    public static LocalDateTime currentDateTime() {
        return LocalDateTime.now();
    }

    public static Date localDateTimeToDate(LocalDateTime dateTime) {
        ZoneId zoneId = ZoneId.systemDefault();
        ZonedDateTime zdt = dateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 时间格式字符串转换为时间
     *
     * @param dateTime
     * @param dateFormat
     * @return
     */
    public static LocalDate parseDate(String dateTime, String dateFormat) {
        LocalDate result = null;
        if (StringUtils.isNotEmpty(dateTime)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = LocalDate.parse(dateTime, formatter);
        }
        return result;
    }

    /**
     * utf时间格式字符串转换为时间
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime parseDateTimeUTC(String dateTime) {
        return parseDateTime(dateTime, GREENWICH_DATE_FORMAT);
    }

    /**
     * 时间格式字符串转换为时间
     *
     * @param dateTime
     * @param dateFormat
     * @return
     */
    public static LocalDateTime parseDateTime(String dateTime, String dateFormat) {
        LocalDateTime result = null;
        if (StringUtils.isNotEmpty(dateTime)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = LocalDateTime.parse(dateTime, formatter);
        }
        return result;
    }

    /**
     * 格式化时间为 yyyy-MM-dd 格式
     *
     * @param dateTime
     * @return
     */
    public static String formatDate(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return formatDateTime(dateTime, DATE_FORMAT);
    }

    /**
     * 格式化时间为 yyyy-MM-dd HH:mm:ss 格式
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTime(LocalDateTime dateTime) {
        if (dateTime == null) {
            return null;
        }
        return formatDateTime(dateTime, DATE_TIME_FORMAT);
    }

    /**
     * 格式化时间
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDate(LocalDate date, String dateFormat) {
        String result = null;
        if (date != null && StringUtils.isNotEmpty(dateFormat)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = formatter.format(date);
        }
        return result;
    }
    /**
     * 格式化时间
     *
     * @param dateTime
     * @param dateFormat
     * @return
     */
    public static String formatDateTime(LocalDateTime dateTime, String dateFormat) {
        String result = null;
        if (dateTime != null && StringUtils.isNotEmpty(dateFormat)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
            result = formatter.format(dateTime);
        }
        return result;
    }

    /**
     * 最新时间 + 分钟
     *
     * @param hour
     * @return
     */
    public static LocalDateTime currentDateTimeAddMinute(int hour) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime result = currentDateTime.plusMinutes(hour);
        return result;
    }

    /**
     * 最新时间 + 小时
     *
     * @param hour
     * @return
     */
    public static LocalDateTime currentDateTimeAddHour(int hour) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime result = currentDateTime.plusHours(hour);
        return result;
    }

    /**
     * 最新时间 + 天
     *
     * @param day
     * @return
     */
    public static LocalDateTime currentDateTimeAddDay(long day) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        LocalDateTime result = currentDateTime.plusDays(day);
        return result;
    }

    /**
     * 最新日期 + 月
     *
     * @param month
     * @return
     */
    public static LocalDate currentDateAddMonth(int month) {
        LocalDate currentDateTime = LocalDate.now();
        return currentDateTime.plusMonths(month);
    }

    /**
     * 最新时间 + 月
     *
     * @param month
     * @return
     */
    public static LocalDateTime currentDateTimeAddMonth(int month) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return currentDateTime.plusMonths(month);
    }

    /**
     * 指定时间 + 小时
     *
     * @param dateTime
     * @param hour
     * @return
     */
    public static LocalDateTime dateTimeAddHour(LocalDateTime dateTime, int hour) {
        LocalDateTime result = dateTime.plusHours(hour);
        return result;
    }

    /**
     * 指定时间 + 天
     *
     * @param dateTime
     * @param day
     * @return
     */
    public static LocalDateTime dateTimeAddDay(LocalDateTime dateTime, int day) {
        LocalDateTime result = dateTime.plusDays(day);
        return result;
    }

    /**
     * 获当天日期零点开始时间
     *
     * @return
     */
    public static LocalDateTime currentdateTimeToFirstTime() {
        return dateTimeToFirstTime(currentDateTime());
    }

    /**
     * 获当天日期零点开始时间
     *
     * @return
     */
    public static LocalDateTime currentdateTimeToLastTime() {
        return dateTimeToLastTime(currentDateTime());
    }

    /**
     * 获取指定日期零点开始时间
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime dateTimeToFirstTime(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atTime(LocalTime.MIN);
    }

    /**
     * 获取指定日期午夜结束时间
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime dateTimeToLastTime(LocalDateTime dateTime) {
        return dateTime.toLocalDate().atTime(LocalTime.MAX);
    }

    /**
     * 获取指定日期月初日期
     *
     * @param date
     * @return
     */
    public static LocalDate dateToMonthFirstDay(LocalDate date) {
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * 获取指定日期月初零点开始时间
     *
     * @param date
     * @return
     */
    public static LocalDateTime dateTimeToMonthFirstDay(LocalDate date) {
        return LocalDateTime.of(date.with(TemporalAdjusters.firstDayOfMonth()), LocalTime.MIN);
    }

    /**
     * 获取指定日期月初零点开始时间
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime dateTimeToMonthFirstDay(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.firstDayOfMonth()).with(LocalTime.MIN);
    }

    /**
     * 获取指定日期月末日期
     *
     * @param date
     * @return
     */
    public static LocalDate dateToMonthLastDay(LocalDate date) {
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * 获取指定日期月末午夜结束时间
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime dateTimeToMonthLastDay(LocalDate dateTime) {
        return LocalDateTime.of(dateTime.with(TemporalAdjusters.lastDayOfMonth()), LocalTime.MAX);
    }

    /**
     * 获取指定日期月末午夜结束时间
     *
     * @param dateTime
     * @return
     */
    public static LocalDateTime dateTimeToMonthLastDay(LocalDateTime dateTime) {
        return dateTime.with(TemporalAdjusters.lastDayOfMonth()).with(LocalTime.MAX);
    }

    /**
     * 判断 时间是否在日期之内
     *
     * @param startDateTime 开始时间
     * @param endDateTime   结束时间
     * @param dateTime      需要判断的时间
     * @return
     */
    public static boolean intervalTime(LocalDateTime startDateTime, LocalDateTime endDateTime, LocalDateTime dateTime) {
        return dateTime.isAfter(startDateTime) && dateTime.isBefore(endDateTime);
    }





    public static void main(String[] args) {
        LocalDate currentDate = DateUtils.currentDate();
        LocalDate localDate = LocalDate.of(currentDate.getYear(), 9, 1);
        LocalDateTime startTime = DateUtils.dateTimeToMonthFirstDay(localDate);
        LocalDateTime endTime = DateUtils.dateTimeToMonthLastDay(localDate);
        System.out.println(startTime.toLocalDate());
        System.out.println(endTime.toLocalDate());
    }

}
