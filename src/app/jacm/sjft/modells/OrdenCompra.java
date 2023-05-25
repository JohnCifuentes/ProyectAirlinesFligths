package app.jacm.sjft.modells;

import java.util.ArrayList;

public class OrdenCompra {
	private int consecutivo;
	private int numeroVuelo;
	private ArrayList<Tiquete> tiquetes;
	
	private static int consecutivoInterno;
	
	public OrdenCompra() {
		this.consecutivo = ++consecutivoInterno;
	}

	public int getConsecutivo() {
		return consecutivo;
	}

	public int getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public ArrayList<Tiquete> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(ArrayList<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	};
}
