package com.allan.APIStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allan.APIStore.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
