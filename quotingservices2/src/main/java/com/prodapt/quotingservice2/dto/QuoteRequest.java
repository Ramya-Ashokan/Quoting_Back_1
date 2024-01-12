package com.prodapt.quotingservice2.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuoteRequest {
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
