package pruebas_file;

import java.io.File;
import java.io.IOException;

public class FileTest {

    public static void deleteFile(File rutaToDelete, File archivoToDelete){
        if(archivoToDelete.exists()){
            archivoToDelete.delete();
            System.out.println("Archivo borrado.");
        } else{
            System.out.println("El archivo no existe.");
        }
    }

    public static void createArchivo(File ruta, File fileTest) throws IOException {
        if(!fileTest.exists()){
            System.out.println("El fichero no existe.");
            if (!ruta.exists()){
                System.out.println("La ruta no existe.");
                if(ruta.mkdir()){
                    System.out.println("Se ha creado el directorio");
                    if(fileTest.createNewFile()){
                        System.out.println("Se ha creado el Archivo!");
                    }else{
                        System.out.println("NO se ha creado el Archivo!");
                    }
                }else{
                    System.out.println("NO se ha creado el directorio!");
                }
            }else{
                if (fileTest.createNewFile()){
                    System.out.println("Se ha creado el Archivo!");
                }else{
                    System.out.println("NO se ha creado el Archivo!");
                }
            }
        }else{
            System.out.println("El archivo y directorio ya existen!");
        }
    }

    public static void main(String[] args) throws IOException {

        File ruta = new File ("../Java/probaturas");
        File fileTest=new File(ruta, "fileTest.txt");

        System.out.println(fileTest.getAbsolutePath());
        System.out.println(fileTest.getParent());
        System.out.println(ruta.getAbsolutePath());
        System.out.println(ruta.getParent());


        createArchivo(ruta, fileTest);

        deleteFile(ruta, fileTest);


    }
}
