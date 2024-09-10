package ar.edu.unalm.interfaz;
import java.time.LocalDate;
import java.util.Scanner;
import ar.edu.unlam.dominio.*;

public class gestionDeInstitucion {
	private static Scanner teclado = new Scanner(System.in);
	public static void main(String[] args) {
		int numeroIngresado = 0;
		MenuPrincipal opcionMenuPrincipal = null;
		Instituto instituto =new Instituto("San Bonifacio");
		Jardin jardin =new Jardin("San Martin");
			
			/*
			CursoJardin curso =new CursoJardin(SalaJardin.Roja);
			jardin.agregarCurso(curso);
			Profesor profe=new Profesor(1111, "matias", "maestrx jardinerx");
			jardin.agregarProfesorAUnCurso(profe, SalaJardin.Roja);
			System.out.println(jardin.toString());
			*/
			do {			
			mostrarMenuPrincipal();
			numeroIngresado = ingresarNumeroEntero("\nIngrese opcion:");
			opcionMenuPrincipal = obtenerOpcionDeMenuPrincipal(numeroIngresado);
			switch (opcionMenuPrincipal){
				case MODIFICACIONES:
					eleccionMoficiaciones(instituto, mostrarMenunivelEducativo(opcionMenuPrincipal));
					break;
				
				case EVALUAR:
					eleccionEvaluar(instituto,mostrarMenunivelEducativo(opcionMenuPrincipal));					
					break;
					
				case ASISTENCIAS:
					eleccionAsistencia(instituto, mostrarMenunivelEducativo(opcionMenuPrincipal));
					break;
					
				default:
					System.out.println("opcion no disponible intente con otra");
					break;
				
				case SALIR:
					System.out.println("El programa finalizo");
					break;

			}
			// Completar la condicion para que funcione correctamente
		} while (opcionMenuPrincipal!=MenuPrincipal.SALIR);//listo

	}
	
		
	private static MenuPrincipal obtenerOpcionDeMenuPrincipal(int numeroIngresado) {
		if(numeroIngresado>5 || numeroIngresado<0) {
			return MenuPrincipal.FUERA_DE_RANGO;
		}else {
			return MenuPrincipal.values()[numeroIngresado - 1];
		}
	}
	private static int ingresarNumeroEntero(String mensaje) {
		System.out.println(mensaje);
		return teclado.nextInt();
	}
	
	private static String ingresarUnString(String mensaje) {
		System.out.println(mensaje);
		return teclado.next();
	}
	
	private static void mostrarMenuPrincipal() {
		System.out.println("------menu principal------");
		System.out.println("Que desea hacer en el instituto");
		System.out.println("1 - Modificaciones (agregar/eliminar/cambiar)");
		System.out.println("2 - Evaluaciones");
		System.out.println("3 - Asistencias");
		System.out.println("4 - Salir");
		
	}
	
	private static int mostrarMenunivelEducativo(MenuPrincipal eleccion) {
		String palabraClave="";
		int salida;
		switch(eleccion) {
			case MODIFICACIONES:
				palabraClave=" modificar";
				break;
			
			case EVALUAR:
				palabraClave=" evaluar";
				break;
				
			case ASISTENCIAS:
				palabraClave=" tomar asistencia";
				break;
				
			case SALIR:
				break;
				
			default:
				break;
		}
		System.out.println(eleccion);
		if(eleccion==MenuPrincipal.EVALUAR) {
			System.out.println("---menu de nivel educativo---");
			System.out.println("Que nivel desea"+ palabraClave);
			System.out.println("1 - Primario");
			System.out.println("2 - Secundario");
			System.out.println("3 - Salir");
		}else {
				System.out.println("---menu de nivel educativo---");
				System.out.println("Que nivel desea"+ palabraClave);
				System.out.println("1 - Jardin");
				System.out.println("2 - Primario");
				System.out.println("3 - Secundario");
				System.out.println("4 - Salir");
		}

		salida=ingresarNumeroEntero("Ingrese opcion:");
		return salida;
	}
	
