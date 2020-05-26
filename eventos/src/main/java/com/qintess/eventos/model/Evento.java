package com.qintess.eventos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, length = 2000)
	private String descricao;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dtEvento;
	
	@Column(nullable = false)
	private int qtdade_ingressos;
	
	@Column(nullable = false, scale = 2 )
	private BigDecimal preco = new BigDecimal(0);
	
	@Lob
	@Column(columnDefinition="mediumblob")
	private byte[] imagemEvento;
	
	@javax.persistence.Transient
	private String imagemEncoded;
	
	@OneToMany(mappedBy = "FK_evento", cascade = CascadeType.ALL)
	private List <Compra> compras;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
	private CasaDeShow FK_casaDeShow;

	
	// *************** METODOS **************
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQtdade_ingressos() {
		return qtdade_ingressos;
	}

	public void setQtdade_ingressos(int qtdade_ingressos) {
		this.qtdade_ingressos = qtdade_ingressos;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public byte[] getImagemEvento() {
		return imagemEvento;
	}

	public void setImagemProd(byte[] imagemEvento) {
		this.imagemEvento = imagemEvento;
	}

	public String getImagemEncoded() {
		return imagemEncoded;
	}

	public void setImagemEncoded(String imagemEncoded) {
		this.imagemEncoded = imagemEncoded;
	}
	
	
	@Override
	public String toString() {
		return "Evento [id =" + id + ", nome=" + nome + ", descricao =" + descricao + ", dtEvento=" + dtEvento
				+ ", qtdIngresso =" + qtdade_ingressos + ", Preço =" + preco + ", imagemProd =" + Arrays.toString(imagemEvento)
				+ ", imagemEncoded =" + imagemEncoded + ", casaDeShow=" + FK_casaDeShow + ", compras =" + compras + "]";
	}

	public CasaDeShow getFK_casaDeShow() {
		return FK_casaDeShow;
	}
	
	
}
