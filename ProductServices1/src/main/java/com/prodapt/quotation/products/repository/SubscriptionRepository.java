package com.prodapt.quotation.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prodapt.quotation.products.Entity.Subscription;

public interface SubscriptionRepository  extends JpaRepository<Subscription, Integer> {

}