	private static void mostrarSubMenuModifiaciones(NivelEducativo eleccion) {
		String palabraClave="";
		switch(eleccion) {
			case JARDIN:
				palabraClave=" una sala";
				break;
				
			case PRIMARIO:
				palabraClave=" un grado";
				break;
				
			case SECUNDARIO:
				palabraClave=" un anio";
				break;
				
			case SALIR:
				break;

		}
		System.out.println("que desea modificar");
		System.out.println("1 - agregar"+palabraClave);
		System.out.println("2 - agregar un alumno a"+palabraClave);
		System.out.println("3 - agregar un profesor a"+palabraClave);
		System.out.println("4 - eliminar"+palabraClave);
		System.out.println("5 - eliminar un alumno de"+palabraClave);
		System.out.println("6 - eliminar un profesor de"+palabraClave);
		System.out.println("7 - Salir");
	}
	
	private static void eleccionMoficiaciones(Instituto insti, int numeroIngresado) {
		NivelEducativo eleccion=NivelEducativo.values()[numeroIngresado - 1];
		Instituto instituto=insti;
			
		switch(eleccion) {
			
			case JARDIN:
				modificacionesJardin(insti);
				break;
				
			case PRIMARIO:
				modificacionesPrimario(insti);
				break;
					
			case SECUNDARIO:
				modificacionesSecundario(insti);
				break;
				
			case SALIR:
				break;

		}
	}
	
	private static void modificacionesJardin(Instituto instituto){
		boolean volverAlMenuPrincipal=false;
		Jardin jardin=instituto.getJardin();
		System.out.println(instituto.toString());
		while(!volverAlMenuPrincipal) {
			mostrarSubMenuModifiaciones(NivelEducativo.JARDIN);
			int opcionModificacionElegida=ingresarNumeroEntero("");
			switch(opcionModificacionElegida) {
				case 1:
					agregarSalaJardin(jardin);
					volverAlMenuPrincipal=false;
					break;
					
				case 2:
					int idAlumno = ingresarNumeroEntero("ingrese id del alumno:");
					String nombreAlumno = ingresarUnString("ingrese nombre del alumno");
					int edadAlumno= ingresarNumeroEntero("ingrese edad del alumno:");
					Alumno alumno = new Alumno(idAlumno, nombreAlumno, edadAlumno);
					System.out.println("ingrese el color de la sala a ingresar:");
					System.out.println("1-Celeste");
					System.out.println("2-Verde");
					System.out.println("3-Azul");
					System.out.println("4-Rojo");
					System.out.println("5-Retroseder");
					SalaJardin colorDeSala=SalaJardin.values()[ingresarNumeroEntero("valor seleccionado:") - 1];
					jardin.agregarAlumnoAUnaSala(alumno, colorDeSala);
					break;
					
				case 3:
					int idProfesor = ingresarNumeroEntero("ingrese id del profesor:");
					String nombreProfesor = ingresarUnString("ingrese nombre del profesor") ;
					String experienciaProfesor= ingresarUnString("ingrese experiencia del profesor:");
					Profesor profesor = new Profesor(idProfesor,nombreProfesor,experienciaProfesor);
					System.out.println("ingrese el color de la sala a ingresar:");
					System.out.println("1-Celeste");
					System.out.println("2-Verde");
					System.out.println("3-Azul");
					System.out.println("4-Rojo");
					System.out.println("5-Retroseder");
					SalaJardin c=SalaJardin.values()[ingresarNumeroEntero("valor seleccionado:") - 1];
					jardin.agregarProfesorAUnCurso(profesor, c);
					break;
					
				case 4:
					System.out.println("ingrese el color de la sala a eliminar:");
					System.out.println("1-Celeste");
					System.out.println("2-Verde");
					System.out.println("3-Azul");
					System.out.println("4-Rojo");
					System.out.println("5-Retroseder");
					SalaJardin color=SalaJardin.values()[ingresarNumeroEntero("valor seleccionado:") - 1];
					jardin.eliminarCurso(color);
					break;
					
				case 5:
					int idAlumn = ingresarNumeroEntero("id de alumno a eliminar:") ;
					System.out.println("ingrese el color de la sala del alumno a eliminar:");
					System.out.println("1-Celeste");
					System.out.println("2-Verde");
					System.out.println("3-Azul");
					System.out.println("4-Rojo");
					System.out.println("5-Retroseder");
					SalaJardin colo=SalaJardin.values()[ingresarNumeroEntero("valor seleccionado:") - 1];
					jardin.eliminarAlumnoPorSala(idAlumn, colo);
					
					break;
					
				case 6:
					int idProfe = ingresarNumeroEntero("id del profesor a eliminar:") ;
					System.out.println("ingrese el color de la sala del profesor a eliminar:");
					System.out.println("1-Celeste");
					System.out.println("2-Verde");
					System.out.println("3-Azul");
					System.out.println("4-Rojo");
					System.out.println("5-Retroseder");
					SalaJardin col=SalaJardin.values()[ingresarNumeroEntero("valor seleccionado:") - 1];
					jardin.eliminarProfesorDeUnCurso(idProfe, col);
					break;
					
				case 7:
					System.out.println("salio del menu");
					volverAlMenuPrincipal=true;
					break;
			}
		}
	}

