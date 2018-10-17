package com.eric.grace.utils.convert.impl;

import com.eric.grace.utils.convert.AbstractConverter;
import com.eric.grace.utils.convert.ConverterRegistry;
import com.eric.grace.utils.common.ArrayUtil;

/**
 * byte 类型数组转换器
 * @author Looly
 *
 */
public class ByteArrayConverter extends AbstractConverter<byte[]>{
	
	@Override
	protected byte[] convertInternal(Object value) {
		final Byte[] result = ConverterRegistry.getInstance().convert(Byte[].class, value);
		return ArrayUtil.unWrap(result);
	}

}
