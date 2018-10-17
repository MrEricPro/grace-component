package com.eric.grace.utils.bean.copier.provider;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

import com.eric.grace.utils.bean.BeanDesc.PropDesc;
import com.eric.grace.utils.bean.BeanUtil;
import com.eric.grace.utils.bean.copier.ValueProvider;
import com.eric.grace.utils.exceptions.UtilException;

/**
 * Bean的值提供者
 * 
 * @author looly
 *
 */
public class BeanValueProvider implements ValueProvider<String> {

	private Object source;
	private boolean ignoreError;
	final Map<String, PropDesc> sourcePdMap;

	public BeanValueProvider(Object bean, boolean ignoreCase, boolean ignoreError) {
		this.source = bean;
		this.ignoreError = ignoreError;
		sourcePdMap = BeanUtil.getBeanDesc(source.getClass()).getPropMap(ignoreCase);
	}

	@Override
	public Object value(String key, Type valueType) {
		final PropDesc sourcePd = sourcePdMap.get(key);
		if (null != sourcePd) {
			final Method getter = sourcePd.getGetter();
			if (null != getter) {
				try {
					return getter.invoke(source);
				} catch (Exception e) {
					if (false == ignoreError) {
						throw new UtilException(e, "Inject [{}] error!", key);
					}
				}
			}
		}
		return null;
	}

	@Override
	public boolean containsKey(String key) {
		return sourcePdMap.containsKey(key);
	}

}
