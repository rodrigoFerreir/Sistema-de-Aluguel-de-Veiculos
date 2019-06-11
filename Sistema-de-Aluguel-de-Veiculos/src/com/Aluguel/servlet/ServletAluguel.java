package com.Aluguel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Aluguel.Basicas.Aluguel;
import com.Aluguel.controlador.ControladorAluguel;

@WebServlet("/ServletAluguel")
public class ServletAluguel extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Aluguel aluguel = new Aluguel();		
		String cpfCliente = request.getParameter("cpfCliente");
		String placaVeiculo = request.getParameter("placaVeiculo");
		String valor = request.getParameter("Valor");
		String formaDePagamento = request.getParameter("formaDepagamento");
		
		aluguel.setCpfCliente(cpfCliente);
		aluguel.setPlacaVeiculo(placaVeiculo);
		aluguel.setValor(Float.valueOf(valor).floatValue());
		aluguel.setFormadePagamento(formaDePagamento);
		
		ControladorAluguel ctrlAluguel = new ControladorAluguel();
		ctrlAluguel.novoAluguel(aluguel);
		
		response.sendRedirect("novoAluguel.html");
	}

}
