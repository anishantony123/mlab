package com.mlab.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mlab.model.Contract;

public interface ContractRepository extends CrudRepository<Contract, Long> {
	
	public List<Contract> findByUserContractsUserUsername(String userName);
	
}
