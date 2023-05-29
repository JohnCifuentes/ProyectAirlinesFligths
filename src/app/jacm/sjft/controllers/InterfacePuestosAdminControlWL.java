package app.jacm.sjft.controllers;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import app.jacm.sjft.interfaces.InterfacePuestosAdmin;

public class InterfacePuestosAdminControlWL implements WindowListener{
	private InterfacePuestosAdmin vPuestosAdmin;
	
	public InterfacePuestosAdminControlWL(InterfacePuestosAdmin vPuestosAdmin) {
		super();
		this.vPuestosAdmin = vPuestosAdmin; 
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		this.vPuestosAdmin.getvAdministrarBotones().setVisible(true);
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
