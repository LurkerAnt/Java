package fujos_de_datos_y_colecciones_pero_pensando;

import flujos_de_datos_y_colecciones.DAOAlumnoEntradaSalidaSerializa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

public class Asignatura {

    private String subjectName;
    private Map<String, Alumno> studentsEnrolled;
    private DAOAlumnoEntradaSalidaDatosSerializa esSerializa;
    private DaoAlumnoEntradaSalidaDatos entradaSalidaTXT;

    public Asignatura(String newSubjectName) {
        this.subjectName = newSubjectName;
        studentsEnrolled = new HashMap<>();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Map<String, Alumno> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(Map<String, Alumno> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    //metodo consulta alumno por numero de clase.
    public Alumno getStudentByClassNumber(String classID) {
        return studentsEnrolled.get(classID);
    }

    //metodo para añadir un alumno
    public void addStudentToClass(Alumno newStudent) {
        Integer classNumber = studentsEnrolled.size() + 1;
        studentsEnrolled.put(newStudent.getStudentID(), newStudent);
    }

    public void removeStudentFromClass(String classNumber) {
        studentsEnrolled.remove(classNumber);
    }

    public Boolean checkIfStudentIsInClass(Alumno studentToCheck) {
        //EJEMPLO DE PROGRAMACION FUNCIONAL
        //con esto una vez encuentra el objeto que coincide para el flujo y hace el retorno, en un for normal seguiría el recorrido.
        //Lambda
        Map.Entry<String, Alumno> student = studentsEnrolled.entrySet()// Crea una lista de entries [(integer, Student)];
                .stream() // Convierte en un flujo de datos
                .filter((entry) -> studentToCheck.getStudentID().compareTo(entry.getValue().getStudentID()) == 0) // Filtra la lista con la condicion
                .findFirst().orElse(null); // Encuetra el primer entry que haya pasado el filtro y sino devuelve un nulo
        return student != null;
    }

    public void addStudentsInClassToDocument() {
        studentsEnrolled.entrySet().forEach((entry) -> {
            try {
                entry.getValue().recordStudentIntoTXTDoc();
            } catch (IOException e) {
                System.out.println("No se ha podidio grabar");
            }
        });
    }

    public void addStudentsToClassFromDocument() throws IOException, ClassNotFoundException {
        esSerializa.openReader();
        Alumno studentToAdd;
        while (esSerializa.getObjectInputStream().readObject() != null) {
            studentToAdd = (Alumno) esSerializa.getObjectInputStream().readObject();
            addStudentToClass(studentToAdd);
        }
        esSerializa.closeReader();
    }

    public Boolean isStudentInFile(String studentID) throws IOException, ClassNotFoundException {

        esSerializa.openReader();
        Alumno studentToCheck;
        while (esSerializa.getObjectInputStream().readObject() != null) {
            studentToCheck = (Alumno) esSerializa.getObjectInputStream().readObject();
            if (studentToCheck.getStudentID().equals(studentID)) {
                return true;
            }
        }
        return false;
    }

    public void addClassToTheDoc() throws IOException {
        esSerializa.openWriter("map.ser");
        esSerializa.getObjectOutputStream().writeObject(this.studentsEnrolled);
        esSerializa.closeWriter();
    }

    public void readClassFromDoc() throws IOException, ClassNotFoundException {
        esSerializa.openReader("map.ser");
        this.studentsEnrolled = (Map<String, Alumno>) esSerializa.getObjectInputStream().readObject();
        esSerializa.closeReader();
    }

    public void separateFailedAndPassStudents() throws IOException {
        for (Map.Entry<String, Alumno> studentToCategorize : studentsEnrolled.entrySet()) {
            Alumno student = studentToCategorize.getValue();
            double average = Arrays.stream(student.getStudentGrades())
                    .average()
                    .getAsDouble();
            esSerializa.openWriter(average >= 5 ? "aprobados.ser" : "suspensos.ser");
            esSerializa.getObjectOutputStream().writeObject(studentToCategorize);
            esSerializa.closeWriter();
        }

    }

    @Override
    public String toString() {
        String studentsInClass="";
        for (Map.Entry<String, Alumno> studentToCategorize : studentsEnrolled.entrySet()) {
            Alumno student = studentToCategorize.getValue();
            studentsInClass+=student.toString();
        }
        return "Asignatura: "+ subjectName + "Estudiantes: " + studentsInClass+ "|";
    }
}
