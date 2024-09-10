package ar.edu.unlam.dominio;

public class Primario {
	private String nombre;
	private CursoPrimario[] grados = new CursoPrimario[6];
	
	public Primario(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean agregarAlumno(int grado, Alumno alumno) {
		CursoPrimario curso=buscarGrado(grado);
		boolean seAgrego=false;
		if(curso!=null && (alumno.getEdad()>=6 && alumno.getEdad()<11)) {
			for(int i=0; i<curso.getAlumnos().length; i++) {
				if(curso.getAlumnos()[i]==null) {
					curso.getAlumnos()[i]=alumno;
					seAgrego=true;
					break;
				}
			}
		}
		return seAgrego;
	}
	
	public CursoPrimario buscarGrado(int grado) {
		CursoPrimario cursoBuscado=null;
		for(int i=0; i<grados.length; i++) {
			if(grados[i].getGrado()==grado){
				cursoBuscado=grados[i];
				break;
			}
		}
		return cursoBuscado;
	}
	
	
	public boolean agregarProfesorAUnGrado(Profesor profesor,int grado) {
		boolean ingresado=false;
		boolean experienciaValida=verificarExperienciaProfesor(profesor, grado);
		CursoPrimario cursoExistente=buscarGrado(grado);
		if(experienciaValida && cursoExistente!=null /*verificarExperienciaProfesor(profesor)*/){
			cursoExistente.setProfesor(profesor);
			ingresado=true;
		}
		return ingresado;
	}
	
	public boolean eliminarProfesorDeUnCurso(int idprofesor,int grado){
		boolean eliminado=false;
		CursoPrimario cursoExistente=buscarGrado(grado);
		if(cursoExistente!=null && cursoExistente.getProfesor().getIdProfesor()==idprofesor){
			cursoExistente.setProfesor(null);
			eliminado=true;
		}
		return eliminado;
	}
	
	public boolean verificarExperienciaProfesor(Profesor profesor, int grado){
		boolean experienciaSuficiente=false;
		String stringGrado=grado+"";
		if(profesor.getExperienciaEnCargo()==stringGrado) {
			experienciaSuficiente=true;
		}
		return experienciaSuficiente;
	}
	
	public boolean agregarCurso(CursoPrimario curso){
		boolean gradoRepetido=gradoRepetido(curso.getGrado());
		boolean ingresado=false;
		int posicion=0;
		if(!gradoRepetido) {
			while(!ingresado && posicion<grados.length) {
				if(grados[posicion]==null){
					grados[posicion]=curso;
					ingresado=true;
				}
				posicion++;
			}
		}
		
		return ingresado;
	}
	
	

	public boolean eliminarCurso(int grado) {
		boolean seEliminoCurso=false;
		boolean gradoEncontrado=gradoRepetido(grado);
		if(!gradoEncontrado) {
			for(int i=0; i<grados.length; i++) {
				if(grados[i].getGrado()==grado){//falta repartir a los chicos en las demas aulas
					grados[i]=null;
					seEliminoCurso=true;
					break;
				}
			}
		}
		return seEliminoCurso;
	}
	
	private boolean gradoRepetido(int grado) {
		boolean gradoRepetido=false;
		for(int i=0;i<grados.length;i++) {
			if(grados[i]!=null && grados[i].getGrado()==grado){
				gradoRepetido=true;
				break;
				
			}
		}
		return gradoRepetido;
	}
	
	public CursoPrimario buscarCursoPorGrado(int grado){
		CursoPrimario salaBuscada=null;
		for(int i=0; i<grados.length; i++) {
			if(grados[i]!= null && grados[i].getGrado()==grado){
				salaBuscada=grados[i];
				break;
			}
		}
		
		return salaBuscada;
	}
	
	/*
	private Evaluacion tomarEvaluacion(Profesor profe, int grado, int id){
		Evaluacion evaluacion=null;
		HistorialEvaluacion historial=null;
		CursoPrimario cursoExistente = buscarCursoPorGrado(grado);
		boolean profesorCalificado=verificarExperienciaProfesor(profe, grado);
		if(cursoExistente!=null && profesorCalificado) {
			evaluacion=new Evaluacion(id, profe, grado);
			for(int i=0; i<cursoExistente.getAlumnos().length; i++){
				historial
			}
		}
		return evaluacion;
	}*/

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CursoPrimario[] getGrados() {
		return grados;
	}

	public void setGrados(CursoPrimario[] grados) {
		this.grados = grados;
	}

	public boolean eliminarAlumnoDeUnGrado(int idAlumno, int grado) {
		boolean alumnoEliminado=false;
		CursoPrimario cursoExistente=buscarCursoPorGrado(grado);
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
	
	
	
	
}