	public static boolean agregarSalaJardin(Jardin jardin) {
		System.out.println("para agregar una sala necesitamos un color de sala y que no se repita");
		System.out.println("1-Celeste");
		System.out.println("2-Verde");
		System.out.println("3-Azul");
		System.out.println("4-Rojo");
		System.out.println("5-Retroseder");
		SalaJardin colorDeSala=SalaJardin.values()[ingresarNumeroEntero("valor seleccionado:") - 1];
		CursoJardin curso=null;
		switch(colorDeSala){
			case CELESTE:
				curso =new CursoJardin(SalaJardin.CELESTE);
				break;
				
			case VERDE:
				curso =new CursoJardin(SalaJardin.VERDE);
				break;
				
			case AZUL:
				curso =new CursoJardin(SalaJardin.AZUL);
				break;
				
			case ROJA:
				curso =new CursoJardin(SalaJardin.ROJA);
				break;
		}
		System.out.println(jardin.agregarCurso(curso));
		return true;
	}
	
	private static void modificacionesPrimario(Instituto instituto){
		boolean volverAlMenuPrincipal=false;
		int grado=0;
		Primario primario=instituto.getPrimario();
		System.out.println(instituto.toString());
		while(!volverAlMenuPrincipal) {
			mostrarSubMenuModifiaciones(NivelEducativo.PRIMARIO);
			int opcionModificacionElegida=ingresarNumeroEntero("");
			switch(opcionModificacionElegida) {
				case 1:
					do {
					System.out.println("para agregar una grado necesitamos un anio de grado y que no se repita");
					System.out.println("1er grado");
					System.out.println("2do grado");
					System.out.println("3er grado");
					System.out.println("4to grado");
					System.out.println("5to grado");
					System.out.println("6to grado");
					System.out.println("7- salir");
					grado=ingresarNumeroEntero("valor seleccionado:");
					}while(grado>7 || grado<1);
					if(grado==7)
						break;
					CursoPrimario curso=new CursoPrimario(grado);
					primario.agregarCurso(curso);
					break;
					
				case 2:
					int idAlumno = ingresarNumeroEntero("ingrese id del alumno:");
					String nombreAlumno = ingresarUnString("ingrese nombre del alumno");
					int edadAlumno= ingresarNumeroEntero("ingrese edad del alumno:");
					Alumno alumno = new Alumno(idAlumno, nombreAlumno, edadAlumno);
					do {
					System.out.println("ingrese el grado a ingresar el alumno:");
					System.out.println("1er grado");
					System.out.println("2do grado");
					System.out.println("3er grado");
					System.out.println("4to grado");
					System.out.println("5to grado");
					System.out.println("6to grado");
					System.out.println("7- salir");
					grado=ingresarNumeroEntero("valor seleccionado:");
					}while(grado>7 || grado<1);
					if(grado==7)
						break;
					primario.agregarAlumno(grado, alumno);
					break;
					
				case 3:
					int idProfesor = ingresarNumeroEntero("ingrese id del profesor:");
					String nombreProfesor = ingresarUnString("ingrese nombre del profesor") ;
					String experienciaProfesor= ingresarUnString("ingrese experiencia del profesor:");
					Profesor profesor = new Profesor(idProfesor,nombreProfesor,experienciaProfesor);
					do{
					System.out.println("ingrese el grado a ingresar el profesor:");
					System.out.println("1er grado");
					System.out.println("2do grado");
					System.out.println("3er grado");
					System.out.println("4to grado");
					System.out.println("5to grado");
					System.out.println("6to grado");
					System.out.println("7- salir");
					grado=ingresarNumeroEntero("valor seleccionado:");
					}while(grado>7 || grado<1);
					if(grado==7)
						break;
					
					primario.agregarProfesorAUnGrado(profesor, grado);
					break;
					
				case 4:
					System.out.println("ingrese el grado a eliminar:");
					do{											
					System.out.println("1er grado");
					System.out.println("2do grado");
					System.out.println("3er grado");
					System.out.println("4to grado");
					System.out.println("5to grado");
					System.out.println("6to grado");
					System.out.println("7- salir");
					grado=ingresarNumeroEntero("valor seleccionado:");
					}while(grado>7 || grado<1);
					if(grado==7)
						break;
					primario.eliminarCurso(grado);
					break;
					
				case 5:
					int idAlumn = ingresarNumeroEntero("id de alumno a eliminar:") ;
					System.out.println("ingrese el grado a del alumno a eliminar:");
					do {
						System.out.println("1er grado");
						System.out.println("2do grado");
						System.out.println("3er grado");
						System.out.println("4to grado");
						System.out.println("5to grado");
						System.out.println("6to grado");
						System.out.println("7- salir");
						grado=ingresarNumeroEntero("valor seleccionado:");
					}while(grado>7 || grado<1);
					if(grado==7)
						break;
					primario.eliminarAlumnoDeUnGrado(idAlumn,grado);
					
					break;
					
				case 6:
					int idProfe = ingresarNumeroEntero("id del profesor a eliminar:") ;
					do {
						System.out.println("ingrese el grado a del profesor a eliminar:");
						System.out.println("1er grado");
						System.out.println("2do grado");
						System.out.println("3er grado");
						System.out.println("4to grado");
						System.out.println("5to grado");
						System.out.println("6to grado");
						System.out.println("7- salir");
						grado=ingresarNumeroEntero("valor seleccionado:");
					}while(grado>7 || grado<1);
					if(grado==7)
						break;
					primario.eliminarProfesorDeUnCurso(idProfe, grado);
					break;
					
				case 7:
					System.out.println("salio del menu");
					volverAlMenuPrincipal=true;
					break;
			}
		}
	}

