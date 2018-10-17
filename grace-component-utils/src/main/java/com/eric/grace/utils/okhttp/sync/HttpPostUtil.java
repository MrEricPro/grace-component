package com.eric.grace.utils.okhttp.sync;

import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.okhttp.base.AbstractHttpPost;
import com.eric.grace.utils.okhttp.bean.HttpResult;
import com.eric.grace.utils.okhttp.media.HttpMedia;
import okhttp3.*;
import okhttp3.internal.framed.Header;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * HttpPostUtil:
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:59
 */
public class HttpPostUtil extends AbstractHttpPost {


    public JSONObject httpPost2Str(String url, JSONObject json) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        Request request = new Request.Builder().url(url).post(httpBody).build();
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
        }
        return null;
    }


    public JSONObject httpPost2StrHeaders(String url, JSONObject json,Map<String,String> header) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        final Request.Builder builderHeader = new Request.Builder().url(url).post(httpBody);
        for (Map.Entry<String, String> entry : header.entrySet()) {
            builderHeader.addHeader(entry.getKey(), entry.getValue().toString()); //将请求头以键值对形式添加，可添加多个请求头
        }
        final Request request = builderHeader.build();
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
        }
        return null;
    }







    public JSONObject httpPost2Stream(String url, JSONObject json) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        Request request = new Request.Builder().url(url).post(httpBody).build();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public JSONObject httpPost2Stream(String url, Map<String, String> paramPair) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        for (Entry<String, String> element : paramPair.entrySet()) {
            builder.add(element.getKey(), element.getValue());
        }
        httpBody = builder.build();
        HttpResult result = new HttpResult();
        Request request = new Request.Builder().url(url).post(httpBody).build();
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }


    public JSONObject httpPost2Str(String url, Map<String, String> paramPair) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        HttpResult result = new HttpResult();
        for (Entry<String, String> element : paramPair.entrySet()) {
            builder.add(element.getKey(), element.getValue());
        }
        httpBody = builder.build();
        Request request = new Request.Builder().url(url).post(httpBody).build();
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
    public JSONObject httpPost2StrHeaders(String url, Map<String, Object> paramPair, Map<String, Object> headers) {
        if (client == null) {
            client = new OkHttpClient();
        }
        RequestBody httpBody = null;
        FormBody.Builder builder = new FormBody.Builder();
        HttpResult result = new HttpResult();
        for (Entry<String, Object> element : paramPair.entrySet()) {
            builder.add(element.getKey(), element.getValue().toString());
        }
        httpBody = builder.build();
       // Request request = new Request.Builder().url(url).post(httpBody).build();
        final Request.Builder builderHeader = new Request.Builder().url(url).post(httpBody);
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


    public JSONObject httpPostSteamHeaders(String url, JSONObject json, Map<String, Object> headers) {
        if (client == null) {
            client = new OkHttpClient();
        }
        FormBody.Builder builder = new FormBody.Builder();
        HttpResult result = new HttpResult();
        RequestBody httpBody = RequestBody.create(HttpMedia.MEDIA_JSON.getMediaValue(), json.toJSONString());
        final Request.Builder builderHeader = new Request.Builder().url(url).post(httpBody);

        for (Map.Entry<String, Object> entry : headers.entrySet()) {
            builderHeader.addHeader(entry.getKey(), entry.getValue().toString()); //将请求头以键值对形式添加，可添加多个请求头
        }
        builderHeader.removeHeader("Content-Type");
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
        if (params != null){
            for (String key : params.keySet()){
                builder.addFormDataPart(key,params.get(key));
            }
        }

        HttpResult result = new HttpResult();
        //文件...参数name指的是请求路径中所接受的参数...如果路径接收参数键值是fileeeee,//此处应该改变
        builder.addFormDataPart("file",fileName,RequestBody.create
                (MediaType.parse("application/octet-stream"),file));
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
        Request.Builder builder =  new Request.Builder().url(url).post(body);
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