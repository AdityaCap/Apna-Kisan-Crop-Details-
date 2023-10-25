package com.cropDetails.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropDetails.Model.Farmer;

public interface FarmerRepo extends MongoRepository<Farmer, Integer> {

}
