package ejercicios_set.testAeropuerto;

import ejercicios_set.ExceptionEmptyCollection;
import ejercicios_set.Fecha;
import ejercicios_set.Vuelo;
import ejercicios_set.VueloImpl;
import ejercicios_set.aeropuerto.Aeropuerto;
import ejercicios_set.aeropuerto.AeropuertoImpl;

import java.util.NoSuchElementException;

public class TestAeropuerto {

    public static void syso(Object objectToShow){
        System.out.println(objectToShow);
    }
    public static void syso(String stringToShow, Object objectToShow){
        System.out.println(stringToShow + objectToShow);
    }


    public static void main(String[] args) throws ExceptionEmptyCollection {

       //COMPROBACIONES SEGUN EL VIDEO DE LPNEUA

        Aeropuerto aeropuertoPrueba = new AeropuertoImpl("Madrid Barajas");


        Vuelo testVuelo1 = new VueloImpl("Madrid, 12.37, 155, 100, IB1123, 22, 11, 2007");
        Vuelo testVuelo2 = new VueloImpl("Barcelona, 19.56, 200, 150, VLG256, 22, 11, 2007");
        Vuelo testVuelo3 = new VueloImpl("Valencia, 2.1, 150, 150, RYA803, 22, 11, 2007");
        Vuelo testVuelo4 = new VueloImpl("Paris, 10.0, 85, 85, UA894, 23, 11, 2007");
        Vuelo testVuelo5 = new VueloImpl("Madrid, 22.37, 155, 154, IB2365, 23, 11, 2007");
        Vuelo testVuelo6 = new VueloImpl("Bilbao, 29.56, 200, 150, EAS286, 23, 11, 2007");
        Vuelo testVuelo7 = new VueloImpl("Valencia, 22.4, 100, 100, VLG127, 24, 11, 2007");
        Vuelo testVuelo8 = new VueloImpl("Paris, 70.0, 75, 70, EAS348, 24, 11, 2007");
        Vuelo testVuelo9 = new VueloImpl("Madrid, 32.37, 250, 250, AIF389, 24, 11, 2007");
        Vuelo testVuelo10 = new VueloImpl("Barcelona, 39.56, 200, 150, UA7810, 24, 11, 2007");
        Vuelo testVuelo11 = new VueloImpl("Londres, 28.4, 100, 90, IB6511, 25, 11, 2007");
        Vuelo testVuelo12 = new VueloImpl("Paris, 80.0, 75, 75, RYA212, 25, 11, 2007");


        aeropuertoPrueba.addFlight(testVuelo1);
        aeropuertoPrueba.addFlight(testVuelo2);
        aeropuertoPrueba.addFlight(testVuelo3);
        aeropuertoPrueba.addFlight(testVuelo4);
        aeropuertoPrueba.addFlight(testVuelo5);
        aeropuertoPrueba.addFlight(testVuelo6);
        aeropuertoPrueba.addFlight(testVuelo7);
        aeropuertoPrueba.addFlight(testVuelo8);
        aeropuertoPrueba.addFlight(testVuelo9);
        aeropuertoPrueba.addFlight(testVuelo10);
        aeropuertoPrueba.addFlight(testVuelo11);
        aeropuertoPrueba.addFlight(testVuelo12);

        System.out.println(aeropuertoPrueba);

        syso("Primer vuelo con plazas libres a Madrid ", aeropuertoPrueba.checkFirstFlightWithAvailableSitsByDestination("Madrid"));
        syso("Vuelo más barato a Paris ", aeropuertoPrueba.getCheapestFlightByDestination("Paris"));
        syso("Número de vuelos completos ", aeropuertoPrueba.checkNumberOfCompleteFlights());
        Fecha dateToCheck = new Fecha(23,11,2007);
        aeropuertoPrueba.getFlightWithHighestOccupancyPercentageByGivenDate(dateToCheck);
        aeropuertoPrueba.getFlightWithHighestOccupancyPercentageByGivenDate(new Fecha(23,11,2007));

        //Ejercicio 4 SET
        //Capture la excepción NoSuchElementException cuando se invoc Collections.sort con una colección vacía.
        // Por ejemplo, si buscamos un vuelo barato a un destino para el que no hay aviones en el aeropuerto.
        // Cree una excepción ExcepcionColeccionVacia no comprobada que informe convenientemente de que se ha hecho una consulta sin resultado.
        // Trátela mediante una sentencia throws en el método y mediante try-catch en la clase Test.
        // Cambie la excepción al tipo comprobada y haga lo cambios necesarios para que funcione.
        try{
            syso("Vuelo más barato a Paris ", aeropuertoPrueba.getCheapestFlightByDestination("Granada"));
        }catch (ExceptionEmptyCollection e){
        //catch (NoSuchElementException e){
            syso("Excepcion: ", e);
        }

    }
}
