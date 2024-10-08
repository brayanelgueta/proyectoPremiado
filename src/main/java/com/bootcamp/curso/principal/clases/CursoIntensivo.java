package com.bootcamp.curso.principal.clases;
import com.bootcamp.curso.principal.interfaces.IProyecto;
import java.util.ArrayList;
/**
 *
 * @author Felipe Cuevas
 */
public class CursoIntensivo implements IProyecto{
    private Integer codigo, asistenciaMinima;
    private String nombre;
    private Relator relator;
    private ArrayList<Alumno> curso;
    
    public CursoIntensivo(){
    	curso = new ArrayList<Alumno>();
        setCodigo();
        setNombre();
        setAsistenciaMinima();
        setRelator();
        setCurso();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        System.out.println("Ingrese el codigo del curso: ");
        codigo = leer.nextInt(); leer.nextLine();
    }

    public Integer getAsistenciaMinima() {
        return asistenciaMinima;
    }

    public void setAsistenciaMinima() {
        System.out.println("Ingrese la asistencia minima del curso: ");
        asistenciaMinima = leer.nextInt(); leer.nextLine();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        System.out.println("Ingrese el nombre del curso: ");
        nombre = leer.nextLine();
    }

    public Relator getRelator() {
        return relator;
    }

    public void setRelator() {
    	System.out.println("---Datos del relator---");
        relator = new Relator();
    }

    public ArrayList<Alumno> getCurso() {
        return curso;
    }

    public void setCurso() {
    	System.out.println("---Datos del Alumno---");
    	Integer op = 2;

    	do {
    		Alumno a = new Alumno();
            curso.add(a);
            System.out.println("Desea agregar otro alumno?");
            System.out.println("1) Si");
            System.out.println("2) No");
            op = leer.nextInt();
            leer.nextLine();
    	}while(op == 1);
        
    }
    
    public void buscarAlumno(){
    
    	System.out.println("Ingrese el RUN del alumno que desea buscar: ");
    	String runAlumno = leer.nextLine();
    	boolean encontrado = false;

    	for (Alumno a : curso) {
    	   	if (a.getRun().equals(runAlumno)) {
    	       	System.out.println("Alumno encontrado:");
    	       	System.out.println("Nombre: " + a.getNombre());
    	    	System.out.println("Nombre: " + a.getRun());
    	       	
    	       	encontrado = true;
    	       	break;
    	   	}
    	}

    	if (!encontrado) {
    	   	System.out.println("Alumno no encontrado con el RUN ingresado.");
    	}
    	
    }
    
    public void eliminarAlumno(){
    	System.out.println("Ingrese el RUN del alumno que desea eliminar: ");
    	String runAlumno = leer.nextLine();
    	boolean encontrado = false;

    	for (Alumno a : curso) {
    	   	if (a.getRun().equals(runAlumno)) {
    	   		curso.remove(a);
    	       	System.out.println("Alumno Eliminado:");
    	       	encontrado = true;
    	       	break;
    	   	}
    	}

    	if (!encontrado) {
    	   	System.out.println("Alumno no encontrado con el RUN ingresado.");
    	}
    }
    
    public void mostrarSF(){
    	
    	
       for(Alumno aux: curso) {
    	   if(aux.getPromedio() >= 4.0 && aux.getAsistencia() >= asistenciaMinima) {
    		   System.out.println("Situacion Final de " + aux.getNombre() + ": AA");
    	   }else if(aux.getPromedio() >= 4.0 && aux.getAsistencia() < asistenciaMinima){
    		   System.out.println("Situacion Final de " + aux.getNombre() + ": RI");
    	   }else if(aux.getPromedio() < 4.0 && aux.getAsistencia() >= asistenciaMinima) {
    		   System.out.println("Situacion Final de " + aux.getNombre() + ": RN");
    	   }else {
    		   System.out.println("Situacion Final de " + aux.getNombre() + ": RR");
    	   }
       }
     
    }
}
