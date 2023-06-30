/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

/**
 *
 * @author camm
 */
import java.sql.*;

public class Conexion {
	 private Connection conexion;
	 public Conexion() {
        conexion = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conexion = DriverManager.getConnection("jdbc:derby://localhost:1527/sample; create = true; user = app; password = app");
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.print("Error " + ex);
        }
    }
    
    public Connection getConexion(){ return conexion; }
}
