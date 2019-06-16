package com.ylsh.study.books.book6;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * redis字符串操作
 */
public class RedisZSetOpt {
    /**
     * 基本操作
     */
    @Test
    public void baseOpt(){
        Jedis jedis = RedisClientUtil.getJedis();
        jedis.zadd("zset-key", 1, "item1");
        jedis.zadd("zset-key", 5, "item2");

        jedis.zrange("", 0, -1);
        jedis.zrangeByScore("", 0, 100);//
        jedis.zrank("zset-key", "item1");//根据member获取数据



    }


}
