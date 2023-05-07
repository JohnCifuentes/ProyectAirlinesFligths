package app.jacm.sjft.modells;

public class Tiquete {
	private Puesto silla;
	private Pasajero pasajero;
	
	public Tiquete() {}

	public Puesto getSilla() {
		return silla;
	}

	public void setSilla(Puesto silla) {
		this.silla = silla;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	};
}
