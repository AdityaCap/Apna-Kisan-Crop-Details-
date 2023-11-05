package com.cropDetails.Testing;

import com.cropDetails.Controller.CropController;
import com.cropDetails.Exceptions.*;
import com.cropDetails.Model.Crop;
import com.cropDetails.Model.CropSubscription;
import com.cropDetails.Service.ICropService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CropControllerTest {

    private CropController cropController;
    private ICropService cropService;

    @BeforeEach
    public void setUp() {
        cropService = Mockito.mock(ICropService.class);
        cropController = new CropController(cropService);
    }

    @Test
    public void testViewAllCrops() throws NoCropFoundException {
        List<Crop> crops = new ArrayList<>();
        crops.add(getSampleCrop());
        Mockito.when(cropService.viewAllCrops()).thenReturn(crops);

        ResponseEntity<List<Crop>> response = cropController.viewAllCrops();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(crops, response.getBody());
    }

    @Test
    public void testAddCrop() throws CropAlreadyExistException {
        Crop crop = getSampleCrop();
        Mockito.when(cropService.addCrop(crop)).thenReturn(Optional.of(crop));

        ResponseEntity<Crop> response = cropController.addCrop(crop);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(crop, response.getBody());
    }

    @Test
    public void testDeleteCropById() throws NoCropRegisteredException {
        int cropId = 1;
        Mockito.when(cropService.deleteCropById(cropId)).thenReturn(true);

        ResponseEntity<Boolean> response = cropController.deleteCropById(cropId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
    }

    @Test
    public void testUpdateCrop() throws NoCropRegisteredException {
        Crop crop = getSampleCrop();
        Mockito.when(cropService.updateCrop(crop)).thenReturn(Optional.of(crop));

        ResponseEntity<Crop> response = cropController.updateCrop(crop);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(crop, response.getBody());
    }

    @Test
    public void testGetCropById() throws NoCropRegisteredException {
        Crop crop = getSampleCrop();
        Mockito.when(cropService.getCropById(crop.getCId())).thenReturn(Optional.of(crop));

        ResponseEntity<Crop> response = cropController.getCropById(crop.getCId());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(crop, response.getBody());
    }

    @Test
    public void testGetCropByName() throws NoCropRegisteredException {
        Crop crop = getSampleCrop();
        Mockito.when(cropService.getCropByName(crop.getName())).thenReturn(Optional.of(crop));

        ResponseEntity<Crop> response = cropController.getCropByName(crop.getName());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(crop, response.getBody());
    }

    @Test
    public void testGetCropByType() throws NoCropRegisteredException {
        List<Crop> crops = new ArrayList<>();
        crops.add(getSampleCrop());
        Mockito.when(cropService.getCropByType(getSampleCrop().getType())).thenReturn(crops);

        ResponseEntity<List<Crop>> response = cropController.getCropByType(getSampleCrop().getType());

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(crops, response.getBody());
    }

    @Test
    public void testSubscribeToCrop() throws SubscriptionAlreadyExistsException, NotDealerException {
        CropSubscription subscription = getSampleSubscription();
        cropService.subscribeToCrop(subscription);
        ResponseEntity<String> response = cropController.subscribeToCrop(subscription);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Subscription successful.", response.getBody());
    }

    @Test
    public void testGetSubscription() throws NoSubscriptionFoundException {
        List<CropSubscription> subscriptions = new ArrayList<>();
        subscriptions.add(getSampleSubscription());
        Mockito.when(cropService.getSubscription()).thenReturn(subscriptions);

        ResponseEntity<List<CropSubscription>> response = cropController.getSubscription();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(subscriptions, response.getBody());
    }

    @Test
    public void testDeleteSubscriptionById() throws NoSubscriptionFoundException {
        int subscriptionId = 1;
        Mockito.when(cropService.deleteSubscriptionById(subscriptionId)).thenReturn(true);

        ResponseEntity<Boolean> response = cropController.deleteSubscriptionById(subscriptionId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody());
    }

    @Test
    public void testGetAllCropsByUserId() throws NoUserFoundException, UserNotRegisteredException, NoCropFoundException {
        List<Crop> crops = new ArrayList<>();
        crops.add(getSampleCrop());
        int userId = 1;
        Mockito.when(cropService.getAllCropsByUserId(userId)).thenReturn(crops);

        ResponseEntity<List<Crop>> response = cropController.getAllCropsByUserId(userId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(crops, response.getBody());
    }

    private Crop getSampleCrop() {
        Crop crop = new Crop();
        crop.setCId(122);
        crop.setUId(44);
        crop.setName("StrawBerries");
        crop.setType("Fruits");
        crop.setQuantity(499);
        crop.setCost(100);
        crop.setDescription("Fresh and Juicy, Direct from Farm Strawberries");
        return crop;
    }

    private CropSubscription getSampleSubscription() {
        CropSubscription subscription = new CropSubscription();
        subscription.setSId(1002);
        subscription.setDealerId(60);
        subscription.setCropType("Fruits");
        return subscription;
    }
}
