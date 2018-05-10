package com.lixiang.ssm;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixiang.ssm.service.ProductService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SecondKill {

	static int index = 1;

	public static void main(String[] args) {
		
		AtomicInteger num = new AtomicInteger(150);

		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");

		ProductService service = ctx.getBean(ProductService.class);
		//计数器
		CountDownLatch count = new CountDownLatch(10000);
		//初始化redis连接池
		JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.0.91", 7001, 3000, "123456");
		
		//获取连接
		
		
		System.out.println("准备秒杀");
		// 1000人参与秒杀
		String name = "user";
		for (int i = 0; i < 10000; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						count.await();//计数为0
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Jedis jedis = pool.getResource();
					long num2 = jedis.decr("product:ticket");//获取号，拿到好减一
					jedis.close();
					//取号
					if(num2>0){
						String name2 =name + (index++);
						boolean result=service.secondKill(name2, 1);
						System.out.println(name2+"秒杀结果："+result);
					}else{
						System.out.println("秒杀失败");
					}
					
				}
			}).start();
			count.countDown();//计数减1
		}

	}

}
