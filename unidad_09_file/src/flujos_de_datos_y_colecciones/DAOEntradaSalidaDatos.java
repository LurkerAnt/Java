package flujos_de_datos_y_colecciones;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DAOEntradaSalidaDatos implements DAO {
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public void openReaders() throws IOException {

    }

    public Alumno getStudentFromDocument(Integer studentID) throws IOException {
        String studentData;
        List<Alumno> listToCheck=new ArrayList<Alumno>();
        while (bufferedReader.readLine()!=null){
            studentData=bufferedReader.readLine();
           listToCheck.add(new Alumno(studentData));
        }
    }

    public void addStudentToFile(Alumno studentToAdd) throws IOException {
        bufferedWriter.write(studentToAdd.toString());
    }

    @Override
    public void closeReadersAndWriters() throws IOException {

        bufferedReader.close();
        bufferedWriter.close();
    }
}
