package com.wjx.teemo.domain.exceptions;

import com.wjx.teemo.domain.enumeration.ErrorEnum;
import com.wjx.teemo.domain.result.Result;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author WJX
 * @since 2018/4/15 12:34
 */
@Getter
@Setter
@NoArgsConstructor
public class BaseException extends Exception {
    /**
     * 错误码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMessage;

    public BaseException(ErrorEnum errorEnum) {
        this.errorCode = errorEnum.getCode();
        this.errorMessage = errorEnum.getMessage();
    }

    public BaseException(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public BaseException(Result result) {
        this.errorCode = result.getCode();
        this.errorMessage = result.getMessage();
    }
}
