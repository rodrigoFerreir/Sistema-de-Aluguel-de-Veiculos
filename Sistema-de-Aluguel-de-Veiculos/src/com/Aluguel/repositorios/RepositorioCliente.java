package com.Aluguel.repositorios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Aluguel.Basicas.Cliente;

public class RepositorioCliente {
	
	public static RepositorioCliente instanciaCliente;
	
	public static RepositorioCliente getInstancia() {
		
		if(instanciaCliente == null) {
			instanciaCliente = new RepositorioCliente();
		}else {
			System.out.println("Instancia de Cliente já criada");
		}
			return instanciaCliente;
	}
	
	public void inserirCliente(Cliente clie) throws Exception {
		//carregar driver
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		
		System.out.println("Driver ok");
		//abrir Conexao
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/projeto_Aluguel;create=true;user=root;password=root");
		System.out.println("conexao ok");
		//realizando consultas
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO CLIENTE(cpf, nome, rg, endereco) VALUES(?,?,?,?)");
		stmt.setString(1, clie.getCPF());
		stmt.setString(2, clie.getNome());
		stmt.setString(3, clie.getRG());
		stmt.setString(4, clie.getEndereco());
		stmt.execute();
		
		System.out.println("Cliente inserido no banco de dados");
		
		//fechar conexao
		conn.commit();
		conn.close();
		
		
	}
	
	public boolean clienteExistente(Cliente cliente) throws Exception {
		boolean clieExistente = false;
		
		//carregar driver
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				
		System.out.println("Driver ok");
		//abrir Conexao
				
		Connection conect = DriverManager.getConnection("jdbc:derby://localhost:1527/projeto_Aluguel;create=true;user=root;password=root");
				
		PreparedStatement consulta = conect.prepareStatement("SELECT cpf FROM CLIENTE WHERE cpf = ?");
		consulta.setString(1, cliente.getCPF());
		ResultSet resultConsulta = consulta.executeQuery();
		
		if (resultConsulta != null) {
			while (resultConsulta.next()) {
				String cpfBanco = resultConsulta.getString("cpf");
				if (cpfBanco != null) {
					clieExistente = true;
				}
			}
		}
		
		
		//fechar conexao
		conect.commit();
		conect.close();
		
		return clieExistente;
	}

}
