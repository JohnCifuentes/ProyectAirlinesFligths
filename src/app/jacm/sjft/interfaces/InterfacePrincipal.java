package app.jacm.sjft.interfaces;

import app.jacm.sjft.controllers.InterfacePrincipalControlAL;
import app.jacm.sjft.modells.*;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class InterfacePrincipal extends JFrame{
	private ArrayList<OrdenCompra> ordenesCompra;
	private String[][] fechaHora = new String[3][4];
	private ArrayList<ArrayList<Tripulante>> tripulantes;
	private ArrayList<ArrayList<Puesto>> puestos;
	/**
	 * 
	 */
	private JLabel lblFechaActualSistema;
	private JButton btnGestionarMiViaje;
	private JButton btnAdministrar;
	private JComboBox cbFechaSalidaVuelo, cbHoraSalidaVuelo;
	private JSpinner sCantidadPasajeroVuelo;
	private JButton btnBuscarPuestoVuelo;
	/**
	 * 
	 */
	private InterfacePrincipalControlAL controlVentanaEventos = new InterfacePrincipalControlAL(this);
	/**
	 * @param ordenesCompra
	 * @param tripulantes
	 * @param puestos
	 */
	public InterfacePrincipal(
			ArrayList<OrdenCompra> ordenesCompra, 
			String[][] fechaHora,
			ArrayList<ArrayList<Tripulante>> tripulantes, 
			ArrayList<ArrayList<Puesto>> puestos
	) {
		this.ordenesCompra = ordenesCompra;
		this.fechaHora = fechaHora;
		this.tripulantes = tripulantes;
		this.puestos = puestos;
		/**
		 * 
		 */
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {40, 0, 0, 0, 40, 0};
		gbl_panel.rowHeights = new int[] {30, 40, 0};
		gbl_panel.columnWeights = new double[]{0.0, 5.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblFechaActualSistema = new JLabel(this.fechaHora[0][0]);
		GridBagConstraints gbc_lblFechaActualSistema = new GridBagConstraints();
		gbc_lblFechaActualSistema.fill = GridBagConstraints.BOTH;
		gbc_lblFechaActualSistema.insets = new Insets(0, 0, 0, 5);
		gbc_lblFechaActualSistema.gridx = 1;
		gbc_lblFechaActualSistema.gridy = 1;
		panel.add(lblFechaActualSistema, gbc_lblFechaActualSistema);
		
		btnGestionarMiViaje = new JButton("Mis Viajes");
		GridBagConstraints gbc_btnGestionarMiViaje = new GridBagConstraints();
		gbc_btnGestionarMiViaje.fill = GridBagConstraints.BOTH;
		gbc_btnGestionarMiViaje.insets = new Insets(0, 0, 0, 5);
		gbc_btnGestionarMiViaje.gridx = 2;
		gbc_btnGestionarMiViaje.gridy = 1;
		panel.add(btnGestionarMiViaje, gbc_btnGestionarMiViaje);
		
		btnAdministrar = new JButton("Administrar");
		GridBagConstraints gbc_btnAdministrar = new GridBagConstraints();
		gbc_btnAdministrar.fill = GridBagConstraints.BOTH;
		gbc_btnAdministrar.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdministrar.gridx = 3;
		gbc_btnAdministrar.gridy = 1;
		panel.add(btnAdministrar, gbc_btnAdministrar);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{40, 0, 0, 0, 0, 40, 0};
		gbl_panel_1.rowHeights = new int[]{30, 30, 40, 30, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 3.0, 3.0, 2.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de Salida");
		lblNewLabel_1.setVerticalAlignment(SwingConstants.BOTTOM);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Hora de Salida");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cantidad de Pasajeros");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 1;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		String[] valoresFechaSalida = new String[4];
		String[] valoresFechaSalidaPrueba = {
			"Seleccionar...",
			this.fechaHora[0][0],
			this.fechaHora[1][0],
			this.fechaHora[2][0]
		};
		
		cbFechaSalidaVuelo = new JComboBox(valoresFechaSalidaPrueba);
		GridBagConstraints gbc_cbFechaSalidaVuelo = new GridBagConstraints();
		gbc_cbFechaSalidaVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_cbFechaSalidaVuelo.fill = GridBagConstraints.BOTH;
		gbc_cbFechaSalidaVuelo.gridx = 1;
		gbc_cbFechaSalidaVuelo.gridy = 2;
		panel_1.add(cbFechaSalidaVuelo, gbc_cbFechaSalidaVuelo);
		
		String[] valoresHoraSalida = {
			"Seleccionar...", 
			this.fechaHora[0][1], 
			this.fechaHora[0][2], 
			this.fechaHora[0][3]
		};
		cbHoraSalidaVuelo = new JComboBox(valoresHoraSalida);
		GridBagConstraints gbc_cbHoraSalidaVuelo = new GridBagConstraints();
		gbc_cbHoraSalidaVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_cbHoraSalidaVuelo.fill = GridBagConstraints.BOTH;
		gbc_cbHoraSalidaVuelo.gridx = 2;
		gbc_cbHoraSalidaVuelo.gridy = 2;
		panel_1.add(cbHoraSalidaVuelo, gbc_cbHoraSalidaVuelo);
		
		sCantidadPasajeroVuelo = new JSpinner();
		GridBagConstraints gbc_sCantidadPasajeroVuelo = new GridBagConstraints();
		gbc_sCantidadPasajeroVuelo.fill = GridBagConstraints.BOTH;
		gbc_sCantidadPasajeroVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_sCantidadPasajeroVuelo.gridx = 3;
		gbc_sCantidadPasajeroVuelo.gridy = 2;
		panel_1.add(sCantidadPasajeroVuelo, gbc_sCantidadPasajeroVuelo);
		
		btnBuscarPuestoVuelo = new JButton("Buscar Puestos");
		GridBagConstraints gbc_btnBuscarPuestoVuelo = new GridBagConstraints();
		gbc_btnBuscarPuestoVuelo.fill = GridBagConstraints.BOTH;
		gbc_btnBuscarPuestoVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_btnBuscarPuestoVuelo.gridx = 4;
		gbc_btnBuscarPuestoVuelo.gridy = 2;
		panel_1.add(btnBuscarPuestoVuelo, gbc_btnBuscarPuestoVuelo);
		
		/**
		 * EVENTOS
		 * */
		this.btnGestionarMiViaje.addActionListener(controlVentanaEventos);
		this.btnAdministrar.addActionListener(controlVentanaEventos); 
		this.btnBuscarPuestoVuelo.addActionListener(controlVentanaEventos);
	}
	
	public InterfacePrincipalControlAL getControlVentanaEventos() {
		return controlVentanaEventos;
	}
	
	public void setControlVentanaEventos(InterfacePrincipalControlAL controlVentanaEventos) {
		this.controlVentanaEventos = controlVentanaEventos;
	}
	
	public ArrayList<OrdenCompra> getOrdenesCompra() {
		return ordenesCompra;
	}
	
	public void setOrdenesCompra(ArrayList<OrdenCompra> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}
	
	public String[][] getFechaHora() {
		return fechaHora;
	}
	
	public void setFechaHora(String[][] fechaHora) {
		this.fechaHora = fechaHora;
	}
	
	public ArrayList<ArrayList<Tripulante>> getTripulantes() {
		return tripulantes;
	}
	
	public void setTripulantes(ArrayList<ArrayList<Tripulante>> tripulantes) {
		this.tripulantes = tripulantes;
	}
	
	public ArrayList<ArrayList<Puesto>> getPuestos() {
		return puestos;
	}
	
	public void setPuestos(ArrayList<ArrayList<Puesto>> puestos) {
		this.puestos = puestos;
	}
	
	public JLabel getLblFechaActualSistema() {
		return lblFechaActualSistema;
	}
	
	public void setLblFechaActualSistema(JLabel lblFechaActualSistema) {
		this.lblFechaActualSistema = lblFechaActualSistema;
	}
	
	public JButton getBtnGestionarMiViaje() {
		return btnGestionarMiViaje;
	}
	
	public void setBtnGestionarMiViaje(JButton btnGestionarMiViaje) {
		this.btnGestionarMiViaje = btnGestionarMiViaje;
	}
	
	public JButton getBtnAdministrar() {
		return btnAdministrar;
	}
	
	public void setBtnAdministrar(JButton btnAdministrar) {
		this.btnAdministrar = btnAdministrar;
	}
	
	public JComboBox getCbFechaSalidaVuelo() {
		return cbFechaSalidaVuelo;
	}
	
	public void setCbFechaSalidaVuelo(JComboBox cbFechaSalidaVuelo) {
		this.cbFechaSalidaVuelo = cbFechaSalidaVuelo;
	}
	
	public JComboBox getCbHoraSalidaVuelo() {
		return cbHoraSalidaVuelo;
	}
	
	public void setCbHoraSalidaVuelo(JComboBox cbHoraSalidaVuelo) {
		this.cbHoraSalidaVuelo = cbHoraSalidaVuelo;
	}
	
	public JSpinner getsCantidadPasajeroVuelo() {
		return sCantidadPasajeroVuelo;
	}
	
	public void setsCantidadPasajeroVuelo(JSpinner sCantidadPasajeroVuelo) {
		this.sCantidadPasajeroVuelo = sCantidadPasajeroVuelo;
	}
	
	public JButton getBtnBuscarPuestoVuelo() {
		return btnBuscarPuestoVuelo;
	}
	
	public void setBtnBuscarPuestoVuelo(JButton btnBuscarPuestoVuelo) {
		this.btnBuscarPuestoVuelo = btnBuscarPuestoVuelo;
	}

	public void addTripulantesVuelo(ArrayList<Tripulante> tripulantesVuelo) {
		this.tripulantes.add(tripulantesVuelo);
		
	}
}
