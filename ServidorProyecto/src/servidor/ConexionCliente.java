/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package servidor;

import base.Tabla;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author camm
 */
public class ConexionCliente extends Thread{
	private BufferedReader entrada;
	private PrintWriter salida;
	private Socket cliente;

	public ConexionCliente(Socket cliente) {
		this.cliente = cliente;
		try {
			this.entrada = new BufferedReader(new InputStreamReader(this.cliente.getInputStream()));
			this.salida = new PrintWriter(this.cliente.getOutputStream(), true);
		} catch (IOException ex) {
			System.out.println("Error al intentar establecer el procedimiento de lectura/escritura\n" + ex);
			System.exit(1);
		}
	}

	@Override
	public void run(){
		recibirMensaje();
	}

	private void recibirMensaje() {
		try {
			String textoRecibido;
			while ((textoRecibido = this.entrada.readLine()) != null) {
				String resultado = procesar(textoRecibido.trim());
				System.out.println("Hash: " + textoRecibido + ". Valor: " + resultado);
				enviarMensaje(resultado);
			}
		} catch (IOException ex) {
			System.out.println("Error al intentar leer/escribir:\n" + ex);
			System.exit(1);
		}
	}

	private void enviarMensaje(String mensaje) {
		this.salida.println(mensaje);
	}

	private String procesar(String valor){
		Tabla tabla = new Tabla();
		String clave = tabla.encontrarClavePorValor(valor).clave;
		return (clave == null) ? "No encontrado" : clave;
	}
}
