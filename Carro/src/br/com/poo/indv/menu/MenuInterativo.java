package br.com.poo.indv.menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.indv.carro.Carro;
import br.com.poo.indv.pessoa.Pessoa;
import br.com.poo.indv.util.Util;
import br.com.poo.indv.io.LeituraEscrita;

public class MenuInterativo {
	@SuppressWarnings("unused")
	private static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void menu() throws IOException {
		Util.customizer();
		logger.log(Level.INFO, "Menu Interativo\n\n[1]\tListar carros\n[2]\tListar vendedores\n"
				+ "[3]\tGravar no arquivo\n[0]\tSair\n\nDigite a opção desejada: ");
		
		int opc = sc.nextInt();

		switch (opc) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\n\nLista de carros:");
			for (Carro c : Carro.mapaCarros.values()) {
				for (Pessoa p : Pessoa.mapaPessoas.values()) {

					if (c.getIdPessoa().equals(p.getId())) {
						Util.customizer();
						logger.log(Level.INFO, () -> " - Modelo:" + c.getModelo() + " - Cor:" + c.getCor() + " - Combustivel:"
								+ c.getTipoCombustivel() + " - Preço" + c.getPreco() + " - Ano:" + c.getLancamento()
								+ " - Informações do Proprietario:" + p.getNome() + p.getEmail() + p.getTel() + "\n");
					}
				}
			}
			System.out.println("\n\n");
			menu();
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "\n\nLista de vendedores:");
			for (Pessoa p : Pessoa.mapaPessoas.values()) {
				Util.customizer();
				logger.log(Level.INFO, () -> " - Nome:" + p.getNome() + " - Telefone:" + p.getTel() + " - Email:" + p.getEmail());
			}
			System.out.println("\n\n");
			menu();
			break;
		case 3:
			menuArquivo();
			break;
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Volte sempre!");
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			menu();
			break;
		}
	}

	public static void menuArquivo() throws IOException {
		Util.customizer();
		logger.log(Level.INFO, () -> "Menu Consulta em Arquivo\n\n[1]\tListar Modelo por Marca\n"
				+ "[2]\tListar Modelo por Combustivel\n[0]\tVoltar\n\nDigite a opção desejada: ");
		int opc = sc.nextInt();

		switch (opc) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\n\nLista de Modelos por Marca ");
			modeloMarca();
			break;
		case 2:
			Util.customizer();
			logger.log(Level.INFO, "\n\nLista de Modelos por Combustivel ");
			modeloCombustivel();
			break;
		case 0:
			menu();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			menuArquivo();
			break;
		}
	}

	public static void modeloMarca() throws IOException {
		List<Carro> listaCarros = new ArrayList<>();
		Carro carro = null;
		Util.customizer();
		logger.log(Level.INFO, () ->
				"\n\nModelo por marca:\n[1]\tFiat\n[2]\tHonda\n" + "[3]\tToyota\n[4]\tSubaru\n[5]\tVolksWagen\n"
						+ "[0]\tVoltar\n\nDigite a opção desejada: ");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			carro = Carro.mapaCarros.get(1);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getMarca().equalsIgnoreCase("Fiat")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroMarca(carro, listaCarros);
			modeloMarca();
			break;

		case 2:
			carro = Carro.mapaCarros.get(2);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getMarca().equalsIgnoreCase("Honda")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroMarca(carro, listaCarros);
			modeloMarca();
			break;

		case 3:
			carro = Carro.mapaCarros.get(3);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getMarca().equalsIgnoreCase("Toyota")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroMarca(carro, listaCarros);
			modeloMarca();
			break;

		case 4:
			carro = Carro.mapaCarros.get(4);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getMarca().equalsIgnoreCase("Subaru")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroMarca(carro, listaCarros);
			modeloMarca();
			break;

		case 5:
			carro = Carro.mapaCarros.get(5);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getMarca().equalsIgnoreCase("Volkswagen")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroMarca(carro, listaCarros);
			modeloMarca();
			break;

		case 0:
			menuArquivo();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			modeloMarca();
			break;
		}
	}

	public static void modeloCombustivel() throws IOException {
		List<Carro> listaCarros = new ArrayList<>();
		Carro carro = null;
		Util.customizer();
		logger.log(Level.INFO, "\n\nModelo por Combustivel:\n[1]\tGasolina\n[2]\tHíbrido - Gasolina/Elétrico\n"
				+ "[3]\tFlex - Gasolina/Etanol\n[4]\tDiesel\n"
				+ "[0]\tVoltar\n\nDigite a opção desejada: ");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			carro = Carro.mapaCarros.get(1);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getTipoCombustivel().equalsIgnoreCase("Gasolina")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroCombustivel(carro, listaCarros);
			modeloCombustivel();
			break;

		case 2:
			carro = Carro.mapaCarros.get(10);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getTipoCombustivel().equalsIgnoreCase("Hibrido")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroCombustivel(carro, listaCarros);
			modeloCombustivel();
			break;

		case 3:
			carro = Carro.mapaCarros.get(3);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getTipoCombustivel().equalsIgnoreCase("Flex")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
				}
			}
			LeituraEscrita.relatorioCarroCombustivel(carro, listaCarros);
			modeloCombustivel();
			break;

		case 4:
			carro = Carro.mapaCarros.get(6);
			listaCarros.clear();
			for (Carro c : Carro.mapaCarros.values()) {
				if (c.getTipoCombustivel().equalsIgnoreCase("Diesel")) {
					Util.customizer();
					logger.log(Level.INFO, c.getModelo());
					listaCarros.add(c);
					
				}
			}
			LeituraEscrita.relatorioCarroCombustivel(carro, listaCarros);
			modeloCombustivel();
			break;

		case 0:
			menuArquivo();
			break;
		default:
			Util.customizer();
			logger.log(Level.INFO, "Opção inválida!");
			modeloCombustivel();
			break;
		}
	}

}
