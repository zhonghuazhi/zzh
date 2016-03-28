package org.smart4j.chapter1;

import org.apache.commons.net.ftp.FTPClient;

/**
 * Created by zhonghua on 15/10/28.
 */
public class Test {

    public static void main(String[] args) throws Exception{

        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("",21);
    }
}
