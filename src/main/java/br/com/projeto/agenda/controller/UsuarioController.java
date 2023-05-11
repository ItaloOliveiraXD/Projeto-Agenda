package br.com.projeto.agenda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UsuarioController {

	@GetMapping
	public String login() {
		return "login";
	}
}
