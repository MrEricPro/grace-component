package com.eric.grace.utils.okhttp.exec;

import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.okhttp.sync.HttpRequestUtil;
import okhttp3.Callback;

import java.io.File;
import java.util.Map;

/**
 * OkHttpUtil:对外发布的OkHttp客户端 网络服务组建进行调用get和post请求操作
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:52
 */
public class OkHttpUtil {


    /**
     * get方式获取 字符串结果
     * @param url
     * @return
     */
    public static final JSONObject getContent(String url) {
        //校验是否合法
        validateURI(url);
        return HttpRequestUtil.getInstance().buildGetClient().httpGet2Str(url);
    }

    /**
     * get方式获取 字节流获取
     * @param url
     * @return
     */
    public static final JSONObject getStream(String url) {
        //校验是否合法
        validateURI(url);
        return HttpRequestUtil.getInstance().buildGetClient().httpGet2Stream(url);
    }


    public static final JSONObject postContent(String url, Map<String, String> param) {
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPost2Str(url, param);
    }


    public static final JSONObject postContent(String url, String param) {
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPost2Str(url, param);
    }


    public static final JSONObject postStream(String url, JSONObject param) {
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPost2Stream(url, param);
    }

    public static final JSONObject postStream(String url, Map<String, String> param) {
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPost2Stream(url, param);
    }

    public static final JSONObject httpPost2StrHeaders(String url, JSONObject json, Map<String, String> headers) {
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPost2StrHeaders(url, json, headers);
    }


    public static final JSONObject httpPost2StrHeaders(String url, Map<String, Object> paramPair, Map<String, Object> headers) {
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPost2StrHeaders(url, paramPair, headers);
    }



    public static final JSONObject httpPostSteamHeaders(String url, JSONObject json, Map<String, Object> headers) {
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPostSteamHeaders(url, json, headers);
    }

    public static final JSONObject httpPostFile (String url, File file, String fileName, Map<String,String> params){
        validateURI(url);
        return HttpRequestUtil.getInstance().buildPostClient().httpPostFile(url, file,fileName, params);
    }


    /**
     * 校验URI是否合法
     *
     * @param url
     */
    private static void validateURI(String url) {
        //判断url是否服务要求
        if (url == null || "".equals(url) || url.length() == 0) {
            throw new NullPointerException("传入的URL为空,请传入检查的URL!");
        }
        //判断url是否真正的以Http/Https开头 暂时只接受这两种方案
        else if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new IllegalArgumentException("传入的URL为不合法,请传入Http或者Https开头的URL路径");
        }
    }
}