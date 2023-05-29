package app.jacm.sjft.interfaces;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import app.jacm.sjft.controllers.InterfacePuestosSeleccionarControlAl;
import app.jacm.sjft.controllers.InterfacePuestosSeleccionarControlWL;
import app.jacm.sjft.modells.Puesto;
import app.jacm.sjft.modells.Tiquete;
import app.jacm.sjft.modells.Tripulante;
import app.jacm.sjft.tools.Herramientas;

public class InterfacePuestosSeleccionar extends JFrame{
	private InterfacePrincipal vistaPrincipal;
	private int numeroVuelo;
	private Herramientas herramienta = new Herramientas();
	//
	private ArrayList<Tripulante> tripulantes = new ArrayList<Tripulante>();
	private ArrayList<Puesto> puestos  = new ArrayList<Puesto>();
	private ArrayList<Tiquete> tiquetes = new ArrayList<Tiquete>();
	//
	private JButton[] btnPuestos;
	private GridBagConstraints[] gbc_btnPuestos;
	private JButton btnConfirmar;
	private JButton btnCancelar;
	//
	private InterfacePuestosSeleccionarControlAl controlVentanaEventos = new InterfacePuestosSeleccionarControlAl(this);
	private InterfacePuestosSeleccionarControlWL controlVentana = new InterfacePuestosSeleccionarControlWL(this);
	//
	public InterfacePuestosSeleccionar(InterfacePrincipal vistaPrincipal, int numeroVuelo) {
		this.vistaPrincipal = vistaPrincipal;
		this.numeroVuelo = numeroVuelo;
		this.vistaPrincipal.setVisible(false);
		
		try {
			tripulantes = this.vistaPrincipal.getTripulantes().get(numeroVuelo);
		} catch(Exception e) {
			tripulantes.add(new Tripulante("Piloto"));
			tripulantes.add(new Tripulante("Copiloto"));
			tripulantes.add(new Tripulante("Asistente 1"));
			tripulantes.add(new Tripulante("Asistente 2"));
			tripulantes.add(new Tripulante("Asistente 3"));
		}
		this.puestos = this.vistaPrincipal.getPuestos().get(numeroVuelo);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 0, 0, 30, 40, 40, 0};
		gbl_panel.rowHeights = new int[]{50, 0, 50, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 9.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panelTripulante = new JPanel();
		GridBagConstraints gbc_panelTripulante = new GridBagConstraints();
		gbc_panelTripulante.insets = new Insets(0, 0, 5, 5);
		gbc_panelTripulante.fill = GridBagConstraints.BOTH;
		gbc_panelTripulante.gridx = 1;
		gbc_panelTripulante.gridy = 1;
		panel.add(panelTripulante, gbc_panelTripulante);
		GridBagLayout gbl_panelTripulante = new GridBagLayout();
		gbl_panelTripulante.columnWidths = new int[]{0, 0, 0};
		gbl_panelTripulante.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 30, 0};
		gbl_panelTripulante.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelTripulante.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelTripulante.setLayout(gbl_panelTripulante);
		
		JLabel lblCopiloto = new JLabel();
		lblCopiloto.setText(tripulantes.get(0).getNombreCompleto());
		GridBagConstraints gbc_lblCopiloto = new GridBagConstraints();
		gbc_lblCopiloto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCopiloto.gridx = 0;
		gbc_lblCopiloto.gridy = 2;
		panelTripulante.add(lblCopiloto, gbc_lblCopiloto);
		
		JLabel lblPiloto = new JLabel();
		lblPiloto.setText(tripulantes.get(1).getNombreCompleto());
		GridBagConstraints gbc_lblPiloto = new GridBagConstraints();
		gbc_lblPiloto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPiloto.gridx = 0;
		gbc_lblPiloto.gridy = 4;
		panelTripulante.add(lblPiloto, gbc_lblPiloto);

		JLabel lblAsistente1 = new JLabel();
		lblAsistente1.setText(tripulantes.get(2).getNombreCompleto());
		GridBagConstraints gbc_lblAsistente1 = new GridBagConstraints();
		gbc_lblAsistente1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsistente1.gridx = 1;
		gbc_lblAsistente1.gridy = 1;
		panelTripulante.add(lblAsistente1, gbc_lblAsistente1);
		
		JLabel lblAsistente2 = new JLabel();
		lblAsistente2.setText(tripulantes.get(3).getNombreCompleto());
		GridBagConstraints gbc_lblAsistente2 = new GridBagConstraints();
		gbc_lblAsistente2.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsistente2.gridx = 1;
		gbc_lblAsistente2.gridy = 3;
		panelTripulante.add(lblAsistente2, gbc_lblAsistente2);
		
