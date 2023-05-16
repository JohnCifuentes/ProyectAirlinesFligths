package app.jacm.sjft.controllers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.jacm.sjft.interfaces.InterfaceDatosPersonalesPasajero;
import app.jacm.sjft.interfaces.InterfacePuestosSeleccionar;
import app.jacm.sjft.modells.Puesto;

public class InterfacePuestosSeleccionarControlAl implements ActionListener{
	private InterfacePuestosSeleccionar vPuestosSeleccionar;
	
	public InterfacePuestosSeleccionarControlAl(InterfacePuestosSeleccionar vPuestosSeleccionar) {
		this.vPuestosSeleccionar = vPuestosSeleccionar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton botonSeleccionado = null;
		for(int i = 0; i < this.vPuestosSeleccionar.getBtnPuestos().length; i++) {
			if(e.getSource() == this.vPuestosSeleccionar.getBtnPuestos()[i]) {
				botonSeleccionado = this.vPuestosSeleccionar.getBtnPuestos()[i];
				break;
			}
		}
		//
		Puesto puesto = null;
		for(int i = 0; i < this.vPuestosSeleccionar.getPuestos().size(); i++) {
			if(this.vPuestosSeleccionar.getPuestos().get(i).getConsecutivoBoleto().equals(botonSeleccionado.getText())) {
				puesto = this.vPuestosSeleccionar.getPuestos().get(i);
				break;
			}
		}
		cargarDatosPersonalesPasajero(puesto);
	}
	
	public void cargarDatosPersonalesPasajero(Puesto puesto) {
		InterfaceDatosPersonalesPasajero vDatosPersonalesPajasero = new InterfaceDatosPersonalesPasajero(this.vPuestosSeleccionar, puesto);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vDatosPersonalesPajasero.setLocation(pantalla.width/8, pantalla.height/4);
		vDatosPersonalesPajasero.setSize(900, 380);
		vDatosPersonalesPajasero.setVisible(true);
	}
	
}
