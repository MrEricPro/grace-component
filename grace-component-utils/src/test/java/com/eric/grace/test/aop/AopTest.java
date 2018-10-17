package com.eric.grace.test.aop;

import com.eric.grace.utils.aop.ProxyUtil;
import com.eric.grace.utils.aop.aspects.TimeIntervalAspect;
import org.junit.Assert;
import org.junit.Test;

/**
 * AopTest:
 *
 * @author: MrServer
 * @since: 2018/2/9 上午10:42
 */
public class AopTest {

    @Test
    public void aopTest(){
        Animal cat = ProxyUtil.proxy(new Cat(), TimeIntervalAspect.class);
        String result = cat.eat();
        Assert.assertEquals("猫吃鱼", result);
    }

    static interface Animal{
        String eat();
    }

    static class Cat implements Animal{

        @Override
        public String eat() {
            return "猫吃鱼";
        }

    }

}