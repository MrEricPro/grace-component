package com.eric.grace.utils.okhttp.ansy;

import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.okhttp.base.AbstractHttpGet;
import com.eric.grace.utils.okhttp.build.OkHttpClientBuilder;
import com.eric.grace.utils.okhttp.callback.DefaultCallback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;

/**
 * AsyncGetUtil: 异步操作get请求操作工具客户端类
 *
 * @author: MrServer
 * @since: 2017/12/25 上午10:29
 */
public class AsyncGetUtil extends AbstractHttpGet {

    private static final Logger logger = LoggerFactory.getLogger(AsyncGetUtil.class);


    private OkHttpClient client = null;


    /**
     * 获取实例
     */
    public void buildClient() {
        client = new OkHttpClientBuilder().build();
    }


    /**
     * 获取实例
     * @param connectTimeout
     * @param readTimeout
     * @param writeTimeout
     */
    public void buildClient(int connectTimeout,int readTimeout,int writeTimeout) {
        client = new OkHttpClientBuilder().build(connectTimeout,readTimeout,writeTimeout);
    }


    /**
     * http请求get方法转为结果是：字符串结果
     * @param url
     * @return
     */
    public JSONObject httpGet2Str(String url) {
        //判断是否为空，避免过多初始化

        if(client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            //默认回调方法
            DefaultCallback callback = new DefaultCallback("string");
            client.newCall(request).enqueue(callback);
            return callback.resultObject;
        } catch (Exception e) {
            logger.error("请求操作失败!",e);
        }
        return null;
    }


    /**
     * http请求get方法转为结果是：字节流结果
     * @param url
     * @return
     */
    public JSONObject httpGet2Stream(String url) {
        //判断是否为空，避免过多初始化

        if(client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            DefaultCallback callback = new DefaultCallback("stream");
            client.newCall(request).enqueue(callback);
            return callback.resultObject;
        } catch (Exception e) {
            logger.error("请求操作失败!",e);
        }
        return null;
    }


    /**
     * http请求get方法转为结果是：字符串结果
     * @param url
     * @return
     */
    public JSONObject httpGet2Str(URL url) {
        //判断是否为空，避免过多初始化

        if(client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            DefaultCallback callback = new DefaultCallback("string");
            client.newCall(request).enqueue(callback);
            return callback.resultObject;
        } catch (Exception e) {
            logger.error("请求操作失败!",e);
        }
        return null;
    }


    /**
     * http请求get方法转为结果是：字节流结果
     * @param url
     * @return
     */
    public JSONObject httpGet2Stream(URL url) {
        //判断是否为空，避免过多初始化
        if(client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            DefaultCallback callback = new DefaultCallback("string");
            client.newCall(request).enqueue(callback);
            return callback.resultObject;
        } catch (Exception e) {
            logger.error("请求操作失败!",e);
        }
        return null;
    }

}