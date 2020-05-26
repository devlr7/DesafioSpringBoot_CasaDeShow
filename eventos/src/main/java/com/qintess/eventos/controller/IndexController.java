package com.qintess.eventos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qintess.eventos.services.UsuarioService;

@Controller

public class IndexController {

	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("")
	public String carregaIndex() {
		
		
		usuarioService.buscaTodos();
		
		return "index";
	}

	
}
