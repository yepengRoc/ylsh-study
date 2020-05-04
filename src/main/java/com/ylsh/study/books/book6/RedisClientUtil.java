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
    public static final String sentinels = "bredis.chunbo.com:26380";
//public static final String sentinels = "redis.uat.chunbo.com:26381";//stock
    public static final String mastername = "mymaster";

    public static final String password = null;

    public static int timeout = 10000;

    public static int dbindex = 9;



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


    public static void main(String[] args) throws Exception{
        JedisSentinelPool pool = getPool();
        Jedis jedis = pool.getResource();

        long str =  jedis.del("北京-北京市-朝阳区-朝阳区惠新西街南口地铁A口处，中航发展大厦B座   胡佳茵13601363296");
        System.out.println(str);
//        jedis.set("hello","world");
//        String value = jedis.get("hello");
//        jedis.del("hello");
//        System.out.println(value);
        pool.close();
    }
}

