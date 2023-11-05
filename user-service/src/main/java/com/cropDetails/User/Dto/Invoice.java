package com.cropDetails.User.Dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "invoice")
public class Invoice {
	@MongoId
	private String invoiceId;

	@Min(value = 0, message = "Farmer ID must be greater than or equal to 0")
	private int farmerId;

	@Min(value = 1, message = "Dealer ID must be greater than or equal to 1")
	private int dealerId;

	@Min(value = 1, message = "Crop ID must be greater than or equal to 1")
	private int cropId;

	@Min(value = 1, message = "Total cost must be greater than 0")
	private int totalCost;

	@Min(value = 1, message = "Quantity must be greater than 0")
	private int quantity;

	@NotNull(message = "Date of purchase is required")
	private Date dateOfPurchase;
}
