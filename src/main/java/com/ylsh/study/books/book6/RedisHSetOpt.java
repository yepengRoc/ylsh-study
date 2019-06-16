package com.ylsh.study.books.book6;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * redis字符串操作
 */
public class RedisHSetOpt {
    /**
     * 基本操作
     */
    @Test
    public void baseOpt(){
        Jedis jedis = RedisClientUtil.getJedis();
        jedis.hset("", "", "");//存值

        jedis.hget("", "");//获取某个值
        jedis.hgetAll("");//获取所有值
        jedis.hdel("", "");//删除散列中的某个值


    }


}
