package app.jacm.sjft.modells;

public class Puesto {
	private int consecutivo;
	/**
	 * 0 - ACTIVA/LIBRE
	 * 1 - INACTIVA
	 * 2 - OCUPADO
	 * */
	private int disponibilidad;
	/**
	 * 0 - VIP
	 * 1 - GENERAL
	 * 2 - TRIPULANTE
	 * */
	private int tipo;
	/**
	 * 0 - VENTANA
	 * 1 - CENTRO 
	 * 2 - PASILLO
	 **/
	private int ubicacion;
	private char letra;
	private int precio;

	public Puesto(){
		
	}
	
	public Puesto(int consecutivo, int disponibilidad, int tipo, int ubicacion, char letra, int precio) {
		super();
		this.consecutivo = consecutivo;
		this.disponibilidad = disponibilidad;
		this.tipo = tipo;
		this.ubicacion = ubicacion;
		this.letra = letra;
		this.precio = precio;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public int getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(int disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(int ubicacion) {
		this.ubicacion = ubicacion;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getConsecutivoBoleto() {
		String consecutivoBoleto;
		String tipoVuelo = this.getTipo()==0?"VIP":"GEN";
		consecutivoBoleto = tipoVuelo + "-" + this.getLetra() + this.getConsecutivo();
		return consecutivoBoleto;
	}
}
