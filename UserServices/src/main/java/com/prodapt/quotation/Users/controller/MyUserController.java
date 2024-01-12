package com.prodapt.quotation.Users.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.quotation.Users.Entity.LoginStatus;
//import com.prodapt.quotation.Users.Entity.User;
import com.prodapt.quotation.Users.dto.UserRequest;
import com.prodapt.quotation.Users.services.UserServices;

import ch.qos.logback.core.status.Status;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MyUserController {
	private final UserServices userServices;
@CrossOrigin(origins="http://localhost:4200")
@PostMapping
@ResponseBody
public String addUser(@RequestBody UserRequest userRequest )
{
	
	return userServices.createUser(userRequest);
}
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/login")
public ResponseEntity<LoginStatus> loginUser(@RequestBody Map<String, String> credentials) {
    String email = credentials.get("email");
    String password = credentials.get("password");

    return userServices.authenticateUser(email, password);
}

//public ResponseEntity<LoginStatus> loginUser(@RequestBody Map<String,String> credentials)
//{
//String email=credentials.get("email");
//String password=credentials.get("password");
//System.out.println(credentials);
//if(userServices.authenticateUser(email, password))
//{
//	System.out.println("Success");
//	return new ResponseEntity<LoginStatus>(new LoginStatus("success"),HttpStatus.OK);
//}
//else {
//	return new ResponseEntity<LoginStatus>(new LoginStatus("invalid"),HttpStatus.UNAUTHORIZED);
//}
//	
//}


//email="senthil123@gmail.com";
//password="Senthil@123";
//if(userServices.authenticateUser(email,password))
//{
//System.out.println("hii");	
//}
//else {
//	System.out.println("invalid");
//}
//return null;
//
}
