package com.eric.grace.utils.okhttp.sync;

import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.okhttp.base.AbstractHttpGet;
import com.eric.grace.utils.okhttp.bean.HttpResult;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.URL;

/**
 * HttpGetUtil: Ok Http 请求工具类,此类建议全局静态即可
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:57
 */
public class HttpGetUtil extends AbstractHttpGet {


    public JSONObject httpGet2Str(String url) {
        //判断是否为空，避免过多初始化
        if (client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        HttpResult result = new HttpResult();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result.setCode(String.valueOf(response.code()));
                result.setResultStr(response.body().string());
                result.setHeaders(response.headers());
                return result.buildSuccess();
            } else {
                result.setCode(String.valueOf(response.code()));
                result.setResultStr(response.body().string());
                result.setHeaders(response.headers());
                return result.buildFailure();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(JSONObject.toJSONString(result, true));
        }
        return null;
    }


    public JSONObject httpGet2Stream(String url) {
        //判断是否为空，避免过多初始化
        if (client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        HttpResult result = new HttpResult();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result.setCode(String.valueOf(response.code()));
                result.setResultStream(response.body().byteStream());
                result.setHeaders(response.headers());
                return result.buildSuccess();
            } else {
                result.setCode(String.valueOf(response.code()));
                result.setResultStream(response.body().byteStream());
                result.setHeaders(response.headers());
                return result.buildFailure();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(JSONObject.toJSONString(result, true));
        }
        return null;
    }


    public JSONObject httpGet2Str(URL url) {
        //判断是否为空，避免过多初始化
        if (client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        HttpResult result = new HttpResult();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result.setCode(String.valueOf(response.code()));
                result.setResultStr(response.body().string());
                result.setHeaders(response.headers());
                return result.buildSuccess();
            } else {
                result.setCode(String.valueOf(response.code()));
                result.setResultStr(response.body().string());
                result.setHeaders(response.headers());
                return result.buildFailure();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println(JSONObject.toJSONString(result, true));
        }
        return null;
    }


    public JSONObject httpGet2Stream(URL url) {
        //判断是否为空，避免过多初始化
        if (client == null)
            client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        HttpResult result = new HttpResult();
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result.setCode(String.valueOf(response.code()));
                result.setResultStream(response.body().byteStream());
                result.setHeaders(response.headers());
                return result.buildSuccess();
            } else {
                result.setCode(String.valueOf(response.code()));
                result.setResultStr(response.body().string());
                result.setHeaders(response.headers());
                return result.buildFailure();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}