package app.jacm.sjft.controllers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import app.jacm.sjft.interfaces.InterfacePuestosSeleccionar;

public class InterfacePuestosSeleccionarControlWL implements WindowListener{
	private InterfacePuestosSeleccionar vPuestosSeleccionarVentana;
	
	public InterfacePuestosSeleccionarControlWL(InterfacePuestosSeleccionar vPuestosSeleccionar) {
		super();
		this.vPuestosSeleccionarVentana = vPuestosSeleccionar;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.vPuestosSeleccionarVentana.getVistaPrincipal().setVisible(true);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
