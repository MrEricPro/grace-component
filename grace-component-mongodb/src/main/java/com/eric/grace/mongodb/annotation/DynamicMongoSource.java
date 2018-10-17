package com.eric.grace.mongodb.annotation;

import java.lang.annotation.*;

/**
 * DynamicMongoSource:  mogondb 动态数据源
 *
 * @author: MrEric
 * @since: 2018/9/7 下午3:58
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DynamicMongoSource {

    String key() default "";
    String db() default "";

}
