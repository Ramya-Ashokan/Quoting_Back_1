package com.prodapt.quotation.products.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private Integer productId;
	@Column(unique=true)
private String productName;
private String productType;
private String customerType;
private List<String> features;
private String validity;
private Integer price;
@ManyToMany
private List<Subscription> subscriptions;
@ManyToMany(cascade = CascadeType.MERGE)
private List<Location> locations;
}
