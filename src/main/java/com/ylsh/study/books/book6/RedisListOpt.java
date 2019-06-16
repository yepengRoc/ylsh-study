package com.ylsh.study.books.book6;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import sun.reflect.generics.visitor.Reifier;

import java.util.List;

/**
 * redis字符串操作
 */
public class RedisListOpt {
    /**
     * 基本操作
     */
    @Test
    public void baseOpt(){
        Jedis jedis = RedisClientUtil.getJedis();
        Long rst = jedis.rpush("list-key", "item");
        rst = jedis.rpush("list-key", "item2");
        rst = jedis.rpush("list-key", "item3");
        System.out.println("列表长度："+ rst);
        String getItemByIdx = jedis.lindex("list-key", 1);
        System.out.println("根据索引1取到的值为：" + getItemByIdx);

        String popItem = jedis.lpop("list-key");
        System.out.println(popItem);
        List<String> strArr = jedis.lrange("list-key", 0, -1);//-1 为结束索引 可以取出所有元素
        System.out.println(strArr.toString());
    }


}
