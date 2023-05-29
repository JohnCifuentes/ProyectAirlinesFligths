package app.jacm.sjft.controllers;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfaceDatosPersonalesPasajero;
import app.jacm.sjft.modells.ContactoEmergencia;
import app.jacm.sjft.modells.Pasajero;
import app.jacm.sjft.modells.Tiquete;
import app.jacm.sjft.tools.Herramientas;

public class InterfaceDatosPersonalesPasajeroControlAL implements ActionListener{
	private InterfaceDatosPersonalesPasajero vDatosPersonalesPasajero; 
	private Herramientas herramienta = new Herramientas();
	
	public InterfaceDatosPersonalesPasajeroControlAL(InterfaceDatosPersonalesPasajero vDatosPersonalesPasajero) {
		this.vDatosPersonalesPasajero = vDatosPersonalesPasajero;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == this.vDatosPersonalesPasajero.getBtnAgregar()) {
			if(!validarDatosPasajero() && !validarDatosContacto()) {
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "Debe de ingresar correctamente los datos del pasajero y contacto de emergencia. Por favor intente de nuevo.");
			}else if(!validarDatosPasajero()) {
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "Debe de ingresar correctamente los datos del pasajero. Por favor intente de nuevo");
			}else if(!validarDatosContacto()) {
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "Debe de ingresar correctamente los datos del contacto de emergencia. Por favor intente de nuevo");
			}else if(this.herramienta.esFecha(this.vDatosPersonalesPasajero.getTextFechaNacimiento().getText())){
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "El campo fecha de nacimiento debe de cumplir con el formato DD/MM/YYYY. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.herramienta.esNumero(this.vDatosPersonalesPasajero.getTextNumeroIdentificacion().getText())){
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "El campo numero de identificacion debe ser numerico. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.herramienta.esNumero(this.vDatosPersonalesPasajero.getTextNumeroTelefono().getText())) {
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "El campo numero de telefono debe ser numerico. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.herramienta.esNumero(this.vDatosPersonalesPasajero.getTextNumeroTelefonoContacto().getText())) {
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "El campo numero de telefono de contacto debe ser numerico. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(this.vDatosPersonalesPasajero.getPuesto().getLetra() == 'F' && this.herramienta.edadPasajero(this.vDatosPersonalesPasajero.getTextFechaNacimiento().getText()) < 18) {
				JOptionPane.showMessageDialog(vDatosPersonalesPasajero, "El pasajero no puede sentarse en las salidas de emergencia. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				agregarTiquete();
			}
		}

	}
	
	public boolean validarDatosPasajero() {
		if(this.vDatosPersonalesPasajero.getTextNombreCompleto().getText().equals("")
			|| this.vDatosPersonalesPasajero.getTextFechaNacimiento().getText().equals("")
			|| this.vDatosPersonalesPasajero.getTextNumeroIdentificacion().getText().equals("")
			|| this.vDatosPersonalesPasajero.getTextNumeroTelefono().getText().equals("")
			|| this.vDatosPersonalesPasajero.getTextDireccionResidencia().getText().equals("")
		) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean validarDatosContacto() {
		if(this.vDatosPersonalesPasajero.getTextNombreCompletoContacto().getText().equals("")
			|| this.vDatosPersonalesPasajero.getTextNumeroTelefonoContacto().getText().equals("")
			|| this.vDatosPersonalesPasajero.getCbParentescoContacto().getSelectedIndex() <= 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public void agregarTiquete() {
		Pasajero pasajero = new Pasajero();
		pasajero.setNombreCompleto(this.vDatosPersonalesPasajero.getTextNombreCompleto().getText());
		pasajero.setFechaNacimiento(this.vDatosPersonalesPasajero.getTextFechaNacimiento().getText());
		pasajero.setNumeroIdentificacion(Integer.parseInt(this.vDatosPersonalesPasajero.getTextNumeroIdentificacion().getText()));
		pasajero.setNumeroContacto(Integer.parseInt(this.vDatosPersonalesPasajero.getTextNumeroTelefono().getText()));
		pasajero.setDireccion(this.vDatosPersonalesPasajero.getTextDireccionResidencia().getText());
		
		ContactoEmergencia contactoEmergencia = new ContactoEmergencia();
		contactoEmergencia.setNombreCompleto(this.vDatosPersonalesPasajero.getTextNombreCompletoContacto().getText());
		contactoEmergencia.setNumeroContaco(Integer.parseInt(this.vDatosPersonalesPasajero.getTextNumeroTelefonoContacto().getText()));
		contactoEmergencia.setParentesco(this.vDatosPersonalesPasajero.getCbParentescoContacto().getSelectedItem().toString());
		
		pasajero.setContactoEmergencia(contactoEmergencia);

		Tiquete tiquete = new Tiquete();
		tiquete.setPasajero(pasajero);
		tiquete.setSilla(this.vDatosPersonalesPasajero.getPuesto());
		
		this.vDatosPersonalesPasajero.getVPuestosSeleccionar().addTiquete(tiquete);
		this.vDatosPersonalesPasajero.getBotonSeleccionado().setBackground(Color.YELLOW);
		this.vDatosPersonalesPasajero.dispose();
		this.vDatosPersonalesPasajero.getVPuestosSeleccionar().setVisible(true);
	}
}