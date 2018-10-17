package com.eric.grace.utils.okhttp.base;

import java.net.URL;
import com.alibaba.fastjson.JSONObject;

/**
 * AbstractHttpGet:抽象Get请求操作的服务构建类
 *
 * @author: MrServer
 * @since: 2017/12/25 上午10:45
 */
public abstract class AbstractHttpGet extends BaseClientBuilder {


    /**
     * http请求get方法转为结果是：字符串结果
     * @param url
     * @return
     */
    public abstract JSONObject httpGet2Str(String url);


    /**
     * http请求get方法转为结果是：字节流结果
     * @param url
     * @return
     */
    public abstract JSONObject httpGet2Stream(String url);


    /**
     *
     * @param url
     * @return
     */
    public abstract JSONObject httpGet2Str(URL url);

    /**
     *
     * @param url
     * @return
     */
    public abstract JSONObject httpGet2Stream(URL url);


}