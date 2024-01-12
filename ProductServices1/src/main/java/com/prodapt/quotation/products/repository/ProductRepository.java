package com.prodapt.quotation.products.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodapt.quotation.products.Dto.ProductResponse;
import com.prodapt.quotation.products.Entity.Location;
import com.prodapt.quotation.products.Entity.Product;
//import com.prodapt.quotation.products.services.Products;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByLocationsLocationId(Integer locationId);

	List<Product> findByLocationsLocationIdAndProductType(Integer locationId, String productType);

	List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);

	//void deleteByProductName(String productName);

	Product findByProductName(String productName);

	List<Product> findByLocationsLocationName(String locationName);

	List<Product> findByLocationsLocationIdAndProductNameContainingIgnoreCase(Integer locationId,
			String productName);

	//void delete(Optional<Product> product);

//	List<Product> findByLocationsIn(List<Location> loctionName);

	//List<Product> findByLocationsIn(Location locationName);

}
