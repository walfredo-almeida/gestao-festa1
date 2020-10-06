package com.walf.convidados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.walf.convidados.model.Convidado;

public interface Convidados extends JpaRepository <Convidado, Long>{
     
	long countByAcompanhantes(int chave);
	
	@Query("select sum(c.acompanhantes) from Convidado c")
	  long quantidadeacomp();
	
}