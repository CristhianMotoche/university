
package ECajeraSinHilo;

/**
 *
 * @author User-WL20
 */
public class Cajera {
//Argumentos getters y setters
	private String nombre;

	public Cajera() {
	}

	public Cajera(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
            //metodo de compra del cliente 
	public void procesarCompra(Cliente cliente, long timeStamp) {

		System.out.println("La cajera " + this.nombre + 
				" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE " + cliente.getNombre() + 
				" EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000	+
				"seg");
                //lectura del arreglo
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {
			this.esperarXsegundos(cliente.getCarroCompra()[i]);
			System.out.println("Procesado el producto " + (i + 1) + 
					" ->Tiempo: " + (System.currentTimeMillis() - timeStamp) / 1000 + 
					"seg");
		}
                    //tiempo de compra
		System.out.println("La cajera " + this.nombre + " HA TERMINADO DE PROCESAR " + 
							cliente.getNombre() + " EN EL TIEMPO: " + 
							(System.currentTimeMillis() - timeStamp) / 1000 + "seg");

	}
        //metodo de esperar segundos para el hilo
	private void esperarXsegundos(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}


}