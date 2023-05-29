package app.jacm.sjft.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfaceDatosVuelo;
import app.jacm.sjft.modells.Puesto;

public class InterfaceDatosVueloControlAL implements ActionListener{
	private InterfaceDatosVuelo vDatosVuelo;
	
	public InterfaceDatosVueloControlAL(InterfaceDatosVuelo vDatosVuelo) {
		this.vDatosVuelo = vDatosVuelo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * 
		 */
		if(e.getSource() == this.vDatosVuelo.getBtnAnularTiquete()) {
			if(JOptionPane.showConfirmDialog(vDatosVuelo, "¿Esta seguro de cancelar el tiquete?") == 0) {
				//Se actualiza la disponibilidad del puesto
				for(Puesto p: this.vDatosVuelo.getvPrincipal().getPuestos().get(this.vDatosVuelo.getOrdenCompra().getNumeroVuelo())) {
					if(p.getConsecutivoBoleto().equals(this.vDatosVuelo.getTiquete().getSilla().getConsecutivoBoleto())) {
						p.setDisponibilidad(0);
						this.vDatosVuelo.getvPrincipal().getPuestos().get(this.vDatosVuelo.getOrdenCompra().getNumeroVuelo()).set(
								this.vDatosVuelo.getvPrincipal().getPuestos().get(this.vDatosVuelo.getOrdenCompra().getNumeroVuelo()).indexOf(p), p);
					}
				}
				//Se elimina el tiquete de la lista de tiquetes relacionada a la orden de compra
				this.vDatosVuelo.getOrdenCompra().getTiquetes().remove(this.vDatosVuelo.getOrdenCompra().getTiquetes().indexOf(this.vDatosVuelo.getTiquete()));
				//Si la orden de compra no tiene tiquetes
				if(this.vDatosVuelo.getOrdenCompra().getTiquetes().size() == 0) {
					//Se elimina la orden de compra de la lista de tiquetes relacionada a la pantalla principal
					this.vDatosVuelo.getvPrincipal().getOrdenesCompra().remove(this.vDatosVuelo.getvPrincipal().getOrdenesCompra().indexOf(this.vDatosVuelo.getOrdenCompra()));
				} else {
					//Se actualiza la orden de compra en la lista de tiquetes relacionada a la pantalla principal
					this.vDatosVuelo.getvPrincipal().getOrdenesCompra().set(this.vDatosVuelo.getvPrincipal().getOrdenesCompra().indexOf(this.vDatosVuelo.getOrdenCompra()), this.vDatosVuelo.getOrdenCompra());
				}
				this.vDatosVuelo.dispose();
				this.vDatosVuelo.getvPrincipal().setVisible(true);
			}
		}
		/**
		 * 
		 */
		if(e.getSource() == this.vDatosVuelo.getBtnOK()) {
			this.vDatosVuelo.dispose();
			this.vDatosVuelo.getvPrincipal().setVisible(true);
		}
		
	}

}
