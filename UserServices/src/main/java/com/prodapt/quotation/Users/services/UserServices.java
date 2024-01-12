package com.prodapt.quotation.Users.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prodapt.quotation.Users.Entity.LoginStatus;
import com.prodapt.quotation.Users.Entity.User;
import com.prodapt.quotation.Users.dto.UserRequest;
import com.prodapt.quotation.Users.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServices {
private final UserRepository userRepository;
public String createUser(UserRequest userRequest)
{
	User u=new User();
	u.setUserName(userRequest.getUserName());
	u.setEmail(userRequest.getEmail());
	u.setPassword(userRequest.getPassword());
	u.setDob(userRequest.getDob());
	u.setAddress(userRequest.getAddress());
	u.setInputStates(userRequest.getInputStates());
	u.setInputDistrict(userRequest.getInputDistrict());
	u.setPhoneno(userRequest.getPhoneno());
	u.setGender(userRequest.getGender());
	userRepository.save(u);
	return null;
}
//public boolean authenticateUser(String email, String password) {
//	User user=userRepository.findByEmail(email);
//	
//	if(user==null || !password.equals(user.getPassword()))
//	System.out.println(user.getPassword().equals(password));
//	System.out.println(user);
//	return user.getPassword().equals(password);
//
//}


public ResponseEntity<LoginStatus> authenticateUser(String email, String password) {
    User user = userRepository.findByEmail(email);
System.out.println(user.getEmail()+" "+user.getPassword());
    if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
        // User authentication successful
        LoginStatus response = new LoginStatus("success", user);
        return ResponseEntity.ok(response);
    } else {
        // User authentication failed
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginStatus("invalid", null));
    }
}






}
//User user=userRepository.findByEmail(email);
//System.out.println("mail model"+user.getEmail());
//System.out.println("password model"+user.getPassword());
//System.out.println(user.getPassword().equals(password));
//
//	return user.getPassword().equals(password);