package app.jacm.sjft.controllers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfaceAdministrarBotones;
import app.jacm.sjft.interfaces.InterfaceDatosPersonalesTripulante;
import app.jacm.sjft.interfaces.InterfaceInformeGeneral;
import app.jacm.sjft.interfaces.InterfacePuestosAdmin;
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
			this.numeroVuelo = herramienta.numeroVuelo(this.vAdministrarBotones.getVistaPrincipal().getCbFechaSalidaVuelo().getSelectedIndex(), this.vAdministrarBotones.getVistaPrincipal().getCbHoraSalidaVuelo().getSelectedIndex());
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
				}else if(this.numeroVuelo > (tripulanteNumeroVueloMaximo+1)) {
					JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo " + this.herramienta.detallesVuelo(
						this.numeroVuelo - 1, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
				} else {
					cargarTripulantes(this.numeroVuelo);
				}
			}					
		}
		/**
		 * ValidaAcceso - activarInactivarPuestos();
		 */
		if(e.getSource() == this.vAdministrarBotones.getBtnActivarPuesto()) {
			this.numeroVuelo = herramienta.numeroVuelo(vAdministrarBotones.getVistaPrincipal().getCbFechaSalidaVuelo().getSelectedIndex(), vAdministrarBotones.getVistaPrincipal().getCbHoraSalidaVuelo().getSelectedIndex());
			int tripulanteNumeroVueloMaximo = this.herramienta.numeroVueloTripulantesCargadosMax(
					this.vAdministrarBotones.getVistaPrincipal().getTripulantes());
			if(tripulanteNumeroVueloMaximo == -1) {
				JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo" + this.herramienta.detallesVuelo(this.numeroVuelo, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
			} else {
				activarInactivarPuestos(this.numeroVuelo-1, 0);
			} 
		}
		/**
		 * ValidaAcceso - activarInactivarPuestos();
		 */
		if(e.getSource() == this.vAdministrarBotones.getBtnDesactivarPuesto()) {
			this.numeroVuelo = herramienta.numeroVuelo(vAdministrarBotones.getVistaPrincipal().getCbFechaSalidaVuelo().getSelectedIndex(), vAdministrarBotones.getVistaPrincipal().getCbHoraSalidaVuelo().getSelectedIndex());
			int tripulanteNumeroVueloMaximo = this.herramienta.numeroVueloTripulantesCargadosMax(
					this.vAdministrarBotones.getVistaPrincipal().getTripulantes());
			if(tripulanteNumeroVueloMaximo == -1) {
				JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo" + this.herramienta.detallesVuelo(this.numeroVuelo, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
			} else {
				activarInactivarPuestos(this.numeroVuelo-1, 1);
			} 
		}
		/**
		 * ValidaAcceso - cargarInformeGeneral();
		 */
		if(e.getSource() == this.vAdministrarBotones.getBtnInformeGeneralVuelo()) {
			this.numeroVuelo = herramienta.numeroVuelo(this.vAdministrarBotones.getVistaPrincipal().getCbFechaSalidaVuelo().getSelectedIndex(), this.vAdministrarBotones.getVistaPrincipal().getCbHoraSalidaVuelo().getSelectedIndex());
			cargarInformeGeneral(this.numeroVuelo-1);
		}
	}
	/**
	 * 
	 */
	public void cargarTripulantes(int numeroVuelo) {
		InterfaceDatosPersonalesTripulante vCargarTripulante = new InterfaceDatosPersonalesTripulante(this.vAdministrarBotones, numeroVuelo);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vCargarTripulante.setLocation(pantalla.width/8, pantalla.height/4);
		vCargarTripulante.setSize(1070, 430);
		vCargarTripulante.setVisible(true);
	};
	/**
	 * 
	 */
	public void activarInactivarPuestos(int numeroVuelo, int activarInactivarPuesto) {
		InterfacePuestosAdmin vCargarPuestosAdmin = new InterfacePuestosAdmin(this.vAdministrarBotones, numeroVuelo, activarInactivarPuesto);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vCargarPuestosAdmin.setLocation(pantalla.width/8, pantalla.height/4);
		vCargarPuestosAdmin.setSize(1070, 430);
		vCargarPuestosAdmin.setVisible(true);
	}
	/**
	 * 
	 */
	public void cargarInformeGeneral(int numeroVuelo) {
		InterfaceInformeGeneral vCargarInformeGeneral = new InterfaceInformeGeneral(this.vAdministrarBotones, numeroVuelo);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vCargarInformeGeneral.setLocation(pantalla.width/8, pantalla.height/4);
		vCargarInformeGeneral.setSize(1070, 430);
		vCargarInformeGeneral.setVisible(true);		
	}

}
