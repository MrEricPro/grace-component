package com.eric.grace.utils.clone;

/**
 * Cloneable: 克隆支持接口
 *
 * @author: MrServer
 * @since: 2017/12/27 上午11:04
 */
public interface Cloneable <T> extends java.lang.Cloneable {

    /**
     * 克隆当前对象，浅复制
     * @return 克隆后的对象
     *
     * 1.浅克隆：只复制基本类型的数据，引用类型的数据只复制了引用的地址，引用的对象并没有复制，在新的对象中修改引用类型的数据会影响原对象中的引用。
     * 2.深克隆：是在引用类型的类中也实现了clone，是clone的嵌套，复制后的对象与原对象之间完全不会影响。
     * 3.使用序列化也能完成深复制的功能：对象序列化后写入流中，此时也就不存在引用什么的概念了，再从流中读取，生成新的对象，新对象和原对象之间也是完全互不影响的。
     * 4.使用clone实现的深克隆其实是浅克隆中嵌套了浅克隆，与toString方法类似
     *
     */
    T clone();

}