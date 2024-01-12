package com.prodapt.quotation.products.Entity;



import jakarta.persistence.Column;
//import jakarta.persistence.Column;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Location {
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer locationId;
	@Column(unique = true)
    private String locationName;
}
//@GeneratedValue(strategy=GenerationType.IDENTITY)