package com.eric.grace.test.utils;

import com.eric.grace.utils.common.NetUtil;
import com.eric.grace.utils.common.ReUtil;
import com.eric.grace.utils.lang.PatternPool;
import org.junit.Assert;
import org.junit.Test;

import java.net.InetAddress;

/**
 * NetUtilTest:
 *
 * @author: MrServer
 * @since: 2017/12/28 下午1:55
 */
public class NetUtilTest {


    @Test
    public void getLocalhostTest(){
        InetAddress localhost = NetUtil.getLocalhost();
        Assert.assertNotNull(localhost);
    }

    @Test
    public void getLocalMacAddressTest(){
        String macAddress = NetUtil.getLocalMacAddress();
        Assert.assertNotNull(macAddress);

        //验证MAC地址正确
        boolean match = ReUtil.isMatch(PatternPool.MAC_ADDRESS, macAddress);
        Assert.assertTrue(match);
    }

    @Test
    public void longToIpTest() {
        String ipv4 = NetUtil.longToIpv4(2130706433L);
        Assert.assertEquals("127.0.0.1", ipv4);
    }

    @Test
    public void ipToLongTest() {
        long ipLong = NetUtil.ipv4ToLong("127.0.0.1");
        Assert.assertEquals(2130706433L, ipLong);
    }

}