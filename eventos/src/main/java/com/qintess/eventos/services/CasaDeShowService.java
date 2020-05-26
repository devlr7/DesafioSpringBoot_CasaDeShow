package com.qintess.eventos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.qintess.eventos.model.CasaDeShow;
import com.qintess.eventos.repositorys.CasaDeShowRepository;

public class CasaDeShowService {

	@Autowired
	private CasaDeShowRepository casaDeShowRpo;
	
	public void insere(CasaDeShow casaDeShow) {
		
		casaDeShowRpo.save(casaDeShow);
	}
	
	public void altera(CasaDeShow casaDeShow) {
		
		casaDeShowRpo.saveAndFlush(casaDeShow);
	}
	
	public void deleta(CasaDeShow casaDeShow) {
		
		casaDeShowRpo.delete(casaDeShow);
		
		}
	
	public CasaDeShow buscaPorNome(String nome) {
		
		return casaDeShowRpo.findByNome(nome);
		
	}
	
	public CasaDeShow buscaPorId(int id) {
		
		return casaDeShowRpo.findById(id);
		
	}
	
	public List<CasaDeShow> buscarTodos(){
		
		return casaDeShowRpo.findAll();
		
	}
	
}
