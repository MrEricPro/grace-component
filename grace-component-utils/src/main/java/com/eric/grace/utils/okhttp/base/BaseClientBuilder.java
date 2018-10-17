package com.eric.grace.utils.okhttp.base;

import com.eric.grace.utils.okhttp.build.OkHttpClientBuilder;
import okhttp3.OkHttpClient;

/**
 * BaseClientBuilder:
 *
 * @author: MrServer
 * @since: 2017/12/25 上午10:43
 */
public abstract class BaseClientBuilder {

    public OkHttpClient client = null;

    public void buildClient() {
        client = new OkHttpClientBuilder().build();
    }

    public void buildClient(int connectTimeout,int readTimeout,int writeTimeout) {
        client = new OkHttpClientBuilder().build(connectTimeout,readTimeout,writeTimeout);
    }

}