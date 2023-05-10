package app.jacm.sjft.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfaceDatosPersonalesTripulante;
import app.jacm.sjft.modells.Tripulante;
import app.jacm.sjft.tools.Herramientas;

public class InterfaceDatosPersonalesTripulanteControlAL implements ActionListener{
	InterfaceDatosPersonalesTripulante vDatosPersonalesTripulante;
	Herramientas herramienta = new Herramientas();
	public InterfaceDatosPersonalesTripulanteControlAL(InterfaceDatosPersonalesTripulante vDatosPersonalesTripulante){
		this.vDatosPersonalesTripulante = vDatosPersonalesTripulante;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * 
		 */
		if(e.getSource() == this.vDatosPersonalesTripulante.getBtnAgregar()) {
			if(
				this.vDatosPersonalesTripulante.getTextNombreCompleto().getText().equals("") |
				this.vDatosPersonalesTripulante.getTextFechaNacimiento().getText().equals("") |
				this.vDatosPersonalesTripulante.getTextNumeroIdentificacion().getText().equals("") |
				this.vDatosPersonalesTripulante.getTextNumeroTelefono().getText().equals("") |
				this.vDatosPersonalesTripulante.getTextDireccionResidencia().getText().equals("")
			) {
				JOptionPane.showMessageDialog(vDatosPersonalesTripulante, "Debe de ingresar todos los datos. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			} else if(herramienta.esNumero(this.vDatosPersonalesTripulante.getTextNumeroIdentificacion().getText())){
				JOptionPane.showMessageDialog(vDatosPersonalesTripulante, "El campo numero de identificacion debe ser numerico. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);	
			} else if(herramienta.esNumero(this.vDatosPersonalesTripulante.getTextNumeroTelefono().getText())) {
				JOptionPane.showMessageDialog(vDatosPersonalesTripulante, "El campo numero de telefono debe ser numerico. Por favor intente de nuevo", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(vDatosPersonalesTripulante, "Ingreso datos correctos.");
				agregarTripulante();
				actualizarCamposTripulante();
			}
		}
	}
	
	public void agregarTripulante() {
		Tripulante tripulante = new Tripulante();
		tripulante.setNombreCompleto(this.vDatosPersonalesTripulante.getTextNombreCompleto().getText());
		tripulante.setFechaNacimiento(this.vDatosPersonalesTripulante.getTextFechaNacimiento().getText());
		tripulante.setNumeroIdentificacion(Integer.parseInt(this.vDatosPersonalesTripulante.getTextNumeroIdentificacion().getText()));
		tripulante.setNumeroContacto(Integer.parseInt(this.vDatosPersonalesTripulante.getTextNumeroTelefono().getText()));
		tripulante.setDireccion(this.vDatosPersonalesTripulante.getTextDireccionResidencia().getText());
		tripulante.setNumeroVuelo(this.vDatosPersonalesTripulante.getNumeroVuelo());
		this.vDatosPersonalesTripulante.addTripulante(tripulante);
	}
	
	public void actualizarCamposTripulante() {
		this.vDatosPersonalesTripulante.getTextNombreCompleto().setText(null);
		this.vDatosPersonalesTripulante.getTextFechaNacimiento().setText(null);
		this.vDatosPersonalesTripulante.getTextNumeroIdentificacion().setText(null);
		this.vDatosPersonalesTripulante.getTextNumeroTelefono().setText(null);
		this.vDatosPersonalesTripulante.getTextDireccionResidencia().setText(null);
		this.vDatosPersonalesTripulante.setNumeroTripulantes(this.vDatosPersonalesTripulante.getNumeroTripulantes()+1);
		this.vDatosPersonalesTripulante.getLblContadorTripulantes().setText("Tripulante " + this.vDatosPersonalesTripulante.getNumeroTripulantes() + " de " + this.vDatosPersonalesTripulante.getNumeroTripulantesMaximo());
		if(this.vDatosPersonalesTripulante.getNumeroTripulantes() > this.vDatosPersonalesTripulante.getNumeroTripulantesMaximo()) {
			this.vDatosPersonalesTripulante.getvAdministrarBotones().getVistaPrincipal().addTripulantesVuelo(this.vDatosPersonalesTripulante.getTripulantes());
			this.vDatosPersonalesTripulante.dispose();
		}
	}
	
}
