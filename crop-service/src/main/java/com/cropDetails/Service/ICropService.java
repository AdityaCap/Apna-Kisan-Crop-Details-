package com.cropDetails.Service;

import java.util.List;
import java.util.Optional;

import com.cropDetails.Exceptions.CropAlreadyExistException;
import com.cropDetails.Exceptions.NoCropFoundException;
import com.cropDetails.Exceptions.NoCropRegisteredException;
import com.cropDetails.Exceptions.NoSubscriptionFoundException;
import com.cropDetails.Exceptions.NotDealerException;
import com.cropDetails.Exceptions.SubscriptionAlreadyExistsException;
import com.cropDetails.Exceptions.UserNotRegisteredException;
import com.cropDetails.Model.Crop;
import com.cropDetails.Model.CropSubscription;

public interface ICropService {

	List<Crop> viewAllCrops() throws NoCropFoundException;
	Optional<Crop> addCrop(Crop crop) throws CropAlreadyExistException;
	Boolean deleteCropById(int id) throws NoCropRegisteredException;
	Optional<Crop> updateCrop(Crop crop) throws NoCropRegisteredException;
	Optional<Crop> getCropById(int id)throws NoCropRegisteredException;
	Optional<Crop> getCropByName(String name)throws NoCropRegisteredException;
	List<Crop> getCropByType(String type)throws NoCropRegisteredException;
	public void subscribeToCrop(CropSubscription sub) throws SubscriptionAlreadyExistsException, NotDealerException;
	List<CropSubscription> getSubscription()throws NoSubscriptionFoundException;
	Boolean deleteSubscriptionById(int id)throws NoSubscriptionFoundException;
	List<Crop> getAllCropsByUserId(int uid)throws UserNotRegisteredException,NoCropFoundException;
}
