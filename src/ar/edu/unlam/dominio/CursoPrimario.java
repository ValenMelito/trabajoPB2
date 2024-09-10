package ar.edu.unlam.dominio;

public class CursoPrimario {
	private int grado;
	private Profesor profesor;
	private Alumno[] alumnos = new Alumno[20];
	
	public CursoPrimario(int grado) {
		this.grado = grado;
		/*this.profesores = profesores;
		this.alumnos = alumnos;*/
	}

	public int getGrado() {
		return grado;
	}

	public void setGrado(int grado) {
		this.grado = grado;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesores) {
		this.profesor = profesores;
	}

	public Alumno[] getAlumnos(){
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}	
	
	
}
