package ejercicios_set;


/*
 * SACADO DE LAS SOLUCIONES DE LA PROGRAMACIÓN NO ES UN ARTE.
 * 
 * */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Fecha implements Comparable <Fecha> {
	
	private GregorianCalendar calendar;
	
	public Fecha (Integer day, Integer month, Integer year) {
		if (!esFechaValida(day,month,year)) {
			throw new IllegalArgumentException("Fecha Invalida.");
		}
		//los month solo van de 0 a 11
		this.calendar= new GregorianCalendar(year,month-1,day);
	}
	
	public Integer getDiaSemana() {
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public Integer getDiaMes() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public Integer getMes() {
		return calendar.get(Calendar.MONTH)+1;
	}
	
	public Integer getYear() {
		return calendar.get(Calendar.YEAR);
	}
	
	public String getDiaSemanaCadena() {
		return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, new Locale("ES"));
	}
	
	public String getMesCadena() {
		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, new Locale("ES"));
	}
	
	public void suma (Integer a) {
		calendar.add(Calendar.DAY_OF_MONTH, a);
	}
	
	public void resta (Integer a) {
		calendar.add(Calendar.DAY_OF_MONTH, -a);
	}
	
	public Integer resta(Fecha f) {
		Integer valor = 0;
		int diff = f.getYear() - this.getYear();
		GregorianCalendar temp = new GregorianCalendar(this.getYear(), Calendar.DECEMBER, 31);
		for (int i = 0; i < diff; i++) {
			valor += temp.get(Calendar.DAY_OF_YEAR);
			temp.add(Calendar.YEAR, 1);
		}
		valor = valor + f.calendar.get(Calendar.DAY_OF_YEAR) - this.calendar.get(Calendar.DAY_OF_YEAR);
		return valor;
	}

	public boolean esBisiesto() {
		return this.calendar.isLeapYear(getYear());
	}

	public int compareTo(Fecha f) {
		return this.calendar.compareTo(f.calendar);
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Fecha) {
			Fecha f = (Fecha) o;
			res = this.calendar.equals(f.calendar);
		}
		return res;
	}

	public String toString() {
		return getDiaSemanaCadena()+", "+getDiaMes()+" de "+getMesCadena()+" de "+getYear();
		}

	public int hashCode() {
		return calendar.hashCode();
	}

	private boolean esFechaValida(Integer d, Integer m, Integer a) {
		boolean r = true;
		try {
			Calendar c = new GregorianCalendar(a, m - 1, d);
			c.setLenient(false);
			c.getTime();
		} catch (IllegalArgumentException e) {
			r = false;
		}
		return r;
	}
}
	
	

