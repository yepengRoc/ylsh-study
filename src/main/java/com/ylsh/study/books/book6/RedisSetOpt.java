package com.ylsh.study.books.book6;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * redis字符串操作
 */
public class RedisSetOpt {
    /**
     * 基本操作
     */
    @Test
    public void baseOpt(){
        Jedis jedis = RedisClientUtil.getJedis();
        String rst = jedis.get("1052235-127-1");

        System.out.println(rst);
        jedis.del("1052235-127-1");
       /* jedis.sadd("set-key", "item1");

        jedis.srem("","");//移除

        jedis.smembers("");// 查询所有set中的值

        jedis.sismember("", "");//查询是否在某个set中*/
    }


}
