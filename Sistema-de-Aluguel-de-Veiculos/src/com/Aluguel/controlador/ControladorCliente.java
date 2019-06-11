package com.Aluguel.controlador;

import com.Aluguel.Basicas.Cliente;
import com.Aluguel.repositorios.RepositorioCliente;

public class ControladorCliente {
	
	public void cadastrarCliente(Cliente cli) {
		
		try {
			RepositorioCliente repCliente = RepositorioCliente.getInstancia();	
			
			boolean existente = repCliente.clienteExistente(cli);
			
			if(!existente) {
				repCliente.inserirCliente(cli);
			}else {
				System.out.println("Cliente ja cadastrado!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
