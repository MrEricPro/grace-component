package com.eric.grace.utils.okhttp.sync;

import com.eric.grace.utils.okhttp.bean.HttpResult;
import com.eric.grace.utils.okhttp.build.OkHttpClientBuilder;
import com.eric.grace.utils.okhttp.media.HttpMedia;
import okhttp3.OkHttpClient;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.util.IOUtils;




/**
 * HttpFileUtil: http请求库 文件上传下载操作
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:55
 */
public class HttpFileUtil {

    private OkHttpClient client = null;

    protected void buildClient() {
        client = new OkHttpClientBuilder().build();
    }


    protected void buildClient(int connectTimeout,int readTimeout,int writeTimeout) {
        client = new OkHttpClientBuilder().build(connectTimeout,readTimeout,writeTimeout);
    }


    public JSONObject uploadFile(String url,File file) throws IOException{
        RequestBody fileBody = RequestBody.create(HttpMedia.MEDIA_STREAM.getMediaValue(),file);
        RequestBody requestBody = new MultipartBody.Builder().addFormDataPart("filename", file.getName(),fileBody).build();
        HttpResult result = new HttpResult();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful())
        {
            result.setCode(String.valueOf(response.code()));
            result.setResultStream(response.body().byteStream());
            result.setHeaders(response.headers());
            return result.buildSuccess();
        }
        else
        {
            result.setCode(String.valueOf(response.code()));
            result.setResultStream(response.body().byteStream());
            result.setHeaders(response.headers());
            return result.buildFailure();
        }
    }


    public JSONObject uploadFile(String url,InputStream is) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        int temp = 0;
        byte[] buffer = new byte[1024*2];//2k
        while((temp = is.read(buffer)) > 0)
        {
            bos.write(buffer);
        }
        RequestBody fileBody = RequestBody.create(HttpMedia.MEDIA_STREAM.getMediaValue(),bos.toByteArray());
        IOUtils.close(bos);
        IOUtils.close(is);
        RequestBody requestBody = new MultipartBody.Builder().addFormDataPart("filename", UUID.randomUUID().toString(),fileBody).build();
        HttpResult result = new HttpResult();
        Request request = new Request.Builder().url(url).post(requestBody).build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful())
        {
            result.setCode(String.valueOf(response.code()));
            result.setResultStream(response.body().byteStream());
            result.setHeaders(response.headers());
            return result.buildSuccess();
        }
        else
        {
            result.setCode(String.valueOf(response.code()));
            result.setResultStream(response.body().byteStream());
            result.setHeaders(response.headers());
            return result.buildFailure();
        }
    }
}