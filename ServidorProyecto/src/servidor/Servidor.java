/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author camm
 */
public class Servidor {
	private int puerto;
	private ServerSocket serverSocket;

	public Servidor(int puerto) {
		try {
			this.puerto = puerto;
			this.serverSocket = new ServerSocket(this.puerto);
		} catch (IOException ex) {
			System.err.println("No se pudo conectar. Problemas I/O.\n" + ex);
		}
	}

	public void iniciar(){
		while (true) {
			try {
				ConexionCliente cc = new ConexionCliente(this.serverSocket.accept());
				cc.start();
			} catch (IOException ex) {
				System.err.println("No se pudo realizar la conexión. Consulte a su servidor.\n" + ex);
				System.exit(1);
			}
		}
	}
}
