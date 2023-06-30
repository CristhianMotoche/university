package CIntrefazRunnable;
import java.io.*;
/**
 *
 * @author User-WL20
 */
//creacion de la clase principal
public class RunnableThread {
     //Instancia de un objeto de escritura
    static PrintWriter out = new PrintWriter(System.out, true);
//funcion Principal ejecutable
    public static void main (String args[]) {
	// Primera Tarea: algunos operacion de seugo entrada y salida
	RunnablePseudoIO pseudo = new RunnablePseudoIO();
	Thread thread = new Thread (pseudo);
	thread.start();
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
class RunnablePseudoIO implements Runnable {
    int data = -1;

    RunnablePseudoIO() {  // constructor
	RunnableThread.showElapsedTime("Simulacion de IO en Runnable creado");
    }
 // Metodo de ejecucion de Hilo
    public void run() {
	RunnableThread.showElapsedTime("Simulacion de IO en Runnable Inicia");
	try {
	    Thread.sleep(10000);  // 10 segundos
	    data = 999;		// data lista
	    RunnableThread.showElapsedTime("Simulacion de IO en Runnable Finaliza");
	} catch (InterruptedException e) {}
    }
}