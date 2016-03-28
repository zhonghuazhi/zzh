package com.boco.redis.test;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhonghua on 15/12/9.
 */
public class Check {

    public static void main(String[] args) {


        String url = "http://120.131.2.119:9081/nais/index1.jsp";
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(1000);

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                System.out.println("ok");
            } else {
                System.out.println("error");
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if(null != connection){
                System.out.println("AAAAAA");
                connection.disconnect();
            }
        }


    }
}
