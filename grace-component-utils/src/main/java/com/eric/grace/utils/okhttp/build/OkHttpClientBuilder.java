package com.eric.grace.utils.okhttp.build;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * OkHttpClientBuilder:  网络访问操作框架工具执行请求构建类
 *
 * @author: MrServer
 * @since: 2017/12/25 上午10:40
 */
public class OkHttpClientBuilder {
    /**
     * 客户端对象
     */
    private OkHttpClient client = null;

    /**
     * 连接超时时间 单位秒 默认 10 秒
     */
    private Integer connectTimeout = 10;

    /**
     * 读取超时时间 单位秒 默认 10 秒
     */
    private Integer readTimeout = 10;


    /**
     * 写入超时时间 单位秒 默认 10 秒
     */
    private Integer writeTimeout = 10;


    /**
     * 获取实例
     * @return
     */
    public OkHttpClient build(){
        if(client == null){
            client = new OkHttpClient.Builder()
                    .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                    .readTimeout(readTimeout, TimeUnit.SECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.SECONDS).build();
        }
        return client;
    }


    /**
     * 获取实例 自行设置参数
     * @param connectTimeout
     * @param readTimeout
     * @param writeTimeout
     * @return
     */
    public OkHttpClient build(Integer connectTimeout,Integer readTimeout,Integer writeTimeout){
        if(client == null){
            client = new OkHttpClient.Builder()
                    .connectTimeout(connectTimeout, TimeUnit.SECONDS)
                    .readTimeout(readTimeout, TimeUnit.SECONDS)
                    .writeTimeout(writeTimeout, TimeUnit.SECONDS).build();
        }
        return client;
    }


    public OkHttpClient getClient() {
        return client;
    }

    public Integer getConnectTimeout() {
        return connectTimeout;
    }

    public Integer getReadTimeout() {
        return readTimeout;
    }
}