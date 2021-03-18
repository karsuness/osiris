package com.wjx.osiris.azir.prototype.serializ;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangjinxin
 * @date 2021/3/16 11:57
 * @mail wjxScott@163.com
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    private String subject;

    private String content;

}
