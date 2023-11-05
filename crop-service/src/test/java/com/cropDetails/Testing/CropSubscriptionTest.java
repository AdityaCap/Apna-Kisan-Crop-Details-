package com.cropDetails.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cropDetails.Model.CropSubscription;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class CropSubscriptionTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testValidCropSubscription() {
        CropSubscription cropSubscription = new CropSubscription();
        cropSubscription.setSId(1001);
        cropSubscription.setDealerId(60);
        cropSubscription.setCropType("Vegetable");

        // Validate the crop subscription object
        Set<ConstraintViolation<CropSubscription>> violations = validator.validate(cropSubscription);
        assertTrue(violations.isEmpty());
    }

    
}
