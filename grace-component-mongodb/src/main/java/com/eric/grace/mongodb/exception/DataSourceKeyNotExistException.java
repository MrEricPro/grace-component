package com.eric.grace.mongodb.exception;

/**
 * DataSourceKeyNotExistException:
 *
 * @author: MrEric
 * @since: 2018/9/7 下午4:25
 */
public class DataSourceKeyNotExistException extends RuntimeException {
    public DataSourceKeyNotExistException() {
        super("传入的key不在数据源map中");
    }
}
