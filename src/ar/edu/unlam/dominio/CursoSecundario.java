package ar.edu.unlam.dominio;

public class CursoSecundario {
	private int anio;
	private Materias[] materias;
	private Alumno[] alumnos = new Alumno[20];
	
	public CursoSecundario(int anio) {
		this.anio = anio;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public Materias[] getMaterias() {
		return materias;
	}

	public void setMaterias(Materias[] materias) {
		this.materias = materias;
	}
	
	
	
}
