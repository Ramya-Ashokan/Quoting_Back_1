package com.prodapt.quotation.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodapt.quotation.products.Entity.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
