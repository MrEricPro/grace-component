package com.eric.grace.test.utils;

import com.eric.grace.utils.common.CharsetUtil;
import com.eric.grace.utils.common.HexUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * HexUtilTest:
 *
 * @author: MrServer
 * @since: 2017/12/28 下午1:53
 */
public class HexUtilTest {


    @Test
    public void hexStrTest(){
        String str = "我是一个字符串";

        String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
        String decodedStr = HexUtil.decodeHexStr(hex);

        System.out.println(hex);
        System.out.println(decodedStr);
        Assert.assertEquals(str, decodedStr);
    }

}