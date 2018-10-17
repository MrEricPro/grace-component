package com.eric.grace.utils.okhttp.ansy;

import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.okhttp.base.AbstractHttpPost;
import com.eric.grace.utils.okhttp.bean.HttpResult;
import com.eric.grace.utils.okhttp.callback.DefaultCallback;
import com.eric.grace.utils.okhttp.media.HttpMedia;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * AsyncPostUtil:用于异步操作的方法信息，系统提供的另外一个Http请求的工具入口
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:36
 */
public final class AsyncPostUtil extends AbstractHttpPost {

    private static final Logger logger = LoggerFactory.getLogger(AsyncPostUtil.class);


    /**
     * Http请求post方法转为结果是：字符串结果
     *
     * @param url  请求参数路径
     * @param json json结构的传输信息数据
     * @return
     */
    @Override
    public JSONObject httpPost2Str(String url, JSONObject json) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        Request request = new Request.Builder().url(url).post(httpBody).build();
        try {
            DefaultCallback callBack = new DefaultCallback("string");
            client.newCall(request).enqueue(callBack);
            return callBack.resultObject;
        } catch (Exception e) {
            logger.error("执行请求失败", e);
        }
        return null;
    }


    @Override
    public JSONObject httpPost2StrHeaders(String url, JSONObject json, Map<String, String> headers) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        final Request.Builder builder = new Request.Builder().url(url).post(httpBody);

        for (Map.Entry<String, String> entry : headers.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue().toString()); //将请求头以键值对形式添加，可添加多个请求头
        }
        final Request request = builder.build();
        try {
            DefaultCallback callBack = new DefaultCallback("string");
            client.newCall(request).enqueue(callBack);
            return callBack.resultObject;
        } catch (Exception e) {
            logger.error("执行请求失败", e);
        }
        return null;
    }


    @Override
    public JSONObject httpPost2Stream(String url, JSONObject json) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        Request request = new Request.Builder().url(url).post(httpBody).build();
        try {
            DefaultCallback callBack = new DefaultCallback("stream");
            client.newCall(request).enqueue(callBack);
            return callBack.resultObject;
        } catch (Exception e) {
            logger.error("执行请求失败", e);
        }
        return null;
    }


    @Override
    public JSONObject httpPost2Stream(String url, Map<String, String> paramPair) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> element : paramPair.entrySet()) {
            builder.add(element.getKey(), element.getValue());
        }
        httpBody = builder.build();
        Request request = new Request.Builder().url(url).post(httpBody).build();
        try {
            DefaultCallback callBack = new DefaultCallback("stream");
            client.newCall(request).enqueue(callBack);
            return callBack.resultObject;
        } catch (Exception e) {
            logger.error("请求失败!", e);
        }
        return null;
    }


    @Override
    public JSONObject httpPost2Str(String url, Map<String, String> paramPair) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        HttpResult result = new HttpResult();
        for (Map.Entry<String, String> element : paramPair.entrySet()) {
            builder.add(element.getKey(), element.getValue());
        }
        httpBody = builder.build();
        Request request = new Request.Builder().url(url).post(httpBody).build();
        try {
            DefaultCallback callBack = new DefaultCallback("string");
            client.newCall(request).enqueue(callBack);
            return callBack.resultObject;
        } catch (Exception e) {
            logger.error("请求失败!", e);
        }
        return null;
    }

    @Override
    public JSONObject httpPost2StrHeaders(String url, Map<String, Object> paramPair, Map<String, Object> headers) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        HttpResult result = new HttpResult();
        for (Map.Entry<String, Object> element : paramPair.entrySet()) {
            builder.add(element.getKey(), element.getValue().toString());
        }
        httpBody = builder.build();
        //Request request = new Request.Builder().url(url).post(httpBody).build();
        final Request.Builder builderHeader = new Request.Builder().url(url).post(httpBody);

        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            builderHeader.addHeader(entry.getKey(), entry.getValue().toString()); //将请求头以键值对形式添加，可添加多个请求头
        }
        final Request request = builderHeader.build();

        try {
            DefaultCallback callBack = new DefaultCallback("string");
            client.newCall(request).enqueue(callBack);
            return callBack.resultObject;
        } catch (Exception e) {
            logger.error("请求失败!", e);
        }
        return null;
    }

    @Override
    public JSONObject httpPostSteamHeaders(String url, JSONObject json, Map<String, Object> headers) {
        if (client == null) {
            client = new OkHttpClient();
        }
        FormBody.Builder builder = new FormBody.Builder();
        HttpResult result = new HttpResult();
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        final Request.Builder builderHeader = new Request.Builder().url(url).post(httpBody);
        builderHeader.removeHeader("Content-Type");
        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            builderHeader.addHeader(entry.getKey(), entry.getValue().toString()); //将请求头以键值对形式添加，可添加多个请求头
        }
        final Request request = builderHeader.build();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject httpPostFile(String url, File file, String fileName, Map<String, String> params) {
        if (client == null) {
            client = new OkHttpClient();
        }
        //MultipartBody多功能的请求实体对象,,,formBody只能传表单形式的数据
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        //参数
        if (params != null) {
            for (String key : params.keySet()) {
                builder.addFormDataPart(key, params.get(key));
            }
        }

        HttpResult result = new HttpResult();
        //文件...参数name指的是请求路径中所接受的参数...如果路径接收参数键值是fileeeee,//此处应该改变
        builder.addFormDataPart("file", fileName, RequestBody.create
                (MediaType.parse("application/octet-stream"), file));
        //构建
        MultipartBody multipartBody = builder.build();
        //创建Request
        Request request = new Request.Builder().url(url).post(multipartBody).build();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JSONObject httpPost2Str(String url, String param) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), param);
        Request.Builder builder = new Request.Builder().url(url).post(body);
        Request request = builder.build();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}