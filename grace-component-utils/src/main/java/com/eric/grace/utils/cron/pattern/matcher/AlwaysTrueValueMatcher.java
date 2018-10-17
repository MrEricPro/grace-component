package com.eric.grace.utils.cron.pattern.matcher;


import com.eric.grace.utils.common.StrUtil;

/**
 * 值匹配，始终返回<code>true</code>
 */
public class AlwaysTrueValueMatcher implements ValueMatcher{

	public boolean match(Integer t) {
		return true;
	}
	
	@Override
	public String toString() {
		return StrUtil.format("[Matcher]: always true.");
	}
}
