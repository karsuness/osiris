package com.wjx.brand.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wangjinxin
 * @date 2021/2/22 19:02
 * @mail wjxScott@icloud.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WxInfoDTO {

    private String wxId;

    private String nickName;
}
