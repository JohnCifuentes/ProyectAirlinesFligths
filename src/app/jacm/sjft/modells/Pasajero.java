package app.jacm.sjft.modells;

public class Pasajero {
	private String nombreCompleto;
	private int numeroIdentificacion;
	private String direccion;
	private int numeroContacto;
	private String fechaNacimiento;
	private ContactoEmergencia contactoEmergencia;
	
	public Pasajero() {}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public int getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	public void setNumeroIdentificacion(int numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNumeroContacto() {
		return numeroContacto;
	}

	public void setNumeroContacto(int numeroContacto) {
		this.numeroContacto = numeroContacto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public ContactoEmergencia getContactoEmergencia() {
		return contactoEmergencia;
	}

	public void setContactoEmergencia(ContactoEmergencia contactoEmergencia) {
		this.contactoEmergencia = contactoEmergencia;
	}
}
