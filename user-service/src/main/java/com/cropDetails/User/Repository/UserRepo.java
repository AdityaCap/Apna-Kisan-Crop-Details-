package com.cropDetails.User.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropDetails.User.Model.User;

public interface UserRepo extends MongoRepository<User, Integer> {

	Optional<User> findByName(String name);
	Optional<User> findByMobileNumber(Long mobile);
	Optional<User> findByEmail(String email);	
	Optional<List<User>> findByRole();

}
