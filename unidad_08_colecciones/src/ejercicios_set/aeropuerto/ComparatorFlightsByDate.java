package ejercicios_set.aeropuerto;

import ejercicios_set.Vuelo;

import java.util.Comparator;

public class ComparatorFlightsByDate implements Comparator<Vuelo> {

    @Override
    public int compare(Vuelo flightToCheck1, Vuelo flightToCheck2) {
        return flightToCheck1.getFechaVuelo().compareTo(flightToCheck2.getFechaVuelo());
    }
}
