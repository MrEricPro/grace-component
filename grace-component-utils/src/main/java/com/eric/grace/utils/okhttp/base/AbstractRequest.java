package com.eric.grace.utils.okhttp.base;

/**
 * AbstractRequest: 抽象操作类：请求客户端类服务操作
 *
 * @author: MrServer
 * @since: 2017/12/25 上午10:45
 */
public abstract class AbstractRequest {

    public abstract AbstractHttpGet buildGetClient();

    public abstract AbstractHttpGet buildGetClient(int connectTimeout, int readTimeout, int writeTimeout);

    public abstract AbstractHttpPost buildPostClient();

    public abstract AbstractHttpPost buildPostClient(int connectTimeout,int readTimeout,int writeTimeout);

}