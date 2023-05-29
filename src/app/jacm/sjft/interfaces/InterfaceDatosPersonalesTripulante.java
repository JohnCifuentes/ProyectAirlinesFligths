package app.jacm.sjft.interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import app.jacm.sjft.controllers.InterfaceDatosPersonalesTripulanteControlAL;
import app.jacm.sjft.controllers.InterfaceDatosPersonalesTripulanteControlWL;
import app.jacm.sjft.modells.Tripulante;

import java.util.ArrayList;

public class InterfaceDatosPersonalesTripulante extends JFrame{
	private InterfaceAdministrarBotones vAdministrarBotones;
	private int numeroVuelo;
	private ArrayList<Tripulante> tripulantes = new ArrayList<Tripulante>();
	private int numeroTripulantes = 1;
	private final int numeroTripulantesMaximo = 5;
	/**
	 * 
	 */
	private JTextField textNombreCompleto;
	private JTextField textFechaNacimiento;
	private JTextField textNumeroIdentificacion;
	private JTextField textNumeroTelefono;
	private JTextField textDireccionResidencia;
	private JButton btnAgregar;
	private JLabel lblContadorTripulantes;
	/**
	 * 
	 */
	private InterfaceDatosPersonalesTripulanteControlAL controlVentanaEventos = new InterfaceDatosPersonalesTripulanteControlAL(this);
	private InterfaceDatosPersonalesTripulanteControlWL controlVentana = new InterfaceDatosPersonalesTripulanteControlWL(this);
	/**
	 * 
	 * @param vAdministrarBotones
	 * @param numeroVuelo
	 */
	public InterfaceDatosPersonalesTripulante(InterfaceAdministrarBotones vAdministrarBotones, int numeroVuelo) {
		this.vAdministrarBotones = vAdministrarBotones; 
		this.numeroVuelo = numeroVuelo;
		this.vAdministrarBotones.setVisible(false);
		
		JPanel panelDatos = new JPanel();
		getContentPane().add(panelDatos, BorderLayout.CENTER);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[]{40, 0, 0, 0, 40, 0};
		gbl_panelDatos.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDatos.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDatos.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelDatos.setLayout(gbl_panelDatos);
		
		JLabel lblNewLabel = new JLabel("Nombre Completo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panelDatos.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Nacimiento");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		panelDatos.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textNombreCompleto = new JTextField();
		GridBagConstraints gbc_textNombreCompleto = new GridBagConstraints();
		gbc_textNombreCompleto.insets = new Insets(0, 0, 5, 5);
		gbc_textNombreCompleto.fill = GridBagConstraints.BOTH;
		gbc_textNombreCompleto.gridx = 1;
		gbc_textNombreCompleto.gridy = 2;
		panelDatos.add(textNombreCompleto, gbc_textNombreCompleto);
		textNombreCompleto.setColumns(10);
		
		textFechaNacimiento = new JTextField();
		GridBagConstraints gbc_textFechaNacimiento = new GridBagConstraints();
		gbc_textFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_textFechaNacimiento.fill = GridBagConstraints.BOTH;
		gbc_textFechaNacimiento.gridx = 3;
		gbc_textFechaNacimiento.gridy = 2;
		panelDatos.add(textFechaNacimiento, gbc_textFechaNacimiento);
		textFechaNacimiento.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Numero de Identificación");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 3;
		panelDatos.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero de Teléfono");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 3;
		panelDatos.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		textNumeroIdentificacion = new JTextField();
		GridBagConstraints gbc_textNumeroIdentificacion = new GridBagConstraints();
		gbc_textNumeroIdentificacion.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroIdentificacion.fill = GridBagConstraints.BOTH;
		gbc_textNumeroIdentificacion.gridx = 1;
		gbc_textNumeroIdentificacion.gridy = 4;
		panelDatos.add(textNumeroIdentificacion, gbc_textNumeroIdentificacion);
		textNumeroIdentificacion.setColumns(10);
		
		textNumeroTelefono = new JTextField();
		GridBagConstraints gbc_textNumeroTelefono = new GridBagConstraints();
		gbc_textNumeroTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroTelefono.fill = GridBagConstraints.BOTH;
		gbc_textNumeroTelefono.gridx = 3;
		gbc_textNumeroTelefono.gridy = 4;
		panelDatos.add(textNumeroTelefono, gbc_textNumeroTelefono);
		textNumeroTelefono.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Dirección de Residencia");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 5;
		panelDatos.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		textDireccionResidencia = new JTextField();
		GridBagConstraints gbc_textDireccionResidencia = new GridBagConstraints();
		gbc_textDireccionResidencia.gridwidth = 3;
		gbc_textDireccionResidencia.insets = new Insets(0, 0, 0, 5);
		gbc_textDireccionResidencia.fill = GridBagConstraints.BOTH;
		gbc_textDireccionResidencia.gridx = 1;
		gbc_textDireccionResidencia.gridy = 6;
		panelDatos.add(textDireccionResidencia, gbc_textDireccionResidencia);
		textDireccionResidencia.setColumns(10);

		JPanel panelAgregar = new JPanel();
		getContentPane().add(panelAgregar, BorderLayout.SOUTH);
		GridBagLayout gbl_panelAgregar = new GridBagLayout();
		gbl_panelAgregar.columnWidths = new int[]{40, 0, 40, 0};
		gbl_panelAgregar.rowHeights = new int[]{0, 30, 0, 0, 30, 0};
		gbl_panelAgregar.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelAgregar.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelAgregar.setLayout(gbl_panelAgregar);
		
		btnAgregar = new JButton("Agregar");
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 2;
		panelAgregar.add(btnAgregar, gbc_btnAgregar);
		
		lblContadorTripulantes = new JLabel("Tripulante " + this.numeroTripulantes + " de " + this.numeroTripulantesMaximo);
		GridBagConstraints gbc_lblContadorTripulantes = new GridBagConstraints();
		gbc_lblContadorTripulantes.anchor = GridBagConstraints.EAST;
		gbc_lblContadorTripulantes.insets = new Insets(0, 0, 5, 5);
		gbc_lblContadorTripulantes.gridx = 1;
		gbc_lblContadorTripulantes.gridy = 3;
		panelAgregar.add(lblContadorTripulantes, gbc_lblContadorTripulantes);
		
		this.addWindowListener(controlVentana);
		btnAgregar.addActionListener(controlVentanaEventos);
	}
	
