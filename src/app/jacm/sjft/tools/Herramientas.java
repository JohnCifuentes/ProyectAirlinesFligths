package app.jacm.sjft.tools;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;

import app.jacm.sjft.modells.Puesto;
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
	
	public JButton[] btnPuestos(ArrayList<Puesto> listaPuestos) {
		JButton[] btnPuestos = new JButton[listaPuestos.size()];
		for(int i = 0; i < listaPuestos.size(); i++) {
			JButton btnPuesto = new JButton(listaPuestos.get(i).getConsecutivoBoleto());
			if(listaPuestos.get(i).getDisponibilidad() == 0) {
				btnPuesto.setBackground(Color.GREEN);
			} else if(listaPuestos.get(i).getDisponibilidad() == 1){
				btnPuesto.setBackground(Color.RED);
			} else {
				btnPuesto.setBackground(Color.YELLOW);
			}
			btnPuestos[i] = btnPuesto;			
		}
		return btnPuestos;
	}
	
	public GridBagConstraints[] gbc_btnPuestos(ArrayList<Puesto> listaPuestos) {
		GridBagConstraints[] gbc_btnPuestos = new GridBagConstraints[listaPuestos.size()];
		int posicionX = 0, posicionY = 0;
		for(int i = 0; i < listaPuestos.size(); i++) {
			GridBagConstraints gbc_btnPuesto = new GridBagConstraints();
			/**
			 **/
			if(Character.toString(listaPuestos.get(i).getLetra()).equals("A")) 
				posicionX = 0;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("B"))
				posicionX = 1;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("C"))
				posicionX = 2;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("D"))
				posicionX = 3;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("E"))
				posicionX = 4;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("F"))
				posicionX = 5;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("G"))
				posicionX = 6;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("H"))
				posicionX = 7;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("I"))
				posicionX = 8;
			else if(Character.toString(listaPuestos.get(i).getLetra()).equals("J"))
				posicionX = 9;
			/**
			 **/
			if(listaPuestos.get(i).getTipo() == 0) {
				gbc_btnPuesto.fill = GridBagConstraints.BOTH;
				gbc_btnPuesto.gridheight = 2;				
			} else {
				gbc_btnPuesto.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnPuesto.gridheight = 1;
			}
			/**
			 **/
			if(i == 0) {
				posicionY = 0;
			} else {
				if(listaPuestos.get(i).getTipo() == 0) {
					if(posicionY == 2)
						posicionY++;
					posicionY = posicionY + 2;
				} else {
					if(posicionY == 3)
						posicionY++;
					posicionY++;
				}
				if (posicionY > 7) {
					posicionY = 0;
					if(listaPuestos.get(i).getTipo() == 1) {
						posicionY++;
					}
				}
			}
			gbc_btnPuesto.insets = new Insets(0, 0, 5, 5);
			gbc_btnPuesto.gridx = posicionX;
			gbc_btnPuesto.gridy = posicionY;
			/**
			 **/
			gbc_btnPuestos[i] = gbc_btnPuesto;
		}
		return gbc_btnPuestos; 
	}
}
