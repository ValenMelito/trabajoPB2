package ar.edu.unlam.dominio;

public class Materias {
	private int idMateria;
	private String nombreMateria;
	private Profesor profesor;
	
	public Materias(int idMateria, String nombreMateria, Profesor profesores) {
		this.idMateria = idMateria;
		this.nombreMateria = nombreMateria;
		this.profesor = profesores;
	}
	
	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesores) {
		this.profesor = profesores;
	}
	
	
}
