package com.qintess.eventos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qintess.eventos.model.Compra;
import com.qintess.eventos.repositorys.CompraRepository;


@Service
public class CompraService {


		@Autowired
		private CompraRepository compraRpo;
		
		public void insere(Compra compra) {
			
			compraRpo.save(compra);
		}
		
		public void altera(Compra compra) {
			
			compraRpo.saveAndFlush(compra);
		}
		
		public void deleta(Compra usuario) {
			
			compraRpo.delete(usuario);
			
		}
		
		public Optional<Compra> buscaPorId(int id) {
			
			return compraRpo.findById(id);
		}
		
		public List<Compra> buscarTodos(){
			
			return compraRpo.findAll();
		}
		
}
