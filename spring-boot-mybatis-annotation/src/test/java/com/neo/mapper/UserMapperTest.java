package com.neo.mapper;

import java.util.List;

import com.neo.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void testInsert() throws Exception {
		userMapper.insert(new User("张三", "a123456", UserSexEnum.MAN));
		userMapper.insert(new User("李四", "b123456", UserSexEnum.WOMAN));
		userMapper.insert(new User("王五", "b123456", UserSexEnum.WOMAN));

		Assert.assertEquals(3, userMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<User> users = userMapper.getAll();
		System.out.println(users.toString());
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		User user = userMapper.getOne(30l);
		System.out.println(user.toString());
		user.setNickName("neo");
		userMapper.update(user);
		Assert.assertTrue(("neo".equals(userMapper.getOne(30l).getNickName())));
	}

}