	private static void modificacionesSecundario(Instituto instituto){
		boolean volverAlMenuPrincipal=false;
		int anio=0;
		Secundario secundaria=instituto.getSecundario();
		System.out.println(instituto.toString());
		while(!volverAlMenuPrincipal) {
			mostrarSubMenuModifiaciones(NivelEducativo.SECUNDARIO);
			int opcionModificacionElegida=ingresarNumeroEntero("");
			switch(opcionModificacionElegida) {
				case 1:
					do {
						System.out.println("para agregar una grado necesitamos un anio de grado y que no se repita");
						System.out.println("1er anio");
						System.out.println("2do anio");
						System.out.println("3er anio");
						System.out.println("4to anio");
						System.out.println("5to anio");
						System.out.println("6to anio");
						System.out.println("7- salir");
						anio=ingresarNumeroEntero("valor seleccionado:");
					}while(anio>7 || anio<1);
					if(anio==7)
						break;
					CursoSecundario curso=new CursoSecundario(anio);
					secundaria.agregarCurso(curso);
					break;
					
				case 2:
					int idAlumno = ingresarNumeroEntero("ingrese id del alumno:");
					String nombreAlumno = ingresarUnString("ingrese nombre del alumno");
					int edadAlumno= ingresarNumeroEntero("ingrese edad del alumno:");
					Alumno alumno = new Alumno(idAlumno, nombreAlumno, edadAlumno);
					do {
						System.out.println("ingrese el grado a ingresar el alumno:");
						System.out.println("1er anio");
						System.out.println("2do anio");
						System.out.println("3er anio");
						System.out.println("4to anio");
						System.out.println("5to anio");
						System.out.println("6to anio");
						System.out.println("7- salir");
					}while(anio>7 || anio<1);
					if(anio==7)
						break;
					anio=ingresarNumeroEntero("valor seleccionado:");
					secundaria.agregarAlumno(anio, alumno);
					break;
					
				case 3:
					int idProfesor = ingresarNumeroEntero("ingrese id del profesor:");
					String nombreProfesor = ingresarUnString("ingrese nombre del profesor") ;
					String experienciaProfesor= ingresarUnString("ingrese experiencia del profesor:");
					Profesor profesor = new Profesor(idProfesor,nombreProfesor,experienciaProfesor);
					int idMateria = ingresarNumeroEntero("ingrese el id de la materia");
					secundaria.agregarProfesorAUnaMateriaEnUnAnio(profesor, idMateria);
					break;
					
				case 4:
					do {
						System.out.println("ingrese el grado a eliminar:");
						System.out.println("1er anio");
						System.out.println("2do anio");
						System.out.println("3er anio");
						System.out.println("4to anio");
						System.out.println("5to anio");
						System.out.println("6to anio");
						System.out.println("7- salir");
						anio=ingresarNumeroEntero("valor seleccionado:");
					}while(anio>7 || anio<1);
					if(anio==7)
						break;
					secundaria.eliminarCurso(anio);
					break;
					
				case 5:
					int idAlumn = ingresarNumeroEntero("id de alumno a eliminar:");
					do {
						System.out.println("ingrese el grado a del alumno a eliminar:");
						System.out.println("1er anio");
						System.out.println("2do anio");
						System.out.println("3er anio");
						System.out.println("4to anio");
						System.out.println("5to anio");
						System.out.println("6to anio");
						System.out.println("7- salir");
						anio=ingresarNumeroEntero("valor seleccionado:");
					}while(anio>7 || anio<1);
					if(anio==7)
						break;
					secundaria.eliminarAlumnoDeUnAnio(idAlumn, anio);
					
					break;
					
				case 6:
					int idProfe = ingresarNumeroEntero("id del profesor a eliminar:");
					int idMat = ingresarNumeroEntero("ingrese id de la materia");
					secundaria.elimimarProfesorDeUnaMateria(idProfe, idMat);
					break;
					
				case 7:
					System.out.println("salio del menu");
					volverAlMenuPrincipal=true;
					break;
			}
		}
	}
	
