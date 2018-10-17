package com.eric.grace.utils.okhttp.callback;

import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.okhttp.bean.HttpResult;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * DefaultCallback: 公共管理操作回调函数方法，进行管理控制异步方法回调函数
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:29
 */
public final class DefaultCallback implements Callback {

    private static final Logger logger = LoggerFactory.getLogger(DefaultCallback.class);


    public JSONObject resultObject;

    private String type;//传输的类型：string字符串、stream流


    private DefaultCallback() {
    }

    public DefaultCallback(String type) {
        this.type = type;
    }


    @Override
    public void onFailure(Call call, IOException e) {
        logger.error("异步方法调用OKHttp请求服务失败!",e);
    }


    @Override
    public void onResponse(Call call, Response response) throws IOException {
        //初始化返回类型服务操作
        HttpResult result = new HttpResult();
        //判断校验服务操作
        if(response.isSuccessful())
        {
            logger.info("异步操作回调成功:"+response.message());
            result.setCode(String.valueOf(response.code()));
            switch(type)
            {
                case "stream":result.setResultStr(response.body().string());break;
                case "string":result.setResultStream(response.body().byteStream());break;
            }
            result.setHeaders(response.headers());
            resultObject = result.buildSuccess();

        }
        else
        {
            logger.warn("异步操作回调出现异常！,"+response.message());
            result.setCode(String.valueOf(response.code()));
            switch(type)
            {
                case "stream":result.setResultStr(response.body().string());break;
                case "string":result.setResultStream(response.body().byteStream());break;
            }
            result.setHeaders(response.headers());
            result.buildFailure();
            resultObject = resultObject;
        }
    }

}