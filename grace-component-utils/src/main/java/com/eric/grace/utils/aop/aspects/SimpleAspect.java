package com.eric.grace.utils.aop.aspects;

import com.eric.grace.utils.aop.Aspect;

import java.lang.reflect.Method;

/**
 * SimpleAspect: 简单切面类，不做任何操作
 *
 * @author: MrServer
 * @since: 2018/2/9 上午10:40
 */
public class SimpleAspect extends Aspect {

    public SimpleAspect(Object target) {
        super(target);
    }

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        //继承此类后实现此方法
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args) {
        //继承此类后实现此方法
        return true;
    }

    @Override
    public boolean afterException(Object target, Method method, Object[] args, Throwable e) {
        //继承此类后实现此方法
        return true;
    }
}