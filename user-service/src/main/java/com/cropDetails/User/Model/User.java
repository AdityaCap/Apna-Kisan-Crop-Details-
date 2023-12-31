package com.cropDetails.User.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.cropDetails.User.Enums.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User {
	@MongoId
	private int uId;

	@NotBlank(message = "Name is required")
	@Size(max = 255, message = "Name should not exceed 255 characters")
	private String name;

	@NotNull(message = "Gender is required")
	private String gender;

	@NotNull(message = "Age is required")
	private int age;

	@NotNull(message = "Ratings is required")
	private int ratings;

	@NotNull(message = "Mobile number is required")
	//@Size(min = 10, message = "Mobile Number should be of ")
	private long mobileNumber;

	@NotBlank(message = "Address is required")
	@Size(max = 255, message = "Address should not exceed 255 characters")
	private String address;

	@NotBlank(message = "Role is required,Please choose ROLE_ADMIN / ROLE_FARMER / ROLE_DEALER")
	@Size(max = 255, message = "Role should not exceed 255 characters,Please choose ROLE_ADMIN / ROLE_FARMER/ROLE_DEALER")
	private String role;

	@NotBlank(message = "Email is required")
	@Size(max = 255, message = "Email should not exceed 255 characters")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email format")
	private String email;

	@NotBlank(message = "Password is required")
	private String password;
	


	private BankDetails bankDetails;

}
