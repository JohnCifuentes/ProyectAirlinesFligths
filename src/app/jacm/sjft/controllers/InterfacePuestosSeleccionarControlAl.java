package app.jacm.sjft.controllers;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfaceDatosPersonalesPasajero;
import app.jacm.sjft.interfaces.InterfacePuestosSeleccionar;
import app.jacm.sjft.modells.OrdenCompra;
import app.jacm.sjft.modells.Puesto;
import app.jacm.sjft.modells.Tiquete;

public class InterfacePuestosSeleccionarControlAl implements ActionListener{
	private InterfacePuestosSeleccionar vPuestosSeleccionar;
	
	public InterfacePuestosSeleccionarControlAl(InterfacePuestosSeleccionar vPuestosSeleccionar) {
		this.vPuestosSeleccionar = vPuestosSeleccionar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() != this.vPuestosSeleccionar.getBtnConfirmar() && e.getSource() != this.vPuestosSeleccionar.getBtnCancelar()) {
			JButton botonSeleccionado = null;
			for(int i = 0; i < this.vPuestosSeleccionar.getBtnPuestos().length; i++) {
				if(e.getSource() == this.vPuestosSeleccionar.getBtnPuestos()[i]) {
					botonSeleccionado = this.vPuestosSeleccionar.getBtnPuestos()[i];
					break;
				}
			}
			if(botonSeleccionado.getBackground() != Color.GREEN) {
				JOptionPane.showMessageDialog(botonSeleccionado, "El puesto no esta disponible. Por favor intente con otro.");
			} else {
				Puesto puesto = null;
				for(int i = 0; i < this.vPuestosSeleccionar.getPuestos().size(); i++) {
					if(this.vPuestosSeleccionar.getPuestos().get(i).getConsecutivoBoleto().equals(botonSeleccionado.getText())) {
						puesto = this.vPuestosSeleccionar.getPuestos().get(i);
						break;
					}
				}
				cargarDatosPersonalesPasajero(puesto, botonSeleccionado);
			}			
		}
		
		if(e.getSource() == this.vPuestosSeleccionar.getBtnConfirmar()) {
			if(this.vPuestosSeleccionar.getTiquetes().size() == 0) {
				JOptionPane.showMessageDialog(vPuestosSeleccionar, "Debe de ingresar al menos un pasajero. Por favor intente de nuevo.");
			} else {
				String mensaje = null;
				int cantidadTiquetes = 0;
				int valorTotal = 0;
				for(Tiquete t: this.vPuestosSeleccionar.getTiquetes()) {
					cantidadTiquetes++;
					valorTotal = valorTotal + t.getSilla().getPrecio();
				}
				mensaje = "Confirma la compra de " + cantidadTiquetes + " tiquete(s) por un total de $" + valorTotal;
				if(JOptionPane.showConfirmDialog(vPuestosSeleccionar, mensaje) == 0) {
					ArrayList<Puesto> puestos = this.vPuestosSeleccionar.getPuestos();
					for(Tiquete t: this.vPuestosSeleccionar.getTiquetes()) {
						for(int i = 0; i < puestos.size(); i++) {
							if(puestos.get(i).getConsecutivoBoleto().equals(t.getSilla().getConsecutivoBoleto())) {
								puestos.get(i).setDisponibilidad(2);
								break;
							}
						}
					}
					this.vPuestosSeleccionar.getVistaPrincipal().getPuestos().set(this.vPuestosSeleccionar.getNumeroVuelo(), puestos);
					
					OrdenCompra ordenCompra = new OrdenCompra();
					ordenCompra.setNumeroVuelo(this.vPuestosSeleccionar.getNumeroVuelo());
					ordenCompra.setTiquetes(this.vPuestosSeleccionar.getTiquetes());
					this.vPuestosSeleccionar.getVistaPrincipal().agregarOrdenCompra(ordenCompra);
					//
					this.vPuestosSeleccionar.dispose();
					this.vPuestosSeleccionar.getVistaPrincipal().setVisible(true);					
				}
			}
		}
		
		if(e.getSource() == this.vPuestosSeleccionar.getBtnCancelar()) {
			this.vPuestosSeleccionar.dispose();
			this.vPuestosSeleccionar.getVistaPrincipal().setVisible(true);			
		}

	}
	
	public void cargarDatosPersonalesPasajero(Puesto puesto, JButton botonSeleccionado) {
		InterfaceDatosPersonalesPasajero vDatosPersonalesPajasero = new InterfaceDatosPersonalesPasajero(this.vPuestosSeleccionar, puesto, botonSeleccionado);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vDatosPersonalesPajasero.setLocation(pantalla.width/8, pantalla.height/4);
		vDatosPersonalesPajasero.setSize(900, 380);
		vDatosPersonalesPajasero.setVisible(true);
	}
	
}
