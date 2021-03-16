package com.wjx.osiris.zed.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangjinxin
 * @date 2021/1/13 11:37
 * @mail wjxScott@163.com
 * @description 时间pattern枚举
 */
@Getter
@AllArgsConstructor
public enum DateTimePatternEnum {

    DEFAULT_DATE_PATTERN("yyyy-MM-dd", "yyyy-MM-dd为默认的时间格式"),

    DATE_PATTERN_YEARMONTH("yyyy-MM", "yyyy-MM格式的日期pattern"),

    DATE_PATTERN_YYYYMMDD("yyyyMMdd", "yyyyMMdd格式的日期pattern"),

    DATE_PATTERN_YYMMDDHH("yyMMddHH", "yyMMddHH样式的日期pattern"),

    DATE_PATTERN_YYYYMM("yyyyMM", "yyyyMM格式的日期pattern"),

    DATE_PATTERN_YYYY_MM_DD("yyyy_MM_dd", "yyyy_MM_dd格式的日期pattern"),

    DATE_PATTERN_DOT("yyyy.MM.dd", "yyyy.MM.dd格式的日期pattern"),

    DATE_PATTERN_SLASH_TIME("MM/dd/yy", "MM/dd/yy格式的日期pattern"),

    DATE_PATTERN_SLASH_DATE("yyyy/MM/dd", "yyyy/MM/dd格式的日期pattern"),

    DATE_PATTERN_LONG("yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm:ss格式的日期pattern"),

    DATE_PATTERN_CHINESE("yyyy年MM月dd日", "yyyy年MM月dd日格式的日期pattern"),

    DATE_PATTERN_FULL_DATE_TIME("yyyyMMddHHmmss", "yyyyMMddHHmmss格式的日期pattern");

    /**
     * 时间样式
     */
    private String pattern;
    /**
     * 描述
     */
    private String description;

    /**
     * Enum映射，用于查找
     */
    private static Map<String, DateTimePatternEnum> map;

    static {
        map = Arrays.stream(DateTimePatternEnum.values()).collect(Collectors.toMap(DateTimePatternEnum::getPattern, Function.identity()));
    }

    /**
     * 通过code获取对应的枚举
     *
     * @param pattern
     * @return
     */
    public static DateTimePatternEnum getDateTimePatternEnumByPattern(String pattern) {
        if (pattern == null) {
            throw new RuntimeException("请输入正确pattern");
        }

        DateTimePatternEnum dateTimePatternEnum = map.getOrDefault(pattern, null);

        if (dateTimePatternEnum == null) {
            throw new RuntimeException("此pattern没有对应的DateTimePatternEnum");
        }

        return dateTimePatternEnum;
    }
}