	public static void eleccionAsistencia(Instituto instituto,int numeroIngresado) {
		NivelEducativo eleccion=NivelEducativo.values()[numeroIngresado - 1];
			
		switch(eleccion) {
			
			case JARDIN:
				tomarListaJardin(instituto);
				break;
				
			case PRIMARIO:
				tomarListaPrimario(instituto);
				break;
				
			case SECUNDARIO:
				tomarListaSecundaria(instituto);
				
			case SALIR:
				break;
				
			default:
				break;
		}
	}
	
	
	public static void tomarListaJardin(Instituto instituto){
		Jardin jardin = instituto.getJardin();
		int opcionPosible=1;
		for(int i=0;i<jardin.getCursos().length;i++) {
			if(jardin.getCursos()[i]!=null) {
				SalaJardin colorOpciones=jardin.getCursos()[i].getSalaJardin();
				System.out.println(opcionPosible+"- "+colorOpciones);
				opcionPosible++;
			}
		}
		int opcionElegida=ingresarNumeroEntero("cual sala desea ingresar");
		Alumno[] arrayAlumnos = jardin.getCursos()[opcionElegida-1].getAlumnos();
		for(int i=0; i<arrayAlumnos.length; i++) {
			if(arrayAlumnos[i]!=null) {
				System.out.println(arrayAlumnos[i].toString());				
				System.out.println("P-presente");
				System.out.println("A-ausente");
				System.out.print("esta presente?:");
				String presentismo=teclado.next();
				boolean presente=false;
				if(presentismo.equals("P")) {
					presente=true;
				}
				Asistencia asistencia = new Asistencia(arrayAlumnos[i].getIdAlumno(), LocalDate.now(), presente);
				for(int j=0; j<instituto.getHistorialAsistenciaAlumnos().length; j++) {
					if(instituto.getHistorialAsistenciaAlumnos()[j]==null) {
						instituto.getHistorialAsistenciaAlumnos()[j]=asistencia;					
					}
				}
			}
		}

	}
	
