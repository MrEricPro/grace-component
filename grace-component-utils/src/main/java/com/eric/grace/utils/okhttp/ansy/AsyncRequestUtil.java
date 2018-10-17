package com.eric.grace.utils.okhttp.ansy;

import com.eric.grace.utils.okhttp.base.AbstractHttpGet;
import com.eric.grace.utils.okhttp.base.AbstractHttpPost;
import com.eric.grace.utils.okhttp.base.AbstractRequest;

import java.lang.ref.SoftReference;

/**
 * AsyncRequestUtil: 用于相对于HttpRequestUtil工具类操作,但是本工具类为AsyncRequestUtil工具类,主要用于操作异步请求操作工具类
 *
 * @author: MrServer
 * @since: 2017/12/25 上午10:35
 */
public final class AsyncRequestUtil extends AbstractRequest {


    //单例对象
    private static AsyncRequestUtil requestUtil = null;


    private AsyncRequestUtil() {

    }

    /**
     * 单例模式对象：懒汉模式/饱汉模式
     * @return
     */
    public static AsyncRequestUtil getInstance() {
        if(requestUtil == null) {
            synchronized(AsyncRequestUtil.class)
            {
                if(requestUtil == null){
                    requestUtil = new AsyncRequestUtil();
                }
            }
        }
        return requestUtil;
    }



    @Override
    public AbstractHttpGet buildGetClient() {
        SoftReference<AsyncGetUtil> client = new SoftReference<AsyncGetUtil>(new AsyncGetUtil());
        AsyncGetUtil object = client.get();
        object.buildClient();
        return object;
    }


    @Override
    public AbstractHttpGet buildGetClient(int connectTimeout, int readTimeout, int writeTimeout) {
        SoftReference<AsyncGetUtil> client = new SoftReference<AsyncGetUtil>(new AsyncGetUtil());
        AsyncGetUtil object = client.get();
        object.buildClient(connectTimeout,readTimeout,writeTimeout);
        return object;
    }


    @Override
    public AbstractHttpPost buildPostClient() {
        SoftReference<AsyncPostUtil> client = new SoftReference<AsyncPostUtil>(new AsyncPostUtil());
        AsyncPostUtil object = client.get();
        object.buildClient();
        return object;
    }


    @Override
    public AbstractHttpPost buildPostClient(int connectTimeout, int readTimeout, int writeTimeout) {
        return null;
    }




}