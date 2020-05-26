package com.qintess.eventos.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findByNome(String nome);
	
	public Usuario findById (int id);
	
}
