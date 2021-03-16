package com.wjx.osiris.zed.domain.query;

import lombok.Getter;
import lombok.Setter;

/**
 * @author wangjinxin
 * @date 2021/1/13 11:59
 * @mail wjxScott@163.com
 * @description 分页查询基类
 */
@Getter
@Setter
public abstract class BaseQuery {
    private static final long serialVersionUID = 1L;

    /**
     * 页码
     */
    protected Integer pageNo = 1;

    /**
     * 每页个数
     */
    protected Integer pageSize = 10;

    /**
     * 分页起始量
     */
    private Integer offset;


    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        computeOffset();
    }

    /**
     * 获得分页数据起始值
     *
     * @return 分页数据起始值
     */
    public Integer getOffset() {
        computeOffset();
        return offset;
    }

    /**
     * 计算分页起始值
     *
     * @return 分页起始值
     */
    public Integer computeOffset() {
        if (pageNo == null || pageSize == null) {
            return null;
        }
        offset = (pageNo - 1) * pageSize;
        return offset;
    }
}
