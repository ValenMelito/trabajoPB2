package ar.edu.unlam.dominio;

import java.util.Arrays;

public class Jardin {
	private String nombre;
	private CursoJardin[] cursos = new CursoJardin[4];

	public Jardin(String nombre){
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CursoJardin[] getCursos() {
		return cursos;
	}

	public void setCursos(CursoJardin[] cursos) {
		this.cursos = cursos;
	}
	
	
	public boolean agregarCurso(CursoJardin curso){
		boolean colorSalaRepetido=colorSalaRepetido(curso);
		boolean ingresado=false;
		int posicion=0;
		if(!colorSalaRepetido) {
			while(!ingresado && posicion<cursos.length) {
				if(cursos[posicion]==null){
					cursos[posicion]=curso;
					ingresado=true;
				}
				posicion++;
			}
		}
		
		return ingresado;
	}
	
	public boolean eliminarCurso(SalaJardin colorSala) {
		boolean seEliminoCurso=false;
		CursoJardin cursoBuscado=buscarCursoPorSala(colorSala);
		if(cursoBuscado!=null) {
			for(int i=0; i<cursos.length; i++) {
				if(cursos[i]!=null && cursos[i].getSalaJardin()==(cursoBuscado.getSalaJardin())){//falta repartir a los chicos en las demas aulas
					cursos[i]=null;
					seEliminoCurso=true;
					break;
				}
			}
		}
		return seEliminoCurso;
	}
	
	public boolean agregarProfesorAUnCurso(Profesor profesor,SalaJardin colorSala) {
		boolean ingresado=false;
		boolean experienciaValida=verificarExperienciaProfesor(profesor);
		CursoJardin cursoExistente=buscarCursoPorSala(colorSala);
		if(experienciaValida && cursoExistente!=null /*verificarExperienciaProfesor(profesor)*/){
			
			int vacantesVacias=0;
			for(int i=0; i<cursoExistente.getProfesores().length; i++) {//va a andar mal porque no estamos haciendo referencia al mismo objeto
				if(cursoExistente.getProfesores()[i]==null) {//uno hace referencia a el objeto dentro del array y el otro es una variable identica al objeto pero NO LO ES
					vacantesVacias++;
				}
			}
			
			if(vacantesVacias>0){//si es mayor a 0 significa que encontro un lugar disponible
				for(int i=0; i<cursoExistente.getProfesores().length; i++) {
					if(cursoExistente.getProfesores()[i]==null) {
						cursoExistente.getProfesores()[i]=profesor;
						ingresado=true;
						break;
					}
				}	
			}
		}

		return ingresado;
	}
	
	public boolean eliminarProfesorDeUnCurso(int idProfesor,SalaJardin colorSala){
		boolean eliminado=false;
		CursoJardin cursoExistente=buscarCursoPorSala(colorSala);
		if(cursoExistente!=null) {
			for(int i=0; i<cursoExistente.getProfesores().length; i++) {
				if(cursoExistente.getProfesores()[i].getIdProfesor()==idProfesor){
					cursoExistente.getProfesores()[i]=null;
					eliminado=true;
					break;
				}
			}
		}
		return eliminado;
	}
	
	public boolean verificarExperienciaProfesor(Profesor profesor){
		boolean experienciaSuficiente=false;
		if(profesor.getExperienciaEnCargo().equals("maestrx jardinerx")) {
			experienciaSuficiente=true;
		}
		return experienciaSuficiente;
	}
	
	public boolean colorSalaRepetido(CursoJardin curso) {
		boolean colorSalaRepetido=false;
		for(int i=0; i<cursos.length; i++){
			if(cursos[i]!=null) {
				if(cursos[i].getSalaJardin().equals(curso.getSalaJardin()) ){
					colorSalaRepetido=true;
					break;
				}
			}
			
		}
		return colorSalaRepetido;
	}
	
	public CursoJardin buscarCursoPorSala(SalaJardin sala){
		CursoJardin salaBuscada=null;
		for(int i=0; i<cursos.length; i++) {
			if(cursos[i].getSalaJardin()==sala){
				salaBuscada=cursos[i];
				break;
			}
		}
		
		return salaBuscada;
	}
	
	public boolean agregarAlumnoAUnaSala(Alumno alumno, SalaJardin colorSala) {
		boolean alumnoAgregado=false;
		CursoJardin cursoExistente=buscarCursoPorSala(colorSala);
		int vacantesDisponibles=vacantesAlumnosDisponibles(cursoExistente);
		if(cursoExistente!=null && vacantesDisponibles>=1){
			for(int i=0; i<cursoExistente.getAlumnos().length; i++) {
				if(cursoExistente.getAlumnos()[i]==null){
					cursoExistente.getAlumnos()[i]=alumno;
					alumnoAgregado=true;
					break;
				}
			}
		}
		return alumnoAgregado;
	}
	
	public int vacantesAlumnosDisponibles(CursoJardin curso){
		int vacantesDisponibles=0;
		for(int i=0; i<curso.getAlumnos().length; i++) {
			if(curso.getAlumnos()[i]==null){
				vacantesDisponibles++;
			}
		}
		
		return vacantesDisponibles;
	}
	
	public boolean eliminarAlumnoPorSala(int idAlumno, SalaJardin colorSala){
			boolean alumnoEliminado=false;
			CursoJardin cursoExistente=buscarCursoPorSala(colorSala);
			if(cursoExistente!=null) {
				for(int i=0; i<cursoExistente.getAlumnos().length; i++) {
					if(cursoExistente.getAlumnos()[i].getIdAlumno()==idAlumno) {
						cursoExistente.getAlumnos()[i]=null;
						alumnoEliminado=true;
						break;
					}
				}
			}
			
		return alumnoEliminado;
	}

	@Override
	public String toString() {
		return "Jardin [nombre=" + nombre + ", cursos=" + Arrays.toString(cursos) + "]";
	}
	
	
}


