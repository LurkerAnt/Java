package ejercicios_set.aeropuerto;

import ejercicios_set.Fecha;
import ejercicios_set.Vuelo;

import java.util.*;

public class AeropuertoImpl2 implements Aeropuerto {
//Le cambio el nombre porque aeropuertoImplementación no me gusta.

//    Un Aeropuerto tiene un nombre y guarda la información de los vuelos que salen del aeropuerto
//    mediante un atributo de tipo Set<Vuelo> con todos los vuelos programados.

    private String name;
    private SortedSet<Vuelo> listOfFlights;

    //    Proporcione un constructor a partir de un String con el nombre del aeropuerto y el conjunto de vuelos vacío.(a que se refiere??)
    public AeropuertoImpl2(String airportNewName) {
        //La info que recibe es del nombre unicamente
        this.name = airportNewName;
        //SortedSet se inicia con TreeSet
        //El orden natural de los vuelos seria el que se inicie por defecto
        //si se quiere que se inicialice ordenado de otro modo se debe añadir un Comparator a la inicialización
        // listOfFlights=new TreeSet<Vuelo>(new ComparatorFlightsByPrice);
        //ES PELIGROSO, PORQUE AL AÑADIR VUELOS LO HACE POR COMPARATOR Y SI EL COMPARADOR COINCIDE CON UNO QUE EXISTE NO LO METE A MENOS QUE EN EL COMPARADOR LO ORDENEMOS POR ORDEN NATURAL
        listOfFlights = new TreeSet<Vuelo>();

    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    //add y remove en SET te devuelven true si se añade el elemento, porque comprueba si esta añadido o no Y DEPENDIENDO DE ESTO
    //añade o borra dependiendo de esto


    public boolean addFlight(Vuelo flightToAdd) {
        return listOfFlights.add(flightToAdd);
    }

    public boolean deleteFlight(Vuelo flightToRemove) {
        return listOfFlights.remove(flightToRemove);
    }

    public Integer getNumberOfFlightsInSpecificDate(Fecha dateToCheck) {
        Integer numberOfFlights = 0;
        for (Vuelo flightToCheck : listOfFlights) {
            if (flightToCheck.getFechaVuelo().equals(dateToCheck)) {
                numberOfFlights++;
            }
        }
        return numberOfFlights;
    }

    public Integer checkNumberOfCompleteFlights() {
        Integer numberOfCompleteFlights = 0;
        for (Vuelo flightToCheck : listOfFlights) {
            if (flightToCheck.getNumeroPlazas().equals(flightToCheck.getNumeroPasajeros())) {
                numberOfCompleteFlights++;
            }
        }
        return numberOfCompleteFlights;
    }

    public Double getTotalAmountEarnedByDestination(String destinationToCheck) {
        Double amountOfMoneyEarned = 0.0;
        for (Vuelo flightToCheck : listOfFlights) {
            if (flightToCheck.getDestino().equals(destinationToCheck)) {
                amountOfMoneyEarned += flightToCheck.getPrecio() * flightToCheck.getNumeroPasajeros();
            }
        }
        return amountOfMoneyEarned;
    }

    public Vuelo getCheapestFlightByDestination(String destinationToCheck) {
        List<Vuelo> listToAddElements = new ArrayList<>();
        for (Vuelo flightToCheck : listOfFlights) {
            if (flightToCheck.getDestino().equals(destinationToCheck)) {
                listToAddElements.add(flightToCheck);
            }
        }

        //devuelve el valor mas bajo de una collection utilizando el comparador que se le proporciona.
        // HAY QUE INICIALIZAR EL COMPARATOR
        return Collections.min(listToAddElements, new ComparatorFlightsByPrice());
    }

    public Vuelo checkFirstFlightWithAvailableSitsByDestination(String destinationToCheck) {
        //hecho en base al anterior antes de hacer comprobaciones en lpneua
        List<Vuelo> listToAddElements = new ArrayList<>();
        for (Vuelo flightToCheck : listOfFlights) {
            //comprueba si hay plazas porque sino no pa que devolverlo.
            //Acostumbrate a comparar objetos con los metodos y no con condicionales.
            if (flightToCheck.getDestino().equals(destinationToCheck) && flightToCheck.getNumeroPlazas().compareTo(flightToCheck.getNumeroPasajeros()) > 0) {
                listToAddElements.add(flightToCheck);
            }
        }

        return Collections.min(listToAddElements, new ComparatorFlightsByDate());
    }

    public Vuelo getFlightWithHighestOccupancyPercentageByGivenDate(Fecha dateToCheck) {
        List<Vuelo> listToAddElements = new ArrayList<>();
        for (Vuelo flightToCheck : listOfFlights) {
            if (flightToCheck.getFechaVuelo().equals(dateToCheck)) {
                listToAddElements.add(flightToCheck);
            }
        }

        return Collections.max(listToAddElements, new ComparatorByOccupancyPercentage());
    }

    public void increasePriceForDateGivenByPercentageGiven(Fecha dateToCheck, Double cutToIncrease) {
        for (Vuelo flightToCheck : listOfFlights) {
            //Comprueba que sea la fecha posterior y el porcentaje lo suma
            if (flightToCheck.getFechaVuelo().compareTo(dateToCheck)>0) {
                //lpneua
                flightToCheck.setPrecio(flightToCheck.getPrecio()*(1+cutToIncrease/100));
            }
        }
    }

    @Override
    public String toString() {
        return "Aeropuerto: " + name + ", Vuelos: " + listOfFlights.toString();
    }
}
