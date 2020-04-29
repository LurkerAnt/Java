package ejercicios_set.aeropuerto;

import ejercicios_set.ExceptionEmptyCollection;
import ejercicios_set.Fecha;
import ejercicios_set.Vuelo;

public interface Aeropuerto {
    //1. Añadir un vuelo
    public boolean addFlight(Vuelo flightToAdd);
    //2. Quitar un vuelo
    public boolean deleteFlight(Vuelo flightToRemove);
    //3. Dada una fecha dar el número de vuelos de ese día
    public Integer getNumberOfFlightsInSpecificDate(Fecha dateToCheck);
    //4. ¿Cuántos vuelos completos (sin plazas libres) hay?
    public Integer checkNumberOfCompleteFlights();
    //5. Dado un destino, obtenga la recaudación de todos los vuelos que van a ese destino (suma de número de pasajeros por precio)
    public Double getTotalAmountEarnedByDestination(String destinationToCheck);
    //6. Dado un destino, cuál es el vuelo más barato para ese destino.
    public Vuelo getCheapestFlightByDestination(String destinationToCheck) throws ExceptionEmptyCollection;
    //7. Dado un destino, cuál es el primer vuelo con plazas libres para ese destino.
    public Vuelo checkFirstFlightWithAvailableSitsByDestination(String destinationToCheck);
    //8. Dada una fecha, cuál es el vuelo de ese día con mayor porcentaje de plazas ocupadas (cociente entre número de pasajeros y número de plazas).
    public Vuelo getFlightWithHighestOccupancyPercentageByGivenDate(Fecha dateToCheck);
    //9. Dado un porcentaje p y una fecha f, incremente el precio de todos los vuelos a partir de f en el porcentaje p.
    public void increasePriceForDateGivenByPercentageGiven(Fecha dateToCheck, Double cutToIncrease);
}
