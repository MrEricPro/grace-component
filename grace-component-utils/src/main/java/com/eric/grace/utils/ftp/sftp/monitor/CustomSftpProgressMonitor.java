package com.eric.grace.utils.ftp.sftp.monitor;

import com.jcraft.jsch.SftpProgressMonitor;

/**
 * CustomSftpProgressMonitor: 对传输进度的监控。
 *
 * @author: MrServer
 * @since: 2018/1/12 下午3:24
 */
public class CustomSftpProgressMonitor implements SftpProgressMonitor {
    private long transfered;

    @Override
    public boolean count(long count) {
        transfered = transfered + count;
        System.out.println("Currently transferred total size: " + transfered + " bytes");
        return true;
    }

    @Override
    public void end() {
        System.out.println("Transferring done.");
    }

    @Override
    public void init(int op, String src, String dest, long max) {
        System.out.println("Transferring begin.");
    }

}