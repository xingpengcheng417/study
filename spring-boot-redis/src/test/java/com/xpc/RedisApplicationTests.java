package com.xpc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.xpc.model.User;
import com.xpc.web.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisApplicationTests {
	@Autowired
	UserController userController;
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
    
	@Autowired
    private RedisTemplate redisTemplate;
	
	@Test
	public void contextLoads() {
		System.out.println("hello web");
		User user=new User("aa@126.com", "aa", "aa123456", "aa","123");
        ValueOperations<String, User> operations=redisTemplate.opsForValue();
        operations.set("user-key", user);
        
        
		userController.getUser();
	}

}
