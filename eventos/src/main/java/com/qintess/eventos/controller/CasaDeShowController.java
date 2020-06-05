package com.qintess.eventos.controller;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.qintess.eventos.model.CasaDeShow;
import com.qintess.eventos.repositorys.CasaDeShowRepository;


@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:4200")
public class CasaDeShowController {
	
	@Autowired
	private CasaDeShowRepository casadeshowRpo;
	
	
	@GetMapping("/casadeshow")
	public List<CasaDeShow> getUsuarios(){
		
	   return casadeshowRpo.findAll();
	   
	}
	
	@GetMapping("/casadeshow/{id}")
	public List<CasaDeShow> getCasaId(@PathVariable(name = "id") int id) throws Exception {
		
		
		try {
			
			CasaDeShow casadeshow = casadeshowRpo.findById(id);
			
			if (casadeshow == null) {
				
				throw new Exception("Id de Casa de Show não existente na base de dados : " + id);
				
			} else {
				
				return casadeshowRpo.findAll();
			}
			
		} catch (NoSuchElementException e) {
			
			throw new Exception("Id de Casa de Show não existente na base de dados :" + id);

		}

	}
	
	
	@PostMapping("/casadeshow")
	public CasaDeShow postCasa(@RequestBody CasaDeShow casadeshow) {
		
		return casadeshowRpo.save(casadeshow);
	}
	
	
	@DeleteMapping("/casadeshow/{id}")
	public List<CasaDeShow> deleteCasa(@PathVariable(name = "id") int id) {
		
		casadeshowRpo.deleteById(id);
		
		return casadeshowRpo.findAll();
	}	
	
	
	@PutMapping("/casadeshow/{id}")	
	public List<CasaDeShow> putCasa(@PathVariable(name = "id") int id,
								@RequestBody CasaDeShow casadeshow) {
		
		casadeshowRpo.findById(id);
		
		casadeshowRpo.save(casadeshow);
		
		return casadeshowRpo.findAll();
	
	}

}
