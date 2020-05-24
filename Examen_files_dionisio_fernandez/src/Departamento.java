/*
Codifica la clase Departamento con los atributos identificador (cadena no nula, p.e. INF),
 descripción (cacena no nula, p.e. Informática) y número de componentes (entero mayor que cero).

Crea un constructor general para inicializar todas propiedades.
Lanza la excepción que creas conveniente para cada una de las propiedades.

Codifica el método correspondiente para poder hacer clasificaciones de departamentos por orden natural:
primero por id del departamento y en caso de coincidir ordenamos por número de componentes.

Realiza los cambios que debas hacer en la cabecera de la clase.



 */

public class Departamento {

    private String identificador;
    private String descripcion;
    private int numeroComponentes;

    public Departamento(String nuevaIdentificador, String nuevaDescripcion, int nuevoNumeroComponentes) {
        try {
            if (nuevaIdentificador.isEmpty() || nuevaDescripcion.isEmpty()) {
                throw new StringVacioException();
            } else {
                this.descripcion = nuevaDescripcion;
                this.identificador = nuevaIdentificador;
            }

            if (nuevoNumeroComponentes < 0) {
                throw new MenorQueCeroException();
            } else {

                this.numeroComponentes = nuevoNumeroComponentes;
            }
        } catch (MenorQueCeroException e) {
            e.printStackTrace();
        } catch (StringVacioException e) {
            e.printStackTrace();
        }
    }

    public Departamento(String departamentoACrear) {
        departamentoACrear=departamentoACrear.replaceAll(" ", "");

        String[] dataSplit=departamentoACrear.split(",");
        this.identificador=dataSplit[0];
        this.descripcion=dataSplit[1];
        this.numeroComponentes=Integer.parseInt(dataSplit[2]);

    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroComponentes() {
        return numeroComponentes;
    }

    public void setNumeroComponentes(int numeroComponentes) {
        this.numeroComponentes = numeroComponentes;
    }

    public int compareByComponents(Departamento departamento){
        if(this.getNumeroComponentes()>departamento.getNumeroComponentes()){
            return 1;
        }else if (this.getNumeroComponentes()==departamento.getNumeroComponentes()){
            return 0;
        }
        return -1;
    }
}
