package app.jacm.sjft.modells;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdenCompra {
	private int consecutivo;
	private LocalDate fecha;
	private ArrayList<Tiquete> tiquetes;
	
	public OrdenCompra() {}

	public int getConsecutivo() {
		return consecutivo;
	}

	public void setConsecutivo(int consecutivo) {
		this.consecutivo = consecutivo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public ArrayList<Tiquete> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(ArrayList<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	};
}
