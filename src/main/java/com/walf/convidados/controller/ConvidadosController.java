package com.walf.convidados.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.walf.convidados.model.Convidado;
import com.walf.convidados.repository.Convidados;

@RequestMapping("/convidados")
@Controller
public class ConvidadosController {

	@Autowired
	private Convidados convidados;

	// @Autowired
	// private Convidados2 convidados2;

	@DeleteMapping("/{id}")
	public String remover(@PathVariable Long id, RedirectAttributes attributes) {
		convidados.delete(id);
		attributes.addFlashAttribute("mensagem", "convidado removido com sucesso!");
		return "redirect:/convidados";
	}
	
	@GetMapping("/delete")
	public String remover1(Long id, RedirectAttributes attributes) {
		convidados.delete(id);
		attributes.addFlashAttribute("mensagem", "convidado removido com sucesso!");
		return "redirect:/convidados";
	}
	

	@GetMapping("cadastro")
	public ModelAndView cadastrar(Convidado convidado) {
		ModelAndView modelAndView = new ModelAndView("Cadastro");
		modelAndView.addObject(convidado);

		return modelAndView;
	}

	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(new Convidado());
		// modelAndView.addObject("totalconv", convidados.count() );
		modelAndView.addObject("totalacomp", convidados.quantidadeacomp());
		return modelAndView;
	}

	@PostMapping
	public String salvar(@Valid Convidado convidado, BindingResult result) {
		if (result.hasErrors()) {
			return "/Cadastro";

		}

		convidados.save(convidado);
		return ("redirect:/convidados");
	}

	@PostMapping("salvarr")
	public ModelAndView salvarr(@Valid Convidado convidado, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(convidado);

		}

		convidados.save(convidado);
		return new ModelAndView("redirect:/convidados");
	}

	@ModelAttribute("totalconv")
	public long contarConvidados() {
		return convidados.count();
	}

	@ResponseBody
	@GetMapping("/todos")
	public List<Convidado> todos() {
		return convidados.findAll();
	}

}
