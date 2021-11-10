package com.android.springboot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.android.springboot.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	
	User save(User user);
	
	User findByUserId(User user);

}
