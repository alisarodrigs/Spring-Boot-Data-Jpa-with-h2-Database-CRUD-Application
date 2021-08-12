package com.tbp.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tbp.crud.dao.UserRepository;
import com.tbp.crud.entity.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//POST
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	public List<User> createUsers(List<User> users) {
		return userRepository.saveAll(users);
	}
	
	//GET
	
	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	//PUT
	
	public User updateUser(User user) {
		Optional<User> optionalUser=userRepository.findById(user.getId()) ;
		User oldUser=null;
		if(optionalUser.isPresent()) {
			oldUser= optionalUser.get();
			oldUser.setName(user.getName());
			oldUser.setAddress(user.getAddress());
			userRepository.save(oldUser);
		}else {
			return new User();
		}
		return oldUser;
	}
	
	//DELETE
	
	public String deleteUserById(int id) {
		userRepository.deleteById(id);
		return "User deleted";
	}
	
}
