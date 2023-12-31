package com.cropDetails.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropDetails.Model.Crop;

public interface CropRepository extends MongoRepository<Crop,Integer>{

	Optional<Crop> findByName(String name);

	List<Crop> findByType(String type);

	List<Crop> findByuId(int uid);

}
