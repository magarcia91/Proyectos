package com.email.sender.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.email.sender.model.Usuario;
import com.email.sender.repository.LoginRepository;
import com.email.sender.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repo;

	@Override
	public Usuario verificarNombreUsuario(String usuario) {
		return repo.verificarNombreUsuario(usuario);
	}

	@Override
	public void cambiarClave(String clave, String nombre) {
		repo.cambiarClave(clave, nombre);
	}

}
