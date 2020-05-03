package pruebas_scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaValores {

    private ArrayList<Integer> valuesList;
    private Scanner scanner;

    public ListaValores(String nameOfDocument){

        File documentToWorkWith=new File(nameOfDocument);

        if(!documentToWorkWith.exists()){
            System.out.println("El documento no existe.");
        }else {
            String scannerLine = null;
            String scannerLineNoSpaces;
            valuesList=new ArrayList<>();
            try {
                scanner = new Scanner(documentToWorkWith);
                while (scanner.hasNextLine()) {
                    scannerLine = scanner.nextLine();
                    scannerLineNoSpaces = scannerLine.replaceAll(" ", "");
                    valuesList.add(Integer.parseInt(scannerLineNoSpaces));
                }
            } catch (FileNotFoundException e) {
                System.out.println("El archivo no se ha podido encontrar");
            } catch (NumberFormatException e) {
                System.out.println("Una de las líneas del documento no es un número");
                System.out.println(scannerLine);
            } finally {
                closeScanner();
            }
        }

    }

    private void closeScanner(){
        scanner.close();
    }

}
