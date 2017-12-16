package com.mlab.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mlab.model.User;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {

	public User findByUsername(String username);

}
