package com.prodapt.quotation.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodapt.quotation.Users.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String email);

}
