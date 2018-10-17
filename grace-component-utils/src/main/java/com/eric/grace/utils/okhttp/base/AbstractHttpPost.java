package com.eric.grace.utils.okhttp.base;

import com.alibaba.fastjson.JSONObject;
import okhttp3.Callback;

import java.io.File;
import java.util.Map;

/**
 * AbstractHttpPost: 抽象操作的Post请求操作方式
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:19
 */
public abstract class AbstractHttpPost extends BaseClientBuilder {

    /**
     * http请求post方法转为结果是：字符串结果
     *
     * @param url
     * @param json
     * @return
     */
    public abstract JSONObject httpPost2Str(String url, JSONObject json);

    /**
     * http请求post方法转为结果是 带请求头：字符串结果
     *
     * @param url
     * @param json
     * @param headers
     * @return
     */
    public abstract JSONObject httpPost2StrHeaders(String url, JSONObject json, Map<String, String> headers);

    /**
     * http请求post方法转为结果是：字节流结果
     *
     * @param url
     * @param json
     * @return
     */
    public abstract JSONObject httpPost2Stream(String url, JSONObject json);


    /**
     * http请求POST方法转为结果是：字节流结果
     *
     * @param url
     * @param paramPair
     * @return
     */
    public abstract JSONObject httpPost2Stream(String url, Map<String, String> paramPair);


    /**
     * http请求POST方法转为结果是：字符串结果
     *
     * @param url
     * @param paramPair
     * @return
     */
    public abstract JSONObject httpPost2Str(String url, Map<String, String> paramPair);


    /**
     * http请求post方法转为结果是：字符串结果
     * @param url
     * @param paramPair
     * @param headers
     * @return
     */
    public abstract JSONObject httpPost2StrHeaders(String url, Map<String, Object> paramPair, Map<String, Object> headers);

    public abstract JSONObject httpPostSteamHeaders(String url, JSONObject json, Map<String, Object> headers);

    public abstract JSONObject httpPostFile(String url, File file, String fileName, Map<String,String> params);

    public abstract JSONObject httpPost2Str(String url, String param);
}