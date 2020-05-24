import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.String.format;
import static jdk.xml.internal.SecuritySupport.getClassLoader;

public class AccesoADatos {
    private BufferedWriter bufferedWriter;
    private BufferedReader bufferedReader;
    private ObjectInputStream objectInputStream;
    private ObjectOutputStream objectOutputStream;
    private DataOutputStream dataOutputStream;
    public ArrayList<Departamento> cargaDepartamentos(String nombreFichero) throws IOException {
        ArrayList<Departamento> listaDepartamentos = null;
        try {
            listaDepartamentos = new ArrayList<>();
            openReader(nombreFichero);
            String departamentoACrear = bufferedReader.readLine();
            Departamento departamentoToAdd;
            while (departamentoACrear != null) {
                departamentoToAdd = new Departamento(departamentoACrear);
                listaDepartamentos.add(departamentoToAdd);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaDepartamentos;
    }

    public File inicializarArchivo(String fileName) throws IOException {
        String path = getClassLoader().getResource("").getPath();
        File initializedFile = new File(path, fileName);
        if (!initializedFile.exists()) {
            initializedFile.createNewFile();
        }
        return initializedFile;
    }

    public void openWriter(String fileName) throws IOException {

        bufferedWriter = new BufferedWriter(new FileWriter(inicializarArchivo(fileName)));
    }

    public void openReader(String fileName) throws IOException {

        bufferedReader = new BufferedReader(new FileReader(inicializarArchivo(fileName)));
    }

    public void openWriterSerial(String fileName) throws IOException {
        objectOutputStream = new ObjectOutputStream(new FileOutputStream(inicializarArchivo(fileName)));
    }

    public void openReaderSerial(String fileName) throws IOException {
        objectInputStream = new ObjectInputStream(new FileInputStream(inicializarArchivo(fileName)));
    }
    public void openDataReader(String fileName) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(inicializarArchivo(fileName)));

    }

    public void serializaLista(String ficheroTextoALeer) {
        ArrayList<Departamento> listaDepartamentos = null;
        try {
            listaDepartamentos = new ArrayList<>();
            openReader(ficheroTextoALeer);
            String[] ficheroSplit = ficheroTextoALeer.split(".");
            openWriterSerial(ficheroSplit[0] + ".lista");
            String departamentoACrear = bufferedReader.readLine();
            Departamento departamentoToAdd;
            while (departamentoACrear != null) {
                departamentoToAdd = new Departamento(departamentoACrear);
                listaDepartamentos.add(departamentoToAdd);
            }

            objectOutputStream.writeObject(listaDepartamentos);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serializaListaObjetos(String ficheroTextoALeer) {
        ArrayList<Departamento> listaDepartamentos = null;
        try {
            //suponiendo que entra un serializable que debe ser departamentos.lista
            openReaderSerial(ficheroTextoALeer);
            listaDepartamentos = (ArrayList<Departamento>) objectInputStream.readObject();
            String[] ficheroSplit = ficheroTextoALeer.split(".");
            openWriterSerial(ficheroSplit[0] + ".dep");
            listaDepartamentos.sort(new ComparatorDepartamentoPorIDComponentes());
            for (Departamento departamentoToSerial : listaDepartamentos) {
                objectOutputStream.writeObject(departamentoToSerial);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void grabaDep(String id, String nombre, int componentes) throws IOException {
        openDataReader("departamentos1.txt");
         String addthis = String.format("%s,%s,%d", id, nombre, componentes);
        dataOutputStream.writeBytes(addthis);

    }

    public void add10Departamentos() throws IOException {
        String id = null;
        String nombre = null;
        int componentes = 0;
        Scanner teclado = new Scanner(System.in);
        Departamento departamento;
        for (int i = 0; i < 10; i++) {
            System.out.println("Introduce el ID: ");
            teclado.next();
            System.out.println("Introduce el Nombre: ");
            teclado.next();
            System.out.println("Introduce el Numero de Componentes: ");
            teclado.nextInt();
            departamento = new Departamento(id, nombre, componentes);
            grabaDep(departamento.getIdentificador(),departamento.getDescripcion(),departamento.getNumeroComponentes());
        }

    }


}
