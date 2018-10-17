package com.eric.grace.test.cron;


import com.eric.grace.utils.cron.CronUtil;

/**
 * 定时任务样例
 */
public class CronDemo {
	public static void main(String[] args) {

		//支持秒级别定时任务
		CronUtil.setCronSetting("config/test/cron.setting");
		CronUtil.setMatchSecond(true);
		
		CronUtil.start();
//		CronUtil.stop();
	}
}
