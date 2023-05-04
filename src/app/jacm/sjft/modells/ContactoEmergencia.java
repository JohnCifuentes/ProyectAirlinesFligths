package app.jacm.sjft.modells;

public class ContactoEmergencia {
	private String nombreCompleto;
	private String parentesco;
	private int numeroContaco;
	
	public ContactoEmergencia() {}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public int getNumeroContaco() {
		return numeroContaco;
	}

	public void setNumeroContaco(int numeroContaco) {
		this.numeroContaco = numeroContaco;
	}
}
