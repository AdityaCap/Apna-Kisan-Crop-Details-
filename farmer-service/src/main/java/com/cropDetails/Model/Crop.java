package com.cropDetails.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.cropDetails.Enums.CropType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="crop")
public class Crop {
	@MongoId
	private int id;
	private String cName;
	private CropType cType;
	private int cQuantity;
	private int cCost;
	

}
