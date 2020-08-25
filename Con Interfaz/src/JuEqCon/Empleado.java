package JuEqCon;


public class Empleado implements Comparable<Empleado>{
	
	private int idempleado;
	private int idtienda;
	private String nombre;
	private int numeroVentas;
	private int edad;
	
	public Empleado (int idempleado, int idtienda, String nombre, int numeroVentas, int edad) {
		this.idempleado=idempleado;
		this.idtienda=idtienda;
		this.nombre=nombre;
		this.numeroVentas=numeroVentas;
		this.edad=edad;
	}

	public Empleado() {
		
	}
	public int getIdempleado() {
		return idempleado;
	}

	public void setIdempleado(int idempleado) {
		this.idempleado = idempleado;
	}

	public int getIdtienda() {
		return idtienda;
	}

	public void setIdtienda(int idtienda) {
		this.idtienda = idtienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroVentas() {
		return numeroVentas;
	}

	public void setNumeroVentas(int numeroVentas) {
		this.numeroVentas = numeroVentas;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	//El orden natural de los empleados es por nombre y si se llaman igual, por id de empleado
	@Override
	public String toString() {
		return idempleado + ", " + idtienda + ", " + nombre
				+ ", " + numeroVentas + ", " + edad ;
	}

	@Override
	public int compareTo(Empleado o) {
		if(this.nombre.compareTo(o.nombre)==0) { //si son iguales, empieza a comparar por id
			if(this.idempleado>o.idempleado) {
				return 1;
			} else if (this.idempleado<o.idempleado) {
				return -1;
			}else
				return 0;
		} else if(this.nombre.compareTo(o.nombre)>0) {
			return 1;
		}
		return -1;
	} 
	
	
}
