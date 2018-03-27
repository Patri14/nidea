package com.ipartek.formacion.nidea.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ipartek.formacion.nidea.pojo.Material;

public class MaterialDAO {

	/**
	 * Recupera todos los materiales de la bbdd ordenados por id descencente
	 * 
	 * @return ArrayList<Material>, si no existen registro new ArrayList<Material>()
	 * @throws SQLException
	 */
	public ArrayList<Material> getAll() {

		ArrayList<Material> lista = new ArrayList<Material>();

		final String URL = "jdbc:mysql://192.168.0.42/spoty?user=alumno&password=alumno";

		String sql = "SELECT id,nombre,precio FROM material;";

		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;// como darle al rayo en la bbdd

		try {

			Class.forName("com.mysql.jdbc.Driver");// chekeo que exista la libreria
			con = DriverManager.getConnection(URL);
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();// como darle al rayo en la bbdd

			// creo el material
			Material m = null;

			while (rs.next()) { // mientras tenga una siguiente resultado, inicializo erl material y lo añado

				m = new Material();
				m.setId(rs.getInt("id"));
				m.setNombre(rs.getString("nombre"));
				m.setPrecio(rs.getInt("precio"));

				lista.add(m);
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				if (rs != null) {
					rs.close();
				}

				if (pst != null) {
					pst.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (SQLException e2) {

				e2.printStackTrace();

			}

		}
		return lista;

	}// end getAll()

}
