package com.eric.grace.utils.okhttp.bean;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import okhttp3.Headers;

import java.io.InputStream;
import java.io.Serializable;

/**
 * HttpResult: http请求result结果对象
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:22
 */
public class HttpResult implements Serializable {

    private static final long serialVersionUID = -3856456949360850611L;

    //标志：success/failure
    private String status;
    //http返回编码
    private String code;
    //返回结果流
    private InputStream resultStream;
    //返回结果数组
    private byte[] resultBytes;
    //返回结果字符串
    private String resultStr;
    //headers服务
    private Headers headers;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public InputStream getResultStream() {
        return resultStream;
    }

    public void setResultStream(InputStream resultStream) {
        this.resultStream = resultStream;
    }

    public byte[] getResultBytes() {
        return resultBytes;
    }

    public void setResultBytes(byte[] resultBytes) {
        this.resultBytes = resultBytes;
    }

    public String getResultStr() {
        return resultStr;
    }

    public void setResultStr(String resultStr) {
        this.resultStr = resultStr;
    }

    public Headers getHeaders() {
        return headers;
    }

    public void setHeaders(Headers headers) {
        this.headers = headers;
    }


    /*
	QuoteFieldNames———-输出key时是否使用双引号,默认为true
	WriteMapNullValue——–是否输出值为null的字段,默认为false
	WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
	WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
	WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
	WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null
	*/


    /**
     * 成功返回数据结果
     * @return
     */
    public JSONObject buildSuccess(){
        this.status = "success";
        this.code = (code == null || code.length() == 0)?"200":code;
        return JSONObject.parseObject(JSONObject.toJSONString(this, SerializerFeature.WriteMapNullValue));
    }


    /**
     * 失败返回结果
     * @return
     */
    public JSONObject buildFailure(){
        this.status = "failure";
        this.code = (code == null || code.length() == 0)?"500":code;
        return JSONObject.parseObject(JSONObject.toJSONString(this,SerializerFeature.WriteMapNullValue));
    }

}