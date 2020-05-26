package com.qintess.eventos.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.eventos.model.CasaDeShow;


public interface CasaDeShowRepository extends JpaRepository<CasaDeShow, Integer> {

	public CasaDeShow findByNome(String nome);
	
	public CasaDeShow findById (int id);
	
}
