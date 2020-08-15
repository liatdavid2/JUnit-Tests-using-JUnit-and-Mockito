package com.group.db.springbootmysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group.db.springbootmysql.model.User;
import com.group.db.springbootmysql.repository.userRepository;

@Service
public class UserService {
	@Autowired
	private userRepository UserRepository;
	
	public User addUser(User user) {
		return UserRepository.save(user);
	}
	
	public List<User> getUsers() {
		return UserRepository.findAll();
	}
	
	public List<User> getUserByName(String name) {
		return UserRepository.findByName(name);
	}
	
	public void deleteUser(User user) {
		UserRepository.delete(user);
	}
	
}
