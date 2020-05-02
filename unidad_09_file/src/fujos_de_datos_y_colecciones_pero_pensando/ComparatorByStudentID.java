package fujos_de_datos_y_colecciones_pero_pensando;

import java.util.Comparator;

public class ComparatorByStudentID implements Comparator<Alumno> {

    @Override
    public int compare(Alumno studentToCompare1, Alumno studentToCompare2) {

        int result = studentToCompare1.getStudentID().compareTo(studentToCompare2.getStudentID());

        return result;
    }
}
