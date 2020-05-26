package com.qintess.eventos.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CasaDeShow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private int capacidade;
	
	@OneToMany(mappedBy = "FK_casaDeShow", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Evento> evento;
	
	
	// ********* CONSTRUOR ********
	
	public CasaDeShow(String nome, String endereco, int capacidade, List<Evento> evento) {
		this.nome = nome;
		this.endereco = endereco;
		this.capacidade = capacidade;
		this.evento = evento;
	}

	// ********* METODOS **********
	
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}

	@Override
	public String toString() {
		
		return "CasaDeShow [id =" + id + ", nome =" + nome + ", capacidade =" + capacidade + "]";
		
	}


	
}
