package app.jacm.sjft.modells;

public class Tiquete {
	private Silla silla;
	private Pasajero pasajero;
	
	public Tiquete() {}

	public Silla getSilla() {
		return silla;
	}

	public void setSilla(Silla silla) {
		this.silla = silla;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	};
}
