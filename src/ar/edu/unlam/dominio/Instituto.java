package ar.edu.unlam.dominio;

import java.util.Arrays;

public class Instituto {
	private String nombre;
	private Profesor arrayProfesores[] = new Profesor[50];
	private Alumno arrayAlumnos[] = new Alumno[100];
	private Jardin jardin = new Jardin("San Bonifacio -Jardin");
	private Primario primario = new Primario("San Bonifacio -Primario");
	private Secundario secundario = new Secundario("San Bonifacio -Secundario");
	private Asistencia[] historialAsistenciaAlumnos = new Asistencia[100];
	private Evaluacion[] evaluaciones = new Evaluacion[50];
	private EvaluacionAlumno[] historialEvaluacionAlumnos = new EvaluacionAlumno[100];
	
	public Instituto(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor[] getArrayProfesores() {
		return arrayProfesores;
	}

	public void setArrayProfesores(Profesor[] arrayProfesores) {
		this.arrayProfesores = arrayProfesores;
	}

	public Alumno[] getArrayAlumnos() {
		return arrayAlumnos;
	}

	public void setArrayAlumnos(Alumno[] arrayAlumnos) {
		this.arrayAlumnos = arrayAlumnos;
	}

	public Jardin getJardin() {
		return jardin;
	}

	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}

	public Primario getPrimario() {
		return primario;
	}

	public void setPrimario(Primario primario) {
		this.primario = primario;
	}

	public Secundario getSecundario() {
		return secundario;
	}

	public void setSecundario(Secundario secundario) {
		this.secundario = secundario;
	}

	public Asistencia[] getHistorialAsistenciaAlumnos() {
		return historialAsistenciaAlumnos;
	}

	public void setHistorialAsistenciaAlumnos(Asistencia[] historialAsistenciaAlumnos) {
		this.historialAsistenciaAlumnos = historialAsistenciaAlumnos;
	}

	public Evaluacion[] getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(Evaluacion[] evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public EvaluacionAlumno[] getHistorialEvaluacionAlumnos() {
		return historialEvaluacionAlumnos;
	}

	public void setHistorialEvaluacionAlumnos(EvaluacionAlumno[] historialEvaluacionAlumnos) {
		this.historialEvaluacionAlumnos = historialEvaluacionAlumnos;
	}

	@Override
	public String toString() {
		return "Instituto [nombre=" + nombre + ", arrayProfesores=" + Arrays.toString(arrayProfesores)
				+ ", arrayAlumnos=" + Arrays.toString(arrayAlumnos) + ", jardin=" + jardin + ", primario=" + primario
				+ ", secundario=" + secundario + ", historialAsistenciaAlumnos="
				+ Arrays.toString(historialAsistenciaAlumnos) + ", historialEvaluacionAlumnos="
				+ Arrays.toString(historialEvaluacionAlumnos) + "]";
	}
	
	
}
