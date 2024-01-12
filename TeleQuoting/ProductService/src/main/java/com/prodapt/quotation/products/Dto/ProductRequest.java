package com.prodapt.quotation.products.Dto;

import java.util.List;
import com.prodapt.quotation.products.Entity.Location;
import com.prodapt.quotation.products.Entity.Subscription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
	private String productName;
	private String productType;
	private String customerType;
	private List<String> features;
	private String validity;
	private Integer price;
	
	private List<Subscription> subscriptions;
	
	private List<Location> locations;
}
