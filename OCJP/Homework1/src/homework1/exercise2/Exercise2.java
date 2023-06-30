package homework1.exercise2;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 * 
 * Crear una lista de números enteros, la cantidad de elementos de la lista 
 * DEBE ser un numero aleatorio dentro del intervalo [10; 20]. Los valores que 
 * se agregan a la lista DEBEN ser números enteros dentro del intervalo [10; 100]
 * Se pide una aplicación en Java que permita cumplir con los siguientes requerimientos:
 * 
 * Imprimir la lista de números generados
 * Imprimir la suma de los números PARES que fueron generados
 * Imprimir la cantidad de números impares que fueron generados.
 * 
 */
public class Exercise2 {
    public static void main(String[] args) {
        RandomList randomList = new RandomList(10, 20, 10, 100);
        
        // Imprimir la lista de números generados
        System.out.println("\n1. Lista aleatoria: ");
        System.out.println(randomList.getListAsString());

        // Imprimir la suma de los números PARES que fueron generados
        System.out.println("\n2. Suma de los números pares: ");
        System.out.println(randomList.getSumEvenNumbers());
        
        // Imprimir la cantidad de números impares que fueron generados.
        System.out.println("\n3. Suma de los números impares: ");
        System.out.println(randomList.getSumOddNumbers());
    }
}
