package br.com.projeto.agenda.models;

public enum Categoria {

	FAMILIA("familia"),
	AMIGO("amigo"),
	CONHECIDO("conhecido"),
	DESCONHECIDO("desconhecido");
	
	private String valor;
	
	private Categoria(String valor) {
		this.valor = valor;
	}
	
	public String getValor() {
		return this.valor;
	}
}
