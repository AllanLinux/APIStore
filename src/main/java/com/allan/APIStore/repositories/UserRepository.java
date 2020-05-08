package com.allan.APIStore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allan.APIStore.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
