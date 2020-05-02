package fujos_de_datos_y_colecciones_pero_pensando;

import java.io.*;

public class DaoAlumnoEntradaSalidaDatos implements DAO{
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    //clase para escribir en un archivo de TEXTO
    @Override
    public void openWriter() throws IOException {
        String fileName="alumnos.txt";
        bufferedWriter=new BufferedWriter(new FileWriter(fileName));
    }

    @Override
    public void openReader() throws IOException {
        String fileName ="alumnos.txt";
        bufferedReader=new BufferedReader(new FileReader(fileName));
    }

    @Override
    public void closeWriter() throws IOException {
        bufferedWriter.close();
    }

    @Override
    public void closeReader() throws IOException {
        bufferedReader.close();
    }

    @Override
    public void writeStudentToDocument(Alumno studentToWrite) throws IOException {
        bufferedWriter.write(studentToWrite.toString());
    }

    @Override
    public void readDocument() throws IOException {
        while (bufferedReader.readLine()!=null){
            System.out.println(bufferedReader.readLine());
        }
    }
}
