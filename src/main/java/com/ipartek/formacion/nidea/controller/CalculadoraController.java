package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Alert;

/**
 * Servlet implementation class CalculadoraController
 */
public class CalculadoraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher dispatch;

	public float num1 = 0f;
	float num2 = 0f;
	int operacion = 0;
	float resultado = 0f;
	String resul = " ";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// llamada a trav�s de un enlace, petici�n GET
		request.getRequestDispatcher("views/calculadora/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lo que me viene desde un formulario, petici�n POST method="post"

		try {

			getParameters(request);// recogo los par�metros
			calcular();// calculo

			request.setAttribute("resultado", resul);// enviar atributos a la vista
			request.getRequestDispatcher("views/calculadora/resultado.jsp").forward(request, response);

		} catch (NumberFormatException e2) {

			e2.printStackTrace();// te pinta la traza por pantalla
			request.setAttribute("alert", new Alert(e2.getMessage(), Alert.TIPO_WARNING));
			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");

		} catch (Exception e) {

			e.printStackTrace();// te pinta la traza por pantalla
			request.setAttribute("msg", "se ha dado un error");
			request.setAttribute("alert", new Alert(e.getMessage(), Alert.TIPO_WARNING));
			dispatch = request.getRequestDispatcher("views/calculadora/index.jsp");

		} finally {

			dispatch.forward(request, response);
		}
	}

	private void getParameters(HttpServletRequest request) {
		String sNum1 = request.getParameter("num1");
		sNum1 = sNum1.replaceAll(",", ".");
		String sNum2 = request.getParameter("num2");
		sNum2 = sNum2.replaceAll(",", ".");
		String sOperacion = request.getParameter("operacion");

		// TODO aplicar l�gica de negocio

		num1 = Float.parseFloat(sNum1);
		num2 = Float.parseFloat(sNum2);
		operacion = Integer.parseInt(sOperacion);
		resultado = 0f;

	}

	private void calcular() {

		switch (operacion) {

		case 1:
			resultado = num1 + num2;
			break;

		case 2:
			resultado = num1 - num2;
			break;

		case 3:
			resultado = num1 * num2;
			break;

		case 4:
			resultado = num1 / num2;
			break;

		default:
			resultado = 0;
			break;

		}

		resul = Float.toString(resultado);
		resul = resul.replace(".", ",");

	}

}
