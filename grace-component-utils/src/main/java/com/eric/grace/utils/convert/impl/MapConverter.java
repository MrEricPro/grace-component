package com.eric.grace.utils.convert.impl;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.Map.Entry;

import com.eric.grace.utils.bean.BeanUtil;
import com.eric.grace.utils.convert.AbstractConverter;
import com.eric.grace.utils.convert.ConverterRegistry;
import com.eric.grace.utils.common.MapUtil;
import com.eric.grace.utils.common.StrUtil;
import com.eric.grace.utils.common.TypeUtil;

/**
 * {@link Map} 转换器
 * 
 * @author Looly
 * @since 3.0.8
 */
public class MapConverter extends AbstractConverter<Map<?, ?>> {
	
	/** Map类型 */
	private final Type mapType;
	/** 键类型 */
	private final Type keyType;
	/** 值类型 */
	private final Type valueType;
	
	/**
	 * 构造，Map的key和value泛型类型自动获取
	 * 
	 * @param mapType Map类型
	 */
	public MapConverter(Type mapType) {
		this(mapType, TypeUtil.getTypeArgument(mapType, 0), TypeUtil.getTypeArgument(mapType, 1));
	}
	
	/**
	 * 构造
	 * @param mapType Map类型
	 * @param keyType 键类型
	 * @param valueType 值类型
	 */
	public MapConverter(Type mapType, Type keyType, Type valueType) {
		this.mapType = mapType;
		this.keyType = keyType;
		this.valueType = valueType;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected Map<?, ?> convertInternal(Object value) {
		Map map = MapUtil.createMap(TypeUtil.getClass(this.mapType));
		
		Class<?> valueType = value.getClass();
		if(value instanceof Map){
			convertMapToMap((Map)value, map);
		}else if(BeanUtil.isBean(valueType)){
			BeanUtil.beanToMap(map);
		}else{
			throw new UnsupportedOperationException(StrUtil.format("Unsupport toMap value type: {}", valueType.getName()));
		}
		return map;
	}

	/**
	 * Map转Map
	 * @param srcMap 源Map
	 * @param targetMap 目标Map
	 */
	private void convertMapToMap(Map<?, ?> srcMap, Map<Object, Object> targetMap){
		final ConverterRegistry convert = ConverterRegistry.getInstance();
		for (Entry<?, ?> entry : srcMap.entrySet()) {
			targetMap.put(convert.convert(this.keyType, entry.getKey()), convert.convert(this.valueType, entry.getValue()));
		}
	}
}
