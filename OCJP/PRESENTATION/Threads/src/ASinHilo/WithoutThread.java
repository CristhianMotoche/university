package ASinHilo;

/**
 *
 * @author User-WL20
 */
//importacion del paquete de Ingreso y salida de teclado
import java.io.*;
//creacion de la clase principal
public class WithoutThread {
    //Instancia de un objeto de escritura
    static PrintWriter out = new PrintWriter(System.out, true);
    //funcion Principal ejecutable
    public static void main (String args[]) {
	// Primera Tarea: algunos operacion de seugo entrada y salida
	NoThreadPseudoIO pseudo = new NoThreadPseudoIO();
	pseudo.start();
	// Segunda Tarea: una tarea Randomica
	showElapsedTime("Una segunda tarea Inicia");
    }
    
    static long baseTime = System.currentTimeMillis();
    
    // Muestra el tiempo que ha pasado desde que el programa inicio
    
    static void showElapsedTime(String message) {
	long elapsedTime = System.currentTimeMillis() -baseTime;
	out.println(message + " a " + (elapsedTime/1000.0) + " segundos");
    }
}

// Operacion pseudo I/O  corre en  un hilo principal
class NoThreadPseudoIO {
    int data = -1;
    NoThreadPseudoIO() {  // constructor
	WithoutThread.showElapsedTime("Simulacion IO creado tiempo: ");
    }
    //Inicio del metodo run del hilo 
    public void run() {
	WithoutThread.showElapsedTime("Comienza Simulacion IO sin Hilo ");
	try {
	    Thread.sleep(10000);  // 10 segundos
	    data = 999;		// data lista
	    WithoutThread.showElapsedTime("finaliza Simulacion IO sin hilo");
	} catch (InterruptedException e) {}
    }
    //inicio del hilo
    public void start() 
    {
	run();
    }
}