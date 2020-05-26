package com.qintess.eventos.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.eventos.model.Usuario;
import com.qintess.eventos.repositorys.UsuarioRepository;

@Service
public class UsuarioService {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void insere(Usuario usuario) {
		
		usuarioRepository.save(usuario);
	}
	
	public void altera(Usuario usuario) {
		
		usuarioRepository.saveAndFlush(usuario);
	}
	
	public void deleta(Usuario usuario) {
		
		usuarioRepository.delete(usuario);
		
		}
	
	public Usuario buscaPorNome(String nome) {
		
		return usuarioRepository.findByNome(nome);
	}
	
	public Usuario buscaPorId(int id) {
		
		return usuarioRepository.findById(id);
		
	}
	
	public List<Usuario> buscaTodos(){
		
		return usuarioRepository.findAll();
		
	}
	
	
}
