/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author camm
 */
public class Tabla {
	private final Conexion conexion;
	private String consulta;

	public Tabla() {
		this.conexion = new Conexion();
		this.consulta = "";
	}

	public boolean insertar(Resultado resultado){
		this.consulta = "INSERT INTO TABLA (CLAVE, VALOR) VALUES (?, ?)";
		try {
			PreparedStatement pst = conexion.getConexion().prepareStatement(this.consulta);
			pst.setString(1, resultado.clave);
			pst.setString(2, resultado.valor);
			return pst.executeUpdate()!= 0;
		} catch (SQLException ex) {
			return false;
		}
	}

	public Resultado encontrarClavePorValor(String valor){
		Resultado resultado = new Resultado();
		this.consulta = "SELECT * FROM TABLA WHERE valor = '" + valor + "'";
		try {
			Statement st = conexion.getConexion().createStatement();
			ResultSet rs = st.executeQuery(this.consulta);
			while (rs.next()) {
				resultado.clave = rs.getString("clave");
				resultado.valor = rs.getString("valor");
			}
		} catch (SQLException ex) {
			System.err.println("Error: " + ex);
		}
		return resultado;
	}
}
