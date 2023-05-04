package app.jacm.sjft.interfaces;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class InterfacePrincipalVuelo extends JFrame{
	private JLabel lblFechaActualSistema;
	private JButton btnGestionarMiViaje;
	private JButton btnAdministrar;
	private JComboBox cbFechaSalidaVuelo, cbHoraSalidaVuelo;
	private JSpinner sCantidadPasajeroVuelo;
	private JButton btnBuscarPuestoVuelo;
	
	public InterfacePrincipalVuelo() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {40, 580, 100, 100, 40, 0};
		gbl_panel.rowHeights = new int[] {30, 40, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblFechaActualSistema = new JLabel("Jueves, 04 de mayo del 2023");
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
		gbl_panel_1.columnWidths = new int[]{40, 195, 195, 195, 195, 40, 0};
		gbl_panel_1.rowHeights = new int[]{0, 30, 40, 30, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		
		String[] valoresFechaSalida = {"Seleccionar...", "Prueba #1", "Prueba #2", "Prueba #2"};
		cbFechaSalidaVuelo = new JComboBox(valoresFechaSalida);
		GridBagConstraints gbc_cbFechaSalidaVuelo = new GridBagConstraints();
		gbc_cbFechaSalidaVuelo.insets = new Insets(0, 0, 5, 5);
		gbc_cbFechaSalidaVuelo.fill = GridBagConstraints.BOTH;
		gbc_cbFechaSalidaVuelo.gridx = 1;
		gbc_cbFechaSalidaVuelo.gridy = 2;
		panel_1.add(cbFechaSalidaVuelo, gbc_cbFechaSalidaVuelo);
		
		String[] valoresHoraSalida = {"Seleccionar...", "Prueba #1", "Prueba #2", "Prueba #2"};
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

	}

}
