package com.cropDetails.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cropDetails.Model.CropSubscription;

public interface CropSubscriptionRepository extends MongoRepository<CropSubscription, Integer> {

	Optional<CropSubscription> findByDealerIdAndCropType(int uId, String cropType);

}
