package flujos_de_datos_y_colecciones;

import java.io.Serializable;
import java.util.Arrays;

public class Alumno implements Serializable {

    private Integer numberIDStudent;
    private String nameStudent;
    private Integer courseOfStudent;
    private Double[] gradesOfStudent;

    public Alumno(Integer numberIDStudent, String nameStudent, Integer courseOfStudent, Double[] gradesOfStudent) {
        this.numberIDStudent = numberIDStudent;
        this.nameStudent = nameStudent;
        this.courseOfStudent = courseOfStudent;
        this.gradesOfStudent = gradesOfStudent;
    }


    public Integer getNumberIDStudent() {
        return numberIDStudent;
    }

    public void setNumberIDStudent(Integer numberIDStudent) {
        this.numberIDStudent = numberIDStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Integer getCourseOfStudent() {
        return courseOfStudent;
    }

    public void setCourseOfStudent(Integer courseOfStudent) {
        this.courseOfStudent = courseOfStudent;
    }

    public Double[] getGradesOfStudent() {
        return gradesOfStudent;
    }

    public void setGradesOfStudent(Double[] gradesOfStudent) {
        this.gradesOfStudent = gradesOfStudent;
    }

    public String toStringGrades(){
        String grades="";

        grades+="[";

        for (Double nota:this.gradesOfStudent) {
            grades+=nota + ", ";
        }

        grades+="]";

        return grades;
    }

    @Override
    public String toString() {
        return numberIDStudent + ", " + nameStudent + ", " + courseOfStudent + ", : " + Arrays.toString(gradesOfStudent) + '.';
    }



}
