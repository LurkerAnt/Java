package ejercicio_collections_y_algoritmos;

import java.util.Vector;

public class BusquedaConVectorEnArray {

    public static void main(String[] args) {

        /*
        Que es un Vector??
        Vector implements a dynamic array that means it can grow or shrink as required. Like an array, it contains components that can be accessed using an integer index
        They are very similar to ArrayList but Vector is synchronised and have some legacy method which collection framework does not contain.
        It extends AbstractList and implements List interfaces.*/

        Vector<Integer> listaIntegers = new Vector();

        for (int i = 0; i < 20; i++) {
            listaIntegers.add((int) (Math.random() * 10) + 1);
        }

        System.out.println(listaIntegers.indexOf(1));
    }
}
