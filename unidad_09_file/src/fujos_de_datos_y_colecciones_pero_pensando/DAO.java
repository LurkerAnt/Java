package fujos_de_datos_y_colecciones_pero_pensando;

import java.io.IOException;

public interface DAO {
    public void openWriter() throws IOException;
    public void openReader() throws IOException;
    public void closeWriter() throws IOException;
    public void closeReader() throws IOException;
    public void writeStudentToDocument(Alumno studentToWrite)throws IOException;
    public void readDocument()throws IOException, ClassNotFoundException;

}
