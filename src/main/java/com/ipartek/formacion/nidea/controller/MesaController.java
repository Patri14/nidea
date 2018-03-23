package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class MesaController
 */
public class MesaController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// crear mesa
		Mesa m = new Mesa();

		// recoger parametros****siempre string***
		String sPatas = request.getParameter("patas");
		String sDimension = request.getParameter("dimension");
		String sMaterial = request.getParameter("material");
		String sCustom = request.getParameter("custom");

		if (sCustom == null) {
			m.setCustom(false);
		} else {// viene on
			m.setCustom(true);
		}

		// si los parametros no son nulos creo una mesa segun los parametros del usuario
		if (sPatas != null) {

			int patas = Integer.parseInt(sPatas);
			m.setNumeroPatas(patas);

		}

		if (sDimension != null) {

			int dimension = Integer.parseInt(sDimension);
			m.setDimension(dimension);

		}

		if (sMaterial != null) {

			int material = Integer.parseInt(sMaterial);
			m.setMaterial(material);

		}

		// enviar atributos a la JSP
		request.setAttribute("mesa", m);

		// ir a la JSP
		request.getRequestDispatcher("mesa.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
