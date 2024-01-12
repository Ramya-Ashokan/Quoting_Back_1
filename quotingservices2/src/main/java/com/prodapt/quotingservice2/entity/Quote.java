package com.prodapt.quotingservice2.entity;

import java.util.List;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer quoteId;
	private String userEmail;
	private Integer productId;
	private String productName;
	private String productType;
	private String customerType;
	private List<String> features;
	private String validity;
	private Integer price;
	private List<String> subscriptions;
	private List<String> locations;
	private Integer quantity;
	private Integer subTotal;
}
