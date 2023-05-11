package br.com.projeto.agenda.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.projeto.agenda.dto.DtoNovoContato;
import br.com.projeto.agenda.models.Categoria;
import br.com.projeto.agenda.models.Contato;
import br.com.projeto.agenda.repository.AgendaRepository;

@Controller
@RequestMapping("/agenda")
public class AgendaController {

	@Autowired
	private AgendaRepository agendaRepository;

	@GetMapping
	public String minhaAgenda(Model model) {

		List<Contato> contatos = agendaRepository.findAll();

		model.addAttribute("contatos", contatos);

		return "/agenda/index";

	}

	@GetMapping("/formNovoContato")
	public String formNovoContato(DtoNovoContato dtoNovoContato, Model model) {

		Categoria[] categorias = Categoria.values();
		model.addAttribute("categorias", categorias);

		return "/agenda/formNovoContato";
	}

	@Transactional
	@PostMapping("/cadastraContato")
	public String cadastraContato(@Valid DtoNovoContato dtoNovoContato, BindingResult resultado, Model model,
			RedirectAttributes redirectAttributes) {

		if (resultado.hasErrors()) {
			Categoria[] categorias = Categoria.values();
			model.addAttribute("categorias", categorias);

			return "/agenda/formNovoContato";
		}

		boolean existsTelefone = agendaRepository.existsByTelefone(dtoNovoContato.telefone());

		if (existsTelefone) {
			String error = "Esse telefone já existe!";
			Categoria[] categorias = Categoria.values();
			model.addAttribute("categorias", categorias);
			model.addAttribute("error", error);
			return "/agenda/formNovoContato";
		}

		String success = "Cadastrado com sucesso!";
		redirectAttributes.addFlashAttribute("success", success);

		agendaRepository.save(new Contato(dtoNovoContato));

		return "redirect:formNovoContato";
	}

	@GetMapping("/verContato/{id}")
	public String verContato(@PathVariable("id") long id, Model model) {

		Contato contato = agendaRepository.findById(id).get();

		model.addAttribute("contato", contato);

		return "/agenda/detalhes";
	}

	@Transactional
	@GetMapping("/deletarContato/{id}")
	public String deletarContato(@PathVariable("id") long id) {

		Contato contato = agendaRepository.findById(id).get();

		agendaRepository.delete(contato);

		return "redirect:/agenda";
	}

}
