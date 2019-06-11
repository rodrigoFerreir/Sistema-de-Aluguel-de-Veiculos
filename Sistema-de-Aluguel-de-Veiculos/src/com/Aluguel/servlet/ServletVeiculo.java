package com.Aluguel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Aluguel.Basicas.Veiculo;
import com.Aluguel.controlador.ControladorVeiculo;

@WebServlet("/ServletVeiculo")
public class ServletVeiculo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		Veiculo veiculo = new Veiculo();
		String chassi = request.getParameter("Chassi");
		String placa = request.getParameter("Placa");
		String cor = request.getParameter("Cor");
		String modelo = request.getParameter("Modelo");
		String marca = request.getParameter("Marca");
		
		veiculo.setChassi(chassi);
		veiculo.setPlaca(placa);
		veiculo.setCor(cor);
		veiculo.setModelo(modelo);
		veiculo.setMarca(marca);
		
		ControladorVeiculo ctrlVeiculo = new ControladorVeiculo();
		ctrlVeiculo.cadastrarVeiculo(veiculo);
		
		response.sendRedirect("cadastroVeiculo.html");
	}

}
