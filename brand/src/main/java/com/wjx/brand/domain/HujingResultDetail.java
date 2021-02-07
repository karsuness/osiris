package com.wjx.brand.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liusha
 * @date 2021/1/26 11:30
 * @mail liusha@wacai.com
 * @description 虎鲸返回分页详情
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HujingResultDetail<T> {
    /**
     * 当前页
     */
    private Integer currentPage;

    /**
     * 总条数
     */
    private Integer totalCount;

    /**
     * 总页数
     */
    private Integer totalPage;

    /**
     * 业务结果
     */
    private List<T> result;
}
