package com.lixiang.ssm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lixiang.ssm.dao.UserMapper;
import com.lixiang.ssm.entity.User;
import com.lixiang.ssm.service.UserService;

public class TestMapper {
	
	@Test
	public void test(){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
		
		/*UserMapper mapper = ctx.getBean("userMapper", UserMapper.class);
		
		User user = mapper.selectByPrimaryKey(16);
		System.out.println(user);*/
		
		UserService userService = ctx.getBean("userService",UserService.class);
		Integer[] list = {6,7,8,9};
/*		boolean result = userService.bathUnlockUser(list);
		System.out.println(result);*/
		
		
		
	}

}
