package com.prodapt.quotation.products.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.prodapt.quotation.products.Dto.ProductRequest;
import com.prodapt.quotation.products.Dto.ProductResponse;
import com.prodapt.quotation.products.Entity.Location;
import com.prodapt.quotation.products.Entity.Product;
import com.prodapt.quotation.products.Entity.Subscription;
import com.prodapt.quotation.products.repository.LocationRepository;
import com.prodapt.quotation.products.repository.ProductRepository;
import com.prodapt.quotation.products.repository.SubscriptionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServices {
private final ProductRepository productRepository;
private final SubscriptionRepository subscriptionRepository;
private final LocationRepository locationRepository;
//public String createProduct(Product product) {
//	
//	productRepository.save(product);
//	return null;
//}

//add product
public String createproductRequest(ProductRequest productRequest)
{
	 Product product=Product.builder()
			 .productName(productRequest.getProductName())
			 .productType(productRequest.getProductType())
			 .customerType(productRequest.getCustomerType())
			 .features(productRequest.getFeatures())
			 .validity(productRequest.getValidity())
			 .price(productRequest.getPrice())
			 .subscriptions(productRequest.getSubscriptions())
	         .locations(productRequest.getLocations())
			 .build(); 
	 productRepository.save(product);
	return null;
}

//get all products
public List<ProductResponse> viewProduct()
{
	List <Product> products=productRepository.findAll();
	List<ProductResponse> pList=new ArrayList<>();
	for( Product p:products)
	{
		pList.add(maptoProductResponse(p));
	}
	System.out.println("product List"+pList);
	return pList;
}

//mapping dto 
public ProductResponse maptoProductResponse(Product p)
{
	ProductResponse ps=ProductResponse.builder()
			.productId(p.getProductId())
			.productName(p.getProductName())
			.productType(p.getProductType())
			.customerType(p.getCustomerType())
			.features(p.getFeatures())
			.validity(p.getValidity())
			.price(p.getPrice())
			.subscriptions(p.getSubscriptions())
			.locations(p.getLocations())
			.build();
	return ps;
	
}

//add subscription
public String createSubscription(Subscription subscription) {
	
	subscriptionRepository.save(subscription);
	return null;
}
//add location
public String createLocation(Location location)
{
	locationRepository.save(location);
	return null;
}



public List<ProductResponse> getProductByLocations(Integer locationId) {
	List<Product> products=productRepository.findByLocationsLocationId(locationId);
	List<ProductResponse> product_locationList=new ArrayList<>();
	for(Product p:products) {
		product_locationList.add(maptoProductResponse(p));
	}
	 return product_locationList;

}

//get product based on location and productType
public ResponseEntity<List<ProductResponse>> getProductByLocations_ProductTypes(Integer locationId, String productType) {
	List<Product> products=productRepository.findByLocationsLocationIdAndProductType(locationId,productType);
	List<ProductResponse> product_locationProductTypeList=new ArrayList<>();
	if(products.isEmpty())
	{
		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());	
	}
	else {
	for(Product p:products)
	{
		product_locationProductTypeList.add(maptoProductResponse(p));	
	}
	
	
	return ResponseEntity.ok(product_locationProductTypeList);
}}

public ResponseEntity<List<ProductResponse>> searchProductByPriceRanges(Integer minPrice, Integer maxPrice) {
	System.out.println("price range");
    List<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice);
    List<ProductResponse> productResponses = new ArrayList<>();

    if (products.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
    }
    else {
    for (Product product : products) {
        productResponses.add(maptoProductResponse(product));
    }

    return ResponseEntity.ok(productResponses);
    }
}
//
//public void deleteProductById(String productName) {
//	
//	 Optional<Product> productOptional = productRepository.findById(productId);
//     productOptional.ifPresent(product -> productRepository.delete(product));
//	productRepository.deleteByProductName(productName);
//}


public String deleteProductById(Integer productId) {
    Product product = productRepository.findById(productId).orElse(null);

    if (product != null) {
        productRepository.delete(product);
        return "success";
    } else {
        return null;
    }
}


public String updateProductByName(String productName, ProductRequest productRequest) {
    Product product = productRepository.findByProductName(productName);

    if (product != null) {
    	product.setProductName(productRequest.getProductName());
        product.setProductType(productRequest.getProductType());
        product.setCustomerType(productRequest.getCustomerType());
        product.setFeatures(productRequest.getFeatures());
        product.setValidity(productRequest.getValidity());
        product.setPrice(productRequest.getPrice());
        product.setSubscriptions(productRequest.getSubscriptions());
        product.setLocations(productRequest.getLocations());


        productRepository.save(product); // Save the updated product to the database

        return "updated successfully";
    } else {
        return "product not updated";
    }
}

public String updateProductById(Integer productId, ProductRequest productRequest) {
    java.util.Optional<Product> optionalProduct = productRepository.findById(productId);

    if (optionalProduct.isPresent()) {
        Product product = optionalProduct.get();
        product.setProductName(productRequest.getProductName());
        product.setProductType(productRequest.getProductType());
        product.setCustomerType(productRequest.getCustomerType());
        product.setFeatures(productRequest.getFeatures());
        product.setValidity(productRequest.getValidity());
        product.setPrice(productRequest.getPrice());
        product.setSubscriptions(productRequest.getSubscriptions());
        product.setLocations(productRequest.getLocations());

        productRepository.save(product); // Save the updated product to the database

        return "updated successfully";
    } else {
        return "Product not found"; // Product with the given ID was not found in the database
    }
}


public java.util.Optional<Product> getProductById(Integer productId)
{
	java.util.Optional<Product> product=productRepository.findById(productId);
	System.out.println(product);
	return product;
}

//get products by location name
public List<ProductResponse> viewRegLocationProducts(String locationName)
{
	List<Product> products=productRepository.findByLocationsLocationName(locationName);
	List<ProductResponse> regLocationProList=new ArrayList<>();
	for(Product p:products)
	{
		regLocationProList.add(maptoProductResponse(p));	
	}
	return regLocationProList;
	
}
//get products by location id and productname search
public List<ProductResponse> searchProductsByNameandLocationId(Integer locationId,String productName)
{
	if(productName!=null && locationId!=null)
	{
		List<Product> products=productRepository.findByLocationsLocationIdAndProductNameContainingIgnoreCase(locationId,productName);
		List<ProductResponse> searchList=new ArrayList<>();
		for(Product p:products)
		{
			searchList.add(maptoProductResponse(p));
		}
		return searchList;
		
	}
	else {
		throw new IllegalArgumentException("No search criteria provided");
		
	}
}
}
