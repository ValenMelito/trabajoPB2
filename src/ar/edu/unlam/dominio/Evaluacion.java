package ar.edu.unlam.dominio;

public class Evaluacion {
	private int idEvaluacion;
	private Profesor profesor;
	private int anio;
	private int idMateria;


	public Evaluacion(int idEvaluacion, Profesor profesor, int grado) {
		this.idEvaluacion = idEvaluacion;
		this.profesor = profesor;
		this.anio = grado;
	}
	
	public Evaluacion(int idEvaluacion, Profesor profesor, int anio, int idMateria) {
		this.idEvaluacion = idEvaluacion;
		this.profesor = profesor;
		this.anio = anio;
		this.idMateria = idMateria;
	}



	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}
	

	
}
