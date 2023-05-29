package app.jacm.sjft.controllers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfaceAdministrarBotones;
import app.jacm.sjft.interfaces.InterfaceDatosVuelo;
import app.jacm.sjft.interfaces.InterfacePrincipal;
import app.jacm.sjft.interfaces.InterfacePuestosSeleccionar;
import app.jacm.sjft.modells.OrdenCompra;
import app.jacm.sjft.modells.Tiquete;
import app.jacm.sjft.modells.Tripulante;
import app.jacm.sjft.tools.Herramientas;

public class InterfacePrincipalControlAL implements ActionListener{
	private InterfacePrincipal vPrincipal;
	private Herramientas herramienta = new Herramientas();
	/**
	 * 
	 * @param vPrincipal
	 */
	public InterfacePrincipalControlAL(InterfacePrincipal vPrincipal) {
		this.vPrincipal = vPrincipal;
	}
	/**
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		/**
		 * ValidaAcceso - cargarCancelarTiquetes();
		 * */
		if (e.getSource() == this.vPrincipal.getBtnGestionarMiViaje()) {
			String idPasajero = JOptionPane.showInputDialog(vPrincipal, "Ingrese numero de identificación");
			if(this.herramienta.esNumero(idPasajero)) {
				JOptionPane.showMessageDialog(vPrincipal, "Numero de identififación debe de ser numerico, por favor intente de nuevo.", "Error!", JOptionPane.ERROR_MESSAGE);
			} else {
				OrdenCompra ordenCompra = new OrdenCompra();;
				Tiquete tiquete = new Tiquete();
				boolean existeTiquetePasajero = false;
				listaCompras:
				for(OrdenCompra oc: this.vPrincipal.getOrdenesCompra()) {
					listaTiquetes:
					for(Tiquete t: oc.getTiquetes()) {
						if(t.getPasajero().getNumeroIdentificacion() == Integer.parseInt(idPasajero)) {
							ordenCompra = oc;
							tiquete = t;
							existeTiquetePasajero = true;
							break listaTiquetes;
						}
					}
					if(existeTiquetePasajero)
						break listaCompras;
				}
				if(!existeTiquetePasajero) {
					JOptionPane.showMessageDialog(vPrincipal, "No existe un tiquete para el numero de identificación, por favor intente de nuevo.");
				} else {
					cargarCancelarTiquetes(ordenCompra, tiquete);
				}
			}
		}
		/**
		 * ValidaAcceso - cargarAdministrarBotones();
		 */
		if (e.getSource() == this.vPrincipal.getBtnAdministrar()) {
			//datoValidoFechaVuelo && datoValidoHoraVuelo
			if( this.vPrincipal.getCbFechaSalidaVuelo().getSelectedIndex() <= 0 | this.vPrincipal.getCbHoraSalidaVuelo().getSelectedIndex() <= 0) {
				JOptionPane.showMessageDialog(vPrincipal, "Fecha u hora de vuelo invalida, por favor intente de nuevo.", "Error!", JOptionPane.ERROR_MESSAGE);
			} else {
				String idUsuarioAdmin = JOptionPane.showInputDialog(vPrincipal, "Ingrese numero de identificación");
				if(herramienta.esNumero(idUsuarioAdmin)) {
					JOptionPane.showMessageDialog(vPrincipal, "Numero de identififación debe de ser numerico, por favor intente de nuevo.", "Error!", JOptionPane.ERROR_MESSAGE);
				} else {
					//usuarioAdministrador
					if(idUsuarioAdmin.equals("1094962750")) {
						cargarAdministrarBotones();
					//usuarioTipoTripulanteAdministrador
					} else if (this.vPrincipal.getTripulantes().size() > 0){
						/**
						 * numeroVuelo - FechaHoraVueloSeleccionado
						 */
						int numeroVuelo = herramienta.numeroVuelo(this.vPrincipal.getCbFechaSalidaVuelo().getSelectedIndex(), this.vPrincipal.getCbHoraSalidaVuelo().getSelectedIndex());
						if(numeroVuelo > this.vPrincipal.getTripulantes().size()) {
							JOptionPane.showMessageDialog(this.vPrincipal, "No se han cargado los tripulantes del vuelo" + this.herramienta.detallesVuelo(numeroVuelo, this.vPrincipal.getFechaHora()));
						} else {
							ArrayList<Tripulante> tripulantes = this.vPrincipal.getTripulantes().get(numeroVuelo - 1);
							Tripulante tripulante = null;
							for(Tripulante t: tripulantes)
								if(t.getNumeroIdentificacion() == Integer.parseInt(idUsuarioAdmin))
									tripulante = t;
							if (tripulante != null)
								cargarAdministrarBotones();
							else 
								JOptionPane.showMessageDialog(vPrincipal, "Usuario sin permisos, por favor intente de nuevo.", "Error!", JOptionPane.ERROR_MESSAGE);							
						}
					} else {
						JOptionPane.showMessageDialog(vPrincipal, "Usuario sin permisos, por favor intente de nuevo.", "Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
		/**
		 * ValidaAcceso - cargarPuestosVuelo();
		 */
		if (e.getSource() == this.vPrincipal.getBtnBuscarPuestoVuelo()) {
			if(this.vPrincipal.getCbFechaSalidaVuelo().getSelectedIndex() <= 0 | this.vPrincipal.getCbHoraSalidaVuelo().getSelectedIndex() <= 0 | (Integer)this.vPrincipal.getsCantidadPasajeroVuelo().getValue() <= 0) {
				JOptionPane.showMessageDialog(vPrincipal, "Fecha y hora de vuelo o cantidad de pasajeros invalido, por favor intente de nuevo.", "Error!", JOptionPane.ERROR_MESSAGE);
			} else {
				int numeroVuelo = herramienta.numeroVuelo(this.vPrincipal.getCbFechaSalidaVuelo().getSelectedIndex(), this.vPrincipal.getCbHoraSalidaVuelo().getSelectedIndex());
				cargarPuestosVuelo(numeroVuelo-1);
			}
		}
	}
	/**
	 * CargarVentana-CancelarTiquetes
	 * */
	public void cargarCancelarTiquetes(OrdenCompra ordenCompra, Tiquete tiquete) {
		InterfaceDatosVuelo vAdministrarBotones = new InterfaceDatosVuelo(this.vPrincipal, ordenCompra, tiquete);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vAdministrarBotones.setLocation(pantalla.width/6, pantalla.height/4);
		vAdministrarBotones.setSize(870, 230);
		vAdministrarBotones.setVisible(true);
	}
	/**
	 * CargarVentana-AdministrarBotones
	 * */
	public void cargarAdministrarBotones() {
		InterfaceAdministrarBotones vAdministrarBotones = new InterfaceAdministrarBotones(this.vPrincipal);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vAdministrarBotones.setLocation(pantalla.width/6, pantalla.height/4);
		vAdministrarBotones.setSize(870, 230);
		vAdministrarBotones.setVisible(true);
	}
	/**
	 * CargarVentana-PuestosVuelo
	 * */
	public void cargarPuestosVuelo(int numeroVuelo) {
		InterfacePuestosSeleccionar vPuestosSeleccionar = new InterfacePuestosSeleccionar(this.vPrincipal, numeroVuelo);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vPuestosSeleccionar.setLocation(1, pantalla.height/4);
		vPuestosSeleccionar.setSize(1370, 430);
		vPuestosSeleccionar.setVisible(true);
	}
}
