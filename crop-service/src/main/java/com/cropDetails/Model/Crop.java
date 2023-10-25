package com.cropDetails.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "crop")
public class Crop {
	
    @MongoId
    private int cId;
    
    @NotNull
    private int uId;
    
    @NotNull
    @Size(min = 2, max = 50, message = "Crop name must be between 2 and 50 characters")
    private String name;
    
    @NotBlank
    @Size(min = 2, max = 50, message = "Crop Type must be there ,Fruits or vegetables")
    private String type;
    
    @Min(value = 0, message = "Quantity must be greater than or equal to 0")
    private int quantity;
    
    @Min(value = 0, message = "Cost must be greater than or equal to 0")
    private int cost;
    
    @NotNull(message="Please some descripton for your crop")
    private String description;
}
