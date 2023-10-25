package com.cropDetails.User.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cropDetails.User.Exceptions.NoAdminFoundException;
import com.cropDetails.User.Exceptions.NoDealersFoundException;
import com.cropDetails.User.Exceptions.NoFarmersFoundExceptions;
import com.cropDetails.User.Exceptions.NoUserFoundException;
import com.cropDetails.User.Exceptions.NotDealerException;
import com.cropDetails.User.Exceptions.UserAlreadyExistsException;
import com.cropDetails.User.Exceptions.UserNotRegisteredException;
import com.cropDetails.User.Model.User;
import com.cropDetails.User.Repository.UserRepo;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	UserRepo repo;
	@Autowired
	PasswordEncoder encoder;

	@Override
	public Optional<User> addUser(User user)throws UserAlreadyExistsException {
		Optional<User> f=repo.findById(user.getUId());
		if(f.isPresent()) {
			throw new UserAlreadyExistsException();
		}
		user.setPassword(encoder.encode(user.getPassword()));
		return  Optional.of(repo.save(user));
	}

	@Override
	public Optional<User> viewUserById(int id) throws UserNotRegisteredException  {
		Optional<User>f=repo.findById(id);
		if(f.isEmpty()) {
			throw new UserNotRegisteredException ();
		}
		
		return f;
	}

	

	@Override
	public List<User> viewAllUsers() throws NoUserFoundException {
		
		List<User> l=repo.findAll();
		if(l.isEmpty()) {
			throw new NoUserFoundException();
		}
		return l;
				
	}

	@Override
	public Optional<User> updateUser(User User)throws UserNotRegisteredException {
		Optional<User> f=repo.findById(User.getUId());
		if(f.isEmpty()) {
			throw new UserNotRegisteredException();
		}
		User far=repo.save(User);
		return Optional.of(far);
	}

	@Override
	public Boolean deleteUserById(int id) throws UserNotRegisteredException {
		Optional<User> f=repo.findById(id);
		if(f.isEmpty()) {
			throw new UserNotRegisteredException();
			
		}
		repo.deleteById(id);
		return true;
	}

	@Override
	public Optional<User> getByName(String name) throws UserNotRegisteredException {
		Optional <User> u=repo.findByName(name);
		if(u.isEmpty()) {
			throw new UserNotRegisteredException();
		}
		
		return u;
	}

	@Override
	public Optional<User> getByMobile(Long mobile) throws UserNotRegisteredException {
		
		Optional <User> u=repo.findByMobileNumber(mobile);
		if(u.isEmpty()) {
			throw new UserNotRegisteredException();
		}
		
		return u;
	}

	@Override
	public Optional<User> getByEmail(String email) throws UserNotRegisteredException {
		Optional <User> u=repo.findByEmail(email);
		if(u.isEmpty()) {
			throw new UserNotRegisteredException();
		}
		
		return u;
	}

	@Override
	public Optional<List<User>> getAllFarmers() throws UserNotRegisteredException,NoFarmersFoundExceptions {
		
		List<User> u=repo.findAll();
		if(u.isEmpty()) {
			throw new UserNotRegisteredException();
		}
		List<User> farmers = u  // Default to an empty list if optional is empty
	            .stream()
	            .filter(user -> user.getRole().equalsIgnoreCase("ROLE_FARMER"))
	            .collect(Collectors.toList());
		if(farmers.isEmpty()) {
			throw new NoFarmersFoundExceptions();
		}
		
		
		return Optional.of(farmers);
	}

	@Override
	public Optional<List<User>> getAllDealers() throws NoDealersFoundException ,UserNotRegisteredException{
		

		List<User> u=repo.findAll();
		if(u.isEmpty()) {
			throw new UserNotRegisteredException();
		}
		List<User> dealers = u  // Default to an empty list if optional is empty
	            .stream()
	            .filter(user -> user.getRole().equalsIgnoreCase("ROLE_DEALER"))
	            .collect(Collectors.toList());
		if(dealers.isEmpty()) {
			throw new NoDealersFoundException();
		}
		
		
		return Optional.of(dealers);
	}

	@Override
	public Boolean checkIsDealerById(int id) throws UserNotRegisteredException,NotDealerException {
		   Optional<User> userOptional = repo.findById(id);
	        if (userOptional.isPresent()) {
	            User user = userOptional.get();
	            if (user.getRole().equalsIgnoreCase("ROLE_DEALER")) {
	                return true;
	            } else {
	                throw new NotDealerException();
	            }
	        } else {
	            throw new UserNotRegisteredException();
	        }
	    }

	@Override
	public Optional<List<User>> getAllAdmins() throws NoAdminFoundException, UserNotRegisteredException {
		List<User> u=repo.findAll();
		if(u.isEmpty()) {
			throw new UserNotRegisteredException();
		}
		List<User> admins = u  // Default to an empty list if optional is empty
	            .stream()
	            .filter(user -> user.getRole().equalsIgnoreCase("ROLE_ADMIN"))
	            .collect(Collectors.toList());
		if(admins.isEmpty()) {
			throw new NoAdminFoundException();
		}
		
		
		return Optional.of(admins);
	}
	
	


	

	

}