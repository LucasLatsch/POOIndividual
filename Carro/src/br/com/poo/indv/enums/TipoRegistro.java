package br.com.poo.indv.enums;

public enum TipoRegistro {
		CARRO("Carro", 1),
		PESSOA("Pessoa", 2);
	
	private String tipo;
	private int id;
	
	TipoRegistro(String tipo, int id){
		this.tipo = tipo;
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public int getId() {
		return id;
	}
	
	
}
