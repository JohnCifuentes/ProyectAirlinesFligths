package app.jacm.sjft.interfaces;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.SwingConstants;

import app.jacm.sjft.modells.OrdenCompra;
import app.jacm.sjft.modells.Tiquete;
import app.jacm.sjft.tools.Herramientas;

public class InterfaceInformeGeneral extends JFrame{
	private InterfaceAdministrarBotones vAdminsitrarBotones;
	private int numeroVuelo = 0;
	private Herramientas herramienta = new Herramientas();
	//
	private JTable table_1;
	//
	public InterfaceInformeGeneral(InterfaceAdministrarBotones vAdminsitrarBotones, int numeroVuelo) {
		this.vAdminsitrarBotones = vAdminsitrarBotones;
		this.numeroVuelo = numeroVuelo;
		
		this.setSize(495, 450);
		getContentPane().setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel("Informe general del vuelo " + this.herramienta.detallesVuelo(numeroVuelo+1, this.vAdminsitrarBotones.getVistaPrincipal().getFechaHora()));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
		ArrayList<OrdenCompra> ordenCompraVuelo = new ArrayList<OrdenCompra>();
		int cantidadTiquetes = 0;
		for(OrdenCompra oc: this.vAdminsitrarBotones.getVistaPrincipal().getOrdenesCompra()) {
			if(oc.getNumeroVuelo() == this.numeroVuelo) {
				ordenCompraVuelo.add(oc);
				cantidadTiquetes = cantidadTiquetes + oc.getTiquetes().size();
			}
		}
		
		String[] nombreColumnas = {"Numero Orden Compra", "Nombre Pasajero", "Numero de Identificación", "Numero de Telefono", "Puesto", "Precio"};
		String[][] datosTabla = new String[cantidadTiquetes][nombreColumnas.length];
		
		int numeroFila = 0;
		for(OrdenCompra oc: ordenCompraVuelo) {
			for(Tiquete t: oc.getTiquetes()) {
				datosTabla[numeroFila][0] = String.valueOf(oc.getConsecutivo());
				datosTabla[numeroFila][1] = t.getPasajero().getNombreCompleto();
				datosTabla[numeroFila][2] = String.valueOf(t.getPasajero().getNumeroIdentificacion());
				datosTabla[numeroFila][3] = String.valueOf(t.getPasajero().getNumeroContacto());
				datosTabla[numeroFila][4] = t.getSilla().getConsecutivoBoleto();
				datosTabla[numeroFila][5] = String.valueOf(t.getSilla().getPrecio());
				numeroFila++;
			}
		}

		table_1 = new JTable(datosTabla, nombreColumnas);
		table_1.setPreferredScrollableViewportSize(new Dimension(500, 70)); //Crear un scroll en caso de muchos datos
		table_1.setAutoResizeMode(4); //Cambia el modo de redimensionar las columnas a automatica segun el contenido
		
		JScrollPane scrollPane = new JScrollPane(table_1);
		
		getContentPane().add(scrollPane, BorderLayout.CENTER);
	}
}
