package com.Aluguel.controlador;

import com.Aluguel.Basicas.Veiculo;
import com.Aluguel.repositorios.RepositorioVeiculo;

public class ControladorVeiculo {
	
	public void cadastrarVeiculo(Veiculo veic) {
		try {
			RepositorioVeiculo repVeiculo = RepositorioVeiculo.getInstanciaVeiculo();
			boolean existente = repVeiculo.veiculoExistente(veic);
			
			if(!existente) {
				repVeiculo.inserirVeiculo(veic);
			}else {
				System.out.println("Veiculo ja cadastrado!");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
