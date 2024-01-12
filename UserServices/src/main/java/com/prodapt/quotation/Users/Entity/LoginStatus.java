package com.prodapt.quotation.Users.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginStatus {

private String status;
private User user;
}
//package com.prodapt.QuotingServices.entity;
//
//import java.util.List;
//
//
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//@Entity
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//public class QuoteLineItems {
//@Id
//private Integer productId;
//private String productName;
//private String productType;
//private String customerType;
//private List<String> features;
//private String validity;
//private Integer price;
//private List<String> subscriptions;
//private List<String> locations;
//}
//
//import java.util.List;
//
//import jakarta.persistence.CascadeType;
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.ManyToMany;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//@Data
//@Entity
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Quoting {
//@Id
//@GeneratedValue(strategy=GenerationType.IDENTITY)
//private Integer quoteId;
//private String userEmail;
//@ManyToMany(cascade = CascadeType.ALL)
//private List<QuoteLineItems> quoteLineItems;
//private Integer quantity;
//}