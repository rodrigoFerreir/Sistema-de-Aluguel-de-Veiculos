package com.Aluguel.repositorios;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.Aluguel.Basicas.Aluguel;

public class RepositorioAluguel {
	
	private static RepositorioAluguel instanciaAluguel;
	

	
	public static RepositorioAluguel getInstancia() {
		
		if(instanciaAluguel == null) {
			instanciaAluguel = new RepositorioAluguel();
		}else {
			System.out.println("Erro não foi possivel criar instancia de Aluguel");
		}
		
		return instanciaAluguel;
	}
	
	public void novoAluguel(Aluguel alg) throws Exception {	
		//carregar driver
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
				
		System.out.println("Driver ok, no Aluguel");
		//abrir Conexao
		Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/projeto_Aluguel;create=true;user=root;password=root");
		System.out.println("conexao ok, no Aluguel");
		// realizando consultas
		PreparedStatement stmt = conn.prepareStatement("INSERT INTO ALUGUEL(cpf_Cliente, placa_Veiculo, valor, forma_Pagamento) VALUES(?,?,?,?)");
		stmt.setString(1, alg.getCpfCliente());
		stmt.setString(2, alg.getPlacaVeiculo());
		stmt.setFloat(3, alg.getValor());
		stmt.setString(4, alg.getFormadePagamento());
		stmt.execute();
		
		
		//fechar conexao
		conn.commit();
		conn.close();
		
		System.out.println("Aluguel realizado com Sucesso!");
	}
}

