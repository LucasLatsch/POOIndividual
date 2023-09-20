package br.com.poo.indv.pessoa;

import java.util.HashMap;
import java.util.Map;

public class Pessoa {
	private Integer id;
	private String dataNascimento;
	private String tel;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	
	public static Map<Integer, Pessoa> mapaPessoas = new HashMap<>();
	
	public Pessoa(Integer id, String dataNascimento, String tel, String nome, String cpf, String email, String senha) {
		this.id = id;
		this.dataNascimento = dataNascimento;
		this.tel = tel;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}

	public Pessoa() {

	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public String getTel() {
		return tel;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Integer getId() {
		return id;
	}

}
