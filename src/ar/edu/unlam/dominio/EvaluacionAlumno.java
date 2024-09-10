package ar.edu.unlam.dominio;

public class EvaluacionAlumno {
	private int idEvaluacion;
	private int idAlumno;
	private Profesor profesorQueCorrigio;
	private double nota;
	
	public EvaluacionAlumno(int idEvaluacion, int idAlumno, Profesor profesorQueCorrigio, double nota) {
		this.idEvaluacion = idEvaluacion;
		this.idAlumno = idAlumno;
		this.profesorQueCorrigio = profesorQueCorrigio;
		this.nota = nota;
	}

	public int getIdEvaluacion() {
		return idEvaluacion;
	}

	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Profesor getProfesorQueCorrigio() {
		return profesorQueCorrigio;
	}

	public void setProfesorQueCorrigio(Profesor profesorQueCorrigio) {
		this.profesorQueCorrigio = profesorQueCorrigio;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
		
	
}
