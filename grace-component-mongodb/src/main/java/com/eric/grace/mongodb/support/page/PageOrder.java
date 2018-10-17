package com.eric.grace.mongodb.support.page;

import java.io.Serializable;

/**
 * PageOrder: 分页排序对象
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:33
 */
public class PageOrder implements Serializable {

    /**
     * 排序字段
     */
    protected String orderField;

    /**
     * 排序方式
     */
    protected String orderDirection;


    public String getOrderField() {
        return orderField;
    }

    public void setOrderField(String orderField) {
        this.orderField = orderField;
    }

    public String getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(String orderDirection) {
        this.orderDirection = orderDirection;
    }
}
