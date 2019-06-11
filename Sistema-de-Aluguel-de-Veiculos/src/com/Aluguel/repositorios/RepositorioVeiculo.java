package com.Aluguel.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Aluguel.Basicas.Veiculo;

public class RepositorioVeiculo {
	public static RepositorioVeiculo instanciaVeiculo;
	
	public static RepositorioVeiculo getInstanciaVeiculo() {
		
		if(instanciaVeiculo == null) {
			instanciaVeiculo = new RepositorioVeiculo();
		}else {
			System.out.println("Erro, não foi possivel criar instancia de Veiculo");
		}
		
		return instanciaVeiculo;
	}
	
	public void inserirVeiculo(Veiculo veic) throws Exception {
				//carregar driver
				Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				
				System.out.println("Driver ok");
				//abrir Conexao
				
				Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/projeto_Aluguel;create=true;user=root;password=root");
				System.out.println("conexao ok");
				
				//realizando consultas
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO VEICULO(placa, chassi, cor, marca, modelo) VALUES(?,?,?,?,?)");
				stmt.setString(1, veic.getPlaca());
				stmt.setString(2, veic.getChassi());
				stmt.setString(3, veic.getCor());
				stmt.setString(4, veic.getMarca());
				stmt.setString(5, veic.getModelo());
				stmt.execute();
				
				System.out.println("Veiculo inserido no banco de dados");
				//fechar conexao
				conn.commit();
				conn.close();
	}
	
	public boolean veiculoExistente(Veiculo veiculo) throws Exception {
		boolean veicExistente = false;
		//carregar driver
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		
		System.out.println("Driver ok");
		//abrir Conexao
		
		Connection conect = DriverManager.getConnection("jdbc:derby://localhost:1527/projeto_Aluguel;create=true;user=root;password=root");
		
		PreparedStatement consulta = conect.prepareStatement("SELECT placa FROM VEICULO WHERE placa = ?");
		consulta.setString(1, veiculo.getPlaca());
		ResultSet resultConsulta = consulta.executeQuery();
		
		if(resultConsulta != null) {
			while (resultConsulta.next()) {
				String placaBanco = resultConsulta.getString("placa");
				
				if(placaBanco != null) {
					veicExistente = true;
				}				
			}			
		}
		
		
		//fechar conexao
		conect.commit();
		conect.close();
		
		return veicExistente;
	}

}















