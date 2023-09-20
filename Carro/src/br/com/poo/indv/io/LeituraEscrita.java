package br.com.poo.indv.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.poo.indv.carro.Carro;
import br.com.poo.indv.enums.TipoRegistro;
import br.com.poo.indv.pessoa.Pessoa;

public class LeituraEscrita {

	static final String PATH_BASICO = ".\\temp\\";
	static final String EXTENSAO = ".txt";

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(";");
				if (dados[0].equalsIgnoreCase(TipoRegistro.CARRO.getTipo())) {
					Carro c = new Carro(Integer.parseInt(dados[1]), dados[2], dados[3], 
							dados[4], dados[5], dados[6], Double.parseDouble(dados[7]), dados[8], Integer.parseInt(dados[9]));
					Carro.mapaCarros.put(Integer.parseInt(dados[1]), c);
				} else if (dados[0].equalsIgnoreCase(TipoRegistro.PESSOA.getTipo())) {
					Pessoa p = new Pessoa(Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5], dados[6], dados[7]);
					Pessoa.mapaPessoas.put(Integer.parseInt(dados[1]), p);
				}
			} else {
				break;
			}
		}
		buffRead.close();
	}

	//VERIFICAR
	
	public static void relatorioCarroMarca(Carro carro, List<Carro> ca) throws IOException {
		String nomeArquivo = carro.getMarca();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO, true));
		buffWrite.append("-------------- RELATÓRIO --------------\n");
		buffWrite.append(carro.getMarca() + ":\n\n");
		if(!ca.isEmpty()) {
			for(Carro c : ca) {
				buffWrite.append(" - Modelo:" + c.getModelo() + " - Cor:" + c.getCor()
				+ " - Combustivel:" + c.getTipoCombustivel() + " - Preço" + c.getPreco()
				+ " - Ano:" + c.getLancamento() + "\n");
			}
		} else {
			buffWrite.append("Não tem carro pra essa marca!!\n");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		buffWrite.append("\nData da consulta: " + sdf.format(date) + "\n");
		buffWrite.append("-------------- FIM RELATÓRIO --------------\n");
		buffWrite.close();
	}
	
	public static void relatorioCarroCombustivel(Carro carro, List<Carro> ca) throws IOException {
		String nomeArquivo = carro.getTipoCombustivel();
		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nomeArquivo + EXTENSAO, true));
		buffWrite.append("-------------- RELATÓRIO --------------\n");
		buffWrite.append(carro.getTipoCombustivel() + ":\n\n");
		if(!ca.isEmpty()) {
			for(Carro c : ca) {
				buffWrite.append(" - Marca:" + c.getMarca() + " - Modelo:" + c.getModelo() + " - Cor:" + c.getCor()
				+ " - Preço" + c.getPreco() + " - Ano:" + c.getLancamento() + "\n");
			}
		} else {
			buffWrite.append("Não tem carro com esse tipo de combustivel!!\n");
		}
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		buffWrite.append("\nData da consulta: " + sdf.format(date) + "\n");
		buffWrite.append("-------------- FIM RELATÓRIO --------------\n");
		buffWrite.close();
	}

}
