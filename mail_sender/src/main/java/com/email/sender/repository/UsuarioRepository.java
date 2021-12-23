package com.email.sender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.email.sender.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findOneByUsername(String username);
}
