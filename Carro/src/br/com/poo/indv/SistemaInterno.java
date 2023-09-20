package br.com.poo.indv;

import java.io.IOException;

import br.com.poo.indv.io.LeituraEscrita;
import br.com.poo.indv.menu.MenuInterativo;

public class SistemaInterno {

	public static void main(String[] args) {
		try {
			LeituraEscrita.leitor("BancoDeDados");
			MenuInterativo.menu();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
