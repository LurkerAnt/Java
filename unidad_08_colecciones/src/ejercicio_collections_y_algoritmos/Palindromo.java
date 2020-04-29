package ejercicio_collections_y_algoritmos;

import java.util.Scanner;
import java.util.Stack;

public class Palindromo {
    public static void main(String[] args) {
    /*
    *   Use la clase Stack<E> de Java para invertir una palabra. A partir de este programa determine si una palabra es palíndromo
    *   (se lee igual de izquierda a derecha que de derecha a izquierda: reconocer, rotor, somos,..)
    *
    * */

        Stack<Character> stackPrueba = new Stack<Character>();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce una palabra:");
        String palindromo = teclado.next();

        for (int i = 0; i < palindromo.length(); i++) {
            stackPrueba.add(palindromo.charAt(i));
        }
        String palindromo2 = "";
        while (!stackPrueba.empty()) {
            palindromo2 += stackPrueba.pop();
        }

        if (palindromo.equals(palindromo2)) {
            System.out.println("Es un palíndromo.");
        } else {
            System.out.println("NO es un palíndromo.");
        }

        teclado.close();
    }

}
