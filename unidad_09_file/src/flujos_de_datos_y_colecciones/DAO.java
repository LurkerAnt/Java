package flujos_de_datos_y_colecciones;

import java.io.File;
import java.io.IOException;

public interface DAO {

    public void openReaders() throws IOException;
    public void openWriters() throws IOException;
    public void closeReadersAndWriters() throws IOException;
    public void addStudentToFile(Alumno studentToAdd) throws IOException;



}
