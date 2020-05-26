package com.qintess.eventos.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.qintess.eventos.model.CasaDeShow;
import com.qintess.eventos.model.Evento;
import com.qintess.eventos.repositorys.CasaDeShowRepository;
import com.qintess.eventos.repositorys.EventoRepository;


@RestController
@RequestMapping("/api")
public class EventoController {
	
	@Autowired
	private EventoRepository eventoRpo;
	
	@Autowired
	private CasaDeShowRepository casaRpo;
	
	
	@GetMapping("/evento")
	public List<Evento> getEventos(){
		
		return eventoRpo.findAll();
	}
	
	@GetMapping("/evento/{id}")
	public Evento getEventoId(@PathVariable(name = "id") int id){
		
		return eventoRpo.findById(id);
	}
	
	@PostMapping("/evento")
	public List<Evento> save(@RequestBody Evento evento , CasaDeShow casaShow ) throws Exception {
		
		CasaDeShow casa  = casaRpo.findById(evento.getFK_casaDeShow().getId());
		
		if(casa == null) {
		
			throw new Exception("Id de Casa de Show não existente na base de dados !");
		
		}else {
			
			eventoRpo.save(evento);
		}
		
		return eventoRpo.findAll();
	}

	@DeleteMapping("/evento/{id}")
	public ResponseEntity<String> deleteEvento(@PathVariable(name = "id") int id) {
		
		eventoRpo.deleteById(id);
		
		return ResponseEntity.ok("Cliente deletado com sucesso !");
	}	
	
	@PutMapping("/evento/{id}")	
	public ResponseEntity<String> putEvento(@PathVariable(name = "id") int id,
								@RequestBody Evento evento) {
		
		eventoRpo.findById(id);
		eventoRpo.save(evento);
		
		return ResponseEntity.ok("Evento atualizado com sucesso !");
	
	}
	
	@PutMapping("/evento/{id}/imagem")	
	public List<Evento> putImg(@PathVariable(name = "id") int id,
			@RequestParam(required=false, value="imagem") MultipartFile imagem) throws IOException {
		
		byte[] bImagem;
		Evento evento = eventoRpo.findById(id);
		
		if(imagem != null && imagem.getSize() > 0) {
			
			bImagem = imagem.getBytes();
			
			evento.setImagemProd(bImagem);
		}
		
		eventoRpo.save(evento);
		
		return eventoRpo.findAll();
	
	}
	
	
}