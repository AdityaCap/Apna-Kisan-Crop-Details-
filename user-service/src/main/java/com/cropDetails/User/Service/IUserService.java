package com.cropDetails.User.Service;

import java.util.List;
import java.util.Optional;

import com.cropDetails.User.Dto.Invoice;
import com.cropDetails.User.Exceptions.InSufficentQuantityException;
import com.cropDetails.User.Exceptions.InvoiceNotFoundException;
import com.cropDetails.User.Exceptions.NoAdminFoundException;
import com.cropDetails.User.Exceptions.NoCropsFoundException;
import com.cropDetails.User.Exceptions.NoDealersFoundException;
import com.cropDetails.User.Exceptions.NoFarmersFoundExceptions;
import com.cropDetails.User.Exceptions.NoUserFoundException;
import com.cropDetails.User.Exceptions.NotDealerException;
import com.cropDetails.User.Exceptions.NotFarmerException;
import com.cropDetails.User.Exceptions.UserAlreadyExistsException;
import com.cropDetails.User.Exceptions.UserNotRegisteredException;
import com.cropDetails.User.Model.User;

public interface IUserService {

	List<User> viewAllUsers() throws NoUserFoundException;

	Optional<User> addUser(User User) throws UserAlreadyExistsException;

	Optional<User> viewUserById(int id) throws UserNotRegisteredException;

	Optional<User> updateUser(User User) throws UserNotRegisteredException;

	Boolean deleteUserById(int id) throws UserNotRegisteredException;

	Optional<User> getByName(String name) throws UserNotRegisteredException;

	Optional<User> getByMobile(Long mobile) throws UserNotRegisteredException;

	Optional<User> getByEmail(String email) throws UserNotRegisteredException;

	Optional<List<User>> getAllFarmers() throws NoFarmersFoundExceptions, UserNotRegisteredException;

	Optional<List<User>> getAllDealers() throws NoDealersFoundException, UserNotRegisteredException;

	Boolean checkIsDealerById(int id) throws UserNotRegisteredException, NotDealerException;

	Optional<List<User>> getAllAdmins()throws NoAdminFoundException, UserNotRegisteredException;

	Optional<Invoice> buyCrops(Invoice invoice)
			throws InSufficentQuantityException, NoCropsFoundException, NotFarmerException;

	Optional<List<Invoice>> getInvoiceOfDealer(int id) throws NoDealersFoundException,InvoiceNotFoundException, UserNotRegisteredException, NotDealerException;

	Optional<List<Invoice>> getInvoiceOfFarmer(int id) throws NoFarmersFoundExceptions,InvoiceNotFoundException, UserNotRegisteredException, NotDealerException;

	
}
