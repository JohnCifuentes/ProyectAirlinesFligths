package app.jacm.sjft.modells;

public class Silla {
	private int consecutivo;
	private char letra;
	private int numero;
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

	public Silla(){
		
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
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
}
