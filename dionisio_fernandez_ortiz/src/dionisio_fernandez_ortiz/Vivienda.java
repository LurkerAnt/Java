/*
 * Tiempo para resolver la página: 15 minutos aproximadamente.


 pon la cabecera de la clase correctamente. 

Supón codificados todos los setter y getter necesarios.
 * */

package dionisio_fernandez_ortiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Vivienda {
	//Codifica la clase Vivienda con los atributos domicilio (cadena), código postal (entero entre de 10000 y 99999 , arrojarás una RuntimeException) y precio (real). 
	private String domicilio;
	private int codigoPostal;
	private double precio;
	private Scanner teclado= new Scanner (System.in);
	
	
	public Vivienda(String domicilio, int codigoPostal, double precio) {

		setDomicilio(domicilio);
		setCodigoPostal(codigoPostal);
		setPrecio(precio);
	}
	
	public Vivienda() {
		setDomicilio();
		setCodigoPostal();
		setPrecio();
	}
	
	public Vivienda (String informacionDomicilio) throws  RuntimeException{
		String info[] = informacionDomicilio.split(" ");
		this.domicilio=info[0];
		int codigoPostal1=Integer.parseInt(info[1]);
		if (codigoPostal1<10000&&codigoPostal>99999) {
			throw new RuntimeException ();
		}else {
			this.codigoPostal = codigoPostal1;
		}
		
		this.precio=Double.parseDouble(info[2]);
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		
		if (codigoPostal<10000&&codigoPostal>99999) {
			throw new RuntimeException ();
		}else {
			this.codigoPostal = codigoPostal;
		}
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	public void setPrecio() {
		System.out.println("Introduce el precio de la vivienda: ");
		this.precio = teclado.nextDouble();
	}
	
	public void setCodigoPostal() {
		System.out.println("Introduce el código postal:");
		int codigoPostal1=teclado.nextInt();
		if (codigoPostal1<10000&&codigoPostal>99999) {
			throw new RuntimeException ();
		}else {
			this.codigoPostal = codigoPostal1;
		}
	}
	
	public void setDomicilio() {
		this.domicilio=teclado.next();
	}
	
	//Además permitirá codifcar un método para poder comparar objetos vivienda por su orden natural
	// (se darán las indicaciónes más adelante);
	public int compararVivienda(Vivienda viviendaCompare) {
		if (this.codigoPostal>viviendaCompare.getCodigoPostal()) {
			return 1;
		}else if (this.codigoPostal<viviendaCompare.getCodigoPostal()) {
			return -1;
		}else if (this.codigoPostal==viviendaCompare.getCodigoPostal()) {
			return this.domicilio.compareTo(viviendaCompare.getDomicilio());
		}
		
		return 0;
	}
	//metodo ordenar viviendas por codigo postal y si coinciden por direccion
	public ArrayList <Vivienda> ordenarViviendas(ArrayList <Vivienda> listaToOrder){
		
		Collections.sort((List<T>) listaToOrder);
		
		return listaToOrder;
	}//siempre fallo en esto, estudialo Dioni.
	
	public boolean  comprobarVivivendaExiste(Vivienda viviendaComprobar, ArrayList <Vivienda> listaViviendas) {
		int control;
		for (Vivienda elementoVivienda : listaViviendas) {
			control=elementoVivienda.compararVivienda(viviendaComprobar);
			if(control==0) {
				return true;
			}
		}
		
		return false;
	}

	@Override
	public String toString() {
		return "Domicilio: " + domicilio + ", Codigo Postal: " + codigoPostal + ", Precio: " + precio + ".";
	}
	
	
}
