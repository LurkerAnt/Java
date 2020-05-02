package fujos_de_datos_y_colecciones_pero_pensando;

import java.io.*;

public class DAOAlumnoEntradaSalidaDatosSerializa implements DAO {

    //codigo para grabar en un archivo objetos.

    private ObjectOutputStream objectOutputStream;
    private ObjectInputStream objectInputStream;

    @Override
    public void openWriter() throws IOException {
        objectOutputStream= new ObjectOutputStream(new FileOutputStream("alumnos.dat"));
    }

    public void openWriter(String docName) throws IOException{
        objectOutputStream= new ObjectOutputStream(new FileOutputStream(docName));
    }

    @Override
    public void openReader() throws IOException {
        objectInputStream= new ObjectInputStream(new FileInputStream("alumnos.dat"));
    }

    public void openReader(String docName) throws IOException {
        objectInputStream= new ObjectInputStream(new FileInputStream(docName));
    }

    @Override
    public void closeWriter() throws IOException {
        objectOutputStream.close();
    }

    @Override
    public void closeReader() throws IOException {
        objectInputStream.close();
    }

    @Override
    public void writeStudentToDocument(Alumno studentToWrite) throws IOException {
        objectOutputStream.writeObject(studentToWrite);
    }

    @Override
    public void readDocument() throws IOException,ClassNotFoundException {
        String toStringOfObject;
        while(objectInputStream.readObject()!=null){
            toStringOfObject=objectInputStream.readObject().toString();
            System.out.println(toStringOfObject);
        }

    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }

    public void setObjectOutputStream(ObjectOutputStream objectOutputStream) {
        this.objectOutputStream = objectOutputStream;
    }

    public ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public void setObjectInputStream(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }
}
