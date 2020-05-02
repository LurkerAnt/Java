package fujos_de_datos_y_colecciones_pero_pensando;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;

public class Alumno {
    private String studentID;
    private String studentName;
    private String studentYear;
    private double[] studentGrades;
    private DAOAlumnoEntradaSalidaDatosSerializa esSerializa;
    private DaoAlumnoEntradaSalidaDatos entradaSalidaTXT;

    public Alumno(String studentID, String studentName, String studentYear, double[] studentGrades) throws IOException {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentYear = studentYear;
        this.studentGrades = studentGrades;
    }

    public Alumno(String studentData) {
        studentData = studentData.trim();
        String[] studentDataSplit = studentData.split(",");
        this.studentID = studentDataSplit[0];
        this.studentName = studentDataSplit[1];
        this.studentYear = studentDataSplit[2];
        String[] studentMarksSplit = studentDataSplit[3].split("/");
        //https://mkyong.com/java8/java-8-how-to-convert-a-stream-to-array/
        this.studentGrades = Arrays
                .stream(studentMarksSplit) // Crear un stream de un array de String[]
                .mapToDouble((stringGrade) -> Double.parseDouble(stringGrade)) // Convertir un String a un double (primitivo)
                .toArray(); // Convertir stream a un array de double[]
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public double[] getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(double[] studentGrades) {
        this.studentGrades = studentGrades;
    }

    public String getGradesAsString() {
        String grades = "";
        for (Double nota : this.studentGrades) {
            grades += nota + "/";
        }

        return grades;
    }

    public void recordStudentIntoTXTDoc() throws IOException {
        esSerializa.openWriter();
        entradaSalidaTXT.openWriter();
        esSerializa.writeStudentToDocument(this);
        entradaSalidaTXT.writeStudentToDocument(this);
    }

    @Override
    public String toString() {
        return studentID + ", " + studentName + ", " + studentYear + ", " + getGradesAsString();
    }


}
