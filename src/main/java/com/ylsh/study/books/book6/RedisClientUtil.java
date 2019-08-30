package com.ylsh.study.books.book6;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class RedisClientUtil {

    /*redis.sentinels=redis.uat.chunbo.com:26380
    redis.mastername=mymaster
    redis.password=
    redis.timeout=100000
    redis.dbindex=1*/

//    redis.sentinels=bredis.chunbo.com:26380
//    redis.mastername=mymaster
//    redis.password=
//    redis.timeout=100000
//    redis.dbindex=8

//    public static final String sentinels = "redis.uat.chunbo.com:26380";
//    public static final String sentinels = "bredis.chunbo.com:26380";
public static final String sentinels = "redis.uat.chunbo.com:26381";//stock
    public static final String mastername = "mymaster";

    public static final String password = null;

    public static int timeout = 10000;

    public static int dbindex = 0;



    public static JedisSentinelPool getPool(){
        Set<String> t_sentinels  = new HashSet<String>();
        t_sentinels.add(sentinels);
        JedisSentinelPool pool = new JedisSentinelPool(mastername, t_sentinels, new GenericObjectPoolConfig(), timeout, (String)null, dbindex);
        return pool;
    }

    public static Jedis getJedis(){
        JedisSentinelPool pool = getPool();
        Jedis jedis = pool.getResource();
        return jedis;
    }


    public static void main(String[] args) {
        JedisSentinelPool pool = getPool();
        Jedis jedis = pool.getResource();

        String str =  jedis.get("1004026_5_1");
        System.out.println(str);
//        jedis.set("hello","world");
//        String value = jedis.get("hello");
//        jedis.del("hello");
//        System.out.println(value);
        pool.close();
    }
}