	public static void tomarListaPrimario(Instituto instituto){
		Primario primario = instituto.getPrimario();
		int opcionPosible=1;
		for(int i=0;i<primario.getGrados().length;i++) {
			if(primario.getGrados()[i]!=null) {
				int gradoOpciones=primario.getGrados()[i].getGrado();
				System.out.println(opcionPosible+"- "+gradoOpciones);
				opcionPosible++;
			}
		}
		int opcionElegida=ingresarNumeroEntero("que grado desea tomar lista:");
		Alumno[] arrayAlumnos = primario.getGrados()[opcionElegida-1].getAlumnos();
		for(int i=0; i<arrayAlumnos.length; i++) {
			if(arrayAlumnos[i]!=null) {
				System.out.println(arrayAlumnos[i].toString());				
				System.out.println("P-presente");
				System.out.println("A-ausente");
				System.out.print("esta presente?:");
				String presentismo=teclado.next();
				boolean presente=false;
				if(presentismo.equals("P")) {
					presente=true;
				}
				Asistencia asistencia = new Asistencia(arrayAlumnos[i].getIdAlumno(), LocalDate.now(), presente);
				for(int j=0; j<instituto.getHistorialAsistenciaAlumnos().length; j++) {
					if(instituto.getHistorialAsistenciaAlumnos()[j]==null) {
						instituto.getHistorialAsistenciaAlumnos()[j]=asistencia;					
					}
				}
			}
		}

	}
	
	public static void tomarListaSecundaria(Instituto instituto){
		Secundario secundario = instituto.getSecundario();
		int opcionPosible=1;
		for(int i=0;i<secundario.getAnio().length;i++) {
			if(secundario.getAnio()[i]!=null) {
				int gradoOpciones=secundario.getAnio()[i].getAnio();
				System.out.println(opcionPosible+"- "+gradoOpciones);
				opcionPosible++;
			}
		}
		int opcionElegida=ingresarNumeroEntero("que anio desea tomar lista");
		Alumno[] arrayAlumnos = secundario.getAnio()[opcionElegida-1].getAlumnos();
		for(int i=0; i<arrayAlumnos.length; i++) {
			if(arrayAlumnos[i]!=null) {
				System.out.println(arrayAlumnos[i].toString());				
				System.out.println("P-presente");
				System.out.println("A-ausente");
				System.out.print("esta presente?:");
				String presentismo=teclado.next();
				boolean presente=false;
				if(presentismo.equals("P")) {
					presente=true;
				}
				Asistencia asistencia = new Asistencia(arrayAlumnos[i].getIdAlumno(), LocalDate.now(), presente);
				for(int j=0; j<instituto.getHistorialAsistenciaAlumnos().length; j++) {
					if(instituto.getHistorialAsistenciaAlumnos()[j]==null) {
						instituto.getHistorialAsistenciaAlumnos()[j]=asistencia;					
					}
				}
			}
		}

	}
	
