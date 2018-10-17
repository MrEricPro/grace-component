package com.eric.grace.test.okhttp;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.eric.grace.utils.codec.Base64;
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
public class TestHttp extends TestCase {


    //商家公钥
    private static final String CUSTOMER_PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDMVMYjWGXLrWRwiYknCTQswVnQDrPon3R7VAFTPpe+X1aiJm7DRU/ZnnwJ8UN7EHRKNSs3LrFLlHstVZnhIoGV4EY9dGeoc2mSpgzoZwEMMHvTWZ8EHNjhsRAJsQPwZXH4giiCS6Zs1GKeWHa8kVPI25Kk310chbqqpOHkR2xCyQIDAQAB";

    //PHKJ;
    private static final String OWNER_PUB_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCJ77tV3JWcu+YZGAtIPOrZ+x0VYaHZeslEh0HIDAaUsIIhpJF4TyIcGZHxk6A6jP76JlF8rPDfbwAAaGawMVNkORbwk0s+Vu0R+XR/iqND3plv659LBNPgXyYEq1sQjkLaHrLPPgnT5WDi7s3E7XX97trySlV0jLE/Oht4r901iQIDAQAB";
    private static final String OWNER_PRI_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAInvu1XclZy75hkYC0g86tn7HRVhodl6yUSHQcgMBpSwgiGkkXhPIhwZkfGToDqM/vomUXys8N9vAABoZrAxU2Q5FvCTSz5W7RH5dH+Ko0PemW/rn0sE0+BfJgSrWxCOQtoess8+CdPlYOLuzcTtdf3u2vJKVXSMsT86G3iv3TWJAgMBAAECgYAJwV2zbd1a72MPpUau/jfx4LOm3nfO5MM1SIebeVZBz9X0QSpUouwbpqdOuY0cdvpVgL5EngqPEs+iN8ADeAmYs2YqVu3cnVnM/pmujnAJ+XoK03o5in7KsAOWCqgUTPUUP/ciogcJoFRfK51p52ceaBQVolMyMWuPTl+wIrZIsQJBAMDGqAKIVlLPMtFRAml0xp/mCd0qnGnIblHCqm3RIeR+4FvirYkhhn9581jFuimjzXtnyBpPzrqejO1lfSsnWw0CQQC3LMikojv09c86U+slIBsuBRHo1wySFCl8/yig8xijLAVpl5iq0XSXqoouVC2gXGPcaywK+Id21/HgEepf2PVtAkEAlGpdf1Wn4ClVXoGX8cjOAt0ASx47PdXp2VieDd4s0dY8tYFXSXReMFabW4UfRl+uG4xTKq624kafCUZRj5/FIQJAeNR62lcGU/VeKGy4/XlrVHUVtlE9QpM4NvMd+uXBB8n/HANbOrsGPRHLKvpuSo0HdpvfprEAsv2J2TQYNfepFQJAHCuhB7fBfZ0KBgZzlp3aQ1rJKp/r8f9KFxQSLVkGA9YjqAtU6ljmCCTNhUjwq2aG7MqS5P9oqaVA23anFoDCOA==";




    public static void main(String args[]){


        String json = "{\n" +
                "    'transaction': {\n" +
                "        'TAG': 'Transaction',\n" +
                "        'body': {\n" +
                "            'request': {\n" +
                "                'prodNo':'10002',\n" +
                "                'loanPric':'2000',\n" +
                "                'isInsuuance':'000001',\n" +
                "                'isAttach':'000001',\n" +
                "                'staffId':'20050001'\n" +
                "\n" +
                "            }\n" +
                "        },\n" +
                "        'header': {\n" +
                "            'msg': {\n" +
                "                'rcvAppCd': '',\n" +
                "                'seqNb': '001',\n" +
                "                'sndAppCd': 'APP',\n" +
                "                'sndDt': '20170622',\n" +
                "                'sndTm': '111202897'\n" +
                "            },\n" +
                "            'status': '',\n" +
                "            'ver': '1'\n" +
                "        }\n" +
                "    }\n" +
                "}";

        String url = "http://test1.phkjcredit.com/pcl/services/rest/appLoanInfo/queryComp";
        Map<String,Object> maps = new HashMap<>();
        maps.put("Content-Type","application/json");
        JSONObject jsonObject = OkHttpUtil.httpPostSteamHeaders(url, JSON.parseObject(json),maps);
        System.out.println(jsonObject.toJSONString());

    }

}