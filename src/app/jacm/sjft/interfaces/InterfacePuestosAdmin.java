package app.jacm.sjft.interfaces;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.jacm.sjft.modells.Puesto;
import app.jacm.sjft.modells.Tripulante;
import app.jacm.sjft.tools.Herramientas;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfacePuestosAdmin extends JFrame{
	private InterfaceAdministrarBotones vAdministrarBotones;
	private JLabel lblCopiloto;
	private JLabel lblAsistente3;
	private JLabel lblAsistente2;
	private JLabel lblPiloto;
	private JLabel lblAsistente1;
	/**
	 * 
	 */
	private Herramientas herramienta = new Herramientas();
	
	public InterfacePuestosAdmin(InterfaceAdministrarBotones vAdministrarBotones, int numeroVuelo) {
		this.vAdministrarBotones = vAdministrarBotones;
		ArrayList<Tripulante> tripulantes = this.vAdministrarBotones.getVistaPrincipal().getTripulantes().get(numeroVuelo);
		ArrayList<Puesto> puestos = this.vAdministrarBotones.getVistaPrincipal().getPuestos().get(numeroVuelo);	

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 0, 0, 40, 0};
		gbl_panel.rowHeights = new int[]{30, 0, 30, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 9.0, 0.0, Double.MIN_VALUE};
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
		
		lblCopiloto = new JLabel();
		lblCopiloto.setText(tripulantes.get(0).getNombreCompleto());
		GridBagConstraints gbc_lblCopiloto = new GridBagConstraints();
		gbc_lblCopiloto.insets = new Insets(0, 0, 5, 5);
		gbc_lblCopiloto.gridx = 0;
		gbc_lblCopiloto.gridy = 2;
		panelTripulante.add(lblCopiloto, gbc_lblCopiloto);
		
		lblPiloto = new JLabel();
		lblPiloto.setText(tripulantes.get(1).getNombreCompleto());
		GridBagConstraints gbc_lblPiloto = new GridBagConstraints();
		gbc_lblPiloto.insets = new Insets(0, 0, 5, 5);
		gbc_lblPiloto.gridx = 0;
		gbc_lblPiloto.gridy = 4;
		panelTripulante.add(lblPiloto, gbc_lblPiloto);

		lblAsistente1 = new JLabel();
		lblAsistente1.setText(tripulantes.get(2).getNombreCompleto());
		GridBagConstraints gbc_lblAsistente1 = new GridBagConstraints();
		gbc_lblAsistente1.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsistente1.gridx = 1;
		gbc_lblAsistente1.gridy = 1;
		panelTripulante.add(lblAsistente1, gbc_lblAsistente1);
		
		lblAsistente2 = new JLabel();
		lblAsistente2.setText(tripulantes.get(3).getNombreCompleto());
		GridBagConstraints gbc_lblAsistente2 = new GridBagConstraints();
		gbc_lblAsistente2.insets = new Insets(0, 0, 5, 0);
		gbc_lblAsistente2.gridx = 1;
		gbc_lblAsistente2.gridy = 3;
		panelTripulante.add(lblAsistente2, gbc_lblAsistente2);
		
		lblAsistente3 = new JLabel();
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
		//gbl_panelPuestos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPuestos.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelPuestos.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		//gbl_panelPuestos.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		gbl_panelPuestos.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		panelPuestos.setLayout(gbl_panelPuestos);
		
		JButton[] btnPuestos = herramienta.btnPuestos(puestos);
		GridBagConstraints[] gbc_btnPuestos = herramienta.gbc_btnPuestos(puestos);
		for(int i = 0; i < btnPuestos.length; i++) {
			panelPuestos.add(btnPuestos[i], gbc_btnPuestos[i]);
		}

		for(int i = 0; i < 10; i++) {
			JLabel lblNewLabel = new JLabel(Character.toString((char)(i+65)));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = i;
			gbc_lblNewLabel.gridy = 4;
			panelPuestos.add(lblNewLabel, gbc_lblNewLabel);
		}

	}
}
