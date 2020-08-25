package jugadores_equipos;

public class Equipo {

    private int idEquipo;
    private String nombreEquipo;
    private String ciudadEquipo;

    public Equipo(int idEquipo, String nombreEquipo, String ciudadEquipo) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.ciudadEquipo = ciudadEquipo;
    }

    public Equipo(String nombreEquipo, String ciudadEquipo){
        this.nombreEquipo=nombreEquipo;
        this.ciudadEquipo=ciudadEquipo;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public String getCiudadEquipo() {
        return ciudadEquipo;
    }

    public void setCiudadEquipo(String ciudadEquipo) {
        this.ciudadEquipo = ciudadEquipo;
    }

    @Override
    public String toString() {
        return "Equipo: " + idEquipo + ", " + nombreEquipo + ", " + ciudadEquipo +'.';
    }

    public int compareTo(Equipo equipoToCompare) {
        int resultado=0;
        if (this.getIdEquipo()>equipoToCompare.getIdEquipo()){
            resultado=1;
        }else if (this.getIdEquipo()<equipoToCompare.getIdEquipo()){
            resultado=-1;
        }else if (this.getIdEquipo()==equipoToCompare.getIdEquipo()){
            resultado=this.getNombreEquipo().compareTo(equipoToCompare.getNombreEquipo());
        }
        return resultado;
    }


}
