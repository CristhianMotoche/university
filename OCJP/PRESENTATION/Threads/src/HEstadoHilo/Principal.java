package HEstadoHilo;


public class Principal {
    public static void main(String[] args) {
        Thread miHilo1 = new HiloEjemplo("Hilo Uno");
        Thread miHilo2 = new HiloEjemplo("Hilo Dos");
        miHilo1.start();
        miHilo2.start();
        System.out.println("Fin del Proceso");
    }
    
}
