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
import com.mlab.model.UserContract;
import com.mlab.repository.ContractRepository;
import com.mlab.repository.UserContractRepository;
import com.mlab.repository.UserRepository;

@RestController
public class LabourController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ContractRepository contractRepository;
	
	@Autowired
	private UserContractRepository ucRepository;

	@RequestMapping(value = "/labour/user/add", method = RequestMethod.POST)
	public User saveUSer(@RequestBody User newUser) {
		return userRepository.save(newUser);
	}

	@RequestMapping(value = "/labour/user/{username}", method = RequestMethod.GET)
	public User getUser(@PathVariable(name = "username") String username) {
		return userRepository.findByUsername(username);
	}
	
	@RequestMapping(value = "/labour/contract/add", method = RequestMethod.POST)
	public Contract saveContact(@RequestBody Contract newContract) {
		
		User u = userRepository.findOne(newContract.getUserId());
		newContract.setUser(u);
		Contract c = contractRepository.save(newContract);
		UserContract uc = new UserContract(c,u);
		ucRepository.save(uc);
		return c;
		
	}

	@RequestMapping(value = "/labour/contract/{username}", method = RequestMethod.GET)
	public List<Contract> getContract(@PathVariable(name = "username") String username) {
		User u = userRepository.findByUsername(username);

		List<Contract> contracts = contractRepository.findByUserContractsUserUsername(username);
		for(Contract c : contracts){
			c.setUser(u);
			c.setUserId(u.getId());
		}
		return contracts;
	}
	
}