	public static void eleccionEvaluar(Instituto instituto,int numeroIngresado) {
		switch(numeroIngresado) {			
			case 1:
				tomarEvaluacionPrimario(instituto);
				break;
				
			case 2:
				tomarEvaluacionSecundaria(instituto);
				
			case 3:
				break;
				
			default:
				break;
		}
	}
	
	public static void tomarEvaluacionPrimario(Instituto instituto){
		int idEvaluacion = ingresarNumeroEntero("ingrese id de la evaluacion");
		int grado = ingresarNumeroEntero("ingrese grado de la evaluacion") ;//verificar si existe y agarrar los alumnos del curso
		int idProfesor = ingresarNumeroEntero("ingrese id de la evaluacion");//verificar si el profesor puede dar la materia
		Primario primario = instituto.getPrimario();
		
		//if(primario.verificarExperienciaProfesor(null, grado)==true) {
			Evaluacion evaluacion = new Evaluacion(idEvaluacion,null, grado);
			for(int i=0; i<instituto.getEvaluaciones().length; i++) {
				if(instituto.getEvaluaciones()[i]==null) {
					instituto.getEvaluaciones()[i]=evaluacion;
					break;
				}
				
			}
			CursoPrimario cursoEvaluado=primario.buscarCursoPorGrado(grado);
			for(int i=0; i<cursoEvaluado.getAlumnos().length; i++) {
				if(cursoEvaluado.getAlumnos()[i]!=null) {
					int idAlumno=cursoEvaluado.getAlumnos()[i].getIdAlumno();
					System.out.println(cursoEvaluado.getAlumnos()[i].toString());
					System.out.print("nota del alumno:");
					double nota=teclado.nextDouble();
					for(int j=0; j<instituto.getHistorialEvaluacionAlumnos().length; j++) {
						if(instituto.getHistorialEvaluacionAlumnos()[j]==null) {
							EvaluacionAlumno evaluacionAlumno = new EvaluacionAlumno(idEvaluacion, idAlumno, null,nota);
							instituto.getHistorialEvaluacionAlumnos()[j]=evaluacionAlumno;
							break;
						}
					}
				}
			}
		}
	//}
	
	public static void tomarEvaluacionSecundaria(Instituto instituto){
		int idEvaluacion = ingresarNumeroEntero("ingrese id de la evaluacion");
		int anio = ingresarNumeroEntero("ingrese anio de la evaluacion") ;//verificar si existe y agarrar los alumnos del curso
		int idMateria = ingresarNumeroEntero("ingrese anio de la evaluacion");
		int idProfesor = ingresarNumeroEntero("ingrese id de la evaluacion");//verificar si el profesor puede dar la materia
		Secundario secundario = instituto.getSecundario();
		//if(primario.verificarExperienciaProfesor(null, grado)==true) { y si la materia existe
			Evaluacion evaluacion = new Evaluacion(idEvaluacion,null, anio, idMateria);
			for(int i=0; i<instituto.getEvaluaciones().length; i++) {
				if(instituto.getEvaluaciones()[i]==null) {
					instituto.getEvaluaciones()[i]=evaluacion;
					break;
				}
				
			}
			CursoSecundario cursoEvaluado=secundario.buscarAnio(anio);
			for(int i=0; i<cursoEvaluado.getAlumnos().length; i++) {
				if(cursoEvaluado.getAlumnos()[i]!=null) {
					int idAlumno=cursoEvaluado.getAlumnos()[i].getIdAlumno();
					System.out.println(cursoEvaluado.getAlumnos()[i].toString());
					System.out.print("nota del alumno:");
					double nota=teclado.nextDouble();
					
					for(int j=0; j<instituto.getHistorialEvaluacionAlumnos().length; j++) {
						if(instituto.getHistorialEvaluacionAlumnos()[j]==null) {
							EvaluacionAlumno evaluacionAlumno = new EvaluacionAlumno(idEvaluacion, idAlumno, null,nota);
							instituto.getHistorialEvaluacionAlumnos()[j]=evaluacionAlumno;
							break;
						}
					}
				}
			}
		}
	//}
	
	
	
}
