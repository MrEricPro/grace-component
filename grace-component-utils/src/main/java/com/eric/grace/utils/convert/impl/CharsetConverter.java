package com.eric.grace.utils.convert.impl;

import java.nio.charset.Charset;

import com.eric.grace.utils.convert.AbstractConverter;
import com.eric.grace.utils.common.CharsetUtil;

/**
 * 编码对象转换器
 * @author Looly
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
