package com.group.db.springbootmysql.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.group.db.springbootmysql.model.User;
import com.group.db.springbootmysql.repository.userRepository;
import com.group.db.springbootmysql.service.UserService;
import com.group.db.springbootmysql.SpringBootMysqlApplication;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT
,classes = SpringBootMysqlApplication.class)
@ActiveProfiles("test")
public class UserControllerTest {
	
	private static final String REST_1_0_USERS = "/rest/1.0/users/";
	@Autowired
	private UserService userService;
	
	@MockBean
	private userRepository _userRepository;
	
	@Test //stub
	public void getUserTest() {
		when(_userRepository.findAll()).thenReturn(Stream
				.of(new User(2,"test-user","P4ssword"),
					new User(4,"test-user4","P4ssword4"))
				.collect(Collectors.toList()));
		
		assertThat(2).isEqualTo(userService.getUsers().size());		
	}
	@Test //stub
	public void getUserByNameTest() {
		String name = "gogo";
		when(_userRepository.findByName(name)).thenReturn(Stream
				.of(new User(2,"test-user","P4ssword"),
					new User(4,"test-user4","P4ssword4"))
				.collect(Collectors.toList()));
		
		assertThat(2).isEqualTo(userService.getUserByName(name).size());	
	}
	@Test //stub
	public void saveUserTest() {
		User user = new User(2,"test-user","P4ssword");
		//User user2 = new User(4,"test-user4","P4ssword4");
		when(_userRepository.save(user)).thenReturn(user);
		assertThat(user).isEqualTo(userService.addUser(user));
	}
	
	@Test //mock
	public void deleteUserTest() {
		User user = new User(2,"test-user","P4ssword");
		userService.deleteUser(user);
		verify(_userRepository,times(1)).delete(user);
	}
}
