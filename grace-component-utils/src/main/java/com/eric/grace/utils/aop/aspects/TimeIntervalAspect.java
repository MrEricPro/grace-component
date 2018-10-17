package com.eric.grace.utils.aop.aspects;

import com.eric.grace.utils.date.TimeInterval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * TimeIntervalAspect: 通过日志打印方法的执行时间的切面
 *
 * @author: MrServer
 * @since: 2018/2/9 上午10:41
 */
public class TimeIntervalAspect extends SimpleAspect {

    private static final Logger log = LoggerFactory.getLogger(TimeIntervalAspect.class);

    public TimeIntervalAspect(Object target) {
        super(target);
    }

    private TimeInterval interval = new TimeInterval();

    @Override
    public boolean before(Object target, Method method, Object[] args) {
        interval.start();
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args) {
        log.info("Method [{}.{}] execute spend [{}]ms", target.getClass().getName(), method.getName(), interval.intervalMs());
        return true;
    }
}