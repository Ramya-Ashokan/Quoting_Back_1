package com.prodapt.quotation.Users.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
	private String userName;
	private String email;
	private String password;
	private Date dob;
	private String address;
	private String inputStates;
	private String inputDistrict;
	//private String pincode;
	private String phoneno;
	private String gender;
}
