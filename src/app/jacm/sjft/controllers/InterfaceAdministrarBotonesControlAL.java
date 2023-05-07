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
import app.jacm.sjft.modells.Tripulante;
import app.jacm.sjft.tools.Herramientas;

public class InterfaceAdministrarBotonesControlAL implements ActionListener{
	private InterfaceAdministrarBotones vAdministrarBotones;
	private InterfacePrincipal vPrincipal;	
	public Herramientas herramienta = new Herramientas();
	/**
	 * @param vPrincipal
	 * @param vAdministrarBotones
	 */
	public InterfaceAdministrarBotonesControlAL(InterfacePrincipal vPrincipal, InterfaceAdministrarBotones vAdministrarBotones) {
		this.vPrincipal = vPrincipal;
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
			int numeroVuelo = this.herramienta.numeroVuelo(
				this.vAdministrarBotones.getVistaPrincipal().getCbFechaSalidaVuelo().getSelectedIndex(), 
				this.vAdministrarBotones.getVistaPrincipal().getCbHoraSalidaVuelo().getSelectedIndex());
			int tripulanteNumeroVueloMaximo = this.herramienta.numeroVueloTripulantesCargadosMax(
				this.vAdministrarBotones.getVistaPrincipal().getTripulantes());
			if(tripulanteNumeroVueloMaximo == -1) {
				if(numeroVuelo > 1) {
					JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo " + this.herramienta.detallesVuelo(
						numeroVuelo - 1, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
				} else {
					cargarTripulantes(numeroVuelo);
				}
			} else {
				if(numeroVuelo > tripulanteNumeroVueloMaximo) {
					JOptionPane.showMessageDialog(vAdministrarBotones, "Debe de cargar primero los tripulantes del vuelo " + this.herramienta.detallesVuelo(
						numeroVuelo - 1, this.vAdministrarBotones.getVistaPrincipal().getFechaHora()));
				} else {
					cargarTripulantes(numeroVuelo);
				}
			}					
		}
	}
	/**
	 * 
	 * @param numeroVuelo
	 */
	public void cargarTripulantes(int numeroVuelo) {
		InterfaceDatosPersonalesTripulante vCargarTripulante = new InterfaceDatosPersonalesTripulante(this.vAdministrarBotones, numeroVuelo);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vCargarTripulante.setLocation(pantalla.width/2 - vCargarTripulante.getSize().width/2, pantalla.height/2 - vCargarTripulante.getSize().height/2);
		vCargarTripulante.setSize(525, 220);
		vCargarTripulante.setVisible(true);
	};

}
