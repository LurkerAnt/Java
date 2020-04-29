package ejercicio_collections_y_algoritmos.listaPruebas;

import java.util.ArrayList;
import java.util.List;

public interface Lista {
    List<Integer> listaElementos = new ArrayList<>();
    public void addElement(Integer element);
    public void showSize();
    public void deleteHigherThan100();
    public void orderHighToLow();
    public void orderLowToHigh();
    public void removeAndShowFirstElementUntilEmpty();
    
}
