package com.walf.convidados.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Convidado implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	@NotBlank(message = "O nome é obrigatório.")
	private String nome;
	@NotNull(message = "Acompanhantes não pode estar vazio")
	private Integer acompanhantes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAcompanhantes() {
		return acompanhantes;
	}
	public void setAcompanhantes(Integer acompanhantes) {
		this.acompanhantes = acompanhantes;
	}
	

	
	
}
