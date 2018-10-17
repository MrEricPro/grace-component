package com.eric.grace.test.ftp;

import com.eric.grace.utils.ftp.sftp.SftpUtil;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;


/**
 * SftpTest:
 *
 * @author: MrServer
 * @since: 2018/1/15 上午11:29
 */
public class SftpTest {


    public static void main(String[] args) throws JSchException {

        for (int i = 0; i <= 100; i++) {
            ChannelSftp sftp = SftpUtil.getSftpConnect("config/test/sftp.properties");
            System.out.println(sftp);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            SftpUtil.exit(sftp);
        }
//            try {
//
//                System.out.println(i);
//                SftpUtil.uploadFile("/Users/eric/Desktop/test1111.csv", "/opt/sftp/puhui/", "test--" + i + ".csv", sftp);
//                // System.out.println(SftpUtil.uploadFile("/Users/eric/Desktop/test1111.csv",sftp));
//                //  SftpUtil.rmFile("test--"+i+".csv",sftp);
//
//
//                //  SftpUtil.rmFile("test1111.csv",sftp);
////            SftpUtil.uploadFile("/Users/eric/Desktop/test.csv","/opt/sftp/puhui/hahah/","1242xs.csv",sftp);
//
////                SftpUtil.exeRmRec("/opt/sftp/puhui/test", sftp);
////                SftpUtil.exeRmRec("/opt/sftp/puhui/test2", sftp);
//
////            SftpUtil.download("/test/test.csv","/Users/eric/Desktop/ok.csv",sftp);
//
//            } catch (Exception e) {
//                // SftpUtil.exit(sftp);
//                e.printStackTrace();
//            }
////            sftp.quit();
//            //           sftp.disconnect();
////            sftp.getSession().disconnect();
//
//        }
//        SftpUtil.exit(sftp);

//        try {
//             SftpUtil.download("mj20180209161434837368.csv","/Users/eric/Desktop/mj20180209161434837368.csv",sftp);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }


}