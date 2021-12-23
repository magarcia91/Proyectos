package com.email.sender.service;

import com.email.sender.model.Usuario;

public interface LoginService {
	
	Usuario verificarNombreUsuario(String usuario);
	void cambiarClave(String clave, String nombre);

}
