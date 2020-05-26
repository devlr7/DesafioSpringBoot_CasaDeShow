package com.qintess.eventos.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventos.model.Evento;

public interface EventoRepository extends JpaRepository<Evento , Integer>{

	public Evento findByNome(String nome);
	
	public Evento findById (int id); 

}
