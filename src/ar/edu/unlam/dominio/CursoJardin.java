package ar.edu.unlam.dominio;

import java.util.Arrays;

public class CursoJardin {
	private SalaJardin salaJardin;
	private Profesor[] profesores = new Profesor[2];
	private Alumno[] alumnos = new Alumno[20];
	
	
	public CursoJardin(SalaJardin salaJardin) {
		this.salaJardin = salaJardin;
		/*this.profesores = profesores;
		this.alumnos = alumnos;*/
	}


	public SalaJardin getSalaJardin() {
		return salaJardin;
	}


	public void setSalaJardin(SalaJardin salaJardin) {
		this.salaJardin = salaJardin;
	}


	public Profesor[] getProfesores() {
		return profesores;
	}


	public void setProfesores(Profesor[] profesores) {
		this.profesores = profesores;
	}


	public Alumno[] getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}


	@Override
	public String toString() {
		return "CursoJardin [salaJardin=" + salaJardin + ", profesores=" + Arrays.toString(profesores) + ", alumnos="
				+ Arrays.toString(alumnos) + "]";
	}
	
	
}
