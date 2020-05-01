package flujos_de_datos_y_colecciones;

import java.util.HashMap;
import java.util.Map;

public class Materia {

    private String courseName;
    private Map<Integer,Alumno> studentsEnrolled;

    public Materia(String courseName) {
        this.courseName = courseName;
        this.studentsEnrolled=new HashMap<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Map<Integer, Alumno> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(Map<Integer, Alumno> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }

    public void enrollStudent(Alumno newStudent){
        Integer classNumber=this.studentsEnrolled.size()+1;
        studentsEnrolled.put(classNumber, newStudent);
    }

    public Alumno getEnrolledStudent(Integer classNumber){
        return studentsEnrolled.get(classNumber);
    }


}
