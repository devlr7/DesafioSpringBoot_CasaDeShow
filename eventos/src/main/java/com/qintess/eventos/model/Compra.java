package com.qintess.eventos.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario FK_usuario;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Evento FK_evento;
	
	private int qtdIngresso;

	
	public Compra() {
		
	}
	
	
	public Compra(Usuario FK_usuario, Evento FK_evento, int qtdIngresso) {
		this.FK_usuario = FK_usuario;
		this.FK_evento = FK_evento;
		this.qtdIngresso = qtdIngresso;
	}
	

	@JsonIgnore
	public Usuario getFK_usuario() {	
		return FK_usuario;
	}
	
	public void setFK_usuario(Usuario FK_usuario) {
		this.FK_usuario = FK_usuario;
	}
	
	@JsonIgnore
	public Evento getEvento() {
		return FK_evento;
	}
	
	public void setEvento(Evento FK_evento) {
		this.FK_evento = FK_evento;
	}
	
	public int getQtdIngresso() {
		return qtdIngresso;
	}
	
	public void setQtdIngresso(int qtdIngresso) {
		this.qtdIngresso = qtdIngresso;
	}
	
	@Override
	public String toString() {
		return "Compra [id =" + id + ", usuario =" + FK_usuario.getId() + ", evento =" + FK_evento.getId() 
				+ ", qtdIngresso =" + qtdIngresso + "]";
	}
	
	
}