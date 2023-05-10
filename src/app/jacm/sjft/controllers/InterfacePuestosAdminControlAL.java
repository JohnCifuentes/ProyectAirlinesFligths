package app.jacm.sjft.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfacePuestosAdmin;
import app.jacm.sjft.modells.Puesto;

public class InterfacePuestosAdminControlAL implements ActionListener{
	private InterfacePuestosAdmin vPuestosAdmin;
	
	public InterfacePuestosAdminControlAL(InterfacePuestosAdmin vPuestosAdmin) {
		this.vPuestosAdmin = vPuestosAdmin;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton botonSeleccionado = null;
		for(int i = 0; i < this.vPuestosAdmin.getBtnPuestos().length; i++) {
			if(e.getSource() == this.vPuestosAdmin.getBtnPuestos()[i]) {
				botonSeleccionado = this.vPuestosAdmin.getBtnPuestos()[i];
			}
		}
		if(this.vPuestosAdmin.getActivarInactivarPuesto() == 0) {
			if(JOptionPane.showConfirmDialog(this.vPuestosAdmin, "Usted va a activar el puesto " + botonSeleccionado.getText() + ", esta seguro?") == 0) {
				encontrarPuestoActualizar(botonSeleccionado);
				botonSeleccionado.setBackground(Color.GREEN);
			}
			
		} else {
			if(JOptionPane.showConfirmDialog(botonSeleccionado, "Usted va a inactivar el puesto " + botonSeleccionado.getText() + ", esta seguro?") == 0) {
				ArrayList<Puesto> puestos = this.vPuestosAdmin.getvAdministrarBotones().getVistaPrincipal().getPuestos().get(this.vPuestosAdmin.getNumeroVuelo());
				encontrarPuestoActualizar(botonSeleccionado);
				botonSeleccionado.setBackground(Color.RED);
			}
		}
	}
	
	public void encontrarPuestoActualizar(JButton botonSeleccionado) {
		ArrayList<Puesto> puestos = this.vPuestosAdmin.getvAdministrarBotones().getVistaPrincipal().getPuestos().get(this.vPuestosAdmin.getNumeroVuelo());
		for(int i = 0; i < puestos.size(); i++) {
			if(puestos.get(i).getConsecutivoBoleto().equals(botonSeleccionado.getText())) {
				puestos.get(i).setDisponibilidad(this.vPuestosAdmin.getActivarInactivarPuesto());
				//
				this.vPuestosAdmin.getvAdministrarBotones().getVistaPrincipal().getPuestos().get(this.vPuestosAdmin.getNumeroVuelo()).set(i, puestos.get(i));
			}
		}		
	}

}