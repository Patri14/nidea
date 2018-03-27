package com.ipartek.formacion.nidea.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.nidea.model.MaterialDAO;
import com.ipartek.formacion.nidea.pojo.Alert;
import com.ipartek.formacion.nidea.pojo.Mesa;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String view = " ";
	private Alert alert = new Alert();

	private static final String USER = "admin";
	private static final String PASS = "admin";

	public LoginController() {
		super();

	}

	/**
	 * DO GET
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		view = "login.jsp";
	}

	/**
	 * DO POST
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Lo que me viene desde un formulario, petici�n POST method="post"
		Mesa m = new Mesa();
		MaterialDAO dao = new MaterialDAO();

		try {

			String usuario = request.getParameter("usuario");
			String password = request.getParameter("password");

			// enviar atributos a la JSP
			request.setAttribute("mesa", m);
			request.setAttribute("materiales", dao.getAll());

			if (USER.equalsIgnoreCase(usuario) && PASS.equals(password)) {

				view = "backoffice/index.jsp";
				alert = new Alert("Ongi Etorri", Alert.TIPO_PRIMARY);

			} else {

				view = "login.jsp";
				alert = new Alert("Credenciales incorrectas, prueba de nuevo");
			}

		} catch (Exception e) {
			e.printStackTrace();
			view = "login.jsp";
			alert = new Alert();

		} finally {
			request.setAttribute("alert", alert);
			request.getRequestDispatcher(view).forward(request, response);
		}

	}

}
