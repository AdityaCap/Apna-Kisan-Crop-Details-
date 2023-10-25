package com.cropDetails.User.Model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class BankDetails {
	@MongoId
	private long accountNumber;
	

    @NotBlank(message = "Account holder name is required")
    @Size(max = 255, message = "Account holder name should not exceed 255 characters")
    private String accountHolderName;

    @NotBlank(message = "Bank name is required")
    @Size(max = 255, message = "Bank name should not exceed 255 characters")
    private String bankName;

    @NotBlank(message = "Bank branch is required")
    @Size(max = 255, message = "Bank branch should not exceed 255 characters")
    private String bankBranch;

    @NotBlank(message = "IFSC code is required")
    @Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Invalid IFSC code format")
    private String Ifsc;
	

}
