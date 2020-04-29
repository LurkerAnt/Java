package ejercicios_set;

public class VueloImpl implements Vuelo {
    private String destino;
    private Double precio;
    private Integer numeroDePlazas;// debe ser positivo
    private Integer numeroDePasajeros;// debe ser positivo y menor de numPlazas
    private String codigoVuelo;
    private Fecha fechaDeVuelo;// posterior al año 2000


    public VueloImpl(String destinoNuevo, Double precioNuevo, Integer numeroDePlazasNuevo, Integer numeroDePasajerosNuevo,
                     String codigoVueloNuevo, Fecha fechaDeVueloNuevo) {

        //comprobar que los argumentos son validos, con excepciones no paras la ejecución del programa.
        //si son objeto o wrappers acostumbrate a utilizar equals o compareTo
        //si el numero plazas es menor que 0
        if (numeroDePlazasNuevo.compareTo(0) < 0) {
            throw new IllegalArgumentException("Numero de plazas no valido");
        }
        //si los pasajeros son menores que 0 o si
        if (numeroDePasajerosNuevo.compareTo(0) < 0 || numeroDePasajerosNuevo.compareTo(numeroDePlazasNuevo) > 0) {
            throw new IllegalArgumentException("Numero de pasajeros no valido");
        }

        if (fechaDeVueloNuevo.getYear() > 2000) {
            throw new IllegalArgumentException("Año no valido");
        }

        this.destino = destinoNuevo;
        this.precio = precioNuevo;
        this.numeroDePlazas = numeroDePlazasNuevo;
        this.numeroDePasajeros = numeroDePasajerosNuevo;
        this.codigoVuelo = codigoVueloNuevo;
        this.fechaDeVuelo = fechaDeVueloNuevo;
    }

    //Aqui no hay control de excepciones porque se supone que el control viene de más arriba,
    //aunque en un programa de mercado debe haberlas, aqui la lista esta predefinida, no te acostumbres

    public VueloImpl(String infoVuelo) {
        //quita los espacios.
        infoVuelo = infoVuelo.replaceAll(" ", "");
        //parte String en array
        String[] infoVueloPartida = infoVuelo.split(",");
        //inicializa
        //control de longitud, no lo puse lo vi en el video de LPNEUA
        if (infoVueloPartida.length != 8) {
            throw new IllegalArgumentException("Número de elementos en vuelo, no valida.");
        }

        this.destino = infoVueloPartida[0];
        this.precio = Double.parseDouble(infoVueloPartida[1]);
        this.numeroDePlazas = Integer.parseInt(infoVueloPartida[2]);
        this.numeroDePasajeros = Integer.parseInt(infoVueloPartida[3]);
        this.codigoVuelo = infoVueloPartida[4];
        this.fechaDeVuelo = new Fecha(Integer.parseInt(infoVueloPartida[5]), Integer.parseInt(infoVueloPartida[6]), Integer.parseInt(infoVueloPartida[7]));
    }


    public String getDestino() {
        return this.destino;
    }


    public Double getPrecio() {
        return this.precio;
    }


    public void setPrecio(Double precioNuevo) {
        this.precio = precioNuevo;
    }


    public Integer getNumeroPlazas() {
        return this.numeroDePlazas;
    }


    public Integer getNumeroPasajeros() {
        return this.numeroDePasajeros;
    }

    public void setNumeroPasajeros(Integer nuevoNumeroPasajeros) {
        this.numeroDePasajeros = nuevoNumeroPasajeros;
    }

    public String getCodigo() {
        return this.codigoVuelo;
    }

    public Fecha getFechaVuelo() {
        return this.fechaDeVuelo;
    }

    //No tenía ni idea de como comparar por mas de un valor asíque esto esta sacado del video de La programacion No Es Un Arte

    public boolean equals(Object o) {
        boolean resultado = false;

        if (o instanceof Vuelo) {
            Vuelo v = (Vuelo) o;

            resultado = v.getCodigo().equals(this.getCodigo()) && v.getFechaVuelo().equals(this.getFechaVuelo());
        }

        return resultado;
    }
    //esto esta hecho en base al equals, en base a pruebas de integers en otra clase.
    //El orden natural será por fecha y a igualdad de ésta por código.

    public int compareToOtroVuelo(Vuelo v) {
        int resultado;
        resultado = this.getFechaVuelo().compareTo(v.getFechaVuelo());
        if (resultado == 0) {
            resultado = this.getCodigo().compareTo(v.getCodigo());
        }
        return resultado;
    }

    public int comparePriceOfFlight(Vuelo flightToCheck) {
        return this.getPrecio().compareTo(flightToCheck.getPrecio());
    }

    @Override
    public String toString() {
        return "\n" + destino + ", " + precio + ", " + numeroDePlazas + ", " + numeroDePasajeros + ", " + codigoVuelo + ", " + fechaDeVuelo;
    }


    //resulta que set no puede comprobar si dos objetos son iguales a menos que se haga a través del hashCode de Objects
    //por lo tanto para comprobarlo se debe hacer una operación aritmetica en la que si la suma de dos hashCode es la misma el objeto es igual
    //ahora con esto hace la comprobación del hashCode y si son iguales no los añade los vuelos, retorna boolean asique si no se añade lo puedes controlar
    //lpneua
    @Override
    public int hashCode() {
        return getFechaVuelo().hashCode()+31*getCodigo().hashCode();
    }

    public Double checkOccupancyPercentage(){
        Double percentage=(double) ((this.getNumeroPasajeros()/this.getNumeroPlazas())*100);
        return percentage;
    }


    @Override
    public int compareTo(Object o) {
        return this.compareTo(o);
    }
}
