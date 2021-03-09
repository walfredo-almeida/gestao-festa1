package com.walf.convidados.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;


@Entity
public class Convidado implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	@Size(min = 3, max = 60, message = "O nome  deve ter entre {min} e {max} caracteres.")
	@Column(nullable = false, unique = true, length = 60)
	@NotBlank(message = "O nome é obrigatório.")
	private String nome;
	@Size(min = 3, max = 60, message = "O nome  deve ter entre {min} e {max} caracteres.")
	@Column( nullable = false,unique = true, length = 60)
	@NotBlank(message = "O nome1 é obrigatório.")
	private String nome1;
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
	public String getNome1() {
		return nome1;
	}
	public void setNome1(String nome1) {
		this.nome1 = nome1;
	}
	

	
	
}
