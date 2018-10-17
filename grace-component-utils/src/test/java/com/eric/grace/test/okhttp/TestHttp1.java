package com.eric.grace.test.okhttp;


import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.common.CharsetUtil;
import com.eric.grace.utils.common.StrUtil;
import com.eric.grace.utils.crypto.asymmetric.KeyType;
import com.eric.grace.utils.crypto.asymmetric.RSA;
import com.eric.grace.utils.date.DatePattern;
import com.eric.grace.utils.date.DateUtil;
import com.eric.grace.utils.okhttp.exec.OkHttpUtil;
import com.eric.grace.utils.okhttp.sync.HttpRequestUtil;
import junit.framework.TestCase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TestHttp:
 *
 * @author: MrServer
 * @since: 2017/12/25 下午3:08
 */
public class TestHttp1 extends TestCase {


    //商家公钥
    private static final String CUSTOMER_PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMVMYjWGXLrWRwiYknCTQswVnQDrPon3R7VAFTPpe+X1aiJm7DRU/ZnnwJ8UN7EHRKNSs3LrFLlHstVZnhIoGV4EY9dGeoc2mSpgzoZwEMMHvTWZ8EHNjhsRAJsQPwZXH4giiCS6Zs1GKeWHa8kVPI25Kk310chbqqpOHkR2xCyQIDAQAB";

    //PHKJ;
    private static final String OWNER_PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJ77tV3JWcu+YZGAtIPOrZ+x0VYaHZeslEh0HIDAaUsIIhpJF4TyIcGZHxk6A6jP76JlF8rPDfbwAAaGawMVNkORbwk0s+Vu0R+XR/iqND3plv659LBNPgXyYEq1sQjkLaHrLPPgnT5WDi7s3E7XX97trySlV0jLE/Oht4r901iQIDAQAB";
    private static final String OWNER_PRI_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAInvu1XclZy75hkYC0g86tn7HRVhodl6yUSHQcgMBpSwgiGkkXhPIhwZkfGToDqM/vomUXys8N9vAABoZrAxU2Q5FvCTSz5W7RH5dH+Ko0PemW/rn0sE0+BfJgSrWxCOQtoess8+CdPlYOLuzcTtdf3u2vJKVXSMsT86G3iv3TWJAgMBAAECgYAJwV2zbd1a72MPpUau/jfx4LOm3nfO5MM1SIebeVZBz9X0QSpUouwbpqdOuY0cdvpVgL5EngqPEs+iN8ADeAmYs2YqVu3cnVnM/pmujnAJ+XoK03o5in7KsAOWCqgUTPUUP/ciogcJoFRfK51p52ceaBQVolMyMWuPTl+wIrZIsQJBAMDGqAKIVlLPMtFRAml0xp/mCd0qnGnIblHCqm3RIeR+4FvirYkhhn9581jFuimjzXtnyBpPzrqejO1lfSsnWw0CQQC3LMikojv09c86U+slIBsuBRHo1wySFCl8/yig8xijLAVpl5iq0XSXqoouVC2gXGPcaywK+Id21/HgEepf2PVtAkEAlGpdf1Wn4ClVXoGX8cjOAt0ASx47PdXp2VieDd4s0dY8tYFXSXReMFabW4UfRl+uG4xTKq624kafCUZRj5/FIQJAeNR62lcGU/VeKGy4/XlrVHUVtlE9QpM4NvMd+uXBB8n/HANbOrsGPRHLKvpuSo0HdpvfprEAsv2J2TQYNfepFQJAHCuhB7fBfZ0KBgZzlp3aQ1rJKp/r8f9KFxQSLVkGA9YjqAtU6ljmCCTNhUjwq2aG7MqS5P9oqaVA23anFoDCOA==";


    public void testMethodPost() {
        // 请求发送短信验证码
        String url = "http://122.224.156.194:18082/borrower/account/sendCode.json";

        String sendTime = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_MS_PATTERN);
        String from = "aladingbank";
        String mobile = "15558586969";

        StringBuffer sb = new StringBuffer(mobile).append(from).append(sendTime);
        //String sign = from+mobile+idNo+sendTime;
        //普惠私钥加密
        RSA rsa = new RSA(OWNER_PRI_KEY, null);
        byte[] encrypt = rsa.encrypt(StrUtil.bytes(sb.toString(), CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);

        System.out.println(StrUtil.str(encrypt, CharsetUtil.CHARSET_UTF_8));

//        // 钱掌柜 公钥解密
//        RSA rsa1 = new RSA(null, OWNER_PUB_KEY);
//        byte[] decrypt = rsa1.decrypt(encrypt, KeyType.PublicKey);
//        System.out.println(StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));

        Map<String, String> params = new HashMap<>();
        params.put("sendTime", sendTime);
        params.put("from", from);
        params.put("mobile", mobile);
        params.put("sign", StrUtil.str(encrypt, CharsetUtil.CHARSET_UTF_8));

        JSONObject jsonObject = OkHttpUtil.postContent(url,params);
        System.out.println("-------");
     //   JSONObject jsonObject = HttpRequestUtil.getInstance().buildPostClient(5, 5, 5).httpPost2Str(url, params);

        System.out.println(jsonObject.get("resultStr").toString());
        //对钱掌柜请求结果解密
//        RSA qzg = new RSA(null, CUSTOMER_PUB_KEY);
//
//        byte[] decrypt = qzg.decrypt(jsonObject.toString().getBytes(), KeyType.PublicKey);
//        String result = StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8);
//        System.out.println(JSONObject.toJSONString(result));





//        Map<String,String> header = new HashMap<>();
//        header.put("Authorization","bearer 61797f9b47f9b0a24a82c4562541168b");
//        JSONObject json1 = OkAsyncHttpUtils.httpPost2StrHeaders(url, JSON.parseObject(JSON.toJSON(params).toString()),header);
//        System.out.println("-------"+json1);
//        JSONObject json =  OkHttpUtil.httpPost2StrHeaders(url, JSON.parseObject(JSON.toJSON(params).toString()),header);
//        System.out.println(json.get("resultStr"));


    }

}