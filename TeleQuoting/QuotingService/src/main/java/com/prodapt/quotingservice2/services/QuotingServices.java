package com.prodapt.quotingservice2.services;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.prodapt.quotingservice2.dto.QuoteRequest;
import com.prodapt.quotingservice2.entity.Quote;
import com.prodapt.quotingservice2.repository.QuoteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuotingServices {
	private final QuoteRepository quoteRepository;
	Integer updQuan;
public String createQuote(QuoteRequest quoteRequest)
{
	String email=quoteRequest.getUserEmail();
	Integer productId=quoteRequest.getProductId();
	
	Quote qCheckQuote=getByIdEmail(email,productId);
	System.out.println("exist plan "+qCheckQuote);
	if(qCheckQuote==null)
	{
	 Quote quote=Quote.builder()
			.userEmail(quoteRequest.getUserEmail())
			.productId(quoteRequest.getProductId())
			.productName(quoteRequest.getProductName())
			.productType(quoteRequest.getProductType())
			.customerType(quoteRequest.getCustomerType())
			.features(quoteRequest.getFeatures())
			.price(quoteRequest.getPrice())
			.validity(quoteRequest.getValidity())
			.subscriptions(quoteRequest.getSubscriptions())
			.locations(quoteRequest.getLocations())
			.quantity(quoteRequest.getQuantity())
			.subTotal(quoteRequest.getSubTotal())
			.build();
	quoteRepository.save(quote);
	return "new plan added to quote";
	}
	else
	{
		Integer qun=qCheckQuote.getQuantity();
		Integer subTotal=qCheckQuote.getSubTotal();
		Integer price=qCheckQuote.getPrice();
		qCheckQuote.setQuantity(qun+1);
		qCheckQuote.setSubTotal((qun+1)*price);
		quoteRepository.save(qCheckQuote);
		return "already exist plan quantity increased";
	}
	
}
public ResponseEntity<List<Quote>> viewQuoteByEmail(String userEmail)
{
	List<Quote> quote1=quoteRepository.getByUserEmail(userEmail);
	
	if(quote1.isEmpty())
	{
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // No quotes found, return 204 No Content
	}
	else {
		System.out.println(quote1);
		return new ResponseEntity<>(quote1, HttpStatus.OK);
	}
}
public Quote getByIdEmail(String userEmail,Integer productId)
{
	Quote quote=quoteRepository.findByUserEmailAndProductId(userEmail,productId);
	return quote;
}
public String deleteQuote(String userEmail,Integer productId)
{
	Quote quote=quoteRepository.findByUserEmailAndProductId(userEmail,productId);
	quoteRepository.delete(quote);
	return "delete success";
}
public String removeQuantity(Quote quote)
{
	Integer d_quantity=quote.getQuantity();
	Integer subTotal=quote.getSubTotal();
	Integer price=quote.getPrice();
	
	if(d_quantity!=0)
	{
		updQuan=d_quantity-1;
		quote.setQuantity(updQuan);
		quote.setSubTotal(subTotal-price);
		quoteRepository.save(quote);
	}
       if(updQuan==0){
		quoteRepository.delete(quote);
	
	}
	return "remove successfully";
}}

