package com.boco.redis.test;

import redis.clients.jedis.Jedis;

/**
 * Created by zhonghua on 15/11/26.
 */
public class TestRedis {


    public static void main(String[] args) throws Exception {

        Jedis jedis = new Jedis("127.0.0.1", 6379);
    }
}