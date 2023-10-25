package com.cropDetails.User.SecurityService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cropDetails.User.Repository.UserRepo;
import com.cropDetails.User.Model.Login;
import com.cropDetails.User.Model.User;

 

@Service

public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	UserRepo userRepository;

 

	@Override

	@Transactional

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<User> user=userRepository.findByEmail(username);

		if(user==null) {

			throw new UsernameNotFoundException("User Not Found with username: "+username);

		}

		return UserDetailsImpl.getUser(user.get());

	}

 

}
