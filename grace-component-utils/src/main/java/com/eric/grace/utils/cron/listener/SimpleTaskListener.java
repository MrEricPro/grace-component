package com.eric.grace.utils.cron.listener;


import com.eric.grace.utils.cron.TaskExecutor;

/**
 * 简单监听实现，不做任何操作<br>
 * 继承此监听后实现需要的方法即可
 *
 */
public class SimpleTaskListener implements TaskListener{

	@Override
	public void onStart(TaskExecutor executor) {
	}

	@Override
	public void onSucceeded(TaskExecutor executor) {
		
	}

	@Override
	public void onFailed(TaskExecutor executor, Throwable exception) {

	}

}
