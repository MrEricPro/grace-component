package com.eric.grace.utils.okhttp.media;
import okhttp3.MediaType;
/**
 * HttpMedia: Http 请求response 相应服务请求体
 *
 * @author: MrServer
 * @since: 2017/12/25 下午2:46
 */
public enum HttpMedia {


    //json格式
    MEDIA_JSON("application/json;charset=utf-8"),

    //xml格式
    MEDIA_XML("application/xml;charset=utf-8"),

    //text文本格式
    MEDIA_HTML("text/html;charset=utf-8"),

    //文件流传输操作
    MEDIA_STREAM("application/octet-stream");


    private String mediaValue;


    private HttpMedia(String mediaValue) {
        this.mediaValue = mediaValue;
    }

    public MediaType getMediaValue() {
        return MediaType.parse(mediaValue);
    }

    public void setMediaValue(String mediaValue) {
        this.mediaValue = mediaValue;
    }

}
