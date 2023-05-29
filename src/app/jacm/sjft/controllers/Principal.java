 package app.jacm.sjft.controllers;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import app.jacm.sjft.interfaces.InterfacePrincipal;
import app.jacm.sjft.modells.OrdenCompra;
import app.jacm.sjft.modells.Puesto;
import app.jacm.sjft.modells.Tripulante;
import app.jacm.sjft.tools.Herramientas;

public class Principal {
	static ArrayList<OrdenCompra> ordenesCompra = new ArrayList<OrdenCompra>();
	static String[][] fechaHora = new String[3][4];
	static ArrayList<ArrayList<Tripulante>> tripulantes = new ArrayList<ArrayList<Tripulante>>();
	static ArrayList<ArrayList<Puesto>> puestos = new ArrayList<ArrayList<Puesto>>();
	static Herramientas herramienta = new Herramientas();
	/**
	 * main
	 * @param args
	 */
	public static void main(String[] args) {
		puestos = generarPuestos();
		fechaHora = generarFechaHora();
		/**
		 * 
		 */
		InterfacePrincipal vPrincipal = new InterfacePrincipal(ordenesCompra, fechaHora, tripulantes, puestos);
		Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
		vPrincipal.setLocation(pantalla.width/6, pantalla.height/4);
		vPrincipal.setSize(870, 230);
		vPrincipal.setVisible(true);
	}
	/**
	 * Se genera matriz con horas de vuelo por cada fecha.
	 * @return
	 */
	public static String[][] generarFechaHora(){
		String[][] generarFechaHora = new String[3][4];
		LocalDate fechaActual = LocalDate.now();
		for(int i = 0; i < generarFechaHora.length; i++) {
			String fechaVuelo = fechaActual.plusDays(i).format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
			generarFechaHora[i][0] = fechaVuelo;
			generarFechaHora[i][1] = "07:30";
			generarFechaHora[i][2] = "15:30";
			generarFechaHora[i][3] = "23:30";
		}
		return generarFechaHora;
	}
	/**
	 * Se genera una lista de 9 posiciones.
	 * cada posicion representa un vuelo junto con sus puestos.
	 * @return
	 */
	public static ArrayList<ArrayList<Puesto>> generarPuestos(){
		ArrayList<ArrayList<Puesto>> generarPuestos = new ArrayList<ArrayList<Puesto>>();
		int cantidadPuestosVIP = 4, cantidadPuestosGeneral = 6;
		int consecutivoPuesto = 0;
		int disponibilidadPuesto = 0;//ACTIVA-LIBRE
		int tipoPuesto = 0;
		int ubicacionPuesto = 0;
		char letraPuesto;
		int precioPuestoEstandar = 230990, precioPuesto = 0;
		for(int listaPuestosFechaHora = 0; listaPuestosFechaHora < 9; listaPuestosFechaHora++) {
			ArrayList<Puesto> puestosFecha = new ArrayList<Puesto>();
			for(int i = 0; i < 10; i++) {
				letraPuesto = (char) (i+65);
				/**
				 * TipoVuelo: VIP
				 */
				if(i < 2) {
					tipoPuesto = 0;
					for(int j = 0; j < (cantidadPuestosVIP+1); j++) {
						if(j != 2) {
							consecutivoPuesto++;
							/**
							 * UbicacionVuelo: Ventana
							 */
							if(j == 0 | j == cantidadPuestosVIP) {
								ubicacionPuesto = 0;
								precioPuesto = (precioPuestoEstandar*2)+(precioPuestoEstandar*30)/100;
							/**
							 * 
							 * 
							 * UbicacionVuelo: Pasillo
							 */
							} else {
								ubicacionPuesto = 2;
								precioPuesto = (precioPuestoEstandar*2)+(precioPuestoEstandar*20)/100;
							}
							puestosFecha.add(new Puesto(consecutivoPuesto, disponibilidadPuesto, tipoPuesto, ubicacionPuesto, letraPuesto, precioPuesto));
						}
					}
				/**
				 * TipoVuelo: General
				 */
				} else {
					tipoPuesto = 1;
					for(int j = 0; j < (cantidadPuestosGeneral+1); j++) {
						if(j != 3) {
							consecutivoPuesto++;
							/**
							 * UbicacionPuesto: Ventana
							 */
							if(j == 0 | j == cantidadPuestosGeneral) {
								ubicacionPuesto = 0;
								precioPuesto = precioPuestoEstandar + (precioPuestoEstandar*30)/100;
							/**
							 * UbicacionPuesto: Centro
							 */
							} else if(j%2 != 0) {
								ubicacionPuesto = 1;
								precioPuesto = precioPuestoEstandar + (precioPuestoEstandar*20)/100;
							/**
							 * UbicacionPuesto: Pasillo
							 */
							} else if(j%2 == 0){
								ubicacionPuesto = 2;
								precioPuesto = precioPuestoEstandar;
							}
							puestosFecha.add(new Puesto(consecutivoPuesto, disponibilidadPuesto, tipoPuesto, ubicacionPuesto, letraPuesto, precioPuesto));
						}
					}				
				}
			}
			generarPuestos.add(puestosFecha);
			if(consecutivoPuesto == 56) {
				consecutivoPuesto = 0;
			}
		}
		return generarPuestos;
	}
}
