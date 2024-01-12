package com.prodapt.quotation.products.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prodapt.quotation.products.Entity.Location;
import com.prodapt.quotation.products.services.LocationService;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
@RequestMapping("/locations")
public class LocationController {

	private final LocationService locationService;
	@CrossOrigin(origins="http://localhost:4200")
	@GetMapping
	public List<Location> getAllLocation()
	{
		System.out.println("entering");
		return locationService.getAllLocations();
	
		
	}
}
