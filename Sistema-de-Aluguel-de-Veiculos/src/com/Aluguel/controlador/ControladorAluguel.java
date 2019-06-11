package com.Aluguel.controlador;

import com.Aluguel.Basicas.Aluguel;
import com.Aluguel.repositorios.RepositorioAluguel;

public class ControladorAluguel {

	public void novoAluguel(Aluguel alug) {
		try {
			RepositorioAluguel repAlug = new RepositorioAluguel();

			repAlug.novoAluguel(alug);

			System.out.println("Veiculo ou Cliente nao casdastrados!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
