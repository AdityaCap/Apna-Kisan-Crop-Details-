package com.cropDetails.Invoice.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Crop {
	private int cId;

	private int uId;
	
	private String name;

	private String type;

	private int quantity;

	private int cost;

	private String description;
}