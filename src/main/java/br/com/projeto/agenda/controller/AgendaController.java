package br.com.projeto.agenda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.projeto.agenda.dto.DtoNovoContato;
import br.com.projeto.agenda.models.Agenda;
import br.com.projeto.agenda.models.Categoria;
import br.com.projeto.agenda.repository.AgendaRepository;

@Controller
@RequestMapping("/agenda")
public class AgendaController {
	
	@Autowired
	private AgendaRepository agendaRepository;
	
	@GetMapping
	public String minhaAgenda() {
		return "/agenda/index";
	}
	
	@GetMapping("/formNovoContato")
	public String formNovoContato(DtoNovoContato dtoNovoContato, Model model) {
		
		Categoria[] categorias = Categoria.values();
		model.addAttribute("categorias", categorias);
		
		return "agenda/formNovoContato";
	}
	
	@PostMapping("/cadastraContato")
	public String cadastraContato(@Valid DtoNovoContato dtoNovoContato, BindingResult resultado, Model model) {
		
		if (resultado.hasErrors()) {
			Categoria[] categorias = Categoria.values();
			model.addAttribute("categorias", categorias);
			return "/agenda/formNovoContato";
		}
		
		System.out.println(dtoNovoContato.categoria());
		
		agendaRepository.save(new Agenda(dtoNovoContato));
		
		return "redirect:formNovoContato";
	}
}
