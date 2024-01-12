package com.prodapt.quotingservice2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodapt.quotingservice2.entity.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Integer> {

	List<Quote> getByUserEmail(String userEmail);

	Quote findByUserEmailAndProductId(String userEmail, Integer productId);

}
