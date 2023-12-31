package com.cropDetails.Model;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.cropDetails.Enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="farmer")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Farmer {
	@MongoId
	private int fId;
	private String firstName;
	private String lastName;
	private Date dob;
	private Gender gender;
	private int age;
	private long mobileNumber;
	//private boolean status;
	private String role;
	private String email;
	private List<Crop>crops;

}
