package br.com.projeto.agenda.dto;

import javax.validation.constraints.NotBlank;

import br.com.projeto.agenda.models.Categoria;

public record DtoNovoContato(
		@NotBlank
		String nome,
		String sobrenome,
		String email,
		@NotBlank
		String telefone,
		Categoria categoria,
		String descricao) {

}
