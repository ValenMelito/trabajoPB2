package ar.edu.unlam.dominio;

import java.time.LocalDate;

public class Asistencia {
	
	private int idAlumno;
	private LocalDate diaAsistencia;
	private boolean presente;

	
	public Asistencia(int idAlumno, LocalDate diaAsistencia, boolean presente) {
		this.idAlumno = idAlumno;
		this.diaAsistencia = diaAsistencia;
		this.presente = presente;
	}


	public int getIdAlumno() {
		return idAlumno;
	}


	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}


	public LocalDate getDiaAsistencia() {
		return diaAsistencia;
	}


	public void setDiaAsistencia(LocalDate diaAsistencia) {
		this.diaAsistencia = diaAsistencia;
	}


	public boolean isPresente() {
		return presente;
	}


	public void setPresente(boolean presente) {
		this.presente = presente;
	}
	
	
	
}
