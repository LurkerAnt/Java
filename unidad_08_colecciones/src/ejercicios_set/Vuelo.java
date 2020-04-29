package ejercicios_set;

public interface Vuelo extends Comparable {

	public String getDestino();
	public Double getPrecio();
	public void setPrecio(Double precioNuevo);
	public Integer getNumeroPlazas();
	public Integer getNumeroPasajeros();
	public void setNumeroPasajeros(Integer nuevoNumeroPasajeros);
	public String getCodigo();
	public Fecha getFechaVuelo();
	public Double checkOccupancyPercentage();
}
