package com.email.sender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.sender.model.ResetToken;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {
	
	ResetToken findByToken(String token);

}
