package com.qintess.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qintess.eventos.model.Usuario;
import com.qintess.eventos.repositorys.UsuarioRepository;


@RestController
@RequestMapping("/api")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRpo;

	
	public UsuarioController(UsuarioRepository usuarioRpo) {
		this.usuarioRpo = usuarioRpo;
	}

	
	@GetMapping("/usuario")
	public List<Usuario> getUsuarios(){
		
	   return usuarioRpo.findAll();
	}
	
	
	@GetMapping("/usuario/{id}")
	public Usuario getClienteId(@PathVariable(name = "id") int id){
		
		return usuarioRpo.findById(id);
	}
	
	@PostMapping("/usuario")
	public Usuario save(@RequestBody Usuario usuario) {
		
		return usuarioRpo.save(usuario);
	}
	
	
	@DeleteMapping("/usuario/{id}")
	public ResponseEntity<String> delete(@PathVariable(name = "id") int id) {
		
		usuarioRpo.deleteById(id);
		
		return ResponseEntity.ok("Cliente deletado com sucesso !");
	}	
	
	
	@PutMapping("/usuario/{id}")	
	public ResponseEntity<String> update(@PathVariable(name = "id") int id,
								@RequestBody Usuario usuario) {
		
		usuarioRpo.findById(id);
		usuarioRpo.save(usuario);
		
		return ResponseEntity.ok("Cliente atualizado com sucesso !");
	
	}
	
}