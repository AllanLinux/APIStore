package com.allan.secao25.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allan.secao25.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
