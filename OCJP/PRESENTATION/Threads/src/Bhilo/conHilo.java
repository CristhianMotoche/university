package Bhilo;
//importacion del paquete de Ingreso y salida de teclado
import java.io.*;
/**
 *
 * @author User-WL20
 */
//creacion de la clase principal
public class conHilo {
    //Instancia de un objeto de escritura
    static PrintWriter out = new PrintWriter(System.out, true);
//funcion Principal ejecutable
    public static void main (String args[]) {
	// Primera Tarea: algunos operacion de seugo entrada y salida
	ThreadedPseudoIO pseudo = new ThreadedPseudoIO();
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

// Operacion de IO se ejecuta en un hilo separado
class ThreadedPseudoIO extends Thread {
    int data = -1;
    ThreadedPseudoIO() {  // constructor
	conHilo.showElapsedTime("Simulacion de IO creada en un hilo separado");
    }
  // Metodo de ejecucion de Hilo
    public void run () {
	conHilo.showElapsedTime("Simulacion de IO en Hilo comienza");
	try {
	    Thread.sleep(10000);  // 10 segundos
	    data = 999;		// data lista
	    conHilo.showElapsedTime("Simulacion de IO en Hilo Finaliza");
	} catch (InterruptedException e) {}
    }
}
