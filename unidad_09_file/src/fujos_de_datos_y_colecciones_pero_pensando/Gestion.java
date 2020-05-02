package fujos_de_datos_y_colecciones_pero_pensando;

import java.io.IOException;

public class Gestion {
    public static void main(String[] args) {
        try{
            Alumno andriyo=new Alumno("001", "Andriyo", "2º", new double[]{7.0, 8.0, 9.0});
            Alumno dioni=new Alumno("002", "Dioni", "2º", new double[]{5.0, 6.0, 4.0});
            Alumno mago=new Alumno("003", "Mago", "2º", new double[]{0.0, 0.0, 0.0});
            Asignatura programacion=new Asignatura("Programacion");

            //1. Alta de un alumno en Materia
            programacion.addStudentToClass(andriyo);
            programacion.addStudentToClass(dioni);
            programacion.addStudentToClass(mago);

            //2. Baja de un alumno de Materia. Buscamos por numero, en este caso por el id.
            programacion.removeStudentFromClass(andriyo.getStudentID());

            //3. Graba Asignatura en un fichero de alumnos.
            programacion.addStudentsInClassToDocument();
            //4 Lee los alumnos del fichero de datos y guardalos en Materia.
            programacion.addStudentsToClassFromDocument();
            //5.Busca un alumno por su número e indica si está o no. La búsqueda se realiza en el
            //fichero.
            programacion.isStudentInFile(dioni.getStudentID());
            //6. Graba en un archivo de texto los alumnos aprobados y en otro los suspensos. Toma la
            //información del mapa.
            programacion.separateFailedAndPassStudents();
            //7. Serializa Materia, la clase completa, a un fichero.
            programacion.addClassToTheDoc();
            //8.Lee el fichero serializado en el punto anterior.
            programacion.readClassFromDoc();


        }catch (IOException  e) {
            System.out.println("No se ha creado el alumno");
        }catch (ClassNotFoundException e){
            System.out.println("No se han encontrado alumnos en el fichero.");
        }



    }
}
