/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCajeraRunnable;

/**
 *
 * @author User-WL20
 */
//HILO RUNNABLE
public class MainRunnable implements Runnable{
	//ARGUMENTOS
	private Cliente cliente;
	private Cajera cajera;
	private long initialTime;
	//Constructor
	public MainRunnable (Cliente cliente, Cajera cajera, long initialTime){
		this.cajera = cajera;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}
        //funcion Main ejecutable
	public static void main(String[] args) {
		//INSTANCIA DE CLEINTES
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
		//INSTANCIA DE CAJERAS
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");
		
		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
		//INSTANCIA DE METODO RUNNABLE
		Runnable proceso1 = new MainRunnable(cliente1, cajera1, initialTime);
		Runnable proceso2 = new MainRunnable(cliente2, cajera2, initialTime);
		//INICIO DE LOS HILOS
		new Thread(proceso1).start();
		new Thread(proceso2).start();

	}
        //METODO RUN DE EJECUCION DE HILOS
	@Override
	public void run() {
		this.cajera.procesarCompra(this.cliente, this.initialTime);
	}

}
