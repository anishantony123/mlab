package com.mlab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mlab.model.Contract;
import com.mlab.model.UserContract;

@RepositoryRestResource
public interface UserContractRepository  extends CrudRepository<UserContract, Long>{

}
