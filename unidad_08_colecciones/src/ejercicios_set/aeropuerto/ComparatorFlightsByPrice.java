package ejercicios_set.aeropuerto;

import ejercicios_set.Vuelo;

import java.util.Comparator;

public class ComparatorFlightsByPrice implements Comparator <Vuelo>{


    //GRABATE ESTO A FUEGO, HAY QUE METERLE EL TIPO DE COMPARATOR O PETA
    public int compare (Vuelo flightToCompare1, Vuelo flightToCompare2){
        //COMPARA POR PRECIOS Y DEVUELVE
        return flightToCompare1.getPrecio().compareTo(flightToCompare2.getPrecio());
    }

}
