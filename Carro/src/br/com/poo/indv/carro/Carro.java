package br.com.poo.indv.carro;

import java.util.HashMap;
import java.util.Map;

public class Carro {
	private Integer id;
	private String marca;
	private String modelo;
	private String cor;
	private String tipoCombustivel;
	private String lancamento;
	private double preco;
	private String placa;
	private Integer idPessoa;
	
	//marca, modelo, cor, combustivel, lancamento, preco, placa
	
	public static Map<Integer, Carro> mapaCarros = new HashMap<>();
	
	public Carro(Integer id, String marca, String modelo, String cor, String tipoCombustivel, String lancamento, double preco,
			String placa, Integer idPessoa) {
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.tipoCombustivel = tipoCombustivel;
		this.lancamento = lancamento;
		this.preco = preco;
		this.placa = placa;
		this.idPessoa = idPessoa;
	}

	public Carro() {

	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public String getTipoCombustivel() {
		return tipoCombustivel;
	}

	public String getLancamento() {
		return lancamento;
	}

	public double getPreco() {
		return preco;
	}

	public String getPlaca() {
		return placa;
	}
	
	public Integer getId() {
		return id;
	}

	public Integer getIdPessoa() {
		return idPessoa;
	}
	
}
