package ECajeraSinHilo;

/**
 *
 * @author User-WL20
 */
//clase principal 
public class Main {
        //funcion void de ejecucion
	public static void main(String[] args) {
                //Instanciacion de los arreglos de compra
		Cliente cliente1 = new Cliente("Cliente 1", new int[] { 2, 2, 1, 5, 2, 3 });
		Cliente cliente2 = new Cliente("Cliente 2", new int[] { 1, 3, 5, 1, 1 });
                    //Instanciacion de los objeots cajera
		Cajera cajera1 = new Cajera("Cajera 1");
		Cajera cajera2 = new Cajera("Cajera 2");

		// Tiempo inicial de referencia
		long initialTime = System.currentTimeMillis();
                //llamada a las funciones y metodos. sin hilos
		cajera1.procesarCompra(cliente1, initialTime);
		cajera2.procesarCompra(cliente2, initialTime);
	}
}
