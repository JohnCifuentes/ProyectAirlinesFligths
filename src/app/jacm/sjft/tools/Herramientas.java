package app.jacm.sjft.tools;

import java.util.ArrayList;

import app.jacm.sjft.modells.Tripulante;

public class Herramientas {

	public int numeroVuelo(int posicionFechaVuelo, int posicionHoraVuelo) {
		int numeroVuelo = -1;
		if(posicionFechaVuelo == 1) {
			numeroVuelo = posicionFechaVuelo + (posicionHoraVuelo-1);
		} else if(posicionFechaVuelo == 2) {
			numeroVuelo = 4 + (posicionHoraVuelo-1);
		} else if(posicionFechaVuelo == 3) {
			numeroVuelo = 7 + (posicionHoraVuelo-1);
		}
		return numeroVuelo;
	}
	
	public String detallesVuelo(int numeroVuelo, String[][] fechaHoraVuelo) {
		String detallesVuelo = null;
		if(numeroVuelo > 0 && numeroVuelo <= 3) {
			detallesVuelo = fechaHoraVuelo[0][0] + " - " + fechaHoraVuelo[0][numeroVuelo];
		} else if (numeroVuelo > 3 && numeroVuelo <= 6) {
			detallesVuelo = fechaHoraVuelo[1][0] + " - " + fechaHoraVuelo[0][numeroVuelo-3];
		} else {
			detallesVuelo = fechaHoraVuelo[2][0] + " - " + fechaHoraVuelo[0][numeroVuelo-6];
		}
		return detallesVuelo;
	}
	
	public int numeroVueloTripulantesCargadosMax(ArrayList<ArrayList<Tripulante>> tripulantesCargados) {
		int numeroVueloTripulantesCargadosMax = -1;
		for(ArrayList<Tripulante> listaTripulanteVuelo: tripulantesCargados)
			for(Tripulante t: listaTripulanteVuelo)
				if(t.getNumeroVuelo() > numeroVueloTripulantesCargadosMax)
					numeroVueloTripulantesCargadosMax = t.getNumeroVuelo();
		return numeroVueloTripulantesCargadosMax;
	}

	public boolean esNumero(String dato) {
		try {
			int datoNumero = Integer.parseInt(dato);
			return false;
		}catch(Exception e) {
			return true;
		}
	}
}
