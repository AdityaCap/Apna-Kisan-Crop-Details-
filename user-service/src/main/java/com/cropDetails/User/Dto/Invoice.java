package com.cropDetails.User.Dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Invoice {
	@MongoId
	private int invoiceId;
	private int farmerId;
	private int dealerId;
	private int cropId;
	private int totalCost;
	private int quantity;
	private Date dateOfPurhase;

}
