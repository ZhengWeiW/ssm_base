package com.lixiang.ssm;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestRedis {
	
	@Test
	public void test(){
		//连接
		Jedis jedis = new Jedis("192.168.0.91",7001);
		System.out.println(jedis.getClass().getName());
		//授权
		jedis.auth("123456");
		//放里面放值
		jedis.set("foo", "bar");
		//拿值
		String value = jedis.get("foo");
		System.out.println(value);
		//关闭客户端
		jedis.close();
	}
	
	@Test
	public void test2(){
		//创建Jedis连接池,可以达到连接复用的目的，节省资源，提升性能，意思线程池，数据库连接池道理是一样的
		JedisPool pool = new JedisPool("192.168.0.91",7001);
		Jedis jedis = pool.getResource();
		System.out.println(jedis.getClass().getName());
		//授权
		jedis.auth("123456");
		//放里面放值
		jedis.set("key5", "val5");
		//拿值
		String value = jedis.get("key5");
		System.out.println(value);
		//关闭客户端
		jedis.close();
	}

}
