package com.eric.grace.utils.clone;


/**
 * CloneSupport: 克隆支持类，提供默认的克隆方法
 *
 * @author: MrServer
 * @since: 2017/12/27 上午11:07
 */
public class CloneSupport<T> implements Cloneable<T> {
    @Override
    public T clone(){
        try {
            return (T) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new CloneRuntimeException(e);
        }
    }
}