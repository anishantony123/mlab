package com.mlab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mlab.model.User;
import com.mlab.repository.UserRepository;

@RestController
public class LabourController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/labour/user/c", method = RequestMethod.POST)
	public User saveUSer(@RequestBody User newUser) {
		
		User user = null;
		
		if(newUser != null && newUser.getUsername() != null){
			user = userRepository.findByUsername(newUser.getUsername());
		} else {
			user = newUser;
		}
		
		return userRepository.save(user);
	}

	@RequestMapping(value = "/labour/user/{username}", method = RequestMethod.GET)
	public User saveUSer(@PathVariable(name = "username") String username) {
		return userRepository.findByUsername(username);
	}
}