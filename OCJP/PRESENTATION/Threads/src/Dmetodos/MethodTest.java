
package Dmetodos;
/**
 *
 * @author User-WL20
 */
import java.io.*;
//creacion de la clase principal
public class MethodTest {
     //Instancia de un objeto de escritura
    static PrintWriter out = new PrintWriter(System.out, true);
    //funcion Principal ejecutable
    public static void main (String args[]) {
        //instaciacion de objetos
	FirstThread first = new FirstThread();
	SecondThread second = new SecondThread();
        //ejecucion de los hilos
	first.start();//metodo start
	second.start();
        //try cathc para capturas de errores
	try {
	    out.println("Esperando para que el primer hilo finalize...");
	    first.join();//Metodo Join
	    out.println("Es una espera larga!!");
	    out.println("Despertando el segundo Hilo ...");
	    synchronized(second) {
	      second.notify();//metodo notify
	    }
	    out.println("Esperando que el segundo Hilo Finalize ...");
	    second.join();
	} catch (InterruptedException e) {}
	out.println("Estoy listo para finalizar tambien.");
    }
}
// clase primer hilo heredada
class FirstThread extends Thread {
    //metodo run de hilo
    public void run () {
	try {
	    MethodTest.out.println("  Primer hilo comienza a ejecutar.");
	    sleep(10000);//metodo sleeo
	    MethodTest.out.println(" Primer hilo finaliza la ejecucion .");
	} catch (InterruptedException e) {}
    }
}
// clase segundo hilo heredada
class SecondThread extends Thread {
    public synchronized void run () {
	try {
	    MethodTest.out.println("  Segundo hilo comienza la ejecucion.");
	    MethodTest.out.println("  Segundo hilo se suspende el mismo.");
	    wait();//metodo waith de espera
	    MethodTest.out.println("  Segundo Hilo se ejecuta de nuevo y finaliza.");
	}catch (InterruptedException e) {}
    }
}
