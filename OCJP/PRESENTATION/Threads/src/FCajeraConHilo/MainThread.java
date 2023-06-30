/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FCajeraConHilo;

/**
 *
 * @author User-WL20
 */
//HILO HEREDADO
public class MainThread {

	public static void main(String[] args) {
                //Instantacion de Objetos 
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		CajeraThread cajera1 = new CajeraThread("Cajera 1", cliente1, initialTime);
		CajeraThread cajera2 = new CajeraThread("Cajera 2", cliente2, initialTime);
                //ejecucion de los hilos con metodo heredado
		cajera1.start();
		cajera2.start();
	}
}
