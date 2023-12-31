package com.cropDetails.Service;

import java.util.List;
import java.util.Optional;

import com.cropDetails.Exceptions.FarmerAlreadyExistsException;

import com.cropDetails.Exceptions.FarmerNotRegisteredException;
import com.cropDetails.Exceptions.NoFarmerFoundException;
import com.cropDetails.Model.Farmer;

public interface IFarmerService {

	

	List<Farmer> viewAllFarmers()throws NoFarmerFoundException;

	Optional<Farmer> addfarmer(Farmer farmer) throws FarmerAlreadyExistsException;

	Optional<Farmer> viewFarmerById(int id) throws FarmerNotRegisteredException;

	Optional<Farmer> updateFarmer(Farmer farmer)throws FarmerNotRegisteredException;

	Boolean deleteFarmerById(int id)throws FarmerNotRegisteredException ;

}
