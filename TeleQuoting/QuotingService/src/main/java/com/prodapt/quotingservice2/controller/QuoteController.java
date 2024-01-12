package com.prodapt.quotingservice2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.quotingservice2.dto.QuoteRequest;
import com.prodapt.quotingservice2.entity.Quote;
import com.prodapt.quotingservice2.services.QuotingServices;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/quote")
public class QuoteController {
//private final QuoteRepository quoteRepository;
private final QuotingServices quoteServices;

@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/add")
public ResponseEntity<String> addQuote(@RequestBody QuoteRequest quoteRequest)
{
	String successMessage = "quote added success";
	//quoteRepository.save(quote);
	System.out.println(quoteRequest);
	quoteServices.createQuote(quoteRequest);
	 return ResponseEntity.ok("{\"message\": \"" + successMessage + "\"}");
	
}
@CrossOrigin(origins="http://localhost:4200")
@GetMapping("/{userEmail}")
public ResponseEntity<List<Quote>> getQuoteByEmail(@PathVariable String userEmail)
{
	System.out.println(userEmail);
	return quoteServices.viewQuoteByEmail(userEmail);
    
}
@GetMapping("/{userEmail}/{productId}")
public Quote getByProductIdEmail(@PathVariable String userEmail,@PathVariable Integer productId)
{
	return quoteServices.getByIdEmail(userEmail, productId);
}

/*--Quote delete---*/
@CrossOrigin(origins="http://localhost:4200")
@DeleteMapping("/delete/{userEmail}/{productId}")
public String deleteQuote(@PathVariable String userEmail,@PathVariable Integer productId )
{
	System.out.println("delete"+userEmail+" "+productId);
	 return quoteServices.deleteQuote(userEmail,productId);
		
}
/*-remove quantity-*/
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/remove")
public String removeQuantity(@RequestBody Quote quote)
{
	System.out.println("remove quantity"+quote);
	
	return quoteServices.removeQuantity(quote);
	
}
}
