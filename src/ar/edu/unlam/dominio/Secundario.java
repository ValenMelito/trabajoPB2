package ar.edu.unlam.dominio;

public class Secundario {
	private String nombre;
	private CursoSecundario[] anio = new CursoSecundario[6];
	
	public Secundario(String nombre) {
		this.nombre = nombre;
	}
	
//falta mas verificacion sobre si paso termino el primario o si termino el año anterior al que se lo quiere inscribir
	public boolean agregarAlumno(int anio, Alumno alumno) {
		CursoSecundario curso=buscarAnio(anio);
		boolean seAgrego=false;
		if(curso!=null && (alumno.getEdad()>=6 && alumno.getEdad()<11)) {//edad secundario...
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
	
	public CursoSecundario buscarAnio(int anio) {
		CursoSecundario anioBuscado=null;
		for(int i=0; i<this.anio.length; i++) {
			if(this.anio[i].getAnio()==anio){
				anioBuscado=this.anio[i];
				break;
			}
		}
		return anioBuscado;
	}
	
	public boolean agregarProfesorAUnaMateriaEnUnAnio(Profesor profesor, int idMateria){
		boolean profesorAgregado=false;
		for(int i=0; i<this.anio.length; i++){
			if(this.anio[i]!=null) {
				Materias[] materias = this.anio[i].getMaterias();
				for(int j=0; j<materias.length; j++) {
					if(materias!= null && materias[j].getIdMateria()==idMateria){
						if(profesor.getExperienciaEnCargo()==materias[j].getNombreMateria()) {
							materias[j].setProfesor(profesor);
							profesorAgregado=true;
							break;
							
						}
					}
				}
			}
		}
		
		return profesorAgregado;
	}
	 	
	public boolean agregarCurso(CursoSecundario anio){
		boolean gradoRepetido=anioRepetido(anio.getAnio());
		boolean ingresado=false;
		int posicion=0;
		if(!gradoRepetido) {
			while(!ingresado && posicion<this.anio.length) {
				if(this.anio[posicion]==null){
					this.anio[posicion]=anio;
					ingresado=true;
				}
				posicion++;
			}
		}
		
		return ingresado;
	}
	
	

	public boolean eliminarCurso(int grado) {
		boolean seEliminoCurso=false;
		boolean gradoEncontrado=anioRepetido(grado);
		if(!gradoEncontrado) {
			for(int i=0; i<this.anio.length; i++) {
				if(this.anio[i].getAnio()==grado){ 
					this.anio[i]=null;
					
					seEliminoCurso=true;
					break;
				}
			}
		}
		return seEliminoCurso;
	}
	
	public boolean eliminarMateriaDeUnCurso(int idMateria){
		boolean materiaEliminada=false;
		for(int i=0; i<this.anio.length; i++){
			if(this.anio[i]!=null) {
				Materias[] materias = this.anio[i].getMaterias();
				for(int j=0; j<materias.length; j++) {
					if(materias!= null && materias[j].getIdMateria()==idMateria){
						materiaEliminada=true;
						break;					
					}
				}
			}
		}
		
		return materiaEliminada;
	}
	
	private boolean anioRepetido(int anio) {
		boolean anioRepetido=false;
		for(int i=0;i<this.anio.length;i++) {
			if(this.anio[i]!=null && this.anio[i].getAnio()==anio){
				anioRepetido=true;
				break;
				
			}
		}
		return anioRepetido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CursoSecundario[] getAnio() {
		return anio;
	}

	public void setAnio(CursoSecundario[] anio) {
		this.anio = anio;
	}

	public boolean eliminarAlumnoDeUnAnio(int idAlumno, int anio) {
		boolean alumnoEliminado=false;
		CursoSecundario cursoExistente=buscarAnio(anio);
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

	public boolean elimimarProfesorDeUnaMateria(int idProfe, int idMateria) {
		boolean profesorEliminado=false;
		for(int i=0; i<this.anio.length; i++){
			if(this.anio[i]!=null) {
				Materias[] materias = this.anio[i].getMaterias();
				for(int j=0; j<materias.length; j++) {
					if(materias!= null && materias[j].getIdMateria()==idMateria && materias[j].getProfesor().getIdProfesor()==idProfe){
						materias[j].setProfesor(null);
						profesorEliminado=true;
						break;					
					}
				}
			}
		}
		
		return profesorEliminado;
		
	}

	
	
	
	
}
