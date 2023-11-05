package com.cropDetails.Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cropDetails.Model.Crop;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class CropTest {

    private ValidatorFactory validatorFactory;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    public void testValidCrop() {
        Crop crop = new Crop();
        crop.setCId(122);
        crop.setUId(44);
        crop.setName("StrawBerries");
        crop.setType("Fruits");
        crop.setQuantity(499);
        crop.setCost(100);
        crop.setDescription("Fresh and Juicy, Direct from Farm Strawberries");

        // Validate the crop object
        Set<ConstraintViolation<Crop>> violations = validator.validate(crop);
        assertTrue(violations.isEmpty());
    }

    
}
