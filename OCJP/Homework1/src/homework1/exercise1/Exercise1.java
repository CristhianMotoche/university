package homework1.exercise1;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 * 
 * Ejercicio 1
 * Crear una lista de números decimales, la cantidad de elementos de la lista DEBE
 * ser un número aleatorio dentro del intervalo [5; 10]. Los valores que se agregan
 * a la lista DEBEN ser números decimales dentro del intervalo [45.0; 90.0]
 * Se pide una aplicación en Java que permita cumplir con los siguientes requerimientos
 * 
 * Imprimir la lista de números generados
 * Imprimir el promedio de los valores que fueron incorporados
 * Imprimir el número mayor que forma parte de la lista
 * Imprimir la diferencia entre el segundo número más grande y el segundo más pequeño 
 * 
 */
public class Exercise1 {
    public static void main(String[] args) {
        RandomList randomList = new RandomList(5, 10, 45.0, 90.0);

        // Imprimir la lista de números generados
        System.out.println("\n1. Lista aleatoria: ");
        System.out.println(randomList.getListAsString());

        // Imprimir el promedio de los valores que fueron incorporados
        System.out.println("\n2. Promedio de valores: ");
        System.out.println(randomList.getAverage());

        // Imprimir el número mayor que forma parte de la lista
        System.out.println("\n3. Número mayor de la lista: ");
        System.out.println(randomList.getMaxNumber());

        // Imprimir la diferencia entre el segundo número más grande y el segundo más pequeño 
        System.out.println("\n4. Diferencia entre el segundo número más grande y el segundo más pequeño: ");
        System.out.println(randomList.getDifference());
    }
}
