package app.jacm.sjft.modells;

public class Tripulante extends Pasajero {
	private int numeroVuelo;
	
	public Tripulante() {
		super();
	}
	
	public Tripulante(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public int getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
}
