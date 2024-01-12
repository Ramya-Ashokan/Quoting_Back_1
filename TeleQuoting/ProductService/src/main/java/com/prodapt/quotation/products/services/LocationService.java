package com.prodapt.quotation.products.services;

import java.util.ArrayList;
import java.util.List;
//import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import com.prodapt.quotation.products.Entity.Location;
import com.prodapt.quotation.products.repository.LocationRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LocationService {
private final LocationRepository locationRepository;
 public List<Location> getAllLocations()
 {
	 
 List<Location> locationsList=locationRepository.findAll();
	 System.out.println(locationsList);
      return locationsList;
	 
 }

}
