package homework1.exersice4;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 *
 * Se desea manejar DOS listas de números enteros. La cantidad de elementos de la
 * lista 1 DEBE ser un número aleatorio entre 5 y 15. La cantidad de elementos de
 * la lista 2 DEBE ser un numero aleatorio entre 10 y 20. El rango de los números
 * que serán agregados a la lista DEBE estar entre 50 y 550.
 * Se pide construir una aplicación en java que permita cumplir con la siguiente funcionalidad:
 *
 * Imprimir las listas que han sido generadas.
 * Crear una tercera lista que contenga los elementos que están en la lista 1 y
   NO ESTAN en la lista 2
 * Imprimir la tercera lista
 * Crear una cuarta lista que contenga los elementos de la lista 1 que son pares
   y los elementos de la lista 2 que son impares
 * Imprimir la cuarta lista.
 *
 */
public class Exercise4 {
    public static void main(String[] args) {
        RandomList randomList = new RandomList(5, 15, 10, 20, 50, 550);

        // Imprimir las listas que han sido generadas.
        System.out.println("\n1. Imprimir listas: ");
        System.out.println("\n- Primera lista: ");
        System.out.println(getListAsString(randomList.getRandomList1()));
        System.out.println("\n- Segunda lista: ");
        System.out.println(getListAsString(randomList.getRandomList2()));

        // Crear una tercera lista que contenga los elementos que están en la lista 1 y
        // NO ESTAN en la lista 2
        Integer thirdList [] = randomList.generateThirdList();
        // Imprimir la tercera lista
        System.out.println("\n2. Tercera lista: ");
        System.out.println(getListAsString(thirdList));

        // Crear una cuarta lista que contenga los elementos de la lista 1 que son pares
        // y los elementos de la lista 2 que son impares
        Integer fouthList [] = randomList.generateFourthList();
        // Imprimir la cuarta lista
        System.out.println("\n3. Cuarta lista: ");
        System.out.println(getListAsString(fouthList));
    }

    public static String getListAsString(Integer list[]){
        String result = "[";
        for (int item : list) {
            result += " " + item + " ";
        }
        result += "]";
        return result;
    }
}
