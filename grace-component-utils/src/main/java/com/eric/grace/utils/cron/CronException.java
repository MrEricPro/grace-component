package com.eric.grace.utils.cron;


import com.eric.grace.utils.common.StrUtil;

/**
 * 定时任务异常
 */
public class CronException extends RuntimeException{
	private static final long serialVersionUID = 8247610319171014183L;

	public CronException(Throwable e) {
		super(e.getMessage(), e);
	}
	
	public CronException(String message) {
		super(message);
	}
	
	public CronException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}
	
	public CronException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
