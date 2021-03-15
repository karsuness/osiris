package com.wjx.brand.domain;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjinxin
 * @date 2021/1/26 11:27
 * @mail wjxScott@icloud.com
 * @description 虎鲸返回result
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HujingResult<T> {
    /**
     * code
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String error;

    /**
     * 结果详情
     */
    private JSONObject data;

}
