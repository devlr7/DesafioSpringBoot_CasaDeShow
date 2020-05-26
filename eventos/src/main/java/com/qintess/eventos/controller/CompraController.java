package com.qintess.eventos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qintess.eventos.model.Compra;
import com.qintess.eventos.model.Evento;
import com.qintess.eventos.model.Usuario;
import com.qintess.eventos.repositorys.CompraRepository;
import com.qintess.eventos.repositorys.EventoRepository;
import com.qintess.eventos.repositorys.UsuarioRepository;


@RestController
@RequestMapping("/api")
public class CompraController {

	@Autowired
	private EventoRepository eventoRpo;
	
	@Autowired
	private UsuarioRepository usuarioRpo;
	
	@Autowired
	private CompraRepository compraRpo;
	
	
	@GetMapping("/compra")
	public List<Compra> getCompra(){
		
		return compraRpo.findAll();
	}
	
	
	@PostMapping("/compra/{usuarioId}/{eventoId}")
	private List<Compra> postCompra(@RequestBody Compra compra, 
			@PathVariable(name = "eventoId") int eventoId ,
			@PathVariable(name = "usuarioId") int usuarioId){
		
		Evento evento = eventoRpo.findById(eventoId);
		
		Usuario usuario = usuarioRpo.findById(usuarioId);
		
		if(evento.getQtdade_ingressos() >= compra.getQtdIngresso()) {
			
			
			if(compra.getQtdIngresso() > 0 && compra.getQtdIngresso() <= 4 ) {
				
				int ingresso = evento.getQtdade_ingressos() - compra.getQtdIngresso();
				
				compra.setEvento(evento);
				
				compra.setFK_usuario(usuario);
				
				evento.setQtdade_ingressos(ingresso);
				
				compraRpo.save(compra);
				
				return compraRpo.findAll();
				
			}
			
			return null;	
		
		}
		
		return null;
	}
	
}