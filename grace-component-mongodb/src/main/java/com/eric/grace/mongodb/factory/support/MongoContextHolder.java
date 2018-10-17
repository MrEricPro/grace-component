package com.eric.grace.mongodb.factory.support;

import com.eric.grace.mongodb.factory.support.bo.MongoContext;

/**
 * MongoContextHolder: 处理同一个线程下切换数据源的问题
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:23
 */
public class MongoContextHolder {

    private static final ThreadLocal<MongoContext> mongoContextHolder = new ThreadLocal<>();

    public static void setHolder(String key, String database) {
        mongoContextHolder.set(MongoContext.create(key, database));
    }

    public static MongoContext getHolder() {
        return mongoContextHolder.get();
    }

    public static void clearHolder() {
        mongoContextHolder.remove();
    }

}
