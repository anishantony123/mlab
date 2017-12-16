package com.mlab.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mlab.model.Contract;
import com.mlab.model.User;
import com.mlab.repository.ContractRepository;
import com.mlab.repository.UserRepository;

@RestController
public class LabourController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContractRepository contractRepository;

	@RequestMapping(value = "/labour/user/add", method = RequestMethod.POST)
	public User saveUSer(@RequestBody User newUser) {
		
		User user = null;
		if(newUser != null && newUser.getId() != null){
			user = userRepository.findOne(newUser.getId());
			if(user != null){
				newUser.setId(user.getId());
			}
		}		
		return userRepository.save(newUser);
	}

	@RequestMapping(value = "/labour/user/{username}", method = RequestMethod.GET)
	public User getUser(@PathVariable(name = "username") String username) {
		return userRepository.findByUsername(username);
	}
	
	@RequestMapping(value = "/labour/contract/add", method = RequestMethod.POST)
	public Contract saveContact(@RequestBody Contract newContract) {
		
		Contract contract = null;
		
		if(newContract != null && newContract.getId() != null){
			contract = (Contract) contractRepository.findOne(newContract.getId());
			
			if(contract != null){
				newContract.setId(contract.getId());
			}
		}
		
		return contractRepository.save(newContract);
	}

	@RequestMapping(value = "/labour/contract/{username}", method = RequestMethod.GET)
	public List<Contract> getContract(@PathVariable(name = "username") String username) {
		return contractRepository.findByUserContractsUserUsername(username);
	}
	
}