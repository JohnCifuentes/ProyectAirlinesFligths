package app.jacm.sjft.controllers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import app.jacm.sjft.interfaces.InterfaceDatosPersonalesPasajero;

public class InterfaceDatosPersonalesPasajeroControlWL implements WindowListener{
	private InterfaceDatosPersonalesPasajero vDatosPersonalesPasajeroVenta;
	
	public InterfaceDatosPersonalesPasajeroControlWL(InterfaceDatosPersonalesPasajero vDatosPersonalesPasajeroVenta) {
		super();
		this.vDatosPersonalesPasajeroVenta = vDatosPersonalesPasajeroVenta;
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.vDatosPersonalesPasajeroVenta.getVPuestosSeleccionar().setVisible(true);
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
