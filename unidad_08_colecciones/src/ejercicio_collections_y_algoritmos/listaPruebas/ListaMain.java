package ejercicio_collections_y_algoritmos.listaPruebas;

import java.util.Collections;

public class ListaMain implements Lista {


    public void addElement(Integer newNumber) {
        listaElementos.add(newNumber);

    }

    public void showSize() {
        System.out.println(listaElementos.size());
    }

    public void deleteHigherThan100() {
        //itera la lista y es como for each pero hace que se elimine si es mayor que 100
        listaElementos.removeIf(element ->element>100);
    }

    public void orderHighToLow() {
        Collections.sort(listaElementos);
        Collections.reverse(listaElementos);
    }

    public void orderLowToHigh() {
        Collections.sort(listaElementos);
    }

    public void removeAndShowFirstElementUntilEmpty() {
        Integer numberToShow;
        while(listaElementos.size()>0){
            numberToShow=listaElementos.get(0);
            listaElementos.remove(0);
            System.out.println(numberToShow);
        }
    }

    public static void main (String[]Args){

        ListaMain listaMain= new ListaMain();

        for (int i = 0; i <=100 ; i++) {
            listaMain.addElement((int) ((Math.random()*1000)+1));

        }
        listaMain.deleteHigherThan100();
        listaMain.orderLowToHigh();
        listaMain.removeAndShowFirstElementUntilEmpty();
    }
}
