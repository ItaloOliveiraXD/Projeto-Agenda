package br.com.projeto.agenda.models;

import java.time.LocalDate;

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
public class Contato {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String sobrenome;
	private String telefone;
	private LocalDate dataCriacao;
	private String email;
	private String descricao;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	
	public Contato(DtoNovoContato dtoNovoContato) {
		
		String nome = dtoNovoContato.nome().substring(0, 1).toUpperCase().concat(dtoNovoContato.nome().substring(1));
		
		if (sobrenome != null) {
			String sobrenome = dtoNovoContato.sobrenome().substring(0, 1).toUpperCase().concat(dtoNovoContato.sobrenome().substring(1));
			this.sobrenome = sobrenome;
		} 
		
		this.nome = nome;
		this.telefone = dtoNovoContato.telefone();
		this.email = dtoNovoContato.email();
		this.categoria = dtoNovoContato.categoria();
		this.descricao = dtoNovoContato.descricao();
		this.dataCriacao = LocalDate.now();
	}
}
