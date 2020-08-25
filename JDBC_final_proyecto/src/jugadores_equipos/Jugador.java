package jugadores_equipos;

import java.util.Comparator;

public class Jugador {
    private int idJugador;
    private int idEquipo;
    private String nombreJugador;
    private String posicionJugador;

    public Jugador(int idJugador, int idEquipo, String nombreJugador, String posicionJugador) {
        this.idJugador = idJugador;
        this.idEquipo = idEquipo;
        this.nombreJugador = nombreJugador;
        this.posicionJugador = posicionJugador;
    }

    public Jugador(int idEquipo, String nombreJugador, String posicionJugador) {
        this.idEquipo = idEquipo;
        this.nombreJugador = nombreJugador;
        this.posicionJugador = posicionJugador;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public String getPosicionJugador() {
        return posicionJugador;
    }

    public void setPosicionJugador(String posicionJugador) {
        this.posicionJugador = posicionJugador;
    }

    @Override
    public String toString() {
        return "Jugador: " + idJugador + ", " + idEquipo + ", " + nombreJugador + ", " + posicionJugador + ".";
    }

    public int compareTo(Jugador jugadorToCompare) {
        int resultado = 0;
        if (this.getIdJugador() > jugadorToCompare.getIdJugador()) {
            resultado = 1;
        } else if (this.getIdJugador() < jugadorToCompare.getIdJugador()) {
            resultado = -1;
        } else if (this.getIdJugador() == jugadorToCompare.getIdJugador()) {
            resultado = this.getNombreJugador().compareTo(jugadorToCompare.getNombreJugador());
        }
        return resultado;
    }
}

