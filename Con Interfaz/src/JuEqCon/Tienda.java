package JuEqCon;


public class Tienda {
	
	private int idtienda;
	private String nombre;
	private String direccion;
	private String poblacion;
	private String provincia;
	private int cPostal;
	
	public Tienda (int idtienda, String nombre, String direccion, String poblacion, String provincia, int cPostal) {
		this.idtienda=idtienda;
		this.nombre=nombre;
		this.direccion=direccion;
		this.poblacion=poblacion;
		this.provincia=provincia;
		this.cPostal=cPostal;
	}

	public Tienda() {
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getcPostal() {
		return cPostal;
	}

	public void setcPostal(int cPostal) {
		this.cPostal = cPostal;
	}

	@Override
	public String toString() {
		return idtienda + ", " + nombre + ", " + direccion + ", "
				+ poblacion + ", " + provincia + ", " + cPostal;
	}


	
	

}
