package com.wjx.teemo.domain.result;

import com.wjx.teemo.domain.enumeration.DateTimePatternEnum;
import com.wjx.teemo.domain.enumeration.ErrorEnum;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author wangjinxin
 * @date 2021/1/13 11:46
 * @mail wjxScott@163.com
 * @description 统一返回结果类
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 请求结果是否成功
     */
    private Boolean status;

    /**
     * 结果返回code
     */
    private String code;

    /**
     * 结果返回信息
     */
    private String message;

    /**
     * 返回时间
     */
    private String time;

    /**
     * 返回结果
     */
    private Object data;

    private static final String SUCCESS_CODE = "0000";

    private static final String SUCCESS_MESSAGE = "处理成功";

    /**
     * 私有化构造方法，不允许外部new对象
     */
    private Result() {
    }

    /**
     * 返回成功结果
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 返回成功结果
     *
     * @param data
     * @return
     */
    public static Result success(Object data) {
        return buildResult(true, SUCCESS_CODE, SUCCESS_MESSAGE, data);
    }

    /**
     * 通过自己输入的code和message返回成功结果
     *
     * @param successCode
     * @param successMessage
     * @param data
     * @return
     */
    public static Result success(String successCode, String successMessage, Object data) {
        return buildResult(true, successCode, successMessage, data);
    }

    /**
     * 返回失败结果
     *
     * @return
     */
    public static Result fail() {
        return fail(ErrorEnum.DEFAULT_ERROR);
    }

    /**
     * 返回失败Result
     *
     * @param errorEnum
     * @return
     */
    public static Result fail(ErrorEnum errorEnum) {
        return buildResult(false, errorEnum.getCode(), errorEnum.getMessage(), null);
    }

    /**
     * 返回失败Result
     *
     * @param errorCode
     * @param errorMessage
     * @return
     */
    public static Result fail(String errorCode, String errorMessage) {
        return buildResult(false, errorCode, errorMessage, null);
    }

    /**
     * 返回失败Result
     *
     * @param errorCode
     * @param errorMessage
     * @param data
     * @return
     */
    public static Result fail(String errorCode, String errorMessage, Object data) {
        return buildResult(false, errorCode, errorMessage, data);
    }

    /**
     * 内部构建Result
     *
     * @param status
     * @param code
     * @param message
     * @param data
     * @return
     */
    private static Result buildResult(Boolean status, String code, String message, Object data) {
        Result result = new Result();
        result.setData(data);
        result.setStatus(status);
        result.setCode(code);
        result.setMessage(message);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DateTimePatternEnum.DEFAULT_DATE_PATTERN.getPattern());
        result.setTime(formatter.format(LocalDateTime.now()));
        return result;
    }
}
