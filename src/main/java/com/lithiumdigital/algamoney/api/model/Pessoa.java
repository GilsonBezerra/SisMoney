package com.lithiumdigital.algamoney.api.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long codigo;
	
	@NotNull
	private String nome;
	
	@Embedded
	private Endereco endereco;
	public Endereco getEndereco() {
		return endereco;
	}
	
	public Pessoa() {}
	
	public Pessoa (Long codigo, String nome, Endereco endereco) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		
		}
	

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	
	
	
	
	

}
