package com.eric.grace.utils.okhttp.exec;

import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.okhttp.ansy.AsyncRequestUtil;
import com.eric.grace.utils.okhttp.sync.HttpRequestUtil;

import java.util.Map;

/**
 * OkAsyncHttpUtils: 异步工具类
 *
 * @author: MrServer
 * @since: 2017/12/26 上午10:02
 */
public class OkAsyncHttpUtils {



    public static final JSONObject httpPost2StrHeaders(String url, JSONObject json, Map<String, String> headers) {
        validateURI(url);
        return AsyncRequestUtil.getInstance().buildPostClient().httpPost2StrHeaders(url, json, headers);
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