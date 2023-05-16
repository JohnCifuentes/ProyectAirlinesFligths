package app.jacm.sjft.interfaces;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.border.LineBorder;

import app.jacm.sjft.modells.Puesto;

import java.awt.Color;
import javax.swing.JComboBox;

public class InterfaceDatosPersonalesPasajero extends JFrame{
	private InterfacePuestosSeleccionar vPuestosSeleccionar;
	private Puesto puesto;
	private JTextField textNombreCompleto;
	private JTextField textFechaNacimiento;
	private JTextField textNumeroIdentificacion;
	private JTextField textNumeroTelefono;
	private JTextField textDireccionResidencia;
	private JLabel lblContadorTripulantes;
	private JTextField textNumeroTelefonoContacto;
	private JTextField textNombreCompletoContacto;
	private JComboBox cbParentescoContacto;
	
	
	public InterfaceDatosPersonalesPasajero(InterfacePuestosSeleccionar vPuestosSeleccionar, Puesto puesto){
		this.vPuestosSeleccionar = vPuestosSeleccionar;
		this.puesto = puesto;
		
		JPanel panelDatos = new JPanel();
		getContentPane().add(panelDatos, BorderLayout.CENTER);
		GridBagLayout gbl_panelDatos = new GridBagLayout();
		gbl_panelDatos.columnWidths = new int[]{40, 0, 0, 0, 0, 0, 40, 0};
		gbl_panelDatos.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelDatos.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelDatos.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelDatos.setLayout(gbl_panelDatos);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.gridheight = 6;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 5;
		gbc_panel.gridy = 1;
		panelDatos.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{40, 0, 40, 0};
		gbl_panel.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_5 = new JLabel("Contacto de Emergencia");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 0;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Nombre Completo");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 1;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		textNombreCompletoContacto = new JTextField();
		GridBagConstraints gbc_textNombreCompletoContacto = new GridBagConstraints();
		gbc_textNombreCompletoContacto.insets = new Insets(0, 0, 5, 5);
		gbc_textNombreCompletoContacto.fill = GridBagConstraints.BOTH;
		gbc_textNombreCompletoContacto.gridx = 1;
		gbc_textNombreCompletoContacto.gridy = 2;
		panel.add(textNombreCompletoContacto, gbc_textNombreCompletoContacto);
		textNombreCompletoContacto.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Numero de Teléfono");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 3;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		textNumeroTelefonoContacto = new JTextField();
		GridBagConstraints gbc_textNumeroTelefonoContacto = new GridBagConstraints();
		gbc_textNumeroTelefonoContacto.insets = new Insets(0, 0, 5, 5);
		gbc_textNumeroTelefonoContacto.fill = GridBagConstraints.BOTH;
		gbc_textNumeroTelefonoContacto.gridx = 1;
		gbc_textNumeroTelefonoContacto.gridy = 4;
		panel.add(textNumeroTelefonoContacto, gbc_textNumeroTelefonoContacto);
		textNumeroTelefonoContacto.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Parentesco");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 5;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		String[] parentescos = {
			"Seleccionar...",
			"ABUELO(A)",
			"AMIGO(A)",
			"CUIDADOR(A)",
			"CUÑADO(A)",
			"ESPOSO(A)",
			"HERAMNO(A)",
			"HIJO(A)",
			"MADRE",
			"NIETO(A)",
			"NUERA",
			"OTRO",
			"PADRE",
			"PRIMO(A)",
			"RESPONSABLE",
			"SOBRINO(A)",
			"SUEGRO(A)",
			"TIO(A)",
			"YERNO"
		};
		
		cbParentescoContacto = new JComboBox(parentescos);
		GridBagConstraints gbc_cbParentescoContacto = new GridBagConstraints();
		gbc_cbParentescoContacto.insets = new Insets(0, 0, 5, 5);
		gbc_cbParentescoContacto.fill = GridBagConstraints.BOTH;
		gbc_cbParentescoContacto.gridx = 1;
		gbc_cbParentescoContacto.gridy = 6;
		panel.add(cbParentescoContacto, gbc_cbParentescoContacto);
		
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
		gbl_panelAgregar.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAgregar.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panelAgregar.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panelAgregar.setLayout(gbl_panelAgregar);
		
		JButton btnAgregar = new JButton("Agregar");
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.fill = GridBagConstraints.BOTH;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 1;
		gbc_btnAgregar.gridy = 1;
		panelAgregar.add(btnAgregar, gbc_btnAgregar);
	}

}