		JLabel lblAsistente3 = new JLabel();
		lblAsistente3.setText(tripulantes.get(4).getNombreCompleto());
		GridBagConstraints gbc_lblAsistente3 = new GridBagConstraints();
		gbc_lblAsistente3.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsistente3.gridx = 1;
		gbc_lblAsistente3.gridy = 5;
		panelTripulante.add(lblAsistente3, gbc_lblAsistente3);
		
		JPanel panelPuestos = new JPanel();
		GridBagConstraints gbc_panelPuestos = new GridBagConstraints();
		gbc_panelPuestos.insets = new Insets(0, 0, 5, 5);
		gbc_panelPuestos.fill = GridBagConstraints.BOTH;
		gbc_panelPuestos.gridx = 2;
		gbc_panelPuestos.gridy = 1;
		panel.add(panelPuestos, gbc_panelPuestos);
		GridBagLayout gbl_panelPuestos = new GridBagLayout();
		gbl_panelPuestos.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPuestos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPuestos.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_panelPuestos.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		panelPuestos.setLayout(gbl_panelPuestos);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 1;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 3.0, 3.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		btnConfirmar = new JButton("CONFIRMAR");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnConfirmar.insets = new Insets(0, 0, 5, 0);
		gbc_btnConfirmar.gridx = 0;
		gbc_btnConfirmar.gridy = 1;
		panel_1.add(btnConfirmar, gbc_btnConfirmar);
		
		btnCancelar = new JButton("CANCELAR");
		GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
		gbc_btnCancelar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCancelar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCancelar.gridx = 0;
		gbc_btnCancelar.gridy = 2;
		panel_1.add(btnCancelar, gbc_btnCancelar);
		
		this.btnPuestos = herramienta.btnPuestos(puestos);
		this.gbc_btnPuestos = herramienta.gbc_btnPuestos(puestos);
		for(int i = 0; i < this.btnPuestos.length; i++) {
			panelPuestos.add(this.btnPuestos[i], this.gbc_btnPuestos[i]);
		}

		for(int i = 0; i < 10; i++) {
			JLabel lblNewLabel = new JLabel(Character.toString((char)(i+65)));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = i;
			gbc_lblNewLabel.gridy = 4;
			panelPuestos.add(lblNewLabel, gbc_lblNewLabel);
		}
		/**
		 * EVENTOS 
		 */
		this.addWindowListener(controlVentana);
		for(int i = 0; i < this.btnPuestos.length; i++) {
			this.btnPuestos[i].addActionListener(controlVentanaEventos);
		}
		this.btnConfirmar.addActionListener(controlVentanaEventos);
		this.btnCancelar.addActionListener(controlVentanaEventos);
	}

	public InterfacePrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}

	public void setVistaPrincipal(InterfacePrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
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

	public ArrayList<Puesto> getPuestos() {
		return puestos;
	}

	public void setPuestos(ArrayList<Puesto> puestos) {
		this.puestos = puestos;
	}

	public JButton[] getBtnPuestos() {
		return btnPuestos;
	}

	public void setBtnPuestos(JButton[] btnPuestos) {
		this.btnPuestos = btnPuestos;
	}

	public GridBagConstraints[] getGbc_btnPuestos() {
		return gbc_btnPuestos;
	}

	public void setGbc_btnPuestos(GridBagConstraints[] gbc_btnPuestos) {
		this.gbc_btnPuestos = gbc_btnPuestos;
	}

	public ArrayList<Tiquete> getTiquetes() {
		return tiquetes;
	}

	public void setTiquetes(ArrayList<Tiquete> tiquetes) {
		this.tiquetes = tiquetes;
	}
	
	public void addTiquete(Tiquete tiquete) {
		this.tiquetes.add(tiquete);
	}

	public Herramientas getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramientas herramienta) {
		this.herramienta = herramienta;
	}

	public InterfacePuestosSeleccionarControlAl getControlVentanaEventos() {
		return controlVentanaEventos;
	}

	public void setControlVentanaEventos(InterfacePuestosSeleccionarControlAl controlVentanaEventos) {
		this.controlVentanaEventos = controlVentanaEventos;
	}

	public InterfacePuestosSeleccionarControlWL getControlVentana() {
		return controlVentana;
	}

	public void setControlVentana(InterfacePuestosSeleccionarControlWL controlVentana) {
		this.controlVentana = controlVentana;
	}

	public JButton getBtnConfirmar() {
		return btnConfirmar;
	}

	public void setBtnConfirmar(JButton btnConfirmar) {
		this.btnConfirmar = btnConfirmar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

}