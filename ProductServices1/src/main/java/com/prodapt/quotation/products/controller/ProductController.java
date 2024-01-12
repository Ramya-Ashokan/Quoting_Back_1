package com.prodapt.quotation.products.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.quotation.products.Dto.ProductRequest;
import com.prodapt.quotation.products.Dto.ProductResponse;
import com.prodapt.quotation.products.Entity.Location;
import com.prodapt.quotation.products.Entity.Product;
import com.prodapt.quotation.products.Entity.Subscription;
import com.prodapt.quotation.products.repository.ProductRepository;
import com.prodapt.quotation.products.repository.SubscriptionRepository;
import com.prodapt.quotation.products.services.ProductServices;

import lombok.RequiredArgsConstructor;
import lombok.experimental.PackagePrivate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
private final ProductServices productServices;
//private final ProductResponse productResponse;
//private final ProductResponse productResponse;
//@PostMapping("/add")
//public String addProduct(@RequestBody Product product)
//{
//	System.out.println(product);
//	
//
//	productServices.createProduct(product);
//	return "added successfully";
//}


/*------product  add---*/
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/add")
public String addproduct(@RequestBody ProductRequest productRequest)
{
	System.out.println(productRequest);
	productServices.createproductRequest(productRequest);
	return "added";
}

/*------subscription  add---*/
@PostMapping("/subscription") 
public String addSubscription(@RequestBody Subscription subscription) 
{ 
	 System.out.println(subscription); 

productServices.createSubscription(subscription); 
return "Subscription added successfully"; 
} 


/*------location  add---*/
@PostMapping("/location") 
public
String addLocation(@RequestBody Location location) {
 System.out.println(location); 
 productServices.createLocation(location); 
 return "location added successfully"; 
 }


/*------get all products  ---*/
@CrossOrigin(origins="http://localhost:4200")
@GetMapping
public List<ProductResponse> getProduct()
{
	
	return productServices.viewProduct();
}


/*------get product based on location  ---*/
@CrossOrigin(origins="http://localhost:4200")
@GetMapping("/loc/{locationId}")
 public List<ProductResponse> getProductByLocation(@PathVariable Integer locationId){ 
	System.out.println(locationId);
	 return productServices.getProductByLocations( locationId); 
	 }
  
 
/*-----------------get product based on location and product type----*/
@CrossOrigin(origins="http://localhost:4200")
@GetMapping("/{locationId}/{productType}")
public  ResponseEntity<List<ProductResponse>> getProductByLocation_ProductType(@PathVariable Integer locationId,@PathVariable String productType)
{
	System.out.println(locationId+" "+productType);
	return productServices.getProductByLocations_ProductTypes(locationId,productType);
}

/*-----------get product based on price range---------------*/
@CrossOrigin(origins="http://localhost:4200")
@GetMapping("/search/{minPrice}/{maxPrice}")
public ResponseEntity<List<ProductResponse>> searchProductByPriceRanges(
        @PathVariable Integer minPrice,
        @PathVariable Integer maxPrice) {
	System.out.println(minPrice+" "+maxPrice);
    return productServices.searchProductByPriceRanges(minPrice, maxPrice);
    }

 
/*---------delete product -------------*/
@CrossOrigin(origins="http://localhost:4200")
@DeleteMapping("/{productId}")
public String deleteProductById(@PathVariable Integer productId) {
     System.out.println(productId);
    return productServices.deleteProductById(productId);
}


/*----------update product-------*/
@PostMapping("/{productName}")
public ResponseEntity<String> updateProductByName(@PathVariable String productName, @RequestBody ProductRequest productRequest) {
   String response = productServices.updateProductByName(productName, productRequest);
   if(response.equals("updated successfully")) {
   return new ResponseEntity<>(response, HttpStatus.OK);
   }
   else
   {
	   return new ResponseEntity<>(response, HttpStatus.NOT_MODIFIED);
   }
}

/*--------get product BY Id---*/
@CrossOrigin(origins="http://localhost:4200")
@GetMapping("/edit/{productId}")
public Optional<Product> getProductById(@PathVariable Integer productId)
{
	System.out.println(productId);
	return productServices.getProductById(productId);
}

/* edit product by id*/
@CrossOrigin(origins="http://localhost:4200")
@PostMapping("/edit/{productId}")
public ResponseEntity<String> updateProductById(@PathVariable Integer productId, @RequestBody ProductRequest productRequest) {
    String response = productServices.updateProductById(productId, productRequest);
    if (response.equals("updated successfully")) {
        return new ResponseEntity<>(response, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(response, HttpStatus.NOT_MODIFIED);
    }
}

/*get product by register location*/
@CrossOrigin(origins="http://localhost:4200")
@GetMapping("{locationName}")
public List<ProductResponse> getRegLocationProducts(@PathVariable String locationName)
{
	return productServices.viewRegLocationProducts(locationName);
}
/* search by location Id and product name*/
@CrossOrigin(origins="http://localhost:4200")
@GetMapping("/searches/{locationId}/{productName}")
public ResponseEntity<List<ProductResponse>> searchItemsByNameAndLocationId(@PathVariable Integer locationId,@PathVariable String productName)
{
	List<ProductResponse> productResponse;

    try {
        productResponse = productServices.searchProductsByNameandLocationId(locationId,productName);
        if (productResponse.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    } catch (IllegalArgumentException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}






}

