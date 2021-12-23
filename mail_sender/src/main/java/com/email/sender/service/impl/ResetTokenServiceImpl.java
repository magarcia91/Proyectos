package com.email.sender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.sender.model.ResetToken;
import com.email.sender.repository.ResetTokenRepository;
import com.email.sender.service.ResetTokenService;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {


	@Autowired
	private ResetTokenRepository repo;
	
	@Override
	public ResetToken findByToken(String token) {
		return repo.findByToken(token);
	}

	@Override
	public void guardar(ResetToken token) {
		repo.save(token);
	}

	@Override
	public void eliminar(ResetToken token) {
		repo.delete(token);
	}

}
