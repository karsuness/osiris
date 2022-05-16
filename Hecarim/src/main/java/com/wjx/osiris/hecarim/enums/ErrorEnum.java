package com.wjx.osiris.hecarim.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangjinxin
 * @date 2021/1/13 11:49
 * @mail wjxScott@163.com
 * @description
 */
@Getter
@AllArgsConstructor
public enum ErrorEnum {
    DEFAULT_ERROR("1001", "默认错误"),

    PARAMS_ERROR("1002", "参数错误"),

    DB_ERROR("1003", "数据库操作错误"),

    DATA_NOT_EXIST("1004", "数据不存在"),

    RPC_ERROR("1005", "RPC调用异常"),
    ;
    /**
     * 返回code
     */
    private String code;

    /**
     * 返回message
     */
    private String message;

    /**
     * Enum映射，用于查找
     */
    private static Map<String, ErrorEnum> map;

    //Error加载后将所有ErrorEnum信息存储在map中
    static {
        map = Arrays.stream(ErrorEnum.values()).collect(Collectors.toMap(ErrorEnum::getCode, Function.identity()));
    }

    /**
     * 通过errorCode找到对应的ErrorEnum
     *
     * @param error 错误码
     * @return ErrorEnum
     */
    public static ErrorEnum getErrorEnumByCode(Integer error) {
        if (error == null) {
            throw new RuntimeException("请输入正确error");
        }

        ErrorEnum errorEnum = map.getOrDefault(error, null);

        if (errorEnum == null) {
            throw new RuntimeException("此error没有对应的ErrorEnum");
        }

        return errorEnum;
    }
}