	public InterfaceAdministrarBotones getvAdministrarBotones() {
		return vAdministrarBotones;
	}
	
	public void setvAdministrarBotones(InterfaceAdministrarBotones vAdministrarBotones) {
		this.vAdministrarBotones = vAdministrarBotones;
	}
	
	public int getNumeroVuelo() {
		return numeroVuelo;
	}
	
	public void setNumeroVuelo(int numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}
	
	public ArrayList<Tripulante> getTripulantes() {
		return tripulantes;
	}
	
	public void setTripulantes(ArrayList<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}
	
	public int getNumeroTripulantes() {
		return numeroTripulantes;
	}
	
	public void setNumeroTripulantes(int numeroTripulantes) {
		this.numeroTripulantes = numeroTripulantes;
	}
	
	public JTextField getTextNombreCompleto() {
		return textNombreCompleto;
	}
	
	public void setTextNombreCompleto(JTextField textNombreCompleto) {
		this.textNombreCompleto = textNombreCompleto;
	}
	
	public JTextField getTextFechaNacimiento() {
		return textFechaNacimiento;
	}
	
	public void setTextFechaNacimiento(JTextField textFechaNacimiento) {
		this.textFechaNacimiento = textFechaNacimiento;
	}
	
	public JTextField getTextNumeroIdentificacion() {
		return textNumeroIdentificacion;
	}
	
	public void setTextNumeroIdentificacion(JTextField textNumeroIdentificacion) {
		this.textNumeroIdentificacion = textNumeroIdentificacion;
	}
	
	public JTextField getTextNumeroTelefono() {
		return textNumeroTelefono;
	}
	
	public void setTextNumeroTelefono(JTextField textNumeroTelefono) {
		this.textNumeroTelefono = textNumeroTelefono;
	}
	
	public JTextField getTextDireccionResidencia() {
		return textDireccionResidencia;
	}
	
	public void setTextDireccionResidencia(JTextField textDireccionResidencia) {
		this.textDireccionResidencia = textDireccionResidencia;
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}
	
	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
	
	public JLabel getLblContadorTripulantes() {
		return lblContadorTripulantes;
	}
	
	public void setLblContadorTripulantes(JLabel lblContadorTripulantes) {
		this.lblContadorTripulantes = lblContadorTripulantes;
	}
	
	public InterfaceDatosPersonalesTripulanteControlAL getControlVentanaEventos() {
		return controlVentanaEventos;
	}
	
	public void setControlVentanaEventos(InterfaceDatosPersonalesTripulanteControlAL controlVentanaEventos) {
		this.controlVentanaEventos = controlVentanaEventos;
	}
	
	public InterfaceDatosPersonalesTripulanteControlWL getControlVentana() {
		return controlVentana;
	}
	
	public void setControlVentana(InterfaceDatosPersonalesTripulanteControlWL controlVentana) {
		this.controlVentana = controlVentana;
	}
	
	public int getNumeroTripulantesMaximo() {
		return numeroTripulantesMaximo;
	}
	
	public void addTripulante(Tripulante tripulante) {
		this.tripulantes.add(tripulante);
	}
}