package com.email.sender.service;

import com.email.sender.model.ResetToken;

public interface ResetTokenService {

	ResetToken findByToken(String token);	
	void guardar(ResetToken token);	
	void eliminar(ResetToken token);
}
