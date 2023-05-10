package app.jacm.sjft.controllers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfaceAdministrarBotones;
import app.jacm.sjft.interfaces.InterfaceDatosPersonalesTripulante;
import app.jacm.sjft.interfaces.InterfacePrincipal;
import app.jacm.sjft.interfaces.InterfacePuestosAdmin;
import app.jacm.sjft.modells.Tripulante;
import app.jacm.sjft.tools.Herramientas;

public class InterfaceAdministrarBotonesControlAL implements ActionListener{
	private InterfaceAdministrarBotones vAdministrarBotones;	
	private int numeroVuelo;
	private Herramientas herramienta = new Herramientas();
	/**
	 * @param vAdministrarBotones
	 */
	public InterfaceAdministrarBotonesControlAL(InterfaceAdministrarBotones vAdministrarBotones) {
		this.vAdministrarBotones = vAdministrarBotones;
	};
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * ValidaAcceso - cargarTripulantes(); 
		 */
		if(e.getSource() == this.vAdministrarBotones.getBtnCargarTripulantes()) {
			this.numeroVuelo = herramienta.numeroVuelo(vAdministrarBotones.getVistaPrincipal().getCbFechaSalidaVuelo().getSelectedIndex(), vAdministrarBotones.getVistaPrincipal().getCbHoraSalidaVuelo().getSelectedIndex());
			int tripulanteNumeroVueloMaximo = this.herramienta.numeroVueloTripulantesCargadosMax(
				this.vAdministrarBotones.getVistaPrincipal().getTripulantes());
			if(tripulanteNumeroVueloMaximo == -1) {
				if(this.numeroVuelo > 1) {
					JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo " + this.herramienta.detallesVuelo(
						this.numeroVuelo - 1, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
				} else {
					cargarTripulantes(this.numeroVuelo);
				}
			} else {
				if(this.numeroVuelo == tripulanteNumeroVueloMaximo) {
					JOptionPane.showMessageDialog(vAdministrarBotones, "Ya cargo los tripulantes del vuelo " + this.herramienta.detallesVuelo(
						this.numeroVuelo,  this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));					
				}else if(this.numeroVuelo > tripulanteNumeroVueloMaximo) {
					JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo " + this.herramienta.detallesVuelo(
						this.numeroVuelo - 1, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
				} else {
					cargarTripulantes(this.numeroVuelo);
				}
			}					
		}
		/**
		 * ValidaAcceso - activarPuestos();
		 */
		if(e.getSource() == this.vAdministrarBotones.getBtnActivarPuesto()) {
			this.numeroVuelo = herramienta.numeroVuelo(vAdministrarBotones.getVistaPrincipal().getCbFechaSalidaVuelo().getSelectedIndex(), vAdministrarBotones.getVistaPrincipal().getCbHoraSalidaVuelo().getSelectedIndex());
			int tripulanteNumeroVueloMaximo = this.herramienta.numeroVueloTripulantesCargadosMax(
					this.vAdministrarBotones.getVistaPrincipal().getTripulantes());
			if(tripulanteNumeroVueloMaximo == -1) {
				JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo" + this.herramienta.detallesVuelo(this.numeroVuelo, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
			} else {
				activarPuestos(this.numeroVuelo-1);
			} 
		}
	}
	/**
	 * 
	 */
	public void cargarTripulantes(int numeroVuelo) {
		InterfaceDatosPersonalesTripulante vCargarTripulante = new InterfaceDatosPersonalesTripulante(this.vAdministrarBotones, numeroVuelo);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vCargarTripulante.setLocation(pantalla.width/2, pantalla.height/2);
		vCargarTripulante.setSize(870, 300);
		vCargarTripulante.setVisible(true);
	};
	/**
	 * 
	 */
	public void activarPuestos(int numeroVuelo) {
		InterfacePuestosAdmin vCargarTripulante = new InterfacePuestosAdmin(this.vAdministrarBotones, numeroVuelo);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vCargarTripulante.setLocation(pantalla.width/2, pantalla.height/2);
		vCargarTripulante.setSize(995, 450);
		vCargarTripulante.setVisible(true);
	}
}
