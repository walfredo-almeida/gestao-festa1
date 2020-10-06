package com.walf.convidados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.walf.convidados.model.Convidado;
import com.walf.convidados.repository.Convidados;


@RequestMapping("/convidados")
@Controller
public class ConvidadosController {
	
	
	@Autowired
	private Convidados convidados;
	
	//@Autowired
	//private Convidados2 convidados2;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(new Convidado());
		modelAndView.addObject("totalconv", convidados.count() );
		modelAndView.addObject("totalacomp", convidados.quantidadeacomp() );
		return modelAndView;
		}

	@PostMapping
	public String salvar(Convidado convidado) {
	convidados.save(convidado);
	return "redirect:/convidados";
	}




}


