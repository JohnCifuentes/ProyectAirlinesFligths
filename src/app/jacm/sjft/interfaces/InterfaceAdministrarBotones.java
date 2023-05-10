package app.jacm.sjft.interfaces;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

import app.jacm.sjft.controllers.InterfaceAdministrarBotonesControlAL;
import app.jacm.sjft.controllers.InterfaceAdministrarBotonesControlWL;
import app.jacm.sjft.controllers.InterfacePrincipalControlAL;
import app.jacm.sjft.modells.OrdenCompra;
import app.jacm.sjft.modells.Puesto;
import app.jacm.sjft.modells.Tripulante;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceAdministrarBotones extends JFrame{
	private InterfacePrincipal vistaPrincipal;
	private JButton btnCargarTripulantes;
	private JButton btnDisponibilidad;
	private JButton btnActivarPuesto;
	private JButton btnInformeGeneralVuelo;
	private JButton btnCantidadMenores;
	private JButton btnDesactivarPuesto;
	private JButton btnTotalizarVuelo;
	/**
	 * 
	 */
	private InterfaceAdministrarBotonesControlAL controlVentanaEventos = new InterfaceAdministrarBotonesControlAL(this);
	private InterfaceAdministrarBotonesControlWL controlVentana = new InterfaceAdministrarBotonesControlWL(this);
	/**
	 * 
	 * @param vistaPrincipal
	 */
	public InterfaceAdministrarBotones(
		InterfacePrincipal vistaPrincipal 
	){
		this.vistaPrincipal = vistaPrincipal;
		vistaPrincipal.setVisible(false);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 150, 150, 150, 40, 0};
		gbl_panel.rowHeights = new int[]{30, 0, 0, 0, 30, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnCargarTripulantes = new JButton("Cargar Tripulantes");
		GridBagConstraints gbc_btnCargarTripulantes = new GridBagConstraints();
		gbc_btnCargarTripulantes.fill = GridBagConstraints.BOTH;
		gbc_btnCargarTripulantes.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargarTripulantes.gridx = 1;
		gbc_btnCargarTripulantes.gridy = 1;
		panel.add(btnCargarTripulantes, gbc_btnCargarTripulantes);
		
		btnDisponibilidad = new JButton("Disponibilidad del Vuelo");
		GridBagConstraints gbc_btnDisponibilidad = new GridBagConstraints();
		gbc_btnDisponibilidad.fill = GridBagConstraints.BOTH;
		gbc_btnDisponibilidad.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisponibilidad.gridx = 3;
		gbc_btnDisponibilidad.gridy = 1;
		panel.add(btnDisponibilidad, gbc_btnDisponibilidad);
		
		btnActivarPuesto = new JButton("Activar Puesto");
		GridBagConstraints gbc_btnActivarPuesto = new GridBagConstraints();
		gbc_btnActivarPuesto.fill = GridBagConstraints.BOTH;
		gbc_btnActivarPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_btnActivarPuesto.gridx = 1;
		gbc_btnActivarPuesto.gridy = 2;
		panel.add(btnActivarPuesto, gbc_btnActivarPuesto);
		
		btnInformeGeneralVuelo = new JButton("Informe General");
		GridBagConstraints gbc_btnInformeGeneralVuelo = new GridBagConstraints();
		gbc_btnInformeGeneralVuelo.fill = GridBagConstraints.BOTH;
		gbc_btnInformeGeneralVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_btnInformeGeneralVuelo.gridx = 2;
		gbc_btnInformeGeneralVuelo.gridy = 2;
		panel.add(btnInformeGeneralVuelo, gbc_btnInformeGeneralVuelo);
		
		btnCantidadMenores = new JButton("Cantidad de Menores");
		GridBagConstraints gbc_btnCantidadMenores = new GridBagConstraints();
		gbc_btnCantidadMenores.fill = GridBagConstraints.BOTH;
		gbc_btnCantidadMenores.insets = new Insets(0, 0, 5, 5);
		gbc_btnCantidadMenores.gridx = 3;
		gbc_btnCantidadMenores.gridy = 2;
		panel.add(btnCantidadMenores, gbc_btnCantidadMenores);
		
		btnDesactivarPuesto = new JButton("Inactivar Puesto");
		GridBagConstraints gbc_btnDesactivarPuesto = new GridBagConstraints();
		gbc_btnDesactivarPuesto.fill = GridBagConstraints.BOTH;
		gbc_btnDesactivarPuesto.insets = new Insets(0, 0, 5, 5);
		gbc_btnDesactivarPuesto.gridx = 1;
		gbc_btnDesactivarPuesto.gridy = 3;
		panel.add(btnDesactivarPuesto, gbc_btnDesactivarPuesto);
		
		btnTotalizarVuelo = new JButton("Totalizar Vuelo");
		GridBagConstraints gbc_btnTotalizarVuelo = new GridBagConstraints();
		gbc_btnTotalizarVuelo.fill = GridBagConstraints.BOTH;
		gbc_btnTotalizarVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_btnTotalizarVuelo.gridx = 3;
		gbc_btnTotalizarVuelo.gridy = 3;
		panel.add(btnTotalizarVuelo, gbc_btnTotalizarVuelo);
		/**
		 * EVENTOS
		 */
		this.addWindowListener(controlVentana);
		btnCargarTripulantes.addActionListener(controlVentanaEventos);
		btnDisponibilidad.addActionListener(controlVentanaEventos);
		btnActivarPuesto.addActionListener(controlVentanaEventos);
		btnInformeGeneralVuelo.addActionListener(controlVentanaEventos);
		btnCantidadMenores.addActionListener(controlVentanaEventos);
		btnDesactivarPuesto.addActionListener(controlVentanaEventos);
		btnTotalizarVuelo.addActionListener(controlVentanaEventos);
	}

	public InterfacePrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	public void setVistaPrincipal(InterfacePrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}

	public JButton getBtnCargarTripulantes() {
		return btnCargarTripulantes;
	}

	public void setBtnCargarTripulantes(JButton btnCargarTripulantes) {
		this.btnCargarTripulantes = btnCargarTripulantes;
	}

	public JButton getBtnDisponibilidad() {
		return btnDisponibilidad;
	}

	public void setBtnDisponibilidad(JButton btnDisponibilidad) {
		this.btnDisponibilidad = btnDisponibilidad;
	}

	public JButton getBtnActivarPuesto() {
		return btnActivarPuesto;
	}

	public void setBtnActivarPuesto(JButton btnActivarPuesto) {
		this.btnActivarPuesto = btnActivarPuesto;
	}

	public JButton getBtnInformeGeneralVuelo() {
		return btnInformeGeneralVuelo;
	}

	public void setBtnInformeGeneralVuelo(JButton btnInformeGeneralVuelo) {
		this.btnInformeGeneralVuelo = btnInformeGeneralVuelo;
	}

	public JButton getBtnCantidadMenores() {
		return btnCantidadMenores;
	}

	public void setBtnCantidadMenores(JButton btnCantidadMenores) {
		this.btnCantidadMenores = btnCantidadMenores;
	}

	public JButton getBtnDesactivarPuesto() {
		return btnDesactivarPuesto;
	}

	public void setBtnDesactivarPuesto(JButton btnDesactivarPuesto) {
		this.btnDesactivarPuesto = btnDesactivarPuesto;
	}

	public JButton getBtnTotalizarVuelo() {
		return btnTotalizarVuelo;
	}

	public void setBtnTotalizarVuelo(JButton btnTotalizarVuelo) {
		this.btnTotalizarVuelo = btnTotalizarVuelo;
	}
		
}
