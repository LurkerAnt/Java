package fujos_de_datos_y_colecciones_pero_pensando;

import java.util.Arrays;

public class Alumno {
    private String studentID;
    private String studentName;
    private String studentYear;
    private Double[] studentGrades;

    public Alumno(String studentID, String studentName, String studentYear, Double[] studentGrades) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentYear = studentYear;
        this.studentGrades = studentGrades;
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

    public Double[] getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(Double[] studentGrades) {
        this.studentGrades = studentGrades;
    }

    public String getGradesAsString(){
        String grades="";
        for (Double nota:this.studentGrades) {
            grades+=nota + "/";
        }

        return grades;
    }

    @Override
    public String toString() {
        return studentID+ ", " + studentName +", "+ studentYear + ", " + getGradesAsString();
    }
}
