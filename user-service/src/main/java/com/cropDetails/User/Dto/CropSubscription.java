package com.cropDetails.User.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CropSubscription {
    
    private int sId; 
    
    @NotNull
    private int dealerId; // Dealer's user ID
    @NotBlank
    private String cropType; // Type of crop they want to subscribe to
}
