package com.eric.grace.utils.convert.impl;

import java.lang.reflect.Type;
import java.util.Collection;

import com.eric.grace.utils.collection.CollUtil;
import com.eric.grace.utils.convert.Converter;
import com.eric.grace.utils.collection.CollectionUtil;
import com.eric.grace.utils.common.TypeUtil;

/**
 * 各种集合类转换器
 * 
 * @author Looly
 * @since 3.0.8
 */
public class CollectionConverter implements Converter<Collection<?>> {

	/** 集合类型 */
	private final Type collectionType;
	/** 集合元素类型 */
	private final Type elementType;

	/**
	 * 构造，默认集合类型使用{@link Collection}
	 */
	public CollectionConverter() {
		this(Collection.class);
	}

	// ---------------------------------------------------------------------------------------------- Constractor start
	/**
	 * 构造
	 * 
	 * @param collectionType 集合类型
	 */
	public CollectionConverter(Type collectionType) {
		this(collectionType, TypeUtil.getTypeArgument(collectionType));
	}

	/**
	 * 构造
	 * 
	 * @param collectionType 集合类型
	 */
	public CollectionConverter(Class<?> collectionType) {
		this(collectionType, TypeUtil.getTypeArgument(collectionType));
	}

	/**
	 * 构造
	 * 
	 * @param collectionType 集合类型
	 * @param elementType 集合元素类型
	 */
	public CollectionConverter(Type collectionType, Type elementType) {
		this.collectionType = collectionType;
		this.elementType = elementType;
	}
	// ---------------------------------------------------------------------------------------------- Constractor end

	@Override
	public Collection<?> convert(Object value, Collection<?> defaultValue) throws IllegalArgumentException {
		Collection<?> result = null;
		try {
			result = convertInternal(value);
		} catch (RuntimeException e) {
			return defaultValue;
		}
		return ((null == result) ? defaultValue : result);
	}

	/**
	 * 内部转换
	 * @param value 值
	 * @return 转换后的集合对象
	 */
	protected Collection<?> convertInternal(Object value) {
		final Collection<Object> collection = CollectionUtil.create(TypeUtil.getClass(collectionType));
		return CollUtil.addAll(collection, value, elementType);
	}
}
