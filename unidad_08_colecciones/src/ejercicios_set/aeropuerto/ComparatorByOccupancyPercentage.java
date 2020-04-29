package ejercicios_set.aeropuerto;

import ejercicios_set.Vuelo;

import java.util.Comparator;

public class ComparatorByOccupancyPercentage implements Comparator<Vuelo> {
    //hecho antes de ver el video Comprobado en el vide, me gusta mas asi.
    @Override
    public int compare(Vuelo flightToCheck1, Vuelo flightToCheck2) {
        Double percentage1=flightToCheck1.checkOccupancyPercentage();
        Double percentage2=flightToCheck2.checkOccupancyPercentage();

        return percentage1.compareTo(percentage2);
    }
}
