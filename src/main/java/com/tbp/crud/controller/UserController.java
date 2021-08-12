package com.tbp.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tbp.crud.entity.User;
import com.tbp.crud.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;
	
	
	//POST
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userservice.createUser(user);
	}
	
	@PostMapping("/addUsers")
	public List<User>  addUsers(@RequestBody List<User> users) {
		return userservice.createUsers(users);
	}
	
	
	//GET
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userservice.getUserById(id);
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		return userservice.getUsers();
	}
	
	
	//PUT
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return userservice.updateUser(user);
	}
	
	
	//DELETE
	
	@DeleteMapping("/user/{id}")
	public String deleteUserById(@PathVariable int id) {
		return userservice.deleteUserById(id);
	}
}
