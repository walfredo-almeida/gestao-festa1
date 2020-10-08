package com.walf.convidados.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walf.convidados.model.Convidado;
import com.walf.convidados.repository.Convidados;

@RestController
@RequestMapping("/api/convidados")
public class ConvidadosResources {

	@Autowired
	private Convidados convidados;
	
	@GetMapping
	public List<Convidado> todos() {
		return convidados.findAll();
	}
	
	@GetMapping("/{id}")
	public Convidado buscar(@PathVariable Long id) {
		return convidados.findOne(id);
	}
	
		
}
