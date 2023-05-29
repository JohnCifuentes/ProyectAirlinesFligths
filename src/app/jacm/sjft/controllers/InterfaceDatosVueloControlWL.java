package app.jacm.sjft.controllers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import app.jacm.sjft.interfaces.InterfaceDatosVuelo;

public class InterfaceDatosVueloControlWL implements WindowListener{
	private InterfaceDatosVuelo vDatosVueloVentana;
	public InterfaceDatosVueloControlWL(InterfaceDatosVuelo vDatosVueloVentana) {
		this.vDatosVueloVentana = vDatosVueloVentana;
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		this.vDatosVueloVentana.getvPrincipal().setVisible(true);
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
