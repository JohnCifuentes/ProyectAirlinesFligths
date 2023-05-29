package app.jacm.sjft.interfaces;

import javax.swing.JFrame;

import app.jacm.sjft.controllers.InterfaceDatosVueloControlAL;
import app.jacm.sjft.controllers.InterfaceDatosVueloControlWL;
import app.jacm.sjft.modells.OrdenCompra;
import app.jacm.sjft.modells.Tiquete;
import app.jacm.sjft.tools.Herramientas;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class InterfaceDatosVuelo extends JFrame{
	private InterfacePrincipal vPrincipal;
	private OrdenCompra ordenCompra;
	private Tiquete tiquete;
	private Herramientas herramienta = new Herramientas();
	private JButton btnAnularTiquete;
	private JButton btnOK;
	//
	InterfaceDatosVueloControlAL controlVentanaEventos = new InterfaceDatosVueloControlAL(this);
	InterfaceDatosVueloControlWL controlVentana = new InterfaceDatosVueloControlWL(this);
	
	
	public InterfaceDatosVuelo(InterfacePrincipal vPrincipal, OrdenCompra ordenCompra, Tiquete tiquete) {
		this.vPrincipal = vPrincipal;
		this.ordenCompra = ordenCompra;
		this.tiquete = tiquete;
		this.vPrincipal.setVisible(false);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 0, 40, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		String informacionVuelo = this.herramienta.detallesVuelo(this.ordenCompra.getNumeroVuelo() + 1, this.vPrincipal.getFechaHora()) + " " + this.tiquete.getSilla().getConsecutivoBoleto();
		JLabel lblNewLabel = new JLabel(informacionVuelo);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		String datosPasajero = this.tiquete.getPasajero().getNombreCompleto() + " " + this.tiquete.getPasajero().getNumeroContacto();
		JLabel lblNewLabel_1 = new JLabel(datosPasajero);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 4;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 0, 0, 0, 40, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 10.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnAnularTiquete = new JButton("Cancelar Tiquete");
		GridBagConstraints gbc_btnAnularTiquete = new GridBagConstraints();
		gbc_btnAnularTiquete.fill = GridBagConstraints.BOTH;
		gbc_btnAnularTiquete.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnularTiquete.gridx = 1;
		gbc_btnAnularTiquete.gridy = 0;
		panel.add(btnAnularTiquete, gbc_btnAnularTiquete);
		
		btnOK = new JButton("OK");
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.fill = GridBagConstraints.BOTH;
		gbc_btnOK.insets = new Insets(0, 0, 0, 5);
		gbc_btnOK.gridx = 3;
		gbc_btnOK.gridy = 0;
		panel.add(btnOK, gbc_btnOK);
		
		this.addWindowListener(controlVentana);
		this.btnAnularTiquete.addActionListener(controlVentanaEventos);
		this.btnOK.addActionListener(controlVentanaEventos);
	}

	public InterfacePrincipal getvPrincipal() {
		return vPrincipal;
	}

	public void setvPrincipal(InterfacePrincipal vPrincipal) {
		this.vPrincipal = vPrincipal;
	}

	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}

	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}

	public Tiquete getTiquete() {
		return tiquete;
	}

	public void setTiquete(Tiquete tiquete) {
		this.tiquete = tiquete;
	}

	public Herramientas getHerramienta() {
		return herramienta;
	}

	public void setHerramienta(Herramientas herramienta) {
		this.herramienta = herramienta;
	}

	public JButton getBtnAnularTiquete() {
		return btnAnularTiquete;
	}

	public void setBtnAnularTiquete(JButton btnAnularTiquete) {
		this.btnAnularTiquete = btnAnularTiquete;
	}

	public JButton getBtnOK() {
		return btnOK;
	}

	public void setBtnOK(JButton btnOK) {
		this.btnOK = btnOK;
	}
}
