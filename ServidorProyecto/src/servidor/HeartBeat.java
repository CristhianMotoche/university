/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import monitor.Monitor;

/**
 *
 * @author camm
 */
public class HeartBeat extends Thread{
	private Socket socket;
	private PrintWriter salida;
	String host;
	int puerto;

	public HeartBeat(int puerto, String host) {
		this.puerto = puerto;
		this.host = host;
	}
	@Override
	public void run(){
		establecerConexion();
		enviarLatidos();
	}

	private void enviarLatidos() {
		Monitor monitor = new Monitor();
		while (true) {
			try {
				String resultado = monitor.resultCommands();
				System.out.println(resultado);
				this.salida.println(resultado);
				Thread.sleep(30000);
			} catch (InterruptedException ex) {
				System.err.println("Se ha probocado un problema al intentar enviar. \n" + ex);
			}
		}
	}

	private void establecerConexion() {
		try {
			this.socket = new Socket(this.host, this.puerto);
			this.salida = new PrintWriter(this.socket.getOutputStream(), true);
		} catch (IOException ex) {
			System.err.println("No se pudo establecer la conexión\n" + ex);
			interrupt();
		}
	}
}
