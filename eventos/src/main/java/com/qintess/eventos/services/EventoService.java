package com.qintess.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qintess.eventos.model.Evento;
import com.qintess.eventos.repositorys.EventoRepository;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRpo;
	
	public void insere(Evento evento) {
		eventoRpo.save(evento);
	}
	
	public void compra(Evento evento , int qtIngresso) {
		
		eventoRpo.save(evento);
		
	}
	
	public void altera(Evento evento) {
		
		eventoRpo.saveAndFlush(evento);
		
	}
	
	public void deleta(Evento evento) {
		
		eventoRpo.delete(evento);
		
	}
	
	public Evento buscaPorNome(String nome) {
		
		return eventoRpo.findByNome(nome);
		
	}
	
	public Evento buscaPorId(int id) {
		
		return eventoRpo.findById(id);
		
	}
	
	public List<Evento> buscarTodos(){
		
		return eventoRpo.findAll();
	}
}