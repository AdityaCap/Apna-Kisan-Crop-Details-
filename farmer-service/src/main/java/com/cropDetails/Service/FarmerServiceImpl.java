package com.cropDetails.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cropDetails.Exceptions.FarmerAlreadyExistsException;

import com.cropDetails.Exceptions.FarmerNotRegisteredException;
import com.cropDetails.Exceptions.NoFarmerFoundException;
import com.cropDetails.Model.Farmer;
import com.cropDetails.Repository.FarmerRepo;

@Service
public class FarmerServiceImpl implements IFarmerService{
	@Autowired
	FarmerRepo repo;

	@Override
	public Optional<Farmer> addfarmer(Farmer farmer)throws FarmerAlreadyExistsException {
		Optional<Farmer> f=repo.findById(farmer.getFId());
		if(f.isPresent()) {
			throw new FarmerAlreadyExistsException();
		}
		Farmer far=repo.save(farmer);
		return  Optional.of(far);
	}

	@Override
	public Optional<Farmer> viewFarmerById(int id) throws FarmerNotRegisteredException  {
		Optional<Farmer>f=repo.findById(id);
		if(f.isEmpty()) {
			throw new FarmerNotRegisteredException ();
		}
		
		return f;
	}

	

	@Override
	public List<Farmer> viewAllFarmers() throws NoFarmerFoundException {
		
		List<Farmer> l=repo.findAll();
		if(l.isEmpty()) {
			throw new NoFarmerFoundException();
		}
		return l;
				
	}

	@Override
	public Optional<Farmer> updateFarmer(Farmer farmer)throws FarmerNotRegisteredException {
		Optional<Farmer> f=repo.findById(farmer.getFId());
		if(f.isEmpty()) {
			throw new FarmerNotRegisteredException();
		}
		Farmer far=repo.save(farmer);
		return Optional.of(far);
	}

	@Override
	public Boolean deleteFarmerById(int id) throws FarmerNotRegisteredException {
		Optional<Farmer> f=repo.findById(id);
		if(f.isEmpty()) {
			throw new FarmerNotRegisteredException();
			
		}
		repo.deleteById(id);
		return true;
	}


	

	

}
