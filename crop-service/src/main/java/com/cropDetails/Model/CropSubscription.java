package com.cropDetails.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "subscriptions")
public class CropSubscription {
    @MongoId
    private int sId; 
    @NotNull
    private int dealerId; // Dealer's user ID
    @NotBlank
    private String cropType; // Type of crop they want to subscribe to
}

