package com.Aluguel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Aluguel.Basicas.Cliente;
import com.Aluguel.controlador.ControladorCliente;


@WebServlet("/ServetCliente")
public class ServletCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		Cliente cliente = new Cliente();
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("CPF");
		String endereco = request.getParameter("Endereco");
		String rg = request.getParameter("RG");
		
		cliente.setNome(nome);
		cliente.setCPF(cpf);
		cliente.setEndereco(endereco);
		cliente.setRG(rg);
		
		ControladorCliente ctrlcliente = new ControladorCliente();
		ctrlcliente.cadastrarCliente(cliente);
		
		response.sendRedirect("cadastroCliente.html");

	}

}
