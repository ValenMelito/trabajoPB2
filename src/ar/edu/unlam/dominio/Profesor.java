package ar.edu.unlam.dominio;

public class Profesor {
	private int idProfesor;
	private String nombre;
	private String experienciaEnCargo;
	

	public Profesor(int idProfesor, String nombre, String experienciaEnCargo) {
		this.idProfesor = idProfesor;
		this.nombre = nombre;
		this.experienciaEnCargo = experienciaEnCargo;
	}

	public int getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(int idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExperienciaEnCargo() {
		return experienciaEnCargo;
	}

	public void setExperienciaEnCargo(String experienciaEnCargo) {
		this.experienciaEnCargo = experienciaEnCargo;
	}

	@Override
	public String toString() {
		return "Profesor [idProfesor=" + idProfesor + ", nombre=" + nombre + ", experienciaEnCargo="
				+ experienciaEnCargo + "]";
	}
	
	
	
}
