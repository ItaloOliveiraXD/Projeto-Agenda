package br.com.projeto.agenda.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.projeto.agenda.dto.DtoNovoContato;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Agenda {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String sobrenome;
	private String telefone;
	private String email;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	public Agenda(DtoNovoContato dtoNovoContato) {
		this.nome = dtoNovoContato.nome();
		this.sobrenome = dtoNovoContato.sobrenome();
		this.telefone = dtoNovoContato.telefone();
		this.email = dtoNovoContato.email();
		this.descricao = dtoNovoContato.descricao();
		this.categoria = dtoNovoContato.categoria();
	}
}
