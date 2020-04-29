package dionisio_fernandez_ortiz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


/*
 * Crea la clase Agencia con dos propiedades: nombre de la agencia de compraventa (cadena) y una estructura de datos para guardar las viviendas (lista).
 * 
 * */


public class Agencia extends Vivienda {
	private String nombreAgencia;
	private ArrayList <Vivienda> listaViviendas;
	
	
	public Agencia (File fileX) throws IOException {
		this.nombreAgencia=fileX.getName();
		this.listaViviendas=new ArrayList<Vivienda>();
		
		BufferedReader br =new BufferedReader (new FileReader(fileX));
		String linea;
		while ((linea=br.readLine())!=null) {
			listaViviendas.add(new Vivienda(linea));
		}
		
		br.close();
	}
	
	public void guardarInformacionEnDocumento() {
		try {
			File file = new File ("archivo.txt");
			BufferedWriter fw =new BufferedWriter(new FileWriter(file));
			if (!file.exists()) {
				file.createNewFile();
			}
			
			
			for (Vivienda vivienda : listaViviendas) {
				
				String infoAGrabar=vivienda.toString();
				fw.write(infoAGrabar);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
