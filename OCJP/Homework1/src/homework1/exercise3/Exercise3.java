/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1.exercise3;

/**
 *
 * @author camm
 *
 * Se desea manejar una lista de robots. Cada robot tiene un número y un porcentaje
 * de vida. El número de elementos de la lista será un valor aleatorio entre 5 y 10.
 * El porcentaje de vida de cada ROBOT será un valor aleatorio entre 1 y 100.
 * Se pide construir una aplicación en java que permita cumplir con la siguiente funcionalidad:
 *
 * Imprimir la lista de robots ordenada por porcentaje de vida de los robots.
   Al principio de la lista DEBEN estar los robots con menos porcentaje de vida.
 * Imprimir la cantidad de robot que tiene más del 50% de vida.
 * Imprimir el número de los TRES robots que tienen mayor porcentaje de vida.
 *
 */
public class Exercise3 {
    public static void main(String[] args) {
        RandomList randomList = new RandomList(5, 10, 1, 100);

        // Imprimir la lista de robot ordenada por porcentaje de vida de los robots.
        // Al principio de la lista DEBEN estar los robots con menos porcentaje de vida
        System.out.println("\n1. Lista de robots ordenada por porcentaje de vida: ");
        randomList.sort();
        System.out.println(randomList.getListAsString());

        // Imprimir la cantidad de robot que tiene más del 50% de vida.
        System.out.println("\n2. Robots con más de 50% de vida: ");
        System.out.println(randomList.getRobotsWithMoreThan50AsString());

        // Imprimir el número de los TRES robots que tienen mayor porcentaje de vida.
        System.out.println("\n3. Número de los robtos con mayor porcentaje de vida: ");
        System.out.println(randomList.getRobotsNumberWithMoreLifeAsString(3));
    }
}
