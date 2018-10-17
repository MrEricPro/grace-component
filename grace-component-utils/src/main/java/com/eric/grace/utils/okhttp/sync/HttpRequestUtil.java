package com.eric.grace.utils.okhttp.sync;

import com.eric.grace.utils.okhttp.base.AbstractHttpGet;
import com.eric.grace.utils.okhttp.base.AbstractHttpPost;
import com.eric.grace.utils.okhttp.base.AbstractRequest;

/**
 * HttpRequestUtil: Http请求工具类
 *
 * @author: MrServer
 * @since: 2017/12/25 下午3:01
 */
public class HttpRequestUtil extends AbstractRequest {


    //请求单利类
    private static HttpRequestUtil util ;

    private HttpRequestUtil(){}

    //构造器-内部构造器，用于提供给AsyncRequestUtil工具类使用
    public HttpRequestUtil(Object param) {}

    //单例模式
    public static HttpRequestUtil getInstance(){
        if(util == null)
            util = new HttpRequestUtil();
        return util;
    }

    public AbstractHttpGet buildGetClient(){
        HttpGetUtil client = new HttpGetUtil();
        client.buildClient();
        return client;
    }


    public AbstractHttpGet buildGetClient(int connectTimeout, int readTimeout, int writeTimeout){
        HttpGetUtil client = new HttpGetUtil();
        client.buildClient(connectTimeout,readTimeout,writeTimeout);
        return client;
    }

    public AbstractHttpPost buildPostClient(){
        HttpPostUtil client = new HttpPostUtil();
        client.buildClient();
        return client;
    }

    public AbstractHttpPost buildPostClient(int connectTimeout,int readTimeout,int writeTimeout){
        HttpPostUtil client = new HttpPostUtil();
        client.buildClient(connectTimeout,readTimeout,writeTimeout);
        return client;
    }

}