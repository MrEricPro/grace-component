package com.eric.grace.utils.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.eric.grace.utils.common.StrUtil;
import com.eric.grace.utils.exceptions.FtpException;
import com.eric.grace.utils.io.IoUtil;
import com.eric.grace.utils.setting.dialect.Props;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * FTPUtil:
 *
 * @author: MrServer
 * @since: 2018/1/12 下午2:41
 */
public class FTPUtil {

    /**
     * 默认端口
     */
    private final static int DEFAULT_PORT = 21;

    private final static String HOST = "host";

    private final static String PORT = "port";

    private final static String USER_NAME = "userName";

    private final static String PASSWORD = "password";

    /**
     * 默认配置文件路径
     */
    private final static String FTP_CONFIG_PATH = "ftpConfig.properties";

    /**
     * ftpClient
     */
    private FTPClient ftpClient;

    /**
     * 服务端保存的文件名
     */
    private String remote;

    /**
     * 服务端保存的路径
     */
    private String remotePath;

    /**
     * 本地文件
     */
    private File local;

    /**
     * 主机地址
     */
    private String host;

    /**
     * 端口
     */
    private int port = DEFAULT_PORT;

    /**
     * 登录名
     */
    private String userName;

    /**
     * 登录密码
     */
    private String password;

    private static final Map<String, String> replyCodeMap;

    static {
        replyCodeMap = new HashMap<String, String>();
        replyCodeMap.put("530", "登录错误");
        replyCodeMap.put("550", "权限不足");
    }

    public interface FTPAction {
        boolean action(FTPClient ftpClient) throws Exception;
    }

    public void execute(FTPAction ftpAction) {
        try {
            boolean success = ftpAction.action(ftpClient);
            if (!success) {
                int replyCode = ftpClient.getReplyCode();
                String reply = ftpClient.getReplyString();
                if (!FTPReply.isPositiveCompletion(replyCode)) {
                    throw new FtpException(reply);
                }
            }
        } catch (ConnectException e) {
            throw new FtpException("连接到服务器" + host + ":" + port + "失败," + e.getMessage());
        } catch (Exception e) {
            throw new FtpException(e);
        }
    }


    /**
     * <pre>
     * 默认读取classpath:ftpconfig.propertis
     * 的信息
     * 用户自行配置
     * host:host
     * port:port
     * userName:userName
     * password:password
     * </pre>
     */
    public FTPUtil() {
        this.init(FTP_CONFIG_PATH);
    }

    public FTPUtil(String host, int port, String userName, String password) {
        this.init(host, port, userName, password);
    }

    public FTPUtil(Properties prop) {
        this.init(prop);
    }

    /**
     * @param configPath classpath路径
     */
    public FTPUtil(String configPath) {
        this.init(configPath);
    }

    /**
     * 初始化
     */
    private void init(Properties prop) {
        init(prop.getProperty(HOST),
                Integer.parseInt(prop.getProperty(PORT)),
                prop.getProperty(USER_NAME),
                prop.getProperty(PASSWORD));
    }


    /**
     * 初始化
     *
     * @param host
     * @param port
     * @param userName
     * @param password
     */
    private void init(String host, int port, String userName, String password) {
        this.host = host;
        this.port = port;
        this.userName = userName;
        this.password = password;
    }

    private void init(String configPath) {
        this.init(Props.getProp(configPath));
    }

    /**
     * 连接ftp
     */
    private void ftpConnect() {
        execute(new FTPAction() {
            @Override
            public boolean action(FTPClient ftpClient) throws Exception {
                ftpClient.connect(host, port);
                return true;
            }
        });
    }

    /**
     * 登录
     */
    private void ftpLogin() {
        execute(new FTPAction() {
            @Override
            public boolean action(FTPClient ftpClient) throws Exception {
                return ftpClient.login(userName, password);
            }
        });
    }

    private void ftpSetFileType() {
        execute(new FTPAction() {
            @Override
            public boolean action(FTPClient ftpClient) throws Exception {
                return ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            }
        });
    }

    private void ftpChangeWorkingDirectory() {
        execute(new FTPAction() {
            @Override
            public boolean action(FTPClient ftpClient) throws Exception {
                return ftpClient.changeWorkingDirectory(remotePath);
            }
        });
    }

    private void ftpRetrieveFile(final FileOutputStream output) {
        execute(new FTPAction() {
            @Override
            public boolean action(FTPClient ftpClient) throws Exception {
                return ftpClient.retrieveFile(remote, output);
            }
        });
    }

    private void ftpStoreFile(final FileInputStream fis) {
        execute(new FTPAction() {
            @Override
            public boolean action(FTPClient ftpClient) throws Exception {
                return ftpClient.storeFile(remote, fis);
            }
        });
    }

    /**
     * 连接ftp服务器
     *
     * @throws Exception
     */
    private void connect() throws SocketException, IOException {
        validateConnectInfo();
        ftpClient = new FTPClient();
        ftpConnect();
        ftpLogin();
        ftpSetFileType();
    }

    /**
     * 验证连接信息
     */
    private void validateConnectInfo() {
        if (StrUtil.isEmpty(host)) {
            throw new FtpException("host不能为空");
        }
        if (StrUtil.isEmpty(userName)) {
            throw new FtpException("userName不能为空");
        }
        if (StrUtil.isEmpty(password)) {
            throw new FtpException("password不能为空");
        }
    }

    /**
     * 断开连接
     */
    private void disconnect() {
        try {
            ftpClient.disconnect();
        } catch (Exception e) {
            throw new FtpException(e);
        }
    }


    /**
     * 下载文件
     */
    public void download() {
        FileOutputStream output = null;
        try {
            this.connect();
            if (!StrUtil.isEmpty(remotePath)) {
                ftpChangeWorkingDirectory();
            }
            output = new FileOutputStream(local);
            ftpRetrieveFile(output);
            output.flush();
        } catch (Exception e) {
            throw new FtpException(e);
        } finally {
            IoUtil.close(output);
            this.disconnect();
        }
    }

    /**
     * 上传文件
     */
    public void upload() {
        FileInputStream fis = null;
        try {
            this.connect();
            fis = new FileInputStream(local);
            if (!StrUtil.isEmpty(remotePath)) {
                ftpChangeWorkingDirectory();
            }
            if (StrUtil.isEmpty(remote)) {
                remote = local.getName();
            }
            ftpStoreFile(fis);
        } catch (Exception e) {
            throw new FtpException(e);
        } finally {
            this.disconnect();
            IoUtil.close(fis);
        }
    }

    /**
     * 服务端保存的路径
     * 如果不设置此值，将会默认为用户登录之后的路径
     */
    public void setRemotePath(String remotePath) {
        this.remotePath = remotePath;
    }

    /**
     * 服务端保存的文件名
     * 如果不设置此值，将会默认为本地文件的文件名
     */
    public void setRemote(String remote) {
        this.remote = remote;
    }

    /**
     * 本地文件
     */
    public void setLocal(File local) {
        this.local = local;
    }


}