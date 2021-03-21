package com.walf.convidados.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


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
	@Column( nullable = false,length = 60)
	@NotBlank(message = "O sobrenome é obrigatório.")
	private String sobrenome;
	
	@NotNull(message = "Acompanhantes não pode estar vazio")
	private Integer acompanhantes;
	
	@NotNull (message = "Data não pode estar vazio")
	@DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
	//@DateTimeFormat(iso= DateTimeFormat.ISO.TIME, pattern = "" pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name= "data_entrada", nullable = false, columnDefinition = "DATE")
	private LocalDateTime dataEntrada;
	
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
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public @NotNull(message = "Data não pode estar vazio") LocalDateTime getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(@NotNull(message = "Data não pode estar vazio") LocalDateTime dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	

	
	
}
