package ejercicios_set.aeropuerto;

import ejercicios_set.Vuelo;

import java.util.Comparator;

public class ComparatorFlightByDestiny implements Comparator<Vuelo> {
    //No se si lo voy a usar pero al Carnegie Hall se llega practicando...
    @Override
    public int compare(Vuelo flightToCompare1, Vuelo flightToCompare2) {
        //ESTA ES LA MANERA DE HACER QUE UN COMPARADOR POR SORTEDSET NO SE COMA TUS ENTRADAS
        //Si el comparador que estas comprobando es igual devuelves el orden natural del compareTo
        int resultado= flightToCompare1.getDestino().compareTo(flightToCompare2.getDestino());

        if (resultado==0){
            resultado = flightToCompare1.compareTo(flightToCompare2);
        }

        return resultado;
    }
